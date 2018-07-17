
import com.jisheng.dao.*;
import com.jisheng.po.Role;
import com.jisheng.po.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import www.jisheng.dao.*;
import www.jisheng.po.*;
import com.jisheng.util.SessionUtil;

import java.util.List;

public class ClassTest {
    SqlSession sqlSession;
    UserDAO userDAO;
    AdminDAO adminDAO;
    CustomerDAO customerDAO;
    FoodDAO foodDAO;
    AssessDAO assessDao;
    RoleDAO roleDAO;
    User user;
    List<User>users;

//    List<List> objList;

    @Test
    public void testOO() {
        try{
        sqlSession = SessionUtil.openSqlSession();
        userDAO = sqlSession.getMapper(UserDAO.class);
        adminDAO = sqlSession.getMapper(AdminDAO.class);
        customerDAO = sqlSession.getMapper(CustomerDAO.class);
        foodDAO = sqlSession.getMapper(FoodDAO.class);
        assessDao = sqlSession.getMapper(AssessDAO.class);
            roleDAO = sqlSession.getMapper(RoleDAO.class);
        user=new User();
        user.setUsername("zmx");
//        user.setPassword("zmx");
//        userDAO.add(user);
//            user=(User)userDAO.checkLoginInfo(user);
//            userDAO.updateUserPassword(user, "123");
//            users=(List<User>)userDAO.getUser(user);
//            user=(User)userDAO.getUser(user);
//            objList = adminDAO.lookAll1();
//        sqlSession.commit();
//            Customer customer=new Customer(24,"chihuo1","111","111@","gongyi");
//            List<Customer>customerList= customerDAO.lookSomeOne(customer);
//            System.out.println(customerList);
//            customer.setId(12);
//            customerDAO.update(customer);
//            Food food = new Food(18, "aaa", 111, "aaa", "bbb");
////            foodDAO.add(food);
//            food.setName("");
//            food.setId(61);
//            food = (Food)foodDAO.lookPath(food);
//            System.out.println(food);

//            Assess assess=new Assess(4,"great","aaa","bbb",1,2,"2018-07-16");
//            assess.setId(5);
//            assess=assessDao.lookPath(assess);
//            float assessFloat = assessDao.getStoreMark(assess);
//            System.out.println(assess);
            Role role=new Role(123,"a");
            roleDAO.add(role);
        }
        finally{
            //在finally语句中确保资源被顺利关闭
            if(sqlSession != null){
                sqlSession.close();
            }
        }
//        System.out.println(objList);
    }
}
