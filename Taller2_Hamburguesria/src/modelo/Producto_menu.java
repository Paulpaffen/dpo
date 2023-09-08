package modelo;

public class Producto_menu implements Iproducto
{

	private String nombre;
	private int precio;

	public Producto_menu(String nombre, int precio) 
	{
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public int getprecio() {
		// TODO Auto-generated method stub
		return precio;
	}

	@Override
	public String getnombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public String generarfactura() {
		// TODO Auto-generated method stub
		return null;
	}

}
