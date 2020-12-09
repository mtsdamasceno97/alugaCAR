package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;


public class Consultar {

	public Consultar(){
		
		try {
			Fachada.inicializar();
			System.out.println("1.\n"+Fachada.consultarClientesPorCpf("25687487125") );
			//Consulta que percorre as três classes
			System.out.println(Fachada.clientesAlugueis());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
		System.out.println("\nfim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

