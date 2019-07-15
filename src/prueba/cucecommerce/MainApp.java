package prueba.cucecommerce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import prueba.cucecommerce.dao.TCategoriaDao;
import prueba.cucecommerce.pojo.TCategoria;

public class MainApp {

	public static void main(String args[]) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		
		TCategoriaDao tCategoriaDao = (TCategoriaDao) applicationContext.getBean("tCategoriaDao");
		
		TCategoria categoria = new TCategoria();
		categoria.setCodigo(8);
		categoria.setNombre("Otros");
		categoria.setVisible(true);
		categoria.setCategoria_superior(8);
		
		/*
		if(tCategoriaDao.save(categoria)) {
			System.out.println("Categoria añadida correctamente");
		}else {
			System.out.println("Error al insertar categoria");
		}*/
		try{
//			tCategoriaDao.save(categoria);
//			for(TCategoria tCategoria : tCategoriaDao.findAll()) {
//				System.out.println("** " + tCategoria);
//				
//				System.out.println("******" + tCategoriaDao.findAll().size());
//			}
//			
			TCategoria categoriaBuscar = new TCategoria();
			categoriaBuscar.setCodigo(2);
			
			for(TCategoria tCategoria : tCategoriaDao.findSubCategories(categoriaBuscar)) {
				System.out.println("** " + tCategoria);
			}
			
//			System.out.println("****" + tCategoriaDao.esSuperior(categoriaBuscar));
			
		}catch(CannotGetJdbcConnectionException ex){
			ex.printStackTrace();
		}catch(DataAccessException ex) {
			ex.printStackTrace();
		}
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
