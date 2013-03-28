package com.maynar.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.maynar.model.Employee;

/**
 * A data access object (DAO) providing persistence and search support for
 * Employee entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.maynar.model.Employee
 * @author MyEclipse Persistence Tools
 */

public class EmployeeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(EmployeeDAO.class);
	// property constants
	public static final String LASTNAME = "lastname";
	public static final String FIRSTNAME = "firstname";
	public static final String EXTENSION = "extension";
	public static final String EMAIL = "email";
	public static final String REPORTSTO = "reportsto";
	public static final String JOBTITLE = "jobtitle";

	protected void initDao() {
		// do nothing
	}

	public void save(Employee transientInstance) {
		log.trace("saving Employee instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.trace("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Employee persistentInstance) {
		log.trace("deleting Employee instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.trace("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Employee findById(java.lang.Integer id) {
		log.trace("getting Employee instance with id: " + id);
		try {
			Employee instance = (Employee) getHibernateTemplate().get(
					"com.maynar.model.Employee", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Employee instance) {
		log.trace("finding Employee instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.trace("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.trace("finding Employee instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Employee as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLastname(Object lastname) {
		return findByProperty(LASTNAME, lastname);
	}

	public List findByFirstname(Object firstname) {
		return findByProperty(FIRSTNAME, firstname);
	}

	public List findByExtension(Object extension) {
		return findByProperty(EXTENSION, extension);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByReportsto(Object reportsto) {
		return findByProperty(REPORTSTO, reportsto);
	}

	public List findByJobtitle(Object jobtitle) {
		return findByProperty(JOBTITLE, jobtitle);
	}

	public List findAll() {
		log.trace("finding all Employee instances");
		try {
			String queryString = "from Employee";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Employee merge(Employee detachedInstance) {
		log.trace("merging Employee instance");
		try {
			Employee result = (Employee) getHibernateTemplate().merge(
					detachedInstance);
			log.trace("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Employee instance) {
		log.trace("attaching dirty Employee instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.trace("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Employee instance) {
		log.trace("attaching clean Employee instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.trace("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EmployeeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EmployeeDAO) ctx.getBean("emploDao");
	}
}