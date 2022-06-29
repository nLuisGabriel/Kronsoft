package ro.kronsoft.farmacie.exceptions;

import java.time.LocalDate;

public class ErrorDetails {
	private LocalDate timestamp= LocalDate.now();
    private String message;
    private String details;

    public ErrorDetails(String message, String details) {
         this.message = message;
         this.details = details;
    }

    public LocalDate getTimestamp() {
         return timestamp;
    }

    public String getMessage() {
         return message;
    }

    public String getDetails() {
         return details;
    }
}
