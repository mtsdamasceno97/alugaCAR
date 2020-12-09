/**IFPB - Curso SI 
 * Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

package daojpa;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public abstract class DAO<T> implements DAOInterface<T> {
	protected static EntityManager manager;
	protected static EntityManagerFactory factory;

	public DAO(){}

	public static void open(){
		if(manager==null){
			//			---------------------------------------------------------------
			//			mudar as property do persistence.xml  
			//			as property especificas do hibernate nao podem ser alteradas aqui
			//			---------------------------------------------------------------
			HashMap<String,String> propriedades = new HashMap<String,String>();		
			//			propriedades.put(PersistenceUnitProperties.JDBC_DRIVER, "org.postgresql.Driver" );	
			//			propriedades.put(PersistenceUnitProperties.JDBC_URL, "jdbc:postgresql://localhost4:5432/agenda");
			//			propriedades.put(PersistenceUnitProperties.JDBC_USER, "postgres");
			//			propriedades.put(PersistenceUnitProperties.JDBC_PASSWORD, "ifpb");
			//			propriedades.put(PersistenceUnitProperties.LOGGING_LEVEL, "off");
			//			propriedades.put(PersistenceUnitProperties.LOGGING_FILE, "log.txt");
			//			propriedades.put(PersistenceUnitProperties.SCHEMA_GENERATION_DATABASE_ACTION, "drop-and-create");
			//			propriedades.put(PersistenceUnitProperties.SCHEMA_GENERATION_SCRIPTS_ACTION, "create");						
			//			propriedades.put(PersistenceUnitProperties.SCHEMA_GENERATION_SCRIPTS_ACTION, "create");
			//			factory = Persistence.createEntityManagerFactory("agenda-eclipselink-postgres", propriedades);

			factory = Persistence.createEntityManagerFactory("agenda-eclipselink-postgres");
			manager = factory.createEntityManager();
		}
	}
	public static void close(){
		if(manager != null) {
			manager.close();
			factory.close();
		}
	}
	public void create(T obj){
		manager.persist(obj);
	}

	public abstract T read(Object chave);

	public T update(T obj){
		return manager.merge(obj);
	}
	public void delete(T obj) {
		manager.remove(obj);
	}


	@SuppressWarnings("unchecked")
	public List<T> readAll(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		TypedQuery<T> query = manager.createQuery("select x from " + type.getSimpleName() + " x",type);
		return  query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> readAllPagination(int firstResult, int maxResults) {
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		return manager.createQuery("select x from " + type.getSimpleName() + " x",type)
				.setFirstResult(firstResult - 1)
				.setMaxResults(maxResults)
				.getResultList();
	}

	//----------------------- TRANSA��O   ----------------------
	public static void begin(){
		if(!manager.getTransaction().isActive())
			manager.getTransaction().begin();
	}
	public static void commit(){
		if(manager.getTransaction().isActive()){
			manager.getTransaction().commit();
			manager.clear();		// ---- esvazia o cache de objetos ----
		}
	}
	public static void rollback(){
		if(manager.getTransaction().isActive())
			manager.getTransaction().rollback();
	}

}

