/**
 *@autor : Lizbeth Díaz 
 **/

package pe.edu.upc.srs.alltests;

import org.junit.runner.RunWith;   
import org.junit.runners.Suite.SuiteClasses;   
import org.junit.runners.Suite;

import pe.edu.upc.srs.mantenimientos.GestionServicios;
import pe.edu.upc.srs.mantenimientos.MantenimientoTest;
import pe.edu.upc.srs.mantenimientos.ReservaTest;

@RunWith(Suite.class)   
@SuiteClasses({MantenimientoTest.class,ReservaTest.class,GestionServicios.class}) 

public class Test {}
