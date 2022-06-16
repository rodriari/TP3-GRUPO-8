package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.UsuarioCurso;

@Service
public interface IUsuarioCursoService {
	public UsuarioCurso nuevoUsuarioCurso();
	public void guardarUsuarioCurso(UsuarioCurso usuariocurso);
	public void eliminarUsuarioCurso(Integer id) throws Exception;
	public void modificarUsuarioCurso(UsuarioCurso usuariocurso);
	public List<UsuarioCurso> listarUsuariosCurso(); 
	public UsuarioCurso buscarUsuarioCurso(Integer id) throws Exception; 
}
