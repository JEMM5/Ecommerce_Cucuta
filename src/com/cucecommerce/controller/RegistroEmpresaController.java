package com.cucecommerce.controller;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cucecommerce.pojo.PymeEmpresa;
import com.cucecommerce.service.PymeEmpresaService;


@Controller
@SessionAttributes("UsuarioValido")
public class RegistroEmpresaController {
	
	@Autowired
	private PymeEmpresaService pymeEmpresaService; //LO MISMO FALTA AGREGAR EL BEAN AL SPRING CONFIG
	
	@RequestMapping("/registroEmpresa")
	public String mostrarRegistroEmpresa(Model model) {
		PymeEmpresa pyme = new PymeEmpresa();
		model.addAttribute("pyme", pyme);
		return "registroEmpSena";
	}
	
	@RequestMapping(value="/registroEmpresa/guardar", method=RequestMethod.POST)
	public String gestionarPymeEmpresa(@ModelAttribute("pyme") PymeEmpresa pymeForm, 
										Model model, RedirectAttributes ra, HttpServletRequest request) {
		//System.out.println("........." + pymeForm);
		//metodos para almacenar pyme

		recibirDatos(request);
		String razonSocial = request.getAttribute("razonSocial").toString();
		String nombreEmpresario = request.getAttribute("nombreEmpresario").toString();
		String logo = request.getAttribute("logo").toString();
		String email = request.getAttribute("email").toString();
		String celular = request.getAttribute("celular").toString();
		String usuario = request.getAttribute("usuario").toString();
		String contrasena = request.getAttribute("contrasena").toString();
		String codigo = request.getAttribute("codigo").toString();

		//asignar los valores al objeto
		PymeEmpresa emp = new PymeEmpresa();
		emp.setRazonSocial(razonSocial);
		emp.setNombreEmpresario(nombreEmpresario);
		emp.setLogoEmpresa(logo);
		emp.setEmail(email);
		emp.setCelular(celular);
		emp.setUsuario(usuario);
		emp.setContrasena(contrasena);
		emp.setCodigo_asignado(codigo);
		
		emp.setPermiso("ROLE_USER");
		emp.setFechaCreacion(new Timestamp(new Date().getTime()));
		
		
		
		//metodo para registrar
		pymeEmpresaService.save(emp);
		
		ra.addFlashAttribute("mensajeRegistro", "Gracias y Bienvenido a nuestra Plataforma.");
		return "redirect:/registroEmpresa";
	}
	
    private void recibirDatos(HttpServletRequest request){
        try {
            FileItemFactory fileFactory = new DiskFileItemFactory();
            ServletFileUpload servletUpload = new ServletFileUpload(fileFactory);
        
            String nombre = "";
            List items = servletUpload.parseRequest(request);
            for(int i=0;i<items.size();i++){
                FileItem item = (FileItem) items.get(i);
                if(!item.isFormField()){
//                    String ruta = request.getServletContext().getRealPath("/")+"foto/";
//                    String ruta = request.getServletContext().getRealPath("/")+"foto/";
                    String ruta = request.getRequestURI().toString() + "foto/";
                    System.out.println(ruta);
                    //System.out.println("-{{{{-----   " + request.getServletContext().getAttribute("javax.servlet.context.tempdir"));
                	//String ruta = "C:/IMAGES/foto";
//DEPOSITO DE FOTOS - ruta
//Ecommerce_Cucuta/registroEmpresa/guardarfoto/ <--- /guardar + "foto"
                    SimpleDateFormat sdf = new SimpleDateFormat("ddMyyyyhhss");
                    String fecha = sdf.format(new Date());
                    // no acepta items con tildes imagenes
                    nombre = fecha+ new Random().nextLong() + item.getName();
                    String nuevonombre = ruta + nombre;
                    File folder = new File(ruta);
                    if(!folder.exists()){
                        folder.mkdirs();
                    }
                    File imagen = new File(nuevonombre);
                    if(item.getContentType().contains("image")){
                        item.write(imagen);
                        request.setAttribute(item.getFieldName(), nombre);                     
                    }                    
                }else{
                    request.setAttribute(item.getFieldName(), item.getString());
                }
            }
        } catch (FileUploadException ex) {
            request.setAttribute("subida", false);
        } catch (Exception ex) {
            request.setAttribute("subida", false);
        }        
    }    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    

}
