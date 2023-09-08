package modelo;

public class Ingrediente {

	private String nombre;
	private int precio;

	public Ingrediente(String nombre, int precio) 
	{
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public int getprecio() {
		// TODO Auto-generated method stub
		return precio;
	}

	public String getnombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
}
