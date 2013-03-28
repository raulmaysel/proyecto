package com.maynar.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.maynar.model.Orderdetail;
import com.maynar.model.OrderdetailId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderdetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.maynar.model.Orderdetail
 * @author MyEclipse Persistence Tools
 */

public class OrderdetailDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OrderdetailDAO.class);
	// property constants
	public static final String QUANTITYORDERED = "quantityordered";
	public static final String PRICEEACH = "priceeach";
	public static final String ORDERLINENUMBER = "orderlinenumber";

	protected void initDao() {
		// do nothing
	}

	public void save(Orderdetail transientInstance) {
		log.debug("saving Orderdetail instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Orderdetail persistentInstance) {
		log.debug("deleting Orderdetail instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Orderdetail findById(com.maynar.model.OrderdetailId id) {
		log.debug("getting Orderdetail instance with id: " + id);
		try {
			Orderdetail instance = (Orderdetail) getHibernateTemplate().get(
					"com.maynar.model.Orderdetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Orderdetail instance) {
		log.debug("finding Orderdetail instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Orderdetail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Orderdetail as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByQuantityordered(Object quantityordered) {
		return findByProperty(QUANTITYORDERED, quantityordered);
	}

	public List findByPriceeach(Object priceeach) {
		return findByProperty(PRICEEACH, priceeach);
	}

	public List findByOrderlinenumber(Object orderlinenumber) {
		return findByProperty(ORDERLINENUMBER, orderlinenumber);
	}

	public List findAll() {
		log.debug("finding all Orderdetail instances");
		try {
			String queryString = "from Orderdetail";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orderdetail merge(Orderdetail detachedInstance) {
		log.debug("merging Orderdetail instance");
		try {
			Orderdetail result = (Orderdetail) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orderdetail instance) {
		log.debug("attaching dirty Orderdetail instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orderdetail instance) {
		log.debug("attaching clean Orderdetail instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrderdetailDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (OrderdetailDAO) ctx.getBean("OrderdetailDAO");
	}
}