package com.cucecommerce.controller;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cucecommerce.pojo.PymeEmpresa;
import com.cucecommerce.pojo.TProducto;
import com.cucecommerce.service.TProductoService;

@Controller
public class RegistroProductoController {
	
	//INYECTAR UN SERVICE
	@Autowired
	private TProductoService tProductoService;
	
	@RequestMapping(value="/registrarMisProductos/guardar", method=RequestMethod.POST)
	public String gestionarPymeEmpresa(Model model, RedirectAttributes ra, HttpServletRequest request) {
		//System.out.println("........." + pymeForm);
		//metodos para almacenar pyme

		recibirDatos(request);
		
		String nombreProd = request.getAttribute("nombreProd").toString();
		float precioProd = Float.parseFloat(request.getAttribute("precioProd").toString());
		int stockProd = Integer.parseInt(request.getAttribute("stockProd").toString());
		
		String descripcion = request.getAttribute("descripcion").toString();
		
		int idCategoria = Integer.parseInt(request.getAttribute("categoriaProd").toString());
		int idEmpresa = Integer.parseInt(request.getAttribute("EmpresaProd").toString());
		
//		String img1 = request.getAttribute("img1").toString();
//		String img2 = request.getAttribute("img2").toString();
//		String img3 = request.getAttribute("img3").toString();
//		String img4 = request.getAttribute("img4").toString();
//		String img5 = request.getAttribute("img5").toString();
		
		String img1 = (request.getAttribute("img1")==null)?"":request.getAttribute("img1").toString();
		String img2 = (request.getAttribute("img2")==null)?"":request.getAttribute("img2").toString();
		String img3 = (request.getAttribute("img3")==null)?"":request.getAttribute("img3").toString();
		String img4 = (request.getAttribute("img4")==null)?"":request.getAttribute("img4").toString();
		String img5 = (request.getAttribute("img5")==null)?"":request.getAttribute("img5").toString();
		boolean nuevo, recomendado, visible;
        
        try{
            nuevo = request.getAttribute("nuevo").toString().equalsIgnoreCase("on");
        }catch(Exception e){
            nuevo = false;
        }
        //
        try{
            recomendado = request.getAttribute("recomendado").toString().equalsIgnoreCase("on");
        }catch(Exception e){
            recomendado = false;
        }        
        
        try{
            visible = request.getAttribute("visible").toString().equalsIgnoreCase("on");
        }catch(Exception e){
            visible = false;
        }

        TProducto tproducto = new TProducto();
        tproducto.setNombre(nombreProd);
        tproducto.setPrecio(precioProd);
        tproducto.setStock(stockProd);
        tproducto.setNuevo(nuevo);
        tproducto.setRecomendado(recomendado);
        tproducto.setDescripcion(descripcion);
        tproducto.setVisible(visible);
        tproducto.setCodigo_cat(idCategoria);
        tproducto.setId_empresa(idEmpresa);
        tproducto.setImg1(img1);
        tproducto.setImg2(img2);
        tproducto.setImg3(img3);
        tproducto.setImg4(img4);
        tproducto.setImg5(img5);
        		
		//metodo para registrar
        tProductoService.save(tproducto);
		
		ra.addFlashAttribute("mensajeExitoso", "Producto insertado exitosamente.");
		return "redirect:/registrarMisProductos";
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
                    String ruta = request.getRequestURI().toString() + "foto/misProductos/";
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
