/**
 * 
 */
package pe.edu.upc.srs.gestion.servicios.servicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

/**
 * @author Smart.jar
 *
 */
public class TestRESTService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HttpClient clienteHttp= new DefaultHttpClient();
		HttpPost post = new HttpPost("http://localhost:1838/Usuarios.svc/Login");
			
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("usuario", "aroncalla"));
			nameValuePairs.add(new BasicNameValuePair("clave", "aroncalla"));

			post.addHeader("Content", "aroncalla");
			post.addHeader("clave", "aroncalla");
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = clienteHttp.execute(post);
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			String linea = "";
			while((linea = reader.readLine()) != null){
				System.out.println(linea);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
