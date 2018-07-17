import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.jisheng.dao.StorerDAO;
import com.jisheng.po.Storer;
import com.jisheng.util.SessionUtil;

import java.util.List;

public class StorerDAOTest {
    SqlSession sqlSession;
    Storer storer;
    StorerDAO storerDAO;
    List<Storer> storerList;
    @Test
    public void testOO() {
        try{
            sqlSession = SessionUtil.openSqlSession();
            storerDAO=sqlSession.getMapper(StorerDAO.class);
            storer = new Storer(18, "好吃的", "午饭", 4, "正常");
            storer.setStore_id(20);
//            storerDAO.add(storer);
            storerList = storerDAO.lookAllApply();
            System.out.println(storerList);
        }
        finally{
            //在finally语句中确保资源被顺利关闭
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
