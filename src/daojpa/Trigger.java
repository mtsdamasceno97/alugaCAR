package daojpa;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.PersistenceException;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;

import modelo.Cliente;


public class Trigger{  // usada pelas classes Pessoa e Telefone

	@PrePersist
	public void exibirmsg1(Object obj) throws Exception {
		System.out.println(" @PrePersist... " + obj);

		//cancelar transacao
		//------------------
//		if (obj instanceof Telefone && ((Telefone) obj).getNumero().startsWith("3"))
//			throw new PersistenceException("\n -------nao pode cadastrar");
	}

	@PostPersist
	public void exibirmsg2(Object obj) {
		System.out.println(" @PostPersist... " + obj);
		if (obj instanceof Cliente)  {
			Cliente c = (Cliente) obj;
			int idade = calcularIdade(c);
			c.setIdade(idade);
			System.out.println(" ***idade calculada=" +obj + "\n");
		}

	}

	@PostLoad
	public void exibirmsg3(Object obj) {
		System.out.println(" @PostLoad... " + obj);
		if (obj instanceof Cliente)  {
			Cliente c = (Cliente) obj;
			int idade = calcularIdade( c );
			c.setIdade(idade);
			System.out.println(" ***idade calculada=" +obj + "\n");
		}
	}	

	@PostRemove
	public void exibirmsg4(Object obj) {
		System.out.println(" @PostRemove.... " + obj);
	}

	//============================================================

	public int calcularIdade(Cliente c) {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate nascimento = LocalDate.parse(c.getNascimento(), dataFormatada);
		Period per = Period.between(nascimento, hoje);
		int idade = per.getYears();
		return idade;
	}

}
