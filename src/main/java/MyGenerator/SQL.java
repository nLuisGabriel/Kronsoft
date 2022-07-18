package MyGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL {
 private final String url="jdbc:postgresql://localhost:5432/kronsoft";
 private final String user ="postgres";

 private static final String DB_SYS_PROP = System.getProperty("dbPass");
 private final String password=DB_SYS_PROP != null && !DB_SYS_PROP.isEmpty() ? DB_SYS_PROP : "parezax2";
 
 public void connect() {
	 try(Connection c= DriverManager.getConnection(url,user,password)) {
		if(c!=null) {
			Statement s= c.createStatement();
			String a="ALTER TABLE \"intrari_medicamente\" ADD COLUMN \"id\" SERIAL;";
			s.executeQuery(a);;
 		}
	} catch (Exception e) {
	}
	
	 
	 try(Connection c= DriverManager.getConnection(url,user,password)) {
			if(c!=null) {
				Statement s= c.createStatement();
				String b=" ALTER TABLE \"vz_cant\" ADD COLUMN \"id\" SERIAL;";
				s.executeQuery(b);;
	 		}
		} catch (Exception e) {
		}
	 
	 try(Connection c= DriverManager.getConnection(url,user,password)) {
			if(c!=null) {
				Statement s= c.createStatement();
				String z="ALTER TABLE \"stoc_detaliat\" ADD COLUMN \"id\" SERIAL;";
				s.executeQuery(z);;
	 		}
		} catch (Exception e) {
		}
 }
 
}
