package pe.edu.upc.srs.mail;
/**
 * @author Christian Arias
 */
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pe.edu.upc.srs.util.UtilJMS;

public class JMail{
    
    public static void main(String[] args)    {
      System.out.println("entro en el EnviarMail");
    }
    
    public static boolean enviarMensaje(MailDTO objMailDTO){
	   try{
		  // Propiedades de la conexión
          Properties props = new Properties();
          props.setProperty("mail.smtp.host",UtilJMS.MAIL_SMTP_HOST);
          props.setProperty("mail.smtp.starttls.enable", UtilJMS.MAIL_SMTP_STARTTLS_ENABLE);
          props.setProperty("mail.smtp.port", UtilJMS.MAIL_SMTP_PORT);
          props.setProperty("mail.smtp.user", UtilJMS.MAIL_SMTP_USER);
          props.setProperty("mail.smtp.auth", UtilJMS.MAIL_SMTP_AUTH);

          Session session = Session.getDefaultInstance(props);

          MimeMessage message = new MimeMessage(session);
          message.setFrom(new InternetAddress(UtilJMS.MAIL_SMTP_USER));
          message.addRecipient(Message.RecipientType.TO,new InternetAddress(objMailDTO.getStrPara()));
          //message.addRecipient(Message.RecipientType.CC ,new InternetAddress(UtilJMS.MAIL_SMTP_USER_CC));
        
          message.setSubject(objMailDTO.getStrAsunto());
          message.setSentDate(new Date());
          message.setContent(formateaCorreo(objMailDTO.getStrMensaje()),"text/html");
                    
          Transport sender = session.getTransport("smtp");
          sender.connect(UtilJMS.MAIL_SMTP_HOST,UtilJMS.MAIL_SMTP_USER , UtilJMS.MAIL_SMTP_USER_PASS);
          sender.sendMessage(message , message.getAllRecipients());

          sender.close();
          return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    private static String formateaCorreo(String mensaje){
    	String correo = 
    	"<html>"+
    	"<head>"+
    	"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"+
    	"<title></title>"+
    	"<style type=\"text/css\">"+
    	"<!--"+
    	"htm,body {font-family: Verdana;background: #FFFFFF;font-size: 10px;color: #000000;}"+
    	".texto_contenido {font-family: Verdana;font-size: 11.5px;color: #666666;}"+
    	".nota {font-family: Verdana;font-size: 9px;color: #646464;}"+
    	".notaAceptacion {font-family: Verdana;font-size: 9px;color: #FFC833;}"+
    	".notaMedioAmbiente {font-family: Verdana;font-size: 9px;color: #008000;font-weight: bold;}"+
    	".texto_cuerpo {font-family: Verdana;font-size: 10.5px;}"+
    	".texto_titulo {font-family: Verdana;font-size: 13px;font-weight: bold;}"+
    	".numDoc {font-family: Verdana;color: #3B5998;font-size: 13px;font-weight: bold;}"+
    	".linkWBS {	font-family: Verdana;font-size: 9px;color: #FF5800;}"+
    	"a:hover {font-family: Verdana;color: #666666;text-decoration: underline;}"+
    	"a:link,a:visited,a:active {font-family: Verdana;color: #666666;text-decoration: none;}-->"+
    	"</style>"+
    	"</head>"+
    	"<body>"+
    	"<br>"+
    	"<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"+
    	"	<tr>"+
    	"		<td height=\"20\"></td>"+
    	"	</tr>"+
    	"	<tr>"+
    	"		<td align=\"center\">"+
    	"		<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"540\""+
    	"			style=\"border: 1px solid #8F8F8F\">"+
    	"			<tr>"+
    	"				<td height=\"70\" align=\"center\" id=\"cabecera_popup\">"+
    	"				<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
    	"					<tr>"+
    	"						<td width=\"500\"><img"+
    	"							src=\"http://sites.google.com/site/serveralder/Home/logo_spa.gif\">&nbsp;&nbsp;</td>"+
    	"					</tr>"+
    	"				</table>"+
    	"				</td>"+
    	"			</tr>"+
    	"			<tr>"+
    	"				<td height=\"3\" style=\"background-color: #3B5998\"></td>"+
    	"			</tr>"+
    	"			<tr>"+
    	"				<td height=\"20\" style=\"background-color: #627AAD\"></td>"+
    	"			</tr>"+
    	"			<tr>"+
    	"				<td align=\"center\">"+
    	"				<table width=\"500\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"+
    	"					<tr>"+
    	"						<td height=\"30\" align=\"center\">"+
    	"						<table width=\"460\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\""+
    	"							class=\"texto_contenido\">"+
    	"							<tr>"+
    	"								<td width=\"460\">&nbsp;</td>"+
    	"							</tr>"+
    	"							<tr>"+
    	"								<td height=\"20\">"+mensaje+
    	"								</td>"+
    	"							</tr>"+
    	"							<tr>"+
    	"								<td></td>"+
    	"							</tr>"+
    	"							<tr>"+
    	"								<td height=\"4\"></td>"+
    	"							</tr>"+
    	"						</table>"+
    	"						</td>"+
    	"					</tr>"+
    	"					<tr>"+
    	"						<!-- comienzo del pie de pagina -->"+
    	"						<td height=\"26\" class=\"nota\">"+
    	"						<div align=\"center\">Este e-mail ha sido enviado"+
    	"						automáticamente desde un sistema de mensajería.</div>"+
    	"						</td>"+
    	"						<!-- fin del pie de pagina -->"+
    	"					</tr>"+
    	"					<tr>"+
    	"						<td height=\"26\" class=\"nota\">"+
    	"						<div align=\"center\" class=\"notaMedioAmbiente\"><img"+
    	"							src=\"http://sites.google.com/site/serveralder/Home/save_planet_2.png\">"+
    	"						&nbsp;\"Antes de imprimir este mensaje, asegúrese de que es"+
    	"						necesario.<br> El medio ambiente está en nuestras manos\"</div>"+
    	"						</td>"+
    	"					</tr>"+
    	"					<tr>"+
    	"						<td height=\"26\" align=\"center\"><span class=\"nota\">Copyright"+
    	"						&copy; 2012, Elisa's SPA- </span><span class=\"linkWBS\">"+UtilJMS.MAIL_SMTP_USER+"</span></td>"+
    	"					</tr>"+
    	"				</table>"+
    	"				</td>"+
    	"			</tr>"+
    	"			<tr>"+
    	"				<td height=\"30\"></td>"+
    	"			</tr>"+
    	"		</table>"+
    	"		</td>"+
    	"	</tr>"+
    	"	<tr>"+
    	"		<td height=\"20\"></td>"+
    	"	</tr>"+
    	"</table>"+
    	"</body>"+
    	"</html>";
    	
    	return correo;
    }    
}
    