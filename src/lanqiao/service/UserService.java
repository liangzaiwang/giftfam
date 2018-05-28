package lanqiao.service;
import lanqiao.dao.*;
import lanqiao.entity.*;
public class UserService {

	//查看管理员
	public static User findManager(String username){
		User user=new User();
		user=UserControl.selectManager(username);
		return user;
	}
}
