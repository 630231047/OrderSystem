import com.jisheng.po.User;
import com.jisheng.service.AdminService;
import com.jisheng.service.AdminServiceImplTest;
import org.junit.Test;

public class AdminServiceTest {
    @Test
    public void test1(){
        AdminService adminServiceImplTest = AdminServiceImplTest.getAdminService();
        User user = new User();
        user.setUser_id(3);
        System.out.println(adminServiceImplTest.lookRole(user));
        System.out.println(adminServiceImplTest.getPermRole("/customerregister.jsp"));
    }
}
