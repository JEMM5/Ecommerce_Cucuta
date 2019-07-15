package com.cucecommerce.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cucecommerce.pojo.PymeEmpresa;
import com.cucecommerce.pojo.TProducto;
import com.cucecommerce.service.PymeEmpresaService;
import com.cucecommerce.service.TProductoService;

//
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import prueba.cucecommerce.dao.TCategoriaDao;
import prueba.cucecommerce.pojo.TCategoria;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"mensaje","categorias","metodosCat","empresasAsociadas"})
public class IndexController {
	
	@Autowired
	private PymeEmpresaService pymeEmpresaService;
	
	@Autowired
	private TProductoService tProductoService;
	
	@RequestMapping("/")
	public String mostrarIndex(Model model) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		TCategoriaDao tCategoriaDao = (TCategoriaDao) applicationContext.getBean("tCategoriaDao");
		//todas las categorias y subcategorias juntas
		ArrayList<TCategoria> listaCategorias = tCategoriaDao.findAll();
		List<PymeEmpresa> listaEmpresas = pymeEmpresaService.findAll();
		
		List<TProducto> listaAllProductos = tProductoService.findAllProductos();
		model.addAttribute("allProductos", listaAllProductos);
//		for(PymeEmpresa e: listaEmpresas) {
//			System.out.println("-+-++-+-+" + e);
//		}
		
		//listaSubCategorias
		//List<TCategoria> listaSub = tCategoriaDao.findSubCategories();
		//int codigo = 0;
		model.addAttribute("mensaje", "Mensaje de Tipo Session con Spring");
		model.addAttribute("categorias", listaCategorias);
		model.addAttribute("metodosCat", tCategoriaDao);
		model.addAttribute("empresasAsociadas", listaEmpresas);
		
		model.addAttribute("pymeR", new PymeEmpresa());
		return "index";
	}
	
	//ACA CARGAN LOS ESTILOS
	

}
