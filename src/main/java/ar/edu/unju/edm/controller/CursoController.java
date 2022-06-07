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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Curso;
import ar.edu.unju.edm.service.ICursoService;





@Controller
public class CursoController {

	private static final Log GRUPO8 = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	Curso nuevoCurso;
	
	@Autowired
	ICursoService cursoService;
	
	// cargar cursos
		@GetMapping({"/otroCurso"})	
		public ModelAndView addCourse() {
			GRUPO8.info("ingresando al metodo: nuevocursos");
			ModelAndView vista = new ModelAndView("RegistrarCurso");
			vista.addObject("curso", nuevoCurso);
			vista.addObject("band",false);
			return vista;
		}
		
		// guardar cursos
		@PostMapping("/guardarCurso")
		public String saveCourse(@Valid @ModelAttribute ("curso") Curso coursetosave, BindingResult result, Model model) {
		
			if(result.hasErrors()) {
				GRUPO8.fatal("Error de validacion");
				model.addAttribute("curso", coursetosave);
				model.addAttribute("band", false);
				return "RegistrarCurso";
			}
			
			
			try {
				cursoService.guardarCurso(coursetosave);
			}catch(Exception e) {
				model.addAttribute("formCourseMessage", e.getMessage());
				model.addAttribute("curso", coursetosave);
				model.addAttribute("band", false);
				GRUPO8.error("saliendo del metodo: guardarcursos");
				return "RegistrarCurso";
			}
			model.addAttribute("formCourseMessage", "Curso guardado correctamente");
			model.addAttribute("curso", nuevoCurso);	 
			model.addAttribute("band", false);
			GRUPO8.error("saliendo del metodo: guardarcursos");
				return "RegistrarCurso";
		}
		
		// listar cursos
		@GetMapping({"/listarCursos"})	
		public ModelAndView listCourse() {
			ModelAndView vista = new ModelAndView("ListaCurso");
			if(cursoService.listarCursos().size()!=0) {
				vista.addObject("listacursos", cursoService.listarCursos());
				GRUPO8.info("ingresando al metodo: listacursos "+cursoService.listarCursos().size());
			}
			return vista;
		}
		
		// modificar curso
		@RequestMapping("/editeCourse/{id}")
		public ModelAndView modCourse(@PathVariable(name="id") int id) throws Exception { 
			Curso coursetomod = new Curso();
			coursetomod = cursoService.buscarCurso(id);
			ModelAndView coursemod = new ModelAndView("RegistrarCurso");
		    coursemod.addObject("curso", coursetomod);
		    GRUPO8.error("saliendo del metodo: modCourse "+ coursetomod.getNombre());
		    coursemod.addObject("band",true);
		    return coursemod;
		}
		
		//actualizar curso
		@PostMapping("/editarCurso")
		public ModelAndView savemodCourse(@Valid @ModelAttribute ("curso") Curso cursoparamod, BindingResult result) {
			if(result.hasErrors()) {
				GRUPO8.fatal("Error de validacion");
				ModelAndView vista = new ModelAndView("RegistrarCurso");
				vista.addObject("curso", cursoparamod);
				vista.addObject("band",true);
				return vista;
			}
			try {
				cursoService.modificarCurso(cursoparamod);
			}catch(Exception e){
				ModelAndView vista = new ModelAndView("RegistrarCurso");
				vista.addObject("formCourseMessage", e.getMessage());
				vista.addObject("curso", cursoparamod);
				vista.addObject("band",true);
				GRUPO8.error("saliendo del metodo: editarcursos");
				return vista;
			}
				ModelAndView vista = new ModelAndView("ListaCurso");
				vista.addObject("listacursos", cursoService.listarCursos());	
				vista.addObject("formCourseMessage","Curso modificado Correctamente");
			return vista;
		}
		
		
		// eliminar cursos
		@RequestMapping("/deleteCourse/{id}")
		public String deleteCourse(@PathVariable(name="id") int id, Model model) {
			try {
				cursoService.eliminarCurso(id);
			}catch(Exception e){
				GRUPO8.error("encontrando: eliminarcursos");
				model.addAttribute("formCourseMessage", e.getMessage());
				return "redirect:/otroCurso";
			}
		
		    return "redirect:/listarCursos";
		}
}
