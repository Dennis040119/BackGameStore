package com.example.demo.entity.enums;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "plataforma")
public class Plataforma {
	
	@Id
	private String platId;
	private String nombre;
	private int generacion;
	private String marca;
	
	
	
	
	
	

	public String getPlatId() {
		return platId;
	}





	public void setPlatId(String platId) {
		this.platId = platId;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public int getGeneracion() {
		return generacion;
	}





	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}





	public String getMarca() {
		return marca;
	}





	public void setMarca(String marca) {
		this.marca = marca;
	}





	@Override
	public String toString() {
		return "Plataforma [platId=" + platId + ", nombre=" + nombre + ", generacion=" + generacion + ", marca=" + marca
				+ "]";
	}


	



	
	/*PLAY4("PlayStation 4",4,"Sony"),
	PLAY5("PlayStation 5",5,"Sony"),
	XBOX360("Xbox 360",4,"Microsoft"),
	XBOXONE("Xbox one",5,"Microsoft"),
	PC("Pc",5,"Nvidia"),
	NINTENDOSWITCH("Nintendo Switch ",5,"Nintendo");*/
	

}
