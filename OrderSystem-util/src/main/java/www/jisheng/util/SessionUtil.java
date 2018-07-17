package www.jisheng.util;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class SessionUtil {
    private final static Class<SessionUtil> LOCK = SessionUtil.class;

    private static SqlSessionFactory sqlSessionFactory = null;

    private SessionUtil() {
    }

    /**
     * 单例获取SqlSessionFactory
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        synchronized (LOCK) {
            if (sqlSessionFactory != null) {
                return sqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }

    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession(true);
    }
    /**
     * 关闭SqlSession
     */
    public static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null)
            sqlSession.close();
    }
}