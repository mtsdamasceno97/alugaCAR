/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Aluguel;

public class DAOAluguel  extends DAO<Aluguel>{

    public Aluguel read (Object chave){
        try{
            String placa = (String) chave;
            TypedQuery<Aluguel> q = manager.createQuery("select a from Aluguel a where a.veiculo.placa = :p ",Aluguel.class);
            q.setParameter("p", placa);

            return q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    //--------------------------------------------
    //  consultas
    //--------------------------------------------

    public List<Aluguel> consultarAlugueis (String placa){
        TypedQuery<Aluguel> q = manager.createQuery
                ("select a from Aluguel a where a.veiculo.placa like '%"+ placa +"%' order by a.veiculo.placa",Aluguel.class);
        return (List<Aluguel>) q.getResultList();
    }
}
