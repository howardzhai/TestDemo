package com.marlabs.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.marlabs.domain.Task;

public class DBUtility {
	private static Connection connection = null;

	SessionFactory sessionFactory;

	public DBUtility() {

		try {
			// creating configuration object
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");// populates the data of the
												// configuration file

			// creating seession factory object
			sessionFactory = cfg.buildSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addTask(Task task) {
		
		try{

			// creating session object
			Session session = sessionFactory.openSession();
	
			// creating transaction object
			Transaction t = session.beginTransaction();
	
			session.save(task);
			t.commit();
			session.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void archiveTask(int taskId) {
		
		try{

			// creating session object
			Session session = sessionFactory.openSession();
	
			// creating transaction object
			Transaction t = session.beginTransaction();
			Task task = (Task) session.get(Task.class, taskId);
			
			task.setArchived(1);
			
			session.merge(task);
			
			t.commit();
			session.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void updateTask(Task task) {
		
		try{

			// creating session object
			Session session = sessionFactory.openSession();
	
			// creating transaction object
			Transaction t = session.beginTransaction();
			
			session.merge(task);
			t.commit();
			session.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void changeTaskStatus(int taskId, String status) {
		
		try{

			// creating session object
			Session session = sessionFactory.openSession();
	
			// creating transaction object
			Transaction t = session.beginTransaction();
			Task task = (Task) session.get(Task.class, taskId);
			
			task.setStatus(status);
			
			session.merge(task);
			
			t.commit();
			session.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public List<Task> getAllTasks() {
		
		Criteria criteria = sessionFactory.openSession().createCriteria(Task.class);
		String hql = "FROM Task T WHERE T.archived = 0";
		Query query = sessionFactory.openSession().createQuery(hql);
		
		return query.list();

	}
	
	public Task getTaskById(int taskId) {
		
		return (Task) sessionFactory.getCurrentSession().get(Task.class, taskId);
		
	}

	/*
	 * public static Connection getConnection() { if (connection != null) return
	 * connection; else { try { Properties prop = new Properties(); InputStream
	 * inputStream = DBUtility.class.getClassLoader()
	 * .getResourceAsStream("/config.properties"); prop.load(inputStream);
	 * String driver = prop.getProperty("driver"); String url =
	 * prop.getProperty("url"); String user = prop.getProperty("user"); String
	 * password = prop.getProperty("password"); Class.forName(driver);
	 * connection = DriverManager.getConnection(url, user, password); } catch
	 * (ClassNotFoundException e) { e.printStackTrace(); } catch (SQLException
	 * e) { e.printStackTrace(); } catch (FileNotFoundException e) {
	 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
	 * return connection; }
	 * 
	 * }
	 */

}