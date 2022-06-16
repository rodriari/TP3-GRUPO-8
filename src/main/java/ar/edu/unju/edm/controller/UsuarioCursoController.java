package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.model.UsuarioCurso;
import ar.edu.unju.edm.service.ICursoService;
import ar.edu.unju.edm.service.IUsuarioCursoService;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class UsuarioCursoController {
	private static final Log GRUPO8 = LogFactory.getLog(UsuarioController.class);
	
	@Autowired 
	IUsuarioCursoService usuariocursoservice;
	
	@Autowired
	IUsuarioService usuarioservice;
	
	@Autowired
	ICursoService cursoservice;
	
	@GetMapping({"/inscripcion"})	
	public ModelAndView addInscripcion() {
		GRUPO8.info("ingresando al metodo: Nuevo usuario");
		ModelAndView vista = new ModelAndView("cargarInscripcion");
		vista.addObject("usuariocurso", usuariocursoservice.nuevoUsuarioCurso() );
		vista.addObject("usuarios", usuarioservice.listarUsuarios() );
		vista.addObject("cursos", cursoservice.listarCursos() );
		vista.addObject("editMode",false);
		return vista;
	}
	@PostMapping("/guardarInscripcion")
	public ModelAndView saveInscripcion(@Valid @ModelAttribute ("usuariocurso") UsuarioCurso inscripcionparaguardar, BindingResult result) {
		ModelAndView vista=new ModelAndView ();
		if(result.hasErrors()) {
			GRUPO8.fatal("Error de validacion");
			vista.addObject("usuariocurso", inscripcionparaguardar);
			vista.addObject("editMode", false);
			vista.setViewName("cargarInscripcion");
			return vista;
		}
			try {
				usuariocursoservice.guardarUsuarioCurso(inscripcionparaguardar);
			} catch(Exception e) {
				vista.addObject("formUsuarioErrorMessage", e.getMessage());
				vista.addObject("usuariocurso", inscripcionparaguardar);
				vista.addObject("editMode", false);
				vista.setViewName("cargarInscripcion");
				return vista;
			}
		
			vista.addObject("formUsuarioErrorMessage", "Usuario guardado correctamente");
			vista.addObject("usuariocurso", usuariocursoservice.nuevoUsuarioCurso());
			vista.addObject("editMode", false);
			vista.setViewName("cargarInscripcion");
			return vista;

		
	}
}
