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
 * Artistmodel entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see VO.Artistmodel
 * @author MyEclipse Persistence Tools
 */

public class ArtistmodelDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ArtistmodelDAO.class);
	// property constants
	public static final String ALIAS_ID = "aliasId";
	public static final String NAME = "name";
	public static final String CREATOR_ID = "creatorId";

	public void save(Artistmodel transientInstance) {
		log.debug("saving Artistmodel instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Artistmodel persistentInstance) {
		log.debug("deleting Artistmodel instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Artistmodel findById(java.lang.Integer id) {
		log.debug("getting Artistmodel instance with id: " + id);
		try {
			Artistmodel instance = (Artistmodel) getSession().get(
					"VO.Artistmodel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Artistmodel instance) {
		log.debug("finding Artistmodel instance by example");
		try {
			List results = getSession().createCriteria("VO.Artistmodel")
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
		log.debug("finding Artistmodel instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Artistmodel as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAliasId(Object aliasId) {
		return findByProperty(ALIAS_ID, aliasId);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByCreatorId(Object creatorId) {
		return findByProperty(CREATOR_ID, creatorId);
	}

	public List findAll() {
		log.debug("finding all Artistmodel instances");
		try {
			String queryString = "from Artistmodel";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Artistmodel merge(Artistmodel detachedInstance) {
		log.debug("merging Artistmodel instance");
		try {
			Artistmodel result = (Artistmodel) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Artistmodel instance) {
		log.debug("attaching dirty Artistmodel instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Artistmodel instance) {
		log.debug("attaching clean Artistmodel instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}