package com.cucecommerce.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cucecommerce.dao.PymeEmpresaDao;
import com.cucecommerce.pojo.PymeEmpresa;



@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private PymeEmpresaDao pymeEmpresaDao;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		PymeEmpresa pyme = pymeEmpresaDao.findByUserName(username);
		
		
		if(pyme != null){
			authorities.add(new SimpleGrantedAuthority(pyme.getPermiso()));
			//el user de srping q va a reemplazar al de x defecto
			User user = new User(pyme.getUsuario(), pyme.getContrasena(), authorities);
			return user;
		}else{
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
	}

}
