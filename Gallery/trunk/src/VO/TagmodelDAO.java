package VO;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Tagmodel entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see VO.Tagmodel
 * @author MyEclipse Persistence Tools
 */

public class TagmodelDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TagmodelDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String COUNT = "count";
	public static final String TYPE = "type";
	public static final String CREATE_ID = "createId";
	public static final String AMBIGUOUS = "ambiguous";

	public void save(Tagmodel transientInstance) {
		log.debug("saving Tagmodel instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tagmodel persistentInstance) {
		log.debug("deleting Tagmodel instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tagmodel findById(java.lang.Integer id) {
		log.debug("getting Tagmodel instance with id: " + id);
		try {
			Tagmodel instance = (Tagmodel) getSession().get("VO.Tagmodel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Tagmodel instance) {
		log.debug("finding Tagmodel instance by example");
		try {
			List results = getSession().createCriteria("VO.Tagmodel")
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
		log.debug("finding Tagmodel instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Tagmodel as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByCount(Object count) {
		return findByProperty(COUNT, count);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByCreateId(Object createId) {
		return findByProperty(CREATE_ID, createId);
	}

	public List findByAmbiguous(Object ambiguous) {
		return findByProperty(AMBIGUOUS, ambiguous);
	}

	public List findAll() {
		log.debug("finding all Tagmodel instances");
		try {
			String queryString = "from Tagmodel";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tagmodel merge(Tagmodel detachedInstance) {
		log.debug("merging Tagmodel instance");
		try {
			Tagmodel result = (Tagmodel) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tagmodel instance) {
		log.debug("attaching dirty Tagmodel instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tagmodel instance) {
		log.debug("attaching clean Tagmodel instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}