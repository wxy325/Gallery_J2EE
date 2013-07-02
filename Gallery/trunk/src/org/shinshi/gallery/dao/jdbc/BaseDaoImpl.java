package org.shinshi.gallery.dao.jdbc;

import org.shinshi.gallery.dao.IBaseDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: SpringNyan
 * Date: 13-5-11
 * Time: 下午1:46
 */
public class BaseDaoImpl<M extends Serializable, PK extends Serializable> implements IBaseDao<M, PK> {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private IJdbcSqlBuilder jdbcSqlBuilder;
    private String table;
    private String primaryKey;
    private Map<String, String> propertyMap;
    private Class<M> modelClass;

    public BaseDaoImpl(JdbcTemplate jdbcTemplate, IJdbcSqlBuilder jdbcSqlBuilder, String table, String primaryKey, M model) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        this.jdbcSqlBuilder = jdbcSqlBuilder;
        this.table = table;
        this.primaryKey = primaryKey;
        propertyMap = buildPropertyMap(model);
        modelClass = (Class<M>) model.getClass();
    }

    private Map<String, String> buildPropertyMap(M model)
    {
        Map<String, String> map = new HashMap<String, String>();
        for (String e : new BeanPropertySqlParameterSource(model).getReadablePropertyNames())
            map.put(e, e);
        return map;
    }

    @Override
    public PK save(M model) {
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(model);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = jdbcSqlBuilder.buildSave(table, propertyMap);
        jdbcTemplate.update(sql, paramSource, keyHolder);
        return (PK) keyHolder.getKey();
    }

    @Override
    public void update(M model) {
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(model);
        String sql = jdbcSqlBuilder.buildUpdate(table, primaryKey, paramSource.getValue(primaryKey).toString(), propertyMap);
        jdbcTemplate.update(sql, paramSource);
        Class hehe = getClass();
        Type t = hehe.getGenericSuperclass();
    }

    @Override
    public void delete(PK id) {
        String sql = jdbcSqlBuilder.buildDelete(table, primaryKey, id.toString());
        jdbcTemplate.update(sql, (Map) null);
    }

    @Override
    public M get(PK id) {
        String sql = jdbcSqlBuilder.buildGet(table, primaryKey, id.toString());

        ////TODO 这里的(M)是我加的。。。不然编译通不过。。吴翔宇。。
        return (M)jdbcTemplate.queryForObject(sql, (Map) null, modelClass);
    }

    @Override
    public int countAll() {

        String sql = jdbcSqlBuilder.buildCountAll(table);
        return jdbcTemplate.queryForObject(sql, (Map) null, int.class);
    }

    @Override
    public List<M> listAll() {
        String sql = jdbcSqlBuilder.buildListAll(table);
        return jdbcTemplate.queryForList(sql, (Map) null, modelClass);
    }

    @Override
    public List<M> listPage(int pageNumber, int pageSize) {
        String sql = jdbcSqlBuilder.buildListPage(table, pageNumber, pageSize);
        return jdbcTemplate.queryForList(sql, (Map) null, modelClass);
    }
}
