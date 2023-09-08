package modelo;

import java.util.ArrayList;
import java.util.List;



public class Combo implements Iproducto
{

	private String nombre;
	private double descuento;
	private Producto_menu producto_1;
	private Producto_menu producto_2;
	private Producto_menu producto_3;

	
	public Combo(String nombre, double descuento, Producto_menu producto_1, Producto_menu producto_2, Producto_menu producto_3) 
	{
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.descuento = descuento;
		this.producto_1 = producto_1;
		this.producto_2 = producto_2;
		this.producto_3 = producto_3;
	}

	@Override
	public int getprecio() {
		// TODO Auto-generated method stub
		int pr_1 = producto_1.getprecio();
		int pr_2 = producto_2.getprecio();
		int pr_3 = producto_3.getprecio();
		int descuento_f = (int) ((pr_1 + pr_2 + pr_3)* descuento);
		return (int) ((pr_1 + pr_2 + pr_3) - descuento_f);
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
