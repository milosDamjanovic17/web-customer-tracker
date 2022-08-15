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
		
		// create a query and sort by last name
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query and get result list
		List<Customer> customerList = theQuery.getResultList();
		
		
		// return the results
		return customerList;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current hibernate session
		
		Session session = sessionFactory.getCurrentSession();
		
		// save the customer
		session.save(theCustomer);
		
	}

}
