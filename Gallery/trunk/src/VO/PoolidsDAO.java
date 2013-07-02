package VO;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Poolids entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see VO.Poolids
 * @author MyEclipse Persistence Tools
 */

public class PoolidsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PoolidsDAO.class);
	// property constants
	public static final String OWNER_ID = "ownerId";
	public static final String POOL_ID = "poolId";

	public void save(Poolids transientInstance) {
		log.debug("saving Poolids instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Poolids persistentInstance) {
		log.debug("deleting Poolids instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Poolids findById(java.lang.Integer id) {
		log.debug("getting Poolids instance with id: " + id);
		try {
			Poolids instance = (Poolids) getSession().get("VO.Poolids", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Poolids instance) {
		log.debug("finding Poolids instance by example");
		try {
			List results = getSession().createCriteria("VO.Poolids")
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
		log.debug("finding Poolids instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Poolids as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOwnerId(Object ownerId) {
		return findByProperty(OWNER_ID, ownerId);
	}

	public List findByPoolId(Object poolId) {
		return findByProperty(POOL_ID, poolId);
	}

	public List findAll() {
		log.debug("finding all Poolids instances");
		try {
			String queryString = "from Poolids";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Poolids merge(Poolids detachedInstance) {
		log.debug("merging Poolids instance");
		try {
			Poolids result = (Poolids) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Poolids instance) {
		log.debug("attaching dirty Poolids instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Poolids instance) {
		log.debug("attaching clean Poolids instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}