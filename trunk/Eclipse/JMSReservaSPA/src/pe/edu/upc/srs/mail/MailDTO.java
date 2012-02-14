package pe.edu.upc.srs.mail;

import java.io.Serializable;

public class MailDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String strAsunto;
	private String strPara;
	private String strMensaje;
	
	public String getStrAsunto() {
		return strAsunto;
	}
	public void setStrAsunto(String strAsunto) {
		this.strAsunto = strAsunto;
	}
	public String getStrPara() {
		return strPara;
	}
	public void setStrPara(String strPara) {
		this.strPara = strPara;
	}
	public String getStrMensaje() {
		return strMensaje;
	}
	public void setStrMensaje(String strMensaje) {
		this.strMensaje = strMensaje;
	}
	
}
