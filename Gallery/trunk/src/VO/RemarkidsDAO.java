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
 * Remarkids entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see VO.Remarkids
 * @author MyEclipse Persistence Tools
 */

public class RemarkidsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RemarkidsDAO.class);
	// property constants
	public static final String REMARK = "remark";
	public static final String OWNER_ID = "ownerId";
	public static final String PICTURE_ID = "pictureId";

	public void save(Remarkids transientInstance) {
		log.debug("saving Remarkids instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Remarkids persistentInstance) {
		log.debug("deleting Remarkids instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Remarkids findById(java.lang.Integer id) {
		log.debug("getting Remarkids instance with id: " + id);
		try {
			Remarkids instance = (Remarkids) getSession().get("VO.Remarkids",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Remarkids instance) {
		log.debug("finding Remarkids instance by example");
		try {
			List results = getSession().createCriteria("VO.Remarkids")
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
		log.debug("finding Remarkids instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Remarkids as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByOwnerId(Object ownerId) {
		return findByProperty(OWNER_ID, ownerId);
	}

	public List findByPictureId(Object pictureId) {
		return findByProperty(PICTURE_ID, pictureId);
	}

	public List findAll() {
		log.debug("finding all Remarkids instances");
		try {
			String queryString = "from Remarkids";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Remarkids merge(Remarkids detachedInstance) {
		log.debug("merging Remarkids instance");
		try {
			Remarkids result = (Remarkids) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Remarkids instance) {
		log.debug("attaching dirty Remarkids instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Remarkids instance) {
		log.debug("attaching clean Remarkids instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}