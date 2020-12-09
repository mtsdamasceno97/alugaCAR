package aplicacaoConsole;

import fachada.Fachada;

import java.util.Scanner;

public class Cadastrar {

	public Cadastrar(){
		Fachada.inicializar();
		cadastrar();
		Fachada.finalizar();
		System.out.println("Fim do programa");
	}

	public void cadastrar() {

		try {

			System.out.println("===================== Cadastrando Clientes !!! =====================");

			Fachada.cadastrarCliente("Mateus","13/01/1997","Teste","2568748712");
			Fachada.cadastrarCliente("Bruno","13/10/1997","Teste 2","2164747712");
			Fachada.cadastrarCliente("Mauricio","13/03/1997","Teste 3","1568748712");
			Fachada.cadastrarCliente("Fausto","13/08/1997","Teste 4","3558748712");

			System.out.println("======================== Fim de Cadastro !!! =====================\n");
			System.out.println("===================== Cadastrando Veiculos !!! =====================");

			Fachada.cadastrarVeiculo("ABC1245", "Honda", "Civic", 2019, 2);
			Fachada.cadastrarVeiculo("AYT5578", "Fiat", "Uno", 1994, 1);
			Fachada.cadastrarVeiculo("IUT1845", "Fiat", "Punto", 2020, 3);

			System.out.println("======================== Fim de Cadastro !!! =====================\n");
			System.out.println("===================== Cadastrando Alugueis !!! =====================");

			Fachada.cadastrarAluguel("25/12/2020",151, Fachada.consultarClientesPorCpf("2568748712"), Fachada.consultarVeiculo("ABC1245"));
			Fachada.cadastrarAluguel("04/01/2021",54, Fachada.consultarClientesPorCpf("2164747712"), Fachada.consultarVeiculo("AYT5578"));
			Fachada.cadastrarAluguel("12/12/2020",85, Fachada.consultarClientesPorCpf("2568748712"), Fachada.consultarVeiculo("IUT1845"));

			System.out.println("======================== Fim de Cadastro !!! =====================\n");

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}

	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
	//=================================================

}


