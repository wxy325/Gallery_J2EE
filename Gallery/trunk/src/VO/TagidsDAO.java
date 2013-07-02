package VO;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Tagids entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see VO.Tagids
 * @author MyEclipse Persistence Tools
 */

public class TagidsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TagidsDAO.class);
	// property constants
	public static final String TAGID = "tagid";
	public static final String OWNER_ID = "ownerId";

	public void save(Tagids transientInstance) {
		log.debug("saving Tagids instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tagids persistentInstance) {
		log.debug("deleting Tagids instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tagids findById(java.lang.Integer id) {
		log.debug("getting Tagids instance with id: " + id);
		try {
			Tagids instance = (Tagids) getSession().get("VO.Tagids", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Tagids instance) {
		log.debug("finding Tagids instance by example");
		try {
			List results = getSession().createCriteria("VO.Tagids")
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
		log.debug("finding Tagids instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Tagids as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTagid(Object tagid) {
		return findByProperty(TAGID, tagid);
	}

	public List findByOwnerId(Object ownerId) {
		return findByProperty(OWNER_ID, ownerId);
	}

	public List findAll() {
		log.debug("finding all Tagids instances");
		try {
			String queryString = "from Tagids";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tagids merge(Tagids detachedInstance) {
		log.debug("merging Tagids instance");
		try {
			Tagids result = (Tagids) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tagids instance) {
		log.debug("attaching dirty Tagids instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tagids instance) {
		log.debug("attaching clean Tagids instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}