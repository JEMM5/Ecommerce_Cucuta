package com.cucecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cucecommerce.pojo.PymeEmpresa;

@Transactional
@Repository
public class PymeEmpresaDaoImpl implements PymeEmpresaDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void save(PymeEmpresa pyme) {
		getSession().save(pyme);
		
	}

	@SuppressWarnings("unchecked")
	public List<PymeEmpresa> findAll() {
		Query query = getSession().createQuery("FROM PymeEmpresa");

		return query.list();
	}
	
	public PymeEmpresa validateEmpresa(PymeEmpresa pyme){
		Query query = getSession().createQuery("FROM PymeEmpresa AS pe WHERE pe.email LIKE ? AND pe.contrasena LIKE ?");
		query.setString(0, pyme.getEmail());
		query.setString(1, pyme.getContrasena());
		return (PymeEmpresa)query.uniqueResult();
	}

	public PymeEmpresa searchByRazonSocial(PymeEmpresa pyme){
		Query query = getSession().createQuery("FROM PymeEmpresa AS pe WHERE pe.razonSocial LIKE ?");
		query.setString(0, pyme.getRazonSocial());
		return (PymeEmpresa)query.uniqueResult();
//		return null;
	}
	
	//SECURITY
	public PymeEmpresa findByUserName(String usuario){
		Criteria crit = getSession().createCriteria(PymeEmpresa.class)
				.add(Restrictions.eq("usuario", usuario));
		return (PymeEmpresa) crit.uniqueResult();
	}
}
