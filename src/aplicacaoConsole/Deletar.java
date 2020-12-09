package aplicacaoConsole;


import fachada.Fachada;


public class Deletar {

	public Deletar(){
		try {
			Fachada.inicializar();
			Fachada.excluirCliente("2568748712");
			System.out.println("cliente deletado!!!");

			Fachada.excluirVeiculo("AYT5578");
			System.out.println("veiculo deletado!!!");

			Fachada.excluirAluguel("ABC1245");
			System.out.println("aluguel deletado !!!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Fachada.finalizar();
		}

		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

