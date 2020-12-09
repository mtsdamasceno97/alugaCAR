package modelo;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import daojpa.Trigger;
import fachada.Fachada;
import org.eclipse.persistence.annotations.Indexes;


@Entity
@Table(name = "tb_cliente_20162370022_20171370027", indexes = {@Index(name = "index_nome", columnList = "nome")})
@EntityListeners( Trigger.class )  // CLASSE QUE IMPLEMENTA OS EVENTOS (TRIGGERS)
public class Cliente {

	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	private String nome;

	private String nascimento;

    @Transient
    private int idade;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id")
	private List<Aluguel> alugueis = new ArrayList<Aluguel>();

	@Column(length = 100)
	private String endereco;
	
	@Column(length = 11, unique = true)
	private String cpf;

	public Cliente (){}

	public Cliente(String nome, String nascimento, String endereco, String cpf) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.cpf = cpf;
		this.idade = 0;
	}


//    @PostLoad
//    @PostPersist
//    @PostUpdate
//    private void calcularIdade() {
//        LocalDate hoje = LocalDate.now();
//		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate nascimento = LocalDate.parse(getNascimento(), dataFormatada);
//        Period p = Period.between(nascimento, hoje);
//        idade = p.getYears();
//    }

	public void adicionar(Aluguel a){
		a.setCliente(this);
		this.alugueis.add(a);

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cliente cliente = (Cliente) o;
		return id == cliente.id &&
				idade == cliente.idade &&
				Objects.equals(nome, cliente.nome) &&
				Objects.equals(nascimento, cliente.nascimento) &&
				Objects.equals(alugueis, cliente.alugueis) &&
				Objects.equals(endereco, cliente.endereco) &&
				Objects.equals(cpf, cliente.cpf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, idade, nascimento, alugueis, endereco, cpf);
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", nascimento='" + nascimento + '\'' +
				", idade=" + idade +
				listarAlugueis() +
				", endereco='" + endereco + '\'' +
				", cpf='" + cpf + '\'' +
				'}';
	}

	private String listarAlugueis() {
		List<Aluguel> clientesAlugueis = this.alugueis;
		String texto = "";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		//Date dataDevolucaoF = formato.parse(dataDevolucao);
		for (Aluguel a : clientesAlugueis) {
			String data = formato.format(a.getDataDevolucao());
			texto += ", Aluguel"+ "(" + " id: " + a.getId() + " /" + " Data de Devolução: " + data + ")";
		}
		return texto;
	}
}
