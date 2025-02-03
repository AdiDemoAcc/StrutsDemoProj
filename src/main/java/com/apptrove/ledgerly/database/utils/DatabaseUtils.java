package com.apptrove.ledgerly.database.utils;

import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.apptrove.ledgerly.admin.models.APARTMENT_MST;
import com.apptrove.ledgerly.admin.models.BUILDING_MST;
import com.apptrove.ledgerly.admin.models.MenuItemMst;
import com.apptrove.ledgerly.admin.models.MenuMst;
import com.apptrove.ledgerly.admin.models.Role;
import com.apptrove.ledgerly.admin.models.User;

public class DatabaseUtils {

	private static final SessionFactory sessionFactory;

	static {
		try {
			Properties properties = new Properties();
			InputStream input = DatabaseUtils.class.getClassLoader().getResourceAsStream("config.properties");
			
			if (input != null) {
				properties.load(input);
			} else {
				throw new RuntimeException("config.properties file not found");
			}
			
			String env = properties.getProperty("env","home");
			System.setProperty("env",env);
			String configFile = "hibernate-" + env + ".cfg.xml";
			System.out.println("Loading configuration file: "+configFile);
			System.out.println("Logging File Path: "+env);
			Configuration configuration = new Configuration().configure(configFile);
			
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Role.class);
			configuration.addAnnotatedClass(APARTMENT_MST.class);
			configuration.addAnnotatedClass(BUILDING_MST.class);
			configuration.addAnnotatedClass(MenuMst.class);
			configuration.addAnnotatedClass(MenuItemMst.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
		} catch (Exception ex) {
			throw new ExceptionInInitializerError("Failed to load Hibernate configuration: " + ex.getMessage());
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
