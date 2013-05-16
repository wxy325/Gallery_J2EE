package org.shinshi.gallery.dao.jdbc;

import java.util.Iterator;
import java.util.Map;

/**
 * User: SpringNyan
 * Date: 13-4-19
 * Time: 上午12:05
 */
public class JdbcSqlBuilderImpl implements IJdbcSqlBuilder {
    private String sqlSave;
    private String sqlUpdate;
    private String sqlDelete;
    private String sqlGet;
    private String sqlCountAll;
    private String sqlListPage;
    private String sqlListAll;

    public JdbcSqlBuilderImpl() {
        sqlSave = "insert into %s(%s) values(%s)";
        sqlUpdate = "update %s set %s where %s";
        sqlDelete = "delete from %s where %s";
        sqlGet = "select * from %s where %s";
        sqlCountAll = "select count(*) from %s";
        sqlListAll = "select * from %s";
        sqlListPage = "select * from %s limit %d, %d";
    }

    @Override
    public String buildSave(String table, Map<String, String> paramMap) {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("table");
        }
        if (paramMap == null || paramMap.isEmpty()) {
            throw new IllegalArgumentException("paramMap");
        }

        StringBuilder sbKey = null, sbValue = null;
        boolean first = true;
        for (Map.Entry<String, String> e : paramMap.entrySet()) {
            if (first) {
                sbKey = new StringBuilder(e.getKey());
                sbValue = new StringBuilder(String.format(":%s", e.getValue()));
                first = false;
            } else {
                sbKey.append(String.format(", %s", e.getKey()));
                sbValue.append(String.format(", :%s", e.getValue()));
            }
        }

        return String.format(sqlSave, table, sbKey.toString(), sbValue.toString());
    }

    @Override
    public String buildUpdate(String table, String key, String value, Map<String, String> paramMap) {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("table");
        }
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("key");
        }
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("value");
        }
        if (paramMap == null || paramMap.isEmpty()) {
            throw new IllegalArgumentException("paramMap");
        }

        StringBuilder sb = null;
        boolean first = true;
        for (Map.Entry<String, String> e : paramMap.entrySet()) {
            if (first) {
                sb = new StringBuilder(String.format("%s = :%s", e.getKey(), e.getValue()));
                first = false;
            } else {
                sb.append(String.format(", %s = :%s", e.getKey(), e.getValue()));
            }
        }

        return String.format(sqlUpdate, table, sb.toString(), String.format("%s = :%s", key, value));
    }

    @Override
    public String buildDelete(String table, String key, String value) {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("table");
        }
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("key");
        }
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("value");
        }

        return String.format(sqlDelete, table, String.format("%s = :%s", key, value));
    }

    @Override
    public String buildGet(String table, String key, String value) {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("table");
        }
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("key");
        }
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("value");
        }

        return String.format(sqlGet, table, String.format("%s = :%s", key, value));
    }

    @Override
    public String buildCountAll(String table) {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("table");
        }

        return String.format(sqlCountAll, table);
    }

    @Override
    public String buildListAll(String table) {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("table");
        }

        return String.format(sqlListAll, table);
    }

    @Override
    public String buildListPage(String table, int page, int size) {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("table");
        }

        return String.format(sqlListPage, table, (page - 1) * size + 1, size);
    }
}
