/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Veiculo;


public class DAOVeiculo extends DAO<Veiculo>{

    public Veiculo read (Object chave){
        try{
            String placa = (String) chave;
            TypedQuery<Veiculo> q = manager.createQuery("select v from Veiculo v where v.placa=:n", Veiculo.class);
            q.setParameter("n", placa);

            return q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    //  //pode-se sobrescrever o metodo readAll da classe DAO para ordenar o resultado
    public List<Veiculo> readAll(){
        TypedQuery<Veiculo> q = manager.createQuery("select v from Veiculo v order by v.id", Veiculo.class);
        return  q.getResultList();
    }

    //--------------------------------------------
    //  consultas
    //--------------------------------------------
    public  List<Veiculo> consultarVeiculos(String placa) {
        TypedQuery<Veiculo> q = manager.createQuery
                ("select v from Veiculo v where v.placa like '%"+placa+"%' order by v.placa",Veiculo.class);
        return q.getResultList();
    }

}

