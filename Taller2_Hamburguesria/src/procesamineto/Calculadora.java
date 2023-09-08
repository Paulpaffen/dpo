package procesamineto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import modelo.Combo;
import modelo.Ingrediente;
import modelo.Producto_menu;
import modelo.Pedido;
import modelo.Producto_ajustado;




public class Calculadora 
{
	// ************************************************************************
		// Atributos
		// ************************************************************************

		/**
		 * Una lista con todos los productos del menu.
		 */
		private List<Producto_menu> menu;

		/**
		 * Una lista con todos los ingredientes del menu.
		 */
		private List<Ingrediente> ingrediente;

		/**
		 * Una lista con los combos disponibles.
		 */
		private List<Combo> combo;

		// ************************************************************************
		// Constructores
		// ************************************************************************

		/**
		 * Construye una calculadora, guardando la información
		 * proporcionada sobre productos, ingredientes y combos del menu.
		 * 
		 * @param menu un arraylist con los productos del menu.
		 * @param ingrediente  un arraylist con los ingredientes del menu.
		 * @param combo Un arraylist con los combos del menu.
		 */
	private Calculadora(ArrayList<Producto_menu> menu, ArrayList<Ingrediente> ingrediente, ArrayList<Combo> combo)
	{
		this.menu = new ArrayList<Producto_menu>(menu);
		this.ingrediente = new ArrayList<Ingrediente>(ingrediente);
		this.combo = new ArrayList<Combo>(combo);
	}
	
	public static Calculadora cargarArchivo() throws FileNotFoundException, IOException
	{
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		ArrayList<Combo> combo = new ArrayList<>();
		ArrayList<Producto_menu> menu = new ArrayList<>();
		
		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		BufferedReader br_in = new BufferedReader(new FileReader("data/ingredientes.txt"));
		String linea_in = br_in.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
										// las columnas
		linea_in = br_in.readLine();
		
		while (linea_in != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			String[] partes = linea_in.split(";"); //se separan los items
			String nomingredientes = partes[0];
			int precio = Integer.parseInt(partes[1]);
			Ingrediente elIngrediente = new Ingrediente(nomingredientes, precio); //se crea un nuevo item con un nombre y un precio
			ingredientes.add(elIngrediente); // se agrega el item al objeto
			linea_in = br_in.readLine(); // Leer la siguiente línea
		}
		br_in.close(); //cerrar el archivo
		
		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		BufferedReader br_me = new BufferedReader(new FileReader("data/menu.txt"));
		String linea_me = br_me.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
										// las columnas
		linea_me = br_me.readLine();
		
		while (linea_me != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			String[] partes = linea_me.split(";"); //se separan los items
			String nommenu = partes[0];
			int precio = Integer.parseInt(partes[1]);
			Producto_menu elMenu = new Producto_menu(nommenu, precio); //se crea un nuevo item con un nombre y un precio
			menu.add(elMenu); // se agrega el item al objeto
			linea_me = br_me.readLine(); // Leer la siguiente línea
		}
		br_me.close(); //cerrar el archivo
		
		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
				BufferedReader br_co = new BufferedReader(new FileReader("data/combos.txt"));
				String linea_co = br_co.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
												// las columnas
				linea_co = br_co.readLine();
				
				while (linea_co != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
				{
					String[] partes = linea_co.split(";"); //se separan los items
					String nomcombo = partes[0];
					double descuento = Double.parseDouble(partes[1]);
					String producto1 = partes[2];
					String producto2 = partes[3];
					String producto3 = partes[4];
					
					Producto_menu elMenu1 = null;
					Producto_menu elMenu2 = null;
					Producto_menu elMenu3 = null;
					for (int i = menu.size() - 1; i >= 0 && elMenu1 == null; i--) //se busca en todos los elementos 
																	//del menu en busca de un producto
					{
						Producto_menu unCombo = menu.get(i);
						if (unCombo.getnombre().equals(producto1)) // verifica si se encontro el producto
						{
							elMenu1 = unCombo; // se guarda el objeto pertenciente al producto
						}
					}
					for (int i = menu.size() - 1; i >= 0 && elMenu2 == null; i--) //se busca en todos los elementos 
						//del menu en busca de un producto
					{
						Producto_menu unCombo = menu.get(i);
						if (unCombo.getnombre().equals(producto2)) // verifica si se encontro el producto
						{
							elMenu2 = unCombo; // se guarda el objeto pertenciente al producto
						}
					}
					for (int i = menu.size() - 1; i >= 0 && elMenu3 == null; i--) //se busca en todos los elementos 
						//del menu en busca de un producto
					{
						Producto_menu unCombo = menu.get(i);
						if (unCombo.getnombre().equals(producto3)) // verifica si se encontro el producto
						{
							elMenu3 = unCombo; // se guarda el objeto pertenciente al producto
						}
					}
					Combo elCombo = new Combo(nomcombo, descuento, elMenu1, elMenu2, elMenu3); // se crea un nuevo item que contiene
																// un nombre, un descuento, y 3 productos separados
					combo.add(elCombo); // se agrega el item al objeto
					linea_co = br_co.readLine(); // Leer la siguiente línea
				}
				br_co.close(); //cerrar el archivo
			Calculadora calculadora = new Calculadora(menu, ingredientes, combo);
			return calculadora;
	}
	/**
	 * funcion que sirve para imprimir el menu completo al usuario, 
	 * incluyendo cada producto, combo e ingrediente extra
	 * @return
	 */
	public String getmenu()
	{
		String rta = "Menu: \n"; // variable que sirve como menu 
		rta = rta + "\n Productos: \n";
		for (int i = menu.size() - 1; i >= 0; i--) //se busca en todos los elementos de Producto_menu
		{
			Producto_menu unMenu = menu.get(i);
			String nom = unMenu.getnombre(); //accede al nombre del objeto
			String pre = unMenu.getprecio() + ""; //accede al precio del objeto y lo convierte en String
			rta = rta + nom + " " + pre + "\n"; // junta el nombre y el precio y lo agrega a la variable rta
		}
		rta = rta + "\n Combos: \n" ;
		for (int i = combo.size() - 1; i >= 0; i--) //se busca en todos los elementos de Combo
		{
			Combo unCombo = combo.get(i);
			String nom = unCombo.getnombre(); //accede al nombre del objeto
			String pre = unCombo.getprecio() + ""; //accede al precio del objeto y lo convierte en String
			rta = rta + nom + " " + pre + "\n"; // junta el nombre y el precio y lo agrega a la variable rta
		}
		rta = rta + "\n Extras: \n";
		for (int i = ingrediente.size() - 1; i >= 0; i--) //se busca en todos los elementos de Ingrediente
		{
			Ingrediente uningrediente = ingrediente.get(i);
			String nom = uningrediente.getnombre(); //accede al nombre del objeto
			String pre = uningrediente.getprecio() + ""; //accede al precio del objeto y lo convierte en String
			rta = rta + nom + " " + pre + "\n"; // junta el nombre y el precio y lo agrega a la variable rta
		}
		return rta;	
	}
	public static void iniciarPedido(String nom, String direccion)
	{
		Pedido nuevopedido = new Pedido(nom, direccion);
	}
	
}





