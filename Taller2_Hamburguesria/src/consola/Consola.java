package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import procesamineto.Calculadora;

public class Consola 
{
	
	private Calculadora calculadora;
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Consola consola = new Consola();
		consola.ejecutarAplicacion();
	}

	private void ejecutarAplicacion() throws FileNotFoundException, IOException 
	{
		// TODO Auto-generated method stub
		System.out.println("Hamburgueseria \n");
		ejecutarCarga();
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					ejecutarmenu();
				else if (opcion_seleccionada == 2 && calculadora != null)
					mostrarMenu();
				else if (opcion_seleccionada == 3 && calculadora != null)
					mostrarMenu();
				else if (opcion_seleccionada == 4 && calculadora != null)
					mostrarMenu();
				else if (opcion_seleccionada == 5 && calculadora != null)
					mostrarMenu();
				
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (calculadora == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar menu");
		System.out.println("2. Iniciar nuevo pedido");
		System.out.println("3. Agregar un elemento al pedido");
		System.out.println("4. Terminar pedido");
		System.out.println("5. Consultar un pedido");
		System.out.println("6. Cerrar aplicacion");
	}

	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	private void ejecutarCarga() throws FileNotFoundException, IOException
	{

		calculadora = Calculadora.cargarArchivo();
	}
	private void ejecutarmenu()
	{
		String individual = calculadora.getmenu();
		System.out.println(individual);
	}
	private void ejecutarnuevopedido()
	{
		System.out.println("\nPara crear un nuevo pedido debe ingresa su nombre y direccion\n");
		String nombre = input("Por favor ingrese su nombre: ");
		String direccion = input("Por favor ingrese su direccion: ");
		Calculadora.iniciarPedido(nombre, direccion);
		System.out.println("\nSu pedido se genero con exito\n");
	}
}




