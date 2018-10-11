
package jbr.springmvc.dao;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
public interface UserDao {
 // void register(User user);
  User validateUser(Login login);
  String register(User adduser);
  String updateActivity(String user,String activity,String time);
  String writeToFile(String path1,String path2,String path3,String path4,String path5,String path6);
}