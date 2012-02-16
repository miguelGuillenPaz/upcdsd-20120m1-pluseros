/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilMethod {

	public static String DIRECTORIO_SERVICIO = "images/servicios/";
	
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

	public static String getFechaActual(){
		Date dtFecha = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
		return formatter.format(dtFecha);  
	}
	
	public static String[] obtenerPartesDia(String strFecha){
		String[] lstFecha = new String[3];
		       
		lstFecha[0] = strFecha.substring(0, 2); 
		lstFecha[1] = strFecha.substring(3, 5);  
		lstFecha[2] = strFecha.substring(6, 10);
		
		return lstFecha;
	}
	
	public static String formateaFecha_ddMMyyyy(String strFecha,String strSeparador,String strFormato){
		
		String anio = strFecha.substring(0, strFecha.indexOf(strSeparador));

		strFecha = strFecha.substring(anio.length() + 1);
		String mes = strFecha.substring(0, strFecha.indexOf(strSeparador));

		strFecha = strFecha.substring(mes.length() + 1);
		String dia = strFecha;

		if (dia.length() == 1)
			dia = "0" + dia;
		if (mes.length() == 1)
			mes = "0" + mes;
		String strFechaFinal = dia + strFormato + mes + strFormato + anio;
		
		return strFechaFinal;
	}
	
	public static String grabaArchivoEnServidor(String strNombreArchivo,File flarchivo, String strRutaAplicacionWeb,String strDirectorioImagen) throws Exception {
		String strRutaAbsolutaArchivo = null;
 		String strRutaRelativaArchivo = null;

 		if (!strNombreArchivo.trim().equals("")) {
			File flArchivo = null;
			File flDirectorio = new File(strRutaAplicacionWeb +"/"+ strDirectorioImagen);
			
			if (!flDirectorio.exists()) {
				flDirectorio.mkdirs();
			}

			strRutaRelativaArchivo = strDirectorioImagen +strNombreArchivo;
			strRutaAbsolutaArchivo =strRutaAplicacionWeb + "/"+ strDirectorioImagen + strNombreArchivo;

			flArchivo = new File(strRutaAbsolutaArchivo);

			FileOutputStream fioSalida = 
					new FileOutputStream(flArchivo);
			 
			int intLeido = 0;
			byte[] bytbuffer = new byte[5000];
			InputStream entrada = new FileInputStream(flarchivo);
					
			while ((intLeido = entrada.read(bytbuffer,0,bytbuffer.length)) != -1){
				fioSalida.write(bytbuffer,0,intLeido);
			}
			
			entrada.close();
			fioSalida.close();

		}

		return strRutaRelativaArchivo;
	}
	
}
