/**
 *@autor : Lizbeth Díaz 
 **/

package pe.edu.upc.srs.mantenimientos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pe.edu.upc.srs.mantenimiento.beans.ServicioDTO;
import pe.edu.upc.srs.mantenimiento.despachadores.MySqlServicio;

public class MantenimientoTest {

	public MySqlServicio servicio;

	@Before
	public void AntesDelTest() throws Exception {
		 /**  
		 * El metodo precedido por la etiqueta @Before  
		 * es para indicar a JUnit que debe ejecutarlo  
		 * antes de ejecutar los Tests que figuran en  
		 * esta clase.  
		 **/  

		int rpta =0;
		ServicioDTO serv = new ServicioDTO();
		serv.setId(1);
		serv.setDescripcion("prueba antes");
		rpta= servicio.RegistrarServicio(serv);
	}

	@After
	public void DespuesDeltest() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
		//
	}

}
