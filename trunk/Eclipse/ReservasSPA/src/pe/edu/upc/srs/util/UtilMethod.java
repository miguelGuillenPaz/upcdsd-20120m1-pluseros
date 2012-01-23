/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.util;

public class UtilMethod {

	public static String formateaHora24(String strHora){
		String strHoraF = strHora;
		try {
			//int intHora = Integer.parseInt(strHora);
			strHoraF += ":00"; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strHoraF;
	}
	
}
