package com.cucecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cucecommerce.dao.PymeEmpresaDao;
import com.cucecommerce.pojo.PymeEmpresa;

@Service
public class PymeEmpresaService {
	
	@Autowired
	private PymeEmpresaDao pymeEmpresaDao;	//falta colocarla en el archivo de configuracion o la otra opcion
	
	public void save(PymeEmpresa pymeEmpresa){
		pymeEmpresaDao.save(pymeEmpresa);
	}
	
	public List<PymeEmpresa> findAll(){
		return pymeEmpresaDao.findAll();
		//return null;
	}
	
	public PymeEmpresa validateEmpresa(PymeEmpresa p){
//		PymeEmpresa p = new PymeEmpresa();
//		p.setEmail(email);
//		p.setContrasena(contrasena);
		return pymeEmpresaDao.validateEmpresa(p);
	}
	
	public PymeEmpresa searchByRazonSocial(PymeEmpresa pymeSearch){
		return pymeEmpresaDao.searchByRazonSocial(pymeSearch);
	}
	
	public PymeEmpresa searchByUsuario(String usuario){
		return pymeEmpresaDao.findByUserName(usuario);
	}
	

}
