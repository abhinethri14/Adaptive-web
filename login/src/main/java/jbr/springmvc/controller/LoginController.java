package jbr.springmvc.controller;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

import jbr.springmvc.dao.UserDaoImpl;

@Controller
@SessionAttributes("user")
public class LoginController {
  @Autowired
  UserDaoImpl userService;

  
  @RequestMapping(value = "/UpdateDatabase", method = RequestMethod.POST)
  public @ResponseBody void updateDatabase(HttpSession session,@RequestParam("activity") String ac)
  {
	   Date now=new Date();
	  Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String date_string = formatter.format(now);
	  String res=userService.updateActivity(session.getAttribute("user").toString(),ac,date_string);
	  
    //  ServletContext sc = session.getServletContext();
	// String response=userService.writeToFile(sc.getRealPath("/")+"input.csv");
	  
  String basic_path=System.getProperty("user.home")+"/Desktop/"+"/AbhinethriAW/";
 // Path basic_path=Paths.get(user_path);
  
	  String path1=basic_path+"input_donut.csv";
	  String path2=basic_path+"Voted.csv";
	  String path3=basic_path+"AskedQuestion.csv";
	  String path4=basic_path+"Commented.csv";
	  String path5=basic_path+"Shared.csv";
	  String path6=basic_path+"input_heat.csv";
	  String response=userService.writeToFile(path1,path2,path3,path4,path5,path6);
	  System.out.println(session.getAttribute("user").toString()+"  "+ac+" "+date_string);
	  System.out.println("Database insert "+res);
	  System.out.println("File write: "+response);
	  System.out.println(path1+" "+path2);
	  return;
  }
  
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,HttpSession session,
  @ModelAttribute("login") Login login) {
	  
	  
	  ModelAndView mav = null;
    User user = userService.validateUser(login);
    if (user!=null) {
    	  Date now=new Date();
    	  Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	  String date_string = formatter.format(now);
    	  session.setAttribute("user", user.getUsername());
   String res=userService.updateActivity(session.getAttribute("user").toString(),"login",date_string);	
    mav = new ModelAndView("welcome");
    mav.addObject("firstname", user.getFirstname());
    mav.addObject("lastname", user.getLastname());
    mav.addObject("username", user.getUsername());
    
    } else {
    mav = new ModelAndView("home");
    mav.addObject("message", "Username or Password is wrong!!");
    }
    return mav;
  }
  
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ModelAndView adduser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("adduser") User adduser) 
  {
   ModelAndView mav = null;
     String ans=userService.register(adduser);
     mav = new ModelAndView("registration");
     mav.addObject("message",ans);
    return mav;
  }
  
  @RequestMapping(value = "/logout", method = RequestMethod.POST)
  public ModelAndView logout(HttpServletRequest request,HttpSession session)
  {
	  Date now=new Date();
  	  Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  	  String date_string = formatter.format(now);
  	  String res=userService.updateActivity(session.getAttribute("user").toString(),"logout",date_string);
     //session.setAttribute("users","");
  	 
  	 if(res=="success")
  	 {
  	 session.invalidate();
  	 session = request.getSession(false);
  	 }
     return new ModelAndView("home");
  }
  
  
  @RequestMapping(value = "/visualization", method = RequestMethod.GET)
  public void visualization(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException
  {
	 // String user_path=System.getProperty("user.hone")+"/Desktop/"+"/AbhinethriAW/";
	 // Path basic_path=Paths.get(user_path);
     // response.sendRedirect(basic_path);
  }
  
}