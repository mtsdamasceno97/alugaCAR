package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */


import fachada.Fachada;
import modelo.Cliente;


public class Listar {

	public Listar(){
		try {
			Fachada.inicializar();

			System.out.println("==== Clientes ====");
			System.out.println(Fachada.listarClientes());
			System.out.println("\n==== Veículos ====");
			System.out.println(Fachada.listarVeiculos());
			System.out.println("\n==== Aluguéis ====");
			System.out.println(Fachada.listarAlugueis());
			System.out.println("Até logo!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

