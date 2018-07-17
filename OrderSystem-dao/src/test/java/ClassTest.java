
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import www.jisheng.dao.AdminDAO;
import www.jisheng.dao.UserDAO;
import www.jisheng.po.User;
import www.jisheng.util.SessionUtil;

import java.util.List;

public class ClassTest {
    SqlSession sqlSession;
    UserDAO userDAO;
    AdminDAO adminDAO;
    User user;
    List<User>users;
    List<List> objList;

    @Test
    public void testOO() {
        try{
        sqlSession = SessionUtil.openSqlSession();
        userDAO = sqlSession.getMapper(www.jisheng.dao.UserDAO.class);
        adminDAO = sqlSession.getMapper(www.jisheng.dao.AdminDAO.class);
        user=new User();
        user.setUsername("zmx");
//        user.setPassword("zmx");
//        userDAO.add(user);
//            user=(User)userDAO.checkLoginInfo(user);
//            userDAO.updateUserPassword(user, "123");
//            users=(List<User>)userDAO.getUser(user);
//            user=(User)userDAO.getUser(user);
            objList = adminDAO.lookAll1();
//        sqlSession.commit();

        }
        finally{
            //在finally语句中确保资源被顺利关闭
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        System.out.println(objList);
    }
}
