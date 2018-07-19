
import com.jisheng.bo.AdminLookRole;
import com.jisheng.bo.LookCusOrder1;
import com.jisheng.bo.LookCusPaidOrder;
import com.jisheng.bo.LookCusStatusOrder;
import com.jisheng.dao.*;
import com.jisheng.po.Order;
import com.jisheng.po.Role;
import com.jisheng.po.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.jisheng.util.SessionUtil;

import java.util.List;

public class ClassTest {
    SqlSession sqlSession;
    UserDAO userDAO;
    AdminDAO adminDAO;
    CustomerDAO customerDAO;
    FoodDAO foodDAO;
    OrderDAO orderDAO;
    AssessDAO assessDao;
    RoleDAO roleDAO;
    User user;
    List<User> users;

//    List<List> objList;

    @Test
    public void testOO() {
//        try {
//            sqlSession = SessionUtil.openSqlSession();
//            userDAO = sqlSession.getMapper(UserDAO.class);
//            adminDAO = sqlSession.getMapper(AdminDAO.class);
//            customerDAO = sqlSession.getMapper(CustomerDAO.class);
//            foodDAO = sqlSession.getMapper(FoodDAO.class);
//            assessDao = sqlSession.getMapper(AssessDAO.class);
//            orderDAO = sqlSession.getMapper(OrderDAO.class);
//            roleDAO = sqlSession.getMapper(RoleDAO.class);
//        user=new User();
//        user.setUsername("zmx");
        System.out.println(adminDAO.lookAll1());
//        user.setPassword("zmx");
//        userDAO.add(user);
//            user=(User)userDAO.checkLoginInfo(user);
//            System.out.println(user);
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
//            Role role=new Role(123,"a");
//            roleDAO.add(role);
//            User user1=new User(3,"123","123");
////            List<AdminLookRole> adminLookRole=adminDAO.lookRole(user1);
////            String s1=adminDAO.getPermRole("/myOrderPage.jsp");
//            List<LookCusOrder1> lookCusOrder1 = orderDAO.lookCusOrder1
//                    (new Order(2,1,"a",2,1,"111"));
//            System.out.println(lookCusOrder1);
//        }
//        finally{
//                //在finally语句中确保资源被顺利关闭
//                if (sqlSession != null) {
//                    sqlSession.close();
//                }
////        }
////        System.out.println(objList);
//            }
//
//        }
    }
}