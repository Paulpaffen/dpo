package modelo;
import java.util.ArrayList;

import modelo.Iproducto;
public class Pedido 
{
	private int numeroPedidos = 0;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Iproducto> productos = new ArrayList<Iproducto>();
	private int preciototal = 0;
	
	public Pedido(String nom, String direccion)
	{
		this.numeroPedidos = numeroPedidos + 1;
		this.idPedido = numeroPedidos;
		this.nombreCliente = nom;
		this.direccionCliente = direccion;
	}
	private int getPrecioNetoPedido()
	{
		return (Integer) null;
	}
	private int getPrecioTotalPedido()
	{
		return (Integer) null;
	}
	private int getPrecioIvaPedido()
	{
		return (Integer) null;
	}
	private String generarTextoFactura()
	{
		return null;
	}
	
}
