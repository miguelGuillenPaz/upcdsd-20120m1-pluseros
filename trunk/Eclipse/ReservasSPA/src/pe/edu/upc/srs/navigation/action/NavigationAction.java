/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.navigation.action;

import pe.edu.upc.srs.jms.JMSQueueSender;
import pe.edu.upc.srs.mail.MailDTO;
import pe.edu.upc.srs.util.UtilProperties;
import pe.edu.upc.srs.util.UtilWebServiceSPA;

import com.opensymphony.xwork2.ActionSupport;

public class NavigationAction extends ActionSupport{

	private static final long serialVersionUID = 3013386262446827287L;
	
	public String initLogin(){
		/*
		MailDTO objMailDTO = new MailDTO();
		
		objMailDTO.setStrAsunto("Registro de Reserva prueba nº1");
		objMailDTO.setStrPara("migue0503@gmail.com");
		objMailDTO.setStrMensaje("Mensaje de prueba de JMS");
		
		JMSQueueSender objJmsQueueSender = new JMSQueueSender();
		
				
		objJmsQueueSender.enviaMensaje(UtilWebServiceSPA.JMS_USER , 
										UtilWebServiceSPA.JMS_PASS  ,
										UtilWebServiceSPA.JMS_URL, 
										UtilWebServiceSPA.JMS_QUEUE_NAME, 
										objMailDTO);
		*/
		return SUCCESS;
	}
	
	public String welcome(){
		return SUCCESS;
	}
	
}
