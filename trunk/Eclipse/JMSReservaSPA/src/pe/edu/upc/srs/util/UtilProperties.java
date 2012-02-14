package pe.edu.upc.srs.util;

import java.util.ResourceBundle;
import java.text.MessageFormat;

/**
 * Descripción: Permite obtener información/mensajes de un archivo fichero. <p>
 * Ejemplo: <p>
 * pageContext.getOut().print(<b>UtilPropierties.getMessage(fichero, key, arg0, arg1, arg2, arg3)</b>); <p>
 * <br>
 * Donde 'fichero' es el nombre del archivo fichero, 'key' es la llave de una de los registros presentes 
 * en el archivo y los argumentos del mensaje.
 * <b>@PR</b> 628 
 * @author José Antonio Pinedo Flores 
 * @version 1.00 06/06/2006
 */
public class UtilProperties {
    /**
     * Recuperar el mensaje ubicado en la llave presente en el archivo fichero.
     * @param fichero Nombre del archivo fichero.
     * @param key Llave presente en el archivo fichero.
     * @param args Lista de argumentos a presentar en el mensaje.
     * @return Mensaje.
     */
    public static String getMessage(String fichero, String key, String [] args) {
        try {
            ResourceBundle res = ResourceBundle.getBundle(fichero);            
            MessageFormat format = new MessageFormat((String)res.getObject(key));
            return format.format(args);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Recuperar el mensaje ubicado en la llave presente en el archivo fichero.
     * @param fichero Nombre del archivo fichero.
     * @param key Llave presente en el archivo fichero.
     * @return Mensaje.
     */
    public static String getMessage(String fichero, String key) {
        return getMessage(fichero, key, (String [])null);
    }
    
    /**
     * Recuperar el mensaje ubicado en la llave presente en el archivo fichero.
     * @param fichero Nombre del archivo fichero.
     * @param key Llave presente en el archivo fichero.
     * @param arg0 Argumento a presentar en el mensaje.
     * @return Mensaje.
     */
    public static String getMessage(String fichero, String key, String arg0) {
        String [] args = new String [] {arg0};
        return getMessage(fichero, key, args);
    }
    
    /**
     * Recuperar el mensaje ubicado en la llave presente en el archivo fichero.
     * @param fichero Nombre del archivo fichero.
     * @param key Llave presente en el archivo fichero.
     * @param arg0 Primer argumento a presentar en el mensaje.
     * @param arg1 Segundo argumento a presentar en el mensaje.
     * @return Mensaje.
     */
    public static String getMessage(String fichero, String key, String arg0, String arg1) {
        String [] args = new String [] {arg0, arg1};
        return getMessage(fichero, key, args);
    }
    
    /**
     * Recuperar el mensaje ubicado en la llave presente en el archivo fichero.
     * @param fichero Nombre del archivo fichero.
     * @param key Llave presente en el archivo fichero.
     * @param arg0 Primer argumento a presentar en el mensaje.
     * @param arg1 Segundo argumento a presentar en el mensaje.
     * @param arg2 Tercer argumento a presentar en el mensaje.
     * @return Mensaje.
     */
    public static String getMessage(String fichero, String key, String arg0, String arg1, String arg2) {
        String [] args = new String [] {arg0, arg1, arg2};
        return getMessage(fichero, key, args);
    }
    
    /**
     * Recuperar el mensaje ubicado en la llave presente en el archivo fichero.
     * @param fichero Nombre del archivo fichero.
     * @param key Llave presente en el archivo fichero.
     * @param arg0 Primer argumento a presentar en el mensaje.
     * @param arg1 Segundo argumento a presentar en el mensaje.
     * @param arg2 Tercer argumento a presentar en el mensaje.
     * @param arg3 Cuarto argumento a presentar en el mensaje.
     * @return Mensaje.
     */
    public static String getMessage(String fichero, String key, String arg0, String arg1, String arg2, String arg3) {
        String [] args = new String [] {arg0, arg1, arg2, arg3};
        return getMessage(fichero, key, args);
    }    
}

