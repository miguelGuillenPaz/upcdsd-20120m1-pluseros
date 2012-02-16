package pe.edu.upc.srs.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import pe.edu.upc.srs.mail.JMail;
import pe.edu.upc.srs.mail.MailDTO;
import pe.edu.upc.srs.util.UtilJMS;

public class JMSQueueConsumer implements MessageListener {

	ActiveMQConnectionFactory objConnectionFactory = new ActiveMQConnectionFactory("system", "manager", "tcp://localhost:61616");
    private final Connection objConnection    ;
    private final Session objSession;
    private final MessageConsumer objMessageConsumer;
	
    JMSQueueConsumer(String cola) throws JMSException {
    	
    	UtilJMS.cargarVariablesProperties();
    	
    	objConnection = objConnectionFactory.createConnection();
    	objConnection.start();
    	objSession = objConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = objSession.createQueue(cola);
        objMessageConsumer = objSession.createConsumer(destination);
        objMessageConsumer.setMessageListener(this);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			new JMSQueueConsumer("ReservaQueue");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onMessage(Message objMessage) {
		try {
            ObjectMessage objOMessage = (ObjectMessage) objMessage;;
			
            MailDTO objMailDTO = (MailDTO) objOMessage.getObject();
            
            JMail.enviarMensaje(objMailDTO);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

}
