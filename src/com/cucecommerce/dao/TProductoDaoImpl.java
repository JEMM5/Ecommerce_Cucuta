package com.cucecommerce.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cucecommerce.pojo.PymeEmpresa;
import com.cucecommerce.pojo.TProducto;

@Transactional
@Repository
public class TProductoDaoImpl implements TProductoDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void save(TProducto tProducto) {
		getSession().save(tProducto);
	}
	
	@SuppressWarnings("unchecked")
	public List<TProducto> findAllProductos(){
		Query query = getSession().createQuery("FROM TProducto");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<TProducto> findProductosByPyme(PymeEmpresa pyme){
		Query query = getSession().createQuery("FROM TProducto AS tp WHERE tp.id_empresa LIKE ?");
		query.setInteger(0, pyme.getIdEmpresa());
		return query.list();
	}	

	public void deleteProducto(TProducto p){
		Query query = getSession().createQuery("DELETE TProducto WHERE webid =:webid");
		query.setParameter("webid", p.getWebid());
		query.executeUpdate();
	}
	public void updateProducto(TProducto p){
		//INVESTIGAR
		getSession().merge(p);
//		Query query = getSession().createQuery("UPDATE TProducto tp SET tp.nombre=? "
//				+ ", tp.precio=? , tp.stock=? , tp.nuevo=? , tp.recomendado=? "
//				+ ", tp.descripcion , tp.visible=? , codigo_cart=? , id_empresa=? "
//				+ ", tp.img1=? , tp.img2=? , tp.img3=? , tp.img4=? , tp.img5=? "
//				+ "WHERE webid=?");
//		query.setParameter(0, p.getNombre());
//		query.setParameter(1, p.getPrecio());
//		query.setParameter(2, p.getStock());
//		query.setParameter(3, p.isNuevo());
//		query.setParameter(4, p.isRecomendado());
//		query.setParameter(5, p.getDescripcion());
//		query.setParameter(7, p.isVisible());
//		query.setParameter(8, p.getCodigo_cat());
//		query.setParameter(9, p.getId_empresa());
//		query.setParameter(10, p.getImg1());
//		query.setParameter(11, p.getImg2());
//		query.setParameter(12, p.getImg3());
//		query.setParameter(13, p.getImg4());
//		query.setParameter(14, p.getImg5());
//		
//		query.setParameter(15, p.getWebid());
//		
//		query.executeUpdate();
	}
	
	public TProducto findProductoByWebId(TProducto p){
		Query query = getSession().createQuery("FROM TProducto AS tb WHERE tb.webid = ?");
		query.setInteger(0, p.getWebid());
		
		return (TProducto) query.uniqueResult();
	}
}
