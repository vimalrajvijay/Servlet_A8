package com.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {

	private static EntityManagerFactory emf;
	private HibernateUtil() {	
	}	
	public static void init() {
		if(emf==null) {
			emf = Persistence.createEntityManagerFactory("vimal");
		}
	}
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	public static void destroy() {
		if(emf!=null)
			emf.close();
	}
}
