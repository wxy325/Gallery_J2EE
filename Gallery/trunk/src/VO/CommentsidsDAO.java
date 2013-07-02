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
 * Commentsids entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see VO.Commentsids
 * @author MyEclipse Persistence Tools
 */

public class CommentsidsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CommentsidsDAO.class);
	// property constants
	public static final String OWNER_ID = "ownerId";
	public static final String COMMENT = "comment";
	public static final String PICTURE_ID = "pictureId";

	public void save(Commentsids transientInstance) {
		log.debug("saving Commentsids instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Commentsids persistentInstance) {
		log.debug("deleting Commentsids instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Commentsids findById(java.lang.Integer id) {
		log.debug("getting Commentsids instance with id: " + id);
		try {
			Commentsids instance = (Commentsids) getSession().get(
					"VO.Commentsids", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Commentsids instance) {
		log.debug("finding Commentsids instance by example");
		try {
			List results = getSession().createCriteria("VO.Commentsids")
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
		log.debug("finding Commentsids instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Commentsids as model where model."
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

	public List findByComment(Object comment) {
		return findByProperty(COMMENT, comment);
	}

	public List findByPictureId(Object pictureId) {
		return findByProperty(PICTURE_ID, pictureId);
	}

	public List findAll() {
		log.debug("finding all Commentsids instances");
		try {
			String queryString = "from Commentsids";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Commentsids merge(Commentsids detachedInstance) {
		log.debug("merging Commentsids instance");
		try {
			Commentsids result = (Commentsids) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Commentsids instance) {
		log.debug("attaching dirty Commentsids instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Commentsids instance) {
		log.debug("attaching clean Commentsids instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}