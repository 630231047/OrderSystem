import com.jisheng.dao.AdminDAO;
import com.jisheng.po.Admin;
import com.jisheng.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOTest extends BaseTest {
    @Autowired
//    AdminDAO adminDAO;
            AdminService adminService;

    @Test
    public void test1() {
        System.out.println(adminService.getPermRole("/assessPage.jsp"));
    }
}
