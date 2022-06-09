package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.controller.CursoController;
import ar.edu.unju.edm.model.Curso;
import ar.edu.unju.edm.repository.CursoRepository;
import ar.edu.unju.edm.service.ICursoService;
import ar.edu.unju.edm.util.ListaCursos;


@Service
public class ICursoServiceImp implements ICursoService{

	private static final Log GRUPO8 = LogFactory.getLog(CursoController.class);
	
	@Autowired
	ListaCursos listado;
	
	@Autowired
	CursoRepository lista;
	
	@Override
	public void guardarCurso(Curso curso) {
		// TODO Auto-generated method stub
		lista.save(curso);
	}

	@Override
	public void eliminarCurso(Long id) throws Exception{
		// TODO Auto-generated method stub		
		Curso auxiliar = new Curso();
		auxiliar = buscarCurso(id);
		lista.delete(auxiliar);
	}

	@Override
	public void modificarCurso(Curso curso) {
		// TODO Auto-generated method stub
		GRUPO8.info("ingresando al metodo arraylist: modificar cursos " + curso.getId());
		lista.save(curso);
	}

	@Override
	public List<Curso> listarCursos() {
		// TODO Auto-generated method stub
		List<Curso> auxiliar = new ArrayList<>();
		GRUPO8.info("ingresando al metodo arraylist: listar cursos");
		auxiliar = (List<Curso>) lista.findAll();
		return auxiliar;
	}

	

	@Override
	public Curso buscarCurso(Long id) throws Exception{
		// TODO Auto-generated method stub
		Curso cursoEncontrado = new Curso();
		cursoEncontrado=lista.findById(id).orElseThrow(()->new Exception("usuario no encontrado"));
		return cursoEncontrado;
	}

}
