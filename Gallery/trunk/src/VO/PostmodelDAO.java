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
 * Postmodel entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see VO.Postmodel
 * @author MyEclipse Persistence Tools
 */

public class PostmodelDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PostmodelDAO.class);
	// property constants
	public static final String MD5 = "md5";
	public static final String SIZE = "size";
	public static final String WIDTH = "width";
	public static final String HEIGHT = "height";
	public static final String CREATOR_ID = "creatorId";
	public static final String ARTIST_ID = "artistId";
	public static final String RATING = "rating";
	public static final String SCORE = "score";
	public static final String VISITED = "visited";
	public static final String STATUS = "status";
	public static final String NAME = "name";
	public static final String TITLE = "title";

	public void save(Postmodel transientInstance) {
		log.debug("saving Postmodel instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Postmodel persistentInstance) {
		log.debug("deleting Postmodel instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Postmodel findById(java.lang.Integer id) {
		log.debug("getting Postmodel instance with id: " + id);
		try {
			Postmodel instance = (Postmodel) getSession().get("VO.Postmodel",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Postmodel instance) {
		log.debug("finding Postmodel instance by example");
		try {
			List results = getSession().createCriteria("VO.Postmodel")
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
		log.debug("finding Postmodel instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Postmodel as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMd5(Object md5) {
		return findByProperty(MD5, md5);
	}

	public List findBySize(Object size) {
		return findByProperty(SIZE, size);
	}

	public List findByWidth(Object width) {
		return findByProperty(WIDTH, width);
	}

	public List findByHeight(Object height) {
		return findByProperty(HEIGHT, height);
	}

	public List findByCreatorId(Object creatorId) {
		return findByProperty(CREATOR_ID, creatorId);
	}

	public List findByArtistId(Object artistId) {
		return findByProperty(ARTIST_ID, artistId);
	}

	public List findByRating(Object rating) {
		return findByProperty(RATING, rating);
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findByVisited(Object visited) {
		return findByProperty(VISITED, visited);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findAll() {
		log.debug("finding all Postmodel instances");
		try {
			String queryString = "from Postmodel";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Postmodel merge(Postmodel detachedInstance) {
		log.debug("merging Postmodel instance");
		try {
			Postmodel result = (Postmodel) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Postmodel instance) {
		log.debug("attaching dirty Postmodel instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Postmodel instance) {
		log.debug("attaching clean Postmodel instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}