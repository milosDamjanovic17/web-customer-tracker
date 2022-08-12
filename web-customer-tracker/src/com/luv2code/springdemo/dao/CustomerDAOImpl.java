package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements ICustomerDAO {

	
	// need to inject the session factory, from ICustomer DAO
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomer() {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// create a query	
		Query<Customer> theQuery = session.createQuery("from Customer", Customer.class);
		
		// execute query and get result list
		List<Customer> customerList = theQuery.getResultList();
		
		
		// return the results
		return customerList;
	}

}
