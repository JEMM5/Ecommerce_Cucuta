package com.cucecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cucecommerce.dao.TProductoDao;
import com.cucecommerce.pojo.PymeEmpresa;
import com.cucecommerce.pojo.TProducto;


@Service
public class TProductoService {
	
	@Autowired
	private TProductoDao tProductoDao;

	public void save(TProducto tProducto){		
		tProductoDao.save(tProducto);
	}	
	
	public List<TProducto> findAllProductos(){
		return tProductoDao.findAllProductos();
	}
	
	public List<TProducto> findProductosByPyme(PymeEmpresa pyme){
		return tProductoDao.findProductosByPyme(pyme);
	}
	
	public void deleteProducto(TProducto p){
		tProductoDao.deleteProducto(p);
	}
	
	public void updateProducto(TProducto p){
		tProductoDao.updateProducto(p);
	}
	
	public TProducto findProductoByWebId(TProducto p) {
		return tProductoDao.findProductoByWebId(p);
	}
}
