package com.example.dao;

import java.util.List;

import com.example.entity.Employee;
import com.example.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class EmployeeDao {
	
	public void saveEmployee(Employee employee) {
		EntityManager em = HibernateUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(employee);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public List<Employee> getEmployees(){
		return HibernateUtil.getEntityManager()
				.createQuery("select e from Employee e", Employee.class)
				.getResultList();
	}
	
	public Employee findEmployee(int id) {
		return HibernateUtil.getEntityManager()
				.find(Employee.class, id);
	}
	
	public void updateEmployee(Employee employee) {
		EntityManager em = HibernateUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(employee);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public void deleteEmployee() {
		
	}
}
