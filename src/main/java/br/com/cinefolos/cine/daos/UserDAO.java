package br.com.cinefolos.cine.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cinefolos.cine.models.User;

@Transactional
/*public interface UserDAO extends CrudRepository<User, Long>{

	List<User> listar();

}*/
@Repository
public class UserDAO {
	@PersistenceContext
	private EntityManager manager;
	
	public List<User> listar() {
	    return manager.createQuery("select u from User u", User.class).getResultList();
	}

	public void gravar(User user) {
		manager.persist(user);
	}

	public User find(long id) {
		return manager.createQuery("select u from User u where id = :id", User.class)
	    		.setParameter("id", id)
	    		.getSingleResult();
	}

	public void alterar(User user) {
		manager.merge(user);		
	}
	
	public void removeById(long id) {
		User user = find(id);
		
		remover(user);
	}
	
	public void remover(User user) {
		manager.remove(user);
	}

}
