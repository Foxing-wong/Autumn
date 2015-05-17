package us.cijian.autumn.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import us.cijian.autumn.config.Project;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Murphy on 3/18/2015.
 */
public final class MyBatisUtils {


    private MyBatisUtils() {
    }

    public final static void initMyBatisContext() {
        try {
            String env = System.getProperty(Project.ENV_KEY);
            if (StringUtils.isBlank(env)) {
                env = Project.PRODUCTION;
            }
            InputStream inputStream = Resources.getResourceAsStream(Project.MYBATIS_CONF);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, env);
            CacheUtils.cache(SqlSessionFactory.class, sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final static <T> T getMapper(Class<T> clazz){
        SqlSessionFactory factory = CacheUtils.get(SqlSessionFactory.class);
        return factory.getConfiguration().getMapper(clazz, factory.openSession());
    }

}
