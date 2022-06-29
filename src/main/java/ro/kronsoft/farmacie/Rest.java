package ro.kronsoft.farmacie;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.client.RestTemplate;

import ro.kronsoft.farmacie.model.Evidenta;
import ro.kronsoft.farmacie.model.IntrareMedicament;
import ro.kronsoft.farmacie.model.Stoc_detaliat;
import ro.kronsoft.farmacie.model.Vz_cant;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.time.LocalDate;

public class Rest {

	final static String IM = "http://localhost:8085/api/v1/intrari_medicamente";
	final static String SD = "http://localhost:8085/api/v1/stoc_detaliat";
	final static String VC = "http://localhost:8085/api/v1/vz_cant";
	final static String EV = "http://localhost:8085/api/v1/evidenta";

	static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) throws IOException, InterruptedException {
		String caleFisier = "C://Users//nedel//Desktop//Practica//Resurse//";
		System.out
				.println("Documentele excel nu trebuie sa contina denumirea default: !New Microsoft Excel Worksheet!");
		String fileExtension = "xlsx";
		WatchService watchService = FileSystems.getDefault().newWatchService();
		Path path = Paths.get(caleFisier);
		System.out.println(path.toAbsolutePath());
		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
		WatchKey key = watchService.take();
		while (key != null) {
			for (WatchEvent<?> event : key.pollEvents()) {
				String fileType = event.context().toString().substring(event.context().toString().length() - 4);
				System.out.println(fileType);
				if (fileType.equalsIgnoreCase(fileExtension)
						&& !event.context().toString().contains("New Microsoft Excel Worksheet")
						&& !event.context().toString().contains("$")) {
					System.out.println("Event type: " + event.kind() + " | File affected: " + event.context());
					String currentPath = path.toAbsolutePath().toString() + "\\" + event.context().toString();
					Thread.sleep(35000);
					ExcelIntrareMedicament(currentPath);
					ExcelStocDetaliat(currentPath);
					ExcelVzCant(currentPath);
				}
			}
		}

	}

	public static void ExcelIntrareMedicament(String excelFilePath) throws IOException {
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("Intrari detaliate");
		int numarLinii = sheet.getLastRowNum();
		int numarColoane = sheet.getRow(4).getLastCellNum();
		DataFormatter formatter = new DataFormatter();
		var listaIntrari = new ArrayList<IntrareMedicament>();
		for (int linie = 5; linie < numarLinii; linie++) {
			XSSFRow linieCurenta = sheet.getRow(linie);
			ArrayList<String> dinExcel = new ArrayList<String>();
			for (int coloana = 0; coloana < numarColoane; coloana++) {
				XSSFCell cell = linieCurenta.getCell(coloana);
				dinExcel.add(formatter.formatCellValue(cell));
			}
			if (!dinExcel.get(7).equals("")) {
				IntrareMedicament im = new IntrareMedicament();
				im.setNumeFurnizor(dinExcel.get(0));
				im.setTipStoc(dinExcel.get(1));
				im.setAgentFurnizor(dinExcel.get(2));
				im.setProdus(dinExcel.get(3));
				im.setCodCas(dinExcel.get(4));
				im.setBBD2(dinExcel.get(5));
				im.setLot(dinExcel.get(6));
				im.setNumarDocIntrare(Long.parseLong(dinExcel.get(7)));
				im.setDataDocIntrare2(dinExcel.get(8));
				im.setNumeMoneda(dinExcel.get(9));

				im.setPretAchizitieValuta(
						dinExcel.get(10).contains(",") ? Double.parseDouble(dinExcel.get(10).replace(",", ""))
								: Double.parseDouble(dinExcel.get(10)));

				im.setCantitate(
						dinExcel.get(11).contains(",") ? (int) Double.parseDouble(dinExcel.get(11).replace(",", ""))
								: (int) Double.parseDouble(dinExcel.get(11)));

				im.setValoareAchizitieDiscountat(
						dinExcel.get(12).contains(",") ? Double.parseDouble(dinExcel.get(12).replace(",", ""))
								: Double.parseDouble(dinExcel.get(12)));

				im.setValoareDiscountAchizitie(
						(dinExcel.get(13).contains(",") ? Double.parseDouble(dinExcel.get(13).replace(",", ""))
								: Double.parseDouble(dinExcel.get(13))));

				im.setPretAchizitie(
						dinExcel.get(14).contains(",") ? Double.parseDouble(dinExcel.get(14).replace(",", ""))
								: Double.parseDouble(dinExcel.get(14)));
				listaIntrari.add(im);
			}
		}
		workbook.close();
		int numarIntrariCurent = restTemplate.getForEntity(IM, IntrareMedicament[].class).getBody().length;
		listaIntrari.forEach(
				intrareMedicament -> restTemplate.postForEntity(IM, intrareMedicament, IntrareMedicament.class));
		int numarIntrariFinal = restTemplate.getForEntity(IM, IntrareMedicament[].class).getBody().length;
		int intrariNoi = numarIntrariFinal - numarIntrariCurent;

		Evidenta ev = new Evidenta();
		ev.setIntrariInitiale(numarIntrariCurent);
		ev.setNumeSheet(sheet.getSheetName());
		ev.setIntrariNoi(intrariNoi);
		ev.setTotalIntrari(numarIntrariFinal);
		restTemplate.postForEntity(EV, ev, Evidenta.class);
	}

	public static void ExcelStocDetaliat(String excelFilePath) throws IOException {
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("stoc detaliat");
		int numarLinii = sheet.getLastRowNum();
		int numarColoane = sheet.getRow(3).getLastCellNum();
		DataFormatter formatter = new DataFormatter();
		var listaIntrari = new ArrayList<Stoc_detaliat>();
		for (int linie = 4; linie < numarLinii; linie++) {
			XSSFRow linieCurenta = sheet.getRow(linie);
			ArrayList<String> dinExcel = new ArrayList<String>();
			for (int coloana = 0; coloana < numarColoane; coloana++) {
				XSSFCell cell = linieCurenta.getCell(coloana);
				dinExcel.add(formatter.formatCellValue(cell));
			}
			Stoc_detaliat stocCurent = new Stoc_detaliat();
			stocCurent.setCod(dinExcel.get(0));
			stocCurent.setCodCAS(dinExcel.get(1));
			stocCurent.setProdus(dinExcel.get(2));
			stocCurent.setProducator(dinExcel.get(3));
			stocCurent.setTip_stoc(dinExcel.get(4));
			stocCurent.setCategorie(dinExcel.get(5));
			stocCurent.setVechimeStoc(dinExcel.get(6) == "" ? 0 : Integer.parseInt(dinExcel.get(6)));
			stocCurent.setFurnizor_Nume(dinExcel.get(7));
			stocCurent.seteazaData(dinExcel.get(8));
			stocCurent.setSc_cant(dinExcel.get(9).contains(",") ? Double.parseDouble(dinExcel.get(9).replace(",", ""))
					: Double.parseDouble(dinExcel.get(9)));
			stocCurent.setPret_Achizite(
					dinExcel.get(10).contains(",") ? Double.parseDouble(dinExcel.get(10).replace(",", ""))
							: Double.parseDouble(dinExcel.get(10)));
			stocCurent.setPret_unitar(
					dinExcel.get(11).contains(",") ? Double.parseDouble(dinExcel.get(11).replace(",", ""))
							: Double.parseDouble(dinExcel.get(11)));
			stocCurent.setVal_pret_achizitie(
					dinExcel.get(12).contains(",") ? Double.parseDouble(dinExcel.get(12).replace(",", ""))
							: Double.parseDouble(dinExcel.get(12)));

			listaIntrari.add(stocCurent);
		}
		workbook.close();
		int numarIntrariCurent = restTemplate.getForEntity(SD, Stoc_detaliat[].class).getBody().length;
		listaIntrari.forEach(stocDetaliat -> restTemplate.postForEntity(SD, stocDetaliat, Stoc_detaliat.class));
		int numarIntrariFinal = restTemplate.getForEntity(SD, Stoc_detaliat[].class).getBody().length;
		int intrariNoi = numarIntrariFinal - numarIntrariCurent;

		Evidenta ev = new Evidenta();
		ev.setIntrariInitiale(numarIntrariCurent);
		ev.setNumeSheet(sheet.getSheetName());
		ev.setIntrariNoi(intrariNoi);
		ev.setTotalIntrari(numarIntrariFinal);
		restTemplate.postForEntity(EV, ev, Evidenta.class);
	}

	public static void ExcelVzCant(String excelFilePath) throws IOException {
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("Vz. Cant. (2)");
		int numarLinii = sheet.getLastRowNum();
		int numarColoane = sheet.getRow(6).getLastCellNum();
		DataFormatter formatter = new DataFormatter();
		var listaIntrari = new ArrayList<Vz_cant>();
		for (int linie = 7; linie < numarLinii; linie++) {
			XSSFRow linieCurenta = sheet.getRow(linie);
			ArrayList<String> dinExcel = new ArrayList<String>();
			for (int coloana = 0; coloana < numarColoane; coloana++) {
				XSSFCell cell = linieCurenta.getCell(coloana);
				dinExcel.add(formatter.formatCellValue(cell));
			}
			Vz_cant vzCurent = new Vz_cant();
			vzCurent.setProdus(dinExcel.get(0));
			vzCurent.setTotal_OutD_Cant(
					dinExcel.get(5).contains(",") ? Double.parseDouble(dinExcel.get(5).replace(",", ""))
							: Double.parseDouble(dinExcel.get(5)));
			vzCurent.setTotal_OutD_Val_Vanzare_FTVA(
					dinExcel.get(6).contains(",") ? Double.parseDouble(dinExcel.get(6).replace(",", ""))
							: Double.parseDouble(dinExcel.get(6)));
			vzCurent.setTotal_OutD_Val_Marja(
					dinExcel.get(7).contains(",") ? Double.parseDouble(dinExcel.get(7).replace(",", ""))
							: Double.parseDouble(dinExcel.get(7)));
			if(dinExcel.get(4).equalsIgnoreCase("")) {
				vzCurent.setData(LocalDate.of(2000,1,1));
			}else {
				vzCurent.PrelucreazaData2(dinExcel.get(1), dinExcel.get(3), dinExcel.get(4));
			}
			vzCurent.setTrim(dinExcel.get(2));
			listaIntrari.add(vzCurent);

		}
		workbook.close();
		int numarIntrariCurent = restTemplate.getForEntity(VC, Vz_cant[].class).getBody().length;
		listaIntrari.forEach(Vz_cant -> restTemplate.postForEntity(VC, Vz_cant, Vz_cant.class));
		int numarIntrariFinal = restTemplate.getForEntity(VC, Vz_cant[].class).getBody().length;
		int intrariNoi = numarIntrariFinal - numarIntrariCurent;

		Evidenta ev = new Evidenta();
		ev.setIntrariInitiale(numarIntrariCurent);
		ev.setNumeSheet(sheet.getSheetName());
		ev.setIntrariNoi(intrariNoi);
		ev.setTotalIntrari(numarIntrariFinal);
		restTemplate.postForEntity(EV, ev, Evidenta.class);

	}

}
