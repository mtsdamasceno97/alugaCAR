package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Cliente;



public class TestarErros {

	public TestarErros(){
		Fachada.inicializar();
		
		Cliente c;
		//Telefone t;
		
		try {c = Fachada.cadastrarCliente("joao","1997-12-25","rua José Vieira","22563258971");
		}catch (Exception e) {System.out.println(e.getMessage());}

		try {c = Fachada.alterarCliente("22563258971", "João Damasceno");
		}catch (Exception e) {System.out.println(e.getMessage());}

		try {Fachada.excluirCliente("45863200125");
		}catch (Exception e) {System.out.println(e.getMessage());}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new TestarErros();
	}
}

