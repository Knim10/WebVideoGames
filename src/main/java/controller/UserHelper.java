package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;

/**
 * @author Kenneth Nimmo - Knimmo CIS175 - Fall 2021 Oct 3, 2023
 */
public class UserHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebVideoGames");

	public void insertUser(User user) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public List<User> showAllUsers() {
		EntityManager em = emfactory.createEntityManager();
		List<User> allusers = em.createQuery("SELECT u FROM User u").getResultList();
		return allusers;
	}

	public User findUser(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> typedQuery = em.createQuery("select u from User u where u.userName = :selectedName",
				User.class);

		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);

		User foundUser;
		try {
			foundUser = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundUser = new User(nameToLookUp);
		}
		em.close();
		return foundUser;
	}

}
