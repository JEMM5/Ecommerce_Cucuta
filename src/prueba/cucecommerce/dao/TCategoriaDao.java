package prueba.cucecommerce.dao;

import java.util.List;
import java.util.ArrayList;
import prueba.cucecommerce.pojo.TCategoria;

public interface TCategoriaDao {
	
	public boolean save(TCategoria tCategoria);
	public ArrayList<TCategoria> findAll();
	public List<TCategoria> findCategories();
	public List<TCategoria> findSubCategories(TCategoria tCategoria);
	public boolean esSuperior(TCategoria tCategoria);
}
