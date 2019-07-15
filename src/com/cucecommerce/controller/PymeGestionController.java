package com.cucecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cucecommerce.pojo.PymeEmpresa;
import com.cucecommerce.pojo.TProducto;
import com.cucecommerce.service.PymeEmpresaService;
import com.cucecommerce.service.TProductoService;

import prueba.cucecommerce.dao.TCategoriaDao;
import prueba.cucecommerce.pojo.TCategoria;

@Controller
@SessionAttributes({"UsuarioValido","pymeEmpRecuperada"})
public class PymeGestionController {
	
	@Autowired
	private PymeEmpresaService pymeEmpresaService; //LO MISMO FALTA AGREGAR EL BEAN AL SPRING CONFIG
	
	@Autowired
	private TProductoService tProductoService;

    //LA VALIDACION DE USUARIO AL HACER LOGIN
    @RequestMapping(value="/validarEmpresa", method=RequestMethod.POST)
    public String validarPymeEmpresa(@ModelAttribute("pyme") PymeEmpresa pymeForm, Model model, HttpServletRequest request){
    	PymeEmpresa pe = new PymeEmpresa();
    	pe.setEmail(request.getParameter("email"));
    	pe.setContrasena(request.getParameter("psw"));
    	
    	PymeEmpresa pymeValidada = pymeEmpresaService.validateEmpresa(pe);
    	
    	if(pymeValidada == null){
    		model.addAttribute("mensajeNoValido","Usuario o Contraseña Incorrecta");
    		return "index";
    	}else{
    		model.addAttribute("UsuarioValido", pymeValidada);
    	}
    	
    	return "miCuenta";
    }
    
    /*
     * LOGIN DE SEGURIDAD
     */
    @RequestMapping("/admin")
    public String ingresarSecurity(Model model){
//    	String usuario = (String) request.getSession().getAttribute("principal");
//    	System.out.println("----------   --------" + usuario);
    	String username;
    	//recuperar el login actual
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if (principal instanceof UserDetails) {
    	  username = ((UserDetails)principal).getUsername();
    	} else {
    	  username = principal.toString();
    	}
    	PymeEmpresa pe = new PymeEmpresa();
    	//Buscar por nombre de usuario
    	PymeEmpresa pymeValidada = pymeEmpresaService.searchByUsuario(username);
//    	
//    	pymeEmpresaService.searchByRazonSocial(pymeSearch);
//    	
//    	pe.setRazonSocial(username);
//    	pe.setCelular("celular1");
//    	pe.setEmail("correo@1.com");
//    	pe.setNombreEmpresario("empresario 1");
//    	pe.setLogoEmpresa("01720190945121654796486660155713.png");

    	
    	model.addAttribute("UsuarioValido", pymeValidada);
    	return "miCuenta";
    }    
    
    /*
     * FIN DEL LOGIN DE SEGURIDAD
     */

    //PASAR A UN NUEVO CONTROLLER
    //
    @RequestMapping("/misProductos")
    public String verMisProductos(Model model, HttpServletRequest req){
    	
    	int id_emp_sesion = ((PymeEmpresa) req.getSession().getAttribute("UsuarioValido")).getIdEmpresa();
    	PymeEmpresa pymeSearch = new PymeEmpresa();
    	pymeSearch.setIdEmpresa(id_emp_sesion);
//    	System.out.println("-+-+-++-+**" + id_emp_sesion);
    	
    	List<TProducto> ProductosByPyme = tProductoService.findProductosByPyme(pymeSearch);
    	/**
    	 * FALLA ACORDARSE -- LOS PRODUCTOS DEBEN FILTRARSE POR ID EMPRESA X EJ
    	 */
    	model.addAttribute("productosByPyme", ProductosByPyme);
//    	model.addAttribute("mensajerandom", "Aqi su mensaje");
    	return "/misProductos";
    }
    
    //
    @RequestMapping("/registrarMisProductos")
    public String registrarProductos(Model model){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		TCategoriaDao tCategoriaDao = (TCategoriaDao) applicationContext.getBean("tCategoriaDao");
		
		ArrayList<TCategoria> listaCategorias = tCategoriaDao.findAll();
		model.addAttribute("categorias", listaCategorias);
		
		TProducto producto = new TProducto();
		model.addAttribute("producto", producto);
    	return "/registrarProducto";
    }    
    
    //CERRAR SESION
    @RequestMapping("/cerrarSesion")
    public String closeSessionPymeEmpresa(Model model){
    	model.addAttribute("UsuarioValido", null);
    	return "/";
    }
    

    
    //MOSTRAR EL APARTADO/TIENDA DE CADA EMPRESA
    @RequestMapping("/{razonSocial}")
    public String mostrarTiendaPyme(Model model, @PathVariable("razonSocial") String razonSocial) {
    	PymeEmpresa pymeRecuperar = new PymeEmpresa();
    	pymeRecuperar.setRazonSocial(razonSocial);
//    	System.out.println("-----------------------------------------");
//    	System.out.println("******" + pymeRecuperar.getRazonSocial());
//    	System.out.println("-----------------------------------------");
    	pymeRecuperar = pymeEmpresaService.searchByRazonSocial(pymeRecuperar);
//    	System.out.println("-----------------------------------------");
//    	System.out.println("******" + pymeRecuperar.getRazonSocial());
//    	System.out.println("-----------------------------------------");
    	
    	List<TProducto> ProductosByPyme = tProductoService.findProductosByPyme(pymeRecuperar);
    	/**
    	 * FALLA ACORDARSE -- LOS PRODUCTOS DEBEN FILTRARSE POR ID EMPRESA X EJ
    	 */
    	model.addAttribute("productosByPyme", ProductosByPyme);
    	model.addAttribute("pymeEmpRecuperada", pymeRecuperar);
    	return "/publico/indexPyme";
    }	
}
