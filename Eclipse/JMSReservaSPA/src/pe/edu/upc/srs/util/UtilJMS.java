package pe.edu.upc.srs.util;

public class UtilJMS {

	public static String MAIL_SMTP_HOST;
	public static String MAIL_SMTP_STARTTLS_ENABLE;
	public static String MAIL_SMTP_PORT;
	public static String MAIL_SMTP_USER;
	public static String MAIL_SMTP_AUTH;
	public static String MAIL_SMTP_USER_PASS;
	public static String MAIL_SMTP_USER_CC;
	private static String fichero = "pe.edu.upc.srs.properties.variables";

	public static void cargarVariablesProperties(){
		
		String key = "MAIL_SMTP_HOST";
		MAIL_SMTP_HOST = UtilProperties.getMessage(fichero, key);
		
		key = "MAIL_SMTP_STARTTLS_ENABLE";
		MAIL_SMTP_STARTTLS_ENABLE = UtilProperties.getMessage(fichero, key);
		
		key = "MAIL_SMTP_PORT";
		MAIL_SMTP_PORT = UtilProperties.getMessage(fichero, key);
		
		key = "MAIL_SMTP_USER";
		MAIL_SMTP_USER = UtilProperties.getMessage(fichero, key);
		
		key = "MAIL_SMTP_USER_PASS";
		MAIL_SMTP_USER_PASS = UtilProperties.getMessage(fichero, key);
		
		key = "MAIL_SMTP_AUTH";
		MAIL_SMTP_AUTH = UtilProperties.getMessage(fichero, key);
		
		key = "MAIL_SMTP_USER_CC";
		MAIL_SMTP_USER_CC = UtilProperties.getMessage(fichero, key);
	}
	
}
