package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import model.Role;
import model.User;

@WebListener
public class DefaultUserInitializer implements ServletContextListener {

	private EntityManagerFactory emf;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		emf = Persistence.createEntityManagerFactory("GestionLivres");
		EntityManager em = emf.createEntityManager();

		// Check if the default user exists in the database
		if (em.find(User.class, 1) == null) {
			// Create a new User object with the default values
			User defaultUser = new User();
			defaultUser.setLogin("admin@gmail.com");
			defaultUser.setRole(Role.ADMIN);

			defaultUser.setPassword("admin");
			// Persist the default user to the database
			em.getTransaction().begin();
			em.persist(defaultUser);
			em.getTransaction().commit();
		}

		em.close();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (emf != null) {
			emf.close();
		}
	}
}
