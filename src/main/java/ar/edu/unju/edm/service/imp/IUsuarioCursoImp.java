package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.UsuarioCurso;
import ar.edu.unju.edm.repository.UsuarioCursoRepository;
import ar.edu.unju.edm.service.IUsuarioCursoService;

@Service
public class IUsuarioCursoImp implements IUsuarioCursoService{
@Autowired
UsuarioCurso usuariocurso;
@Autowired 
UsuarioCursoRepository usuariocursorepository;

	@Override
	public UsuarioCurso nuevoUsuarioCurso() {
		// TODO Auto-generated method stub
		return usuariocurso;
	}

	@Override
	public void guardarUsuarioCurso(UsuarioCurso usuariocurso) {
		// TODO Auto-generated method stub
		usuariocursorepository.save (usuariocurso);
	}

	@Override
	public void eliminarUsuarioCurso(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarUsuarioCurso(UsuarioCurso usuariocurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioCurso> listarUsuariosCurso() {
		// TODO Auto-generated method stub
		return (List<UsuarioCurso>) usuariocursorepository.findAll();
	}

	@Override
	public UsuarioCurso buscarUsuarioCurso(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return usuariocursorepository.findById(id).orElseThrow(()-> new Exception("UsuarioCurso no encontrado"));
	}
	

}
