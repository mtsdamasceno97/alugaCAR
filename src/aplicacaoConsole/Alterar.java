package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Aluguel;
import modelo.Cliente;



public class Alterar {

	public Alterar(){
		try {
			Fachada.inicializar();

			Fachada.alterarCliente("2164747712", "Bruno Alterado");
			System.out.println("\nNome alterado com sucesso");
			Fachada.alterarDataDevolucao("ABC1245","28/12/2020");
			System.out.println("\nData de devolução modificada com sucesso!!!");
			Fachada.alterarPlaca("ABC1245", "APC1246");
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new Alterar();
	}
}

