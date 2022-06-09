package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.controller.UsuarioController;
import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.UsuarioRepository;
import ar.edu.unju.edm.service.IUsuarioService;
import ar.edu.unju.edm.util.ListaUsuario;

@Service
public class IUsuarioServiceImp implements IUsuarioService{

	private static final Log GRUPO8 = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	UsuarioRepository lista;
	
	@Override
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		lista.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) throws Exception {
		// TODO Auto-generated method stub		
		Usuario auxiliar = new Usuario();
		auxiliar = buscarUsuario(id);
		lista.delete(auxiliar);
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	lista.save(usuario);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> auxiliar = new ArrayList<>();
		GRUPO8.info("ingresando al metodo arraylist: listar usuarios");
        
		auxiliar = (List<Usuario>) lista.findAll();
		
		return auxiliar;
	}

	

	@Override
	public Usuario buscarUsuario(Long id) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuarioEncontrado = new Usuario();
        usuarioEncontrado=lista.findById(id).orElseThrow(()->new Exception("usuario no encontrado"));
        return usuarioEncontrado;

	}

}
