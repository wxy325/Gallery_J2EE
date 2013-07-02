package VO;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Childids entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see VO.Childids
 * @author MyEclipse Persistence Tools
 */

public class ChildidsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ChildidsDAO.class);
	// property constants
	public static final String CHILD_ID = "childId";
	public static final String OWNER_ID = "ownerId";

	public void save(Childids transientInstance) {
		log.debug("saving Childids instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Childids persistentInstance) {
		log.debug("deleting Childids instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Childids findById(java.lang.Integer id) {
		log.debug("getting Childids instance with id: " + id);
		try {
			Childids instance = (Childids) getSession().get("VO.Childids", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Childids instance) {
		log.debug("finding Childids instance by example");
		try {
			List results = getSession().createCriteria("VO.Childids")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Childids instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Childids as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByChildId(Object childId) {
		return findByProperty(CHILD_ID, childId);
	}

	public List findByOwnerId(Object ownerId) {
		return findByProperty(OWNER_ID, ownerId);
	}

	public List findAll() {
		log.debug("finding all Childids instances");
		try {
			String queryString = "from Childids";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Childids merge(Childids detachedInstance) {
		log.debug("merging Childids instance");
		try {
			Childids result = (Childids) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Childids instance) {
		log.debug("attaching dirty Childids instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Childids instance) {
		log.debug("attaching clean Childids instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}