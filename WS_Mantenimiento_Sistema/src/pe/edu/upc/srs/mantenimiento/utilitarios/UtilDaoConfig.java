package pe.edu.upc.srs.mantenimiento.utilitarios;

import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;

import java.io.Reader;
import java.util.Properties;

public class UtilDaoConfig {
	private static final
	String recurso="pe/edu/upc/srs/mantenimiento/ibatis/dao.xml";
	
	private static final DaoManager daoManager;
	
	static{
		try{
			daoManager = newDaoManager(null);
			
		}catch (Exception e) {
			System.out.println("ERROR" + e.getMessage());
			throw new RuntimeException("Description. Cause: " + e, e);
		}
	}
	
	public static DaoManager obtenerDaoManager(){
		return daoManager;
		
	}
	
	private static DaoManager newDaoManager(Properties props){
		try{
			Reader reader = Resources.getResourceAsReader(recurso);
			DaoManager eldaoManager = DaoManagerBuilder.buildDaoManager(reader, props);
			
			return eldaoManager;
		}catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
			throw new RuntimeException("No se pudo inicializar DaoConfig. Motivo: " + e, e);
		}
	}
}
