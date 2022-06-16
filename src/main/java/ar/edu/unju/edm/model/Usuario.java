package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Entity
@Component
@Table (name = "LISTAUSUARIO")
public class Usuario {

	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name= "DNI", nullable = true)
	@Min(value=1000000, message="El dni debe ser mayor a 1.000.000")
	@Max(value=99999999, message="El dni debe ser menor a 99.999.999")
	private Long dni;
	
	@NotEmpty //@Email
	@Column (name= "MAIL", nullable = true)
	private String email;
	
	@Size(min=4, max=30, message="La contraseÃ±a debe tener 4 caracteres minimo, maximo 30")
	@NotBlank(message="La contraseÃ±a no puede ser espacios en blanco")
	
	@Column (name= "CONTRASEÑA", nullable = true)
	private String contraseña;
	
	@Size(min=2, max=50, message="El apellido debe tener 2 caracteres minimo, maximo 50")
	@NotBlank(message="El apellido no puede ser espacios en blanco")
	@NotEmpty(message="El apellido no puede estar vacio")
	
	@Column (name= "APELLIDO")
	private String apellido;
	
	@Size(min=2, max=50, message="EL nombre debe tener 2 caracteres minimo, maximo 50")
	@NotBlank(message="El nombre no puede ser espacios en blanco")
	@NotEmpty(message="El nombre no puede estar vacio")
	
	@Column (name= "NOMBRE", nullable = true)
	private String nombre;
	
	@Past(message="La fecha de nacimiento debe ser del pasado")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	
	private LocalDate fechanacimiento;
	
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public Usuario() {
	}
	public Usuario(String email, String contraseña) {
		super();
		this.email = email;
		this.contraseña = contraseña;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(LocalDate fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	
}
