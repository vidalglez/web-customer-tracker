package com.example.server.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.server.dao.CustomerDAO;
import com.example.server.entity.Customer;

//It always applies for DAO implementations, it extends from @Component, similar to @Controller
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("FROM Customer c ORDER BY c.lastName", Customer.class);
		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		//session.save(customer);
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		//Customer customer = session.get(Customer.class, id);
		//session.delete(customer);
		Query query = session.createQuery("DELETE FROM Customer WHERE id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();		
	}

	@Override
	public List<Customer> searchCustomer(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query;
		if(name != null && name.length() > 0) {
			query = session.createQuery("FROM Customer c WHERE lower(c.firstName) LIKE :theName OR lower(c.lastName) LIKE :theName", Customer.class);
			query.setParameter("theName", "%" + name.toLowerCase() + "%");
		} else {
			query = session.createQuery("FROM Customer c", Customer.class);
		}		
		return query.getResultList();
	}
	
	
	

}
