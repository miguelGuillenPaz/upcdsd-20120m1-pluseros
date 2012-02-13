/**
 * @author Christian Arias
 * @version 1.0
 */
package pe.edu.upc.srs.util.cifrado;

import java.security.MessageDigest;
public class Sha1 {    
		
	public static void main(String[] args) {
		System.out.println(getHash("alderfg")); 
	}
	
	public static String getHash(String message){        
		MessageDigest md;
		byte[] buffer;
		byte[] digest;
		StringBuffer hash = new StringBuffer();
		
		try {
				buffer = message.getBytes("UTF-8");
				md = MessageDigest.getInstance("SHA1");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}        
			md.update(buffer);        
			digest = md.digest();        
			
			for(byte aux : digest) {            
				int b = aux & 0xff;        
				String s = Integer.toHexString(b);        
				if (s.length() == 1) hash.append("0");        
				hash.append(s);
			}				
			return hash.toString();
	}		
}