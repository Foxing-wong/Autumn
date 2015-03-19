package us.cijian.autumn.servlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import us.cijian.autumn.config.Project;
import us.cijian.autumn.utils.StringUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Murphy on 3/18/2015.
 */
public final class MyBatisContext {


    private MyBatisContext() {
    }

    public final static void initMyBatisContext() {
        try {
            String env = System.getProperty(Project.ENV_KEY);
            if (StringUtils.isBlank(env)) {
                env = Project.PRODUCTION;
            }
            InputStream inputStream = Resources.getResourceAsStream(Project.MYBATIS_CONF);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, env);
            ApplicationCache.getInstance().setSqlSessionFactory(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final static <T> T getMapper(Class<T> clazz){
        ApplicationCache cache = ApplicationCache.getInstance();
        return cache.getSqlConfiguration().getMapper(clazz, cache.openSqlSession());
    }

}
