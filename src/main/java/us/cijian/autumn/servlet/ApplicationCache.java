package us.cijian.autumn.servlet;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import us.cijian.autumn.pojo.Setting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Murphy on 3/18/2015.
 */
public final class ApplicationCache {

    private SqlSessionFactory sqlSessionFactory;

    private ApplicationCache() {
    }

    public static ApplicationCache getInstance() {
        return Inner.ourInstance;
    }

    public SqlSession openSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public Configuration getSqlConfiguration() {
        return sqlSessionFactory.getConfiguration();
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private static class Inner {
        static ApplicationCache ourInstance = new ApplicationCache();
    }

}
