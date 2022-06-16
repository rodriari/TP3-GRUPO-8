package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
public class UsuarioCurso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idUsuarioCurso;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name= "dni")
    private Usuario usuario;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name= "id")
    
	private Curso curso;
	@DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate fechaDeInscripcion;
    
    public UsuarioCurso() {
		// TODO Auto-generated constructor stub
	
    }

	public Integer getIdUsuarioCurso() {
		return idUsuarioCurso;
	}

	public void setIdUsuarioCurso(Integer idUsuarioCurso) {
		this.idUsuarioCurso = idUsuarioCurso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getFechaDeInscripcion() {
		return fechaDeInscripcion;
	}

	public void setFechaDeInscripcion(LocalDate fechaDeInscripcion) {
		this.fechaDeInscripcion = fechaDeInscripcion;
	}

}
