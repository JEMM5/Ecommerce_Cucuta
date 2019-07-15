package com.cucecommerce.dao;
import java.util.List;

import com.cucecommerce.pojo.PymeEmpresa;

public interface PymeEmpresaDao {
	
	public void save(PymeEmpresa pyme);
	public List<PymeEmpresa> findAll();
	
	public PymeEmpresa validateEmpresa(PymeEmpresa pyme);
	
	public PymeEmpresa searchByRazonSocial(PymeEmpresa pyme);
	
	//
	public PymeEmpresa findByUserName(String usuario);

}
