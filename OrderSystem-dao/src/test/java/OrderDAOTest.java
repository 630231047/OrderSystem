import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.jisheng.dao.OrderDAO;
import com.jisheng.po.Order;
import com.jisheng.util.SessionUtil;

import java.util.List;

public class OrderDAOTest {
    SqlSession sqlSession;
    OrderDAO orderDAO;
    Order order;
    @Test
    public void testOO() {
        try{
            sqlSession = SessionUtil.openSqlSession();
            orderDAO=sqlSession.getMapper(OrderDAO.class);
            order=new Order(2,43,"已付款",2,1,"2018-07-15");
            order.setId(84);
//            orderDAO.add(order);
            List<Order> orderList = orderDAO.lookCanDelOrder();
            System.out.println(orderList);
        }
        finally{
            //在finally语句中确保资源被顺利关闭
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
