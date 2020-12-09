/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Cliente;
import modelo.Cliente;

public class DAOCliente extends DAO<Cliente>{

	public Cliente read (Object chave){
		try{
			String cpf = (String) chave;
			TypedQuery<Cliente> q = manager.createQuery("select c from Cliente c where c.cpf=:n", Cliente.class);
			q.setParameter("n", cpf);

			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	//Clientes que alugaram carro x em determinado periodo
	//public List<Cliente> clientes

	//  //pode-se sobrescrever o metodo readAll da classe DAO para ordenar o resultado 
	public List<Cliente> readAll(){
		TypedQuery<Cliente> q = manager.createQuery("select c from Cliente c order by c.id", Cliente.class);
		return  q.getResultList();
	}

	//--------------------------------------------
	//  consultas
	//--------------------------------------------
	public  Cliente consultarClientes(String cpf) {
		TypedQuery<Cliente> q = manager.createQuery
				("select c from Cliente c where c.cpf like '%"+cpf+"%' order by c.cpf",Cliente.class);
		return q.getSingleResult();
	}

	public  List<Cliente>  consultarClientesNAlugueis(int n) {
		TypedQuery<Cliente> q = manager.createQuery
				("select c from Cliente c where SIZE(c.alugueis) = :x",Cliente.class);
		q.setParameter("x", n);
		return q.getResultList();
	}
}

