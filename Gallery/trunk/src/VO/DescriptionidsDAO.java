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
 * Descriptionids entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see VO.Descriptionids
 * @author MyEclipse Persistence Tools
 */

public class DescriptionidsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DescriptionidsDAO.class);
	// property constants
	public static final String DESCRIPTION = "description";
	public static final String OWNER_ID = "ownerId";
	public static final String PICTURE_ID = "pictureId";

	public void save(Descriptionids transientInstance) {
		log.debug("saving Descriptionids instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Descriptionids persistentInstance) {
		log.debug("deleting Descriptionids instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Descriptionids findById(java.lang.Integer id) {
		log.debug("getting Descriptionids instance with id: " + id);
		try {
			Descriptionids instance = (Descriptionids) getSession().get(
					"VO.Descriptionids", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Descriptionids instance) {
		log.debug("finding Descriptionids instance by example");
		try {
			List results = getSession().createCriteria("VO.Descriptionids")
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
		log.debug("finding Descriptionids instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Descriptionids as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByOwnerId(Object ownerId) {
		return findByProperty(OWNER_ID, ownerId);
	}

	public List findByPictureId(Object pictureId) {
		return findByProperty(PICTURE_ID, pictureId);
	}

	public List findAll() {
		log.debug("finding all Descriptionids instances");
		try {
			String queryString = "from Descriptionids";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Descriptionids merge(Descriptionids detachedInstance) {
		log.debug("merging Descriptionids instance");
		try {
			Descriptionids result = (Descriptionids) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Descriptionids instance) {
		log.debug("attaching dirty Descriptionids instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Descriptionids instance) {
		log.debug("attaching clean Descriptionids instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}