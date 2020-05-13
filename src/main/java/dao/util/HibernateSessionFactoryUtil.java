package dao.util;

import models.AbstractModel;
import models.CustomerModel;
import models.UserModel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
	private static SessionFactory sessionFactory;

	private HibernateSessionFactoryUtil() {}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration().configure();
				configuration.addAnnotatedClass(CustomerModel.class);
				configuration.addAnnotatedClass(UserModel.class);
				configuration.addAnnotatedClass(AbstractModel.class);
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				sessionFactory = configuration.buildSessionFactory(builder.build());

			} catch (Exception e) {
				System.out.println("Исключение!" + e);
			}
		}
		return sessionFactory;
	}
}
