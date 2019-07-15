package com.cucecommerce.controller;

import java.io.File;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cucecommerce.pojo.TProducto;
import com.cucecommerce.service.TProductoService;

@Controller
public class TProductoGestionController {
	
	@Autowired
	private TProductoService tProductoService;
	
    @RequestMapping("/eliminarProducto")
    public String eliminarProducto(Model model, HttpServletRequest request){
    	TProducto prod = new TProducto();
    	prod.setWebid(Integer.parseInt(request.getParameter("webid")));
    	
    	tProductoService.deleteProducto(prod);
    	return "redirect:/misProductos";
    }

//    @RequestMapping("/modificarProducto/{webid}")
    @RequestMapping("/modProducto")
    public String exponerProducto(Model model, HttpServletRequest req){
    	
    	TProducto p = new TProducto();
    	p.setWebid(Integer.parseInt(req.getParameter("webid")));
    	p = tProductoService.findProductoByWebId(p);
    	
    	model.addAttribute("productoMod", p);
//    	System.out.println("AQUI ENTRO +++++++" + webid);
    	
//    	TProducto prod = new TProducto();
//    	prod.setWebid(Integer.parseInt(request.getParameter("webid")));
//    	
//    	tProductoService.deleteProducto(prod);
    	return "modificarProducto";
    }
    
    @RequestMapping(value="/modificarProducto/guardar", method=RequestMethod.POST)
    public String modificarProducto(Model model, HttpServletRequest request){
    	
		recibirDatos(request);
		
		int webid = Integer.parseInt(request.getAttribute("webid").toString());
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
		
		String img1 = (request.getAttribute("img1")==null)?request.getAttribute("imagen1").toString():request.getAttribute("img1").toString();
		String img2 = (request.getAttribute("img2")==null)?request.getAttribute("imagen2").toString():request.getAttribute("img2").toString();
		String img3 = (request.getAttribute("img3")==null)?request.getAttribute("imagen3").toString():request.getAttribute("img3").toString();
		String img4 = (request.getAttribute("img4")==null)?request.getAttribute("imagen4").toString():request.getAttribute("img4").toString();
		String img5 = (request.getAttribute("img5")==null)?request.getAttribute("imagen5").toString():request.getAttribute("img5").toString();
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
        tproducto.setWebid(webid);
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
        tProductoService.updateProducto(tproducto);
		
		//ra.addFlashAttribute("mensajeExitoso", "Producto insertado exitosamente.");
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
//                    String ruta = request.getRequestURI().toString() + "foto/misProductos/";
                	//RUTA EN CODIGO DURO
                	String ruta= "/Ecommerce_Cucuta/registrarMisProductos/guardarfoto/misProductos/";
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
