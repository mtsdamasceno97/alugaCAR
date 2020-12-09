package fachada;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import daojpa.*;

import modelo.Cliente;
import modelo.Aluguel;
import modelo.Veiculo;

public class Fachada {
	private static DAOCliente daocliente = new DAOCliente();
	private static DAOAluguel daoaluguel = new DAOAluguel();
	private static DAOVeiculo daoveiculo = new DAOVeiculo();


	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}

	//--------------------------------------------- CLIENTE -------------------------------------------------------

	public static Cliente cadastrarCliente(String nome, String nascimento, String endereco, String cpf) throws  Exception{
		DAO.begin();	
		Cliente c = daocliente.read(cpf);
		if(c != null) {
			DAO.rollback();
			throw new Exception("cliente ja cadastrado:" + nome);
		}
		c = new Cliente(nome,nascimento,endereco,cpf);
		daocliente.create(c);
		DAO.commit();
		return c;
	}


	public static Cliente alterarCliente(String cpf, String novonome) throws Exception{
		DAO.begin();		
		Cliente c = daocliente.read(cpf);	//usando  chave primaria
		if (c==null) {
			DAO.rollback();
			throw new Exception("cliente inexistente:" + cpf);
		}
		c.setNome(novonome);
		c=daocliente.update(c);
		DAO.commit();
		return c;
	}

	public static void excluirCliente(String cpf) throws Exception {
		DAO.begin();
		Cliente c = daocliente.read(cpf);
		if (c==null) {
			DAO.rollback();
			throw new Exception("cpf inexistente:" + cpf);
		}
		for (Aluguel a : c.getAlugueis()){
			daoaluguel.delete(a);
		}
		daocliente.delete(c);  //telefones removidos
		DAO.commit();
	}

	public static String listarClientes(){
		List<Cliente> clientes = daocliente.readAll();
		String texto="";
		for (Cliente cl : clientes) {
			texto += cl +"\n";
		}
		return texto;
	}


	public static Cliente consultarClientesPorCpf(String cpf) {
		Cliente result = daocliente.read(cpf);

		return result;
	}

	public static String clientesAlugueis(){
		List<Aluguel> clientesAlugueis = daocliente.clientesAlugueis();
		String texto = "";
		for (Aluguel a : clientesAlugueis) {
			texto += a +"\n";
		}
		return texto;
	}

	//------------------------------------------------ ALUGUEL ----------------------------------------------------------


	public static Aluguel cadastrarAluguel(String dataDevolucao, double valorDiaria, Cliente cliente, Veiculo veiculo) throws  Exception{

		DAO.begin();

		Veiculo v = daoveiculo.read(veiculo.getPlaca());
		if(v == null){
			throw new Exception("O veiculo não existe");
		}

		Aluguel a = daoaluguel.read(v.getPlaca());
		if(a != null) {
			DAO.rollback();
			throw new Exception("Ja cadastrado no sistema: " + "Veiculo: " + veiculo.getPlaca() + "Data de devolucao: " + dataDevolucao);
		}

		Cliente c = daocliente.read(cliente.getCpf());
		if(c == null){
			DAO.rollback();
			throw new Exception("Cliente não cadastrado");
		}
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataDevolucaoF = formato.parse(dataDevolucao);
		a = new Aluguel(dataDevolucaoF, valorDiaria, c,v);

		c.adicionar(a);
		daocliente.update(c);
		daoaluguel.create(a);

		DAO.commit();
		return a;
	}

	public static String listarAlugueis(){
		List<Aluguel> alugueis = daoaluguel.readAll();
		String texto="";
		for (Aluguel al : alugueis) {
			texto += al +"\n";
		}
		return texto;
	}

	public static List<Aluguel> listarAlugueis2(){
		List<Aluguel> alugueis = daoaluguel.readAll();
		return  alugueis;
	}

	public static Aluguel alterarDataDevolucao(String placa, String dataDevolucao) throws Exception{
		DAO.begin();
		Aluguel a = daoaluguel.read(placa);

		Veiculo v = daoveiculo.read(a.getVeiculo().getPlaca());
		if(v == null){
			throw new Exception("O veiculo não existe");
		}

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataDevolucaoF = formato.parse(dataDevolucao);
		a.setDataDevolucao(dataDevolucaoF);

		a=daoaluguel.update(a);
		DAO.commit();
		return a;

	}

	public static void excluirAluguel(String placa) throws Exception {
		DAO.begin();
		Aluguel a = daoaluguel.read(placa);
		if(a == null){
			DAO.rollback();
			throw new Exception("O aluguel não existe");
		}
		daoaluguel.delete(a);
		DAO.commit();
	}

	//consultar


	//-------------------------------------------------- VEICULO ------------------------------------------------------------

	public static Veiculo cadastrarVeiculo(String placa, String marca, String modelo, int ano, int disponiveis) throws  Exception{
		DAO.begin();
		Veiculo v = daoveiculo.read(placa);
		if(v != null) {
			DAO.rollback();
			throw new Exception("veiculo ja cadastrado:" + placa);
		}
		v = new Veiculo(placa,marca,modelo,ano,disponiveis);
		daoveiculo.create(v);
		DAO.commit();
		return v;
	}

	public static Veiculo consultarVeiculo(String placa) throws  Exception{
		DAO.begin();
		Veiculo result = daoveiculo.read(placa);
		return result;
	}

	public static String listarVeiculos(){
		List<Veiculo> veiculos = daoveiculo.readAll();
		String texto="";
		for (Veiculo v : veiculos) {
			texto += v +"\n";
		}
		return texto;
	}

	public static void excluirVeiculo(String placa) throws Exception{
		DAO.begin();
		Veiculo v = daoveiculo.read(placa);
		if (v==null) {
			DAO.rollback();
			throw new Exception("veiculo inexistente:" + v);
		}
		for (Aluguel a : v.getAlugueis()){
			daoaluguel.delete(a);
		}
		daoveiculo.delete(v);
		DAO.commit();
	}

	public static Veiculo alterarPlaca(String placa, String novaPlaca) throws Exception{
		DAO.begin();
		Veiculo v = daoveiculo.read(placa);	//usando  chave primaria
		if (v==null) {
			DAO.rollback();
			throw new Exception("veiculo inexistente:" + placa);
		}
		v.setPlaca(novaPlaca);
		v=daoveiculo.update(v);
		DAO.commit();
		return v;
	}


}
