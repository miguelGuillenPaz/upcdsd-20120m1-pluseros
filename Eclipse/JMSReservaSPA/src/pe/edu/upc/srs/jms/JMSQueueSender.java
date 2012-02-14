package pe.edu.upc.srs.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;

import pe.edu.upc.srs.mail.MailDTO;

public class JMSQueueSender {

	/**
	 * @param args
	 */
	private Connection objConnection;
	private ActiveMQConnectionFactory  objConnectionFactory;

	public boolean enviaMensaje(String strUser, String strPass, String strURL, String strQueueName, MailDTO objMailDTO) {
	        boolean retorno = false;
	        try {
	            objConnectionFactory = new ActiveMQConnectionFactory(strUser, strPass, strURL);
	            objConnection = objConnectionFactory.createConnection();
	            objConnection.start();
	            
	            Session objSession = objConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	            
	            Destination objDestination = objSession.createQueue(strQueueName);
	            MessageProducer objProducer = objSession.createProducer(objDestination);
	            //TextMessage message = objSession.createTextMessage(strMensaje);
	            ObjectMessage objOMessage = objSession.createObjectMessage(objMailDTO);
	            objProducer.send(objOMessage);
	            objProducer.close();
	            objSession.close();
	            objConnection.close();
	            retorno = true;
	        } catch (Exception ex) {
	            retorno = false;
	            ex.printStackTrace();
	        }
	        return retorno;
	    }
	
}
