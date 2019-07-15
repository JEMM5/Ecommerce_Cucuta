package com.cucecommerce.dao;

import java.util.List;

import com.cucecommerce.pojo.PymeEmpresa;
import com.cucecommerce.pojo.TProducto;

public interface TProductoDao {

	public void save(TProducto tProducto);
	
	public List<TProducto> findAllProductos();
	
	public List<TProducto> findProductosByPyme(PymeEmpresa pyme);
	
	
	public void deleteProducto(TProducto p);
	public void updateProducto(TProducto p);
	public TProducto findProductoByWebId(TProducto p);
	
}
