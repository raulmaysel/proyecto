package com.maynar.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.maynar.model.Purchaseorder;

/**
 * A data access object (DAO) providing persistence and search support for
 * Purchaseorder entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.maynar.model.Purchaseorder
 * @author MyEclipse Persistence Tools
 */

public class PurchaseorderDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PurchaseorderDAO.class);
	// property constants
	public static final String STATUS = "status";
	public static final String COMMENTS = "comments";
	public static final String CUSTOMERNUMBER = "customernumber";

	protected void initDao() {
		// do nothing
	}

	public void save(Purchaseorder transientInstance) {
		log.debug("saving Purchaseorder instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Purchaseorder persistentInstance) {
		log.debug("deleting Purchaseorder instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Purchaseorder findById(java.lang.Integer id) {
		log.debug("getting Purchaseorder instance with id: " + id);
		try {
			Purchaseorder instance = (Purchaseorder) getHibernateTemplate()
					.get("com.maynar.model.Purchaseorder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Purchaseorder instance) {
		log.debug("finding Purchaseorder instance by example");
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
		log.debug("finding Purchaseorder instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Purchaseorder as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List findByCustomernumber(Object customernumber) {
		return findByProperty(CUSTOMERNUMBER, customernumber);
	}

	public List findAll() {
		log.debug("finding all Purchaseorder instances");
		try {
			String queryString = "from Purchaseorder";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Purchaseorder merge(Purchaseorder detachedInstance) {
		log.debug("merging Purchaseorder instance");
		try {
			Purchaseorder result = (Purchaseorder) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Purchaseorder instance) {
		log.debug("attaching dirty Purchaseorder instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Purchaseorder instance) {
		log.debug("attaching clean Purchaseorder instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PurchaseorderDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PurchaseorderDAO) ctx.getBean("PurchaseorderDAO");
	}
}