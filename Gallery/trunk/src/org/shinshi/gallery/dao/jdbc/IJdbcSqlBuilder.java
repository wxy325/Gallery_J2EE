package org.shinshi.gallery.dao.jdbc;

import java.util.Map;

/**
 * User: SpringNyan
 * Date: 13-4-18
 * Time: 下午11:41
 */
public interface IJdbcSqlBuilder {
    public String buildSave(String table, Map<String, String> paramMap);
    public String buildUpdate(String table, String key, String value, Map<String, String> paramMap);
    public String buildDelete(String table, String key, String value);
    public String buildGet(String table, String key, String value);
    public String buildCountAll(String table);
    public String buildListAll(String table);
    public String buildListPage(String table, int page, int size);
}
