package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.sql.*; 
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.opencsv.CSVWriter;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;


public class UserDaoImpl implements UserDao {
	  @Autowired
	  JdbcTemplate jdbcTemplate;

	  @Autowired
	  DataSource datasource;
	  
	  File f;
	  
	  public String writeToFile(String path1,String path2,String path3,String path4,String path5,String path6)
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");  
			  Connection con=DriverManager.getConnection(  
			  "jdbc:mysql://localhost:3306/adaptive_web","root","Abhisana@1993");    
			  Statement stmt=con.createStatement();  
			  
			  // ---------------------FILE1
			  
			  ResultSet rs1=stmt.executeQuery
 ("select activity,count(*) total from activities where activity in('AskedQUestion','Voted','Commented','Shared') group by activity");  
			 // BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		        FileWriter outputfile1 = new FileWriter(path1); 
		        
		        // create CSVWriter object filewriter object as parameter 
		        CSVWriter writer1 = new CSVWriter(outputfile1); 
		        
		        // adding header to csv 
		       String[] header1 = { "action", "count" }; 
		       writer1.writeNext(header1); 
			  while(rs1.next()) 
			  {
				 // writer.write(rs.getString(1)+","+rs.getString(2)+","+rs.getInt(3)+"\n"); 
				  String[] data1 = { rs1.getString(1),rs1.getString(2)};
				  writer1.writeNext(data1);
			  }
	 
			 writer1.close();
			 
			 //----------------------------FILE2
			  ResultSet rs2=stmt.executeQuery("select username,count(*) from adaptive_web.activities where activity='Voted' group by username;");  
				 // BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			        FileWriter outputfile2 = new FileWriter(path2); 
			        
			        // create CSVWriter object filewriter object as parameter 
			        CSVWriter writer2 = new CSVWriter(outputfile2); 
			        
			        // adding header to csv 
			       String[] header2 = {"name", "value"}; 
			       writer2.writeNext(header2); 
				  while(rs2.next()) 
				  {
					 // writer.write(rs.getString(1)+","+rs.getString(2)+","+rs.getInt(3)+"\n"); 
					  String[] data2 = { rs2.getString(1),rs2.getString(2)};
					  writer2.writeNext(data2);
				  }
				  
				 writer2.close();
		 
				 
				 //----------------------------FILE3
				  ResultSet rs3=stmt.executeQuery("select username,count(*) from adaptive_web.activities where activity='AskedQuestion' group by username;");  
					 // BufferedWriter writer = new BufferedWriter(new FileWriter(path));
				        FileWriter outputfile3 = new FileWriter(path3); 
				        
				        // create CSVWriter object filewriter object as parameter 
				        CSVWriter writer3 = new CSVWriter(outputfile3); 
				        
				        // adding header to csv 
				       String[] header3 = { "name", "value" }; 
				       writer3.writeNext(header3); 
					  while(rs3.next()) 
					  {
						 // writer.write(rs.getString(1)+","+rs.getString(2)+","+rs.getInt(3)+"\n"); 
						  String[] data3 = { rs3.getString(1),rs3.getString(2)};
						  writer3.writeNext(data3);
					  }
					  
					 writer3.close();
					 
					 
					 //----------------------------FILE4
					  ResultSet rs4=stmt.executeQuery("select username,count(*) from adaptive_web.activities where activity='Commented' group by username;");  
						 // BufferedWriter writer = new BufferedWriter(new FileWriter(path));
					        FileWriter outputfile4 = new FileWriter(path4); 
					        
					        // create CSVWriter object filewriter object as parameter 
					        CSVWriter writer4 = new CSVWriter(outputfile4); 
					        
					        // adding header to csv 
					       String[] header4 = { "name", "value" }; 
					       writer4.writeNext(header4); 
						  while(rs4.next()) 
						  {
							 // writer.write(rs.getString(1)+","+rs.getString(2)+","+rs.getInt(3)+"\n"); 
							  String[] data4 = { rs4.getString(1),rs4.getString(2)};
							  writer4.writeNext(data4);
						  }
						  
						 writer4.close();	
						 
				
						 //----------------------------FILE5
						  ResultSet rs5=stmt.executeQuery("select username,count(*) from adaptive_web.activities where activity='Shared' group by username;");  
							 // BufferedWriter writer = new BufferedWriter(new FileWriter(path));
						        FileWriter outputfile5 = new FileWriter(path5); 
						        
						        // create CSVWriter object filewriter object as parameter 
						        CSVWriter writer5 = new CSVWriter(outputfile5); 
						        
						        // adding header to csv 
						       String[] header5 = { "name", "value" }; 
						       writer5.writeNext(header5); 
							  while(rs5.next()) 
							  {
								 // writer.write(rs.getString(1)+","+rs.getString(2)+","+rs.getInt(3)+"\n"); 
								  String[] data5 = { rs5.getString(1),rs5.getString(2)};
								  writer5.writeNext(data5);
							  }
							  
							 writer5.close();	
					 
					 
				 
		   //--------------------FILE6
		 //select username,activity,count(*) total from activities group by username,activity
			List<String> list=new ArrayList<String>();
			ResultSet rs6=stmt.executeQuery("select distinct(username) from activities;"); 
			
	        while(rs6.next())
	        {
	        	list.add(rs6.getString(1));
	        	System.out.println(rs6.getString(1));
	        }
	        int i=0;
			 // BufferedWriter writer = new BufferedWriter(new FileWriter(path));
	        FileWriter outputfile6 = new FileWriter(path6); 
	        
	        // create CSVWriter object filewriter object as parameter 
	        CSVWriter writer6 = new CSVWriter(outputfile6); 
	        // adding header to csv 
		       String[] header6 = { "State","Voted","AskedQuestion","Commented","Shared"}; 
		       writer6.writeNext(header6); 
	        
		    String user,voted,question,commented,shared;
		    ResultSet rs8;
	        while(i<list.size())
	        {
	        	user=list.get(i);
	        	rs8=stmt.executeQuery("select count(*) total from activities where username='"+user+"' and activity='Voted'");
	        	if(rs8.next())
                       voted=rs8.getString(1);
	        	else 
	        		voted="0";
	        	
	        	rs8=stmt.executeQuery("select count(*) total from activities where username='"+user+"' and activity='AskedQuestion'");
	        	if(rs8.next())
	        		question=rs8.getString(1);
	        	else 
	        		question="0";
	        	
	        	rs8=stmt.executeQuery("select count(*) total from activities where username='"+user+"' and activity='Commented'");
	        	if(rs8.next())
	        		commented=rs8.getString(1);
	        	else 
	        		commented="0";
	        	
	        	rs8=stmt.executeQuery("select count(*) total from activities where username='"+user+"' and activity='Shared'");
	        	if(rs8.next())
	        		shared=rs8.getString(1);
	        	else 
	        		shared="0";
	        	
	        	String[] data6 = {user,voted,question,commented,shared};
	            System.out.println(user+" "+voted+" "+question+" "+commented+" "+shared);
			    writer6.writeNext(data6); 
			    i++;
	        }
      	 writer6.close();	
         con.close();
			 
			 
		  }
		  catch(Exception e)
		  {
			  return e.toString();
		  }
		  return "success";
	  }
	  
	  
	  
	  public String updateActivity (String user,String activity,String time)
	  {
		 try { 
		  String insertSql =
    			  "INSERT INTO activities (" +
    			  " username, " +
    			  " activity, " +
    			  " date_time) " +
    			  "VALUES (?,?,?)";
      Object[] params = new Object[] {user,activity,time};
      int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
      jdbcTemplate.update(insertSql,params,types); 
      return "success"; 
	  }
	  catch(Exception e)
	  {
		  // return E.getMessage().toString();
		  return e.toString();
	  }  

	  }
	  
    public User validateUser(Login login) {
    /* Testing:
     * if(login.getUsername()=="abhi" && login.getPassword()=="abhi")
        return true;
    else 
        return false;*/
    	try {
    		 String generatedPassword=hashPassword(login.getPassword());
    		 System.out.println(login.getUsername()+" "+login.getPassword()+"  "+generatedPassword);
    	
         String sql = "select * from users where username='" + login.getUsername() + "' and password='" + generatedPassword + "'";	
         List<User> users = jdbcTemplate.query(sql, new UserMapper());
         return users.size() > 0 ? users.get(0):null;
    	}
  	     catch(Exception e)
		  {
			  // return E.getMessage().toString();
  	    	 System.out.println(e.toString());
			  return null;
		  }
    }
    
    public String register(User adduser){
		
    	  try {
  	  String sql = "select * from users where username='" + adduser.getUsername()+"'"; 	 
  	  List<User> users = jdbcTemplate.query(sql, new UserMapper());
	     // User user1= users.size() > 0 ? users.get(0) : null;
	      
	      if(users.size() > 0)
  	    {
  		  return "Please provide a new username as user already exists!";
  	    }
	    
	      String generatedPassword=hashPassword(adduser.getPassword());
	      
	      if(generatedPassword=="error")
	    	  return "Error!Contact Admin";
	            
  	    String insertSql =
	    			  "INSERT INTO users (" +
	    			  " firstname, " +
	    			  " lastname, " +
	    			  " username, " +
	    			  " password) " +
	    			  "VALUES (?,?,?,?)";
	   Object[] params = new Object[] {adduser.getFirstname(),adduser.getLastname(), adduser.getUsername(),generatedPassword};
      int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
	      jdbcTemplate.update(insertSql,params,types); 

	     return "Registered successfully!"; 
		  }
		  catch(Exception e)
		  {
			  // return E.getMessage().toString();
			  return e.toString();
		  }
	  }
    
     String hashPassword(String password)
     {
    	 try {
         // Create MessageDigest instance for MD5
         MessageDigest md = MessageDigest.getInstance("MD5");
         //Add password bytes to digest
         md.update(password.getBytes());
         //Get the hash's bytes
         byte[] bytes = md.digest();
         //This bytes[] has bytes in decimal format;
         //Convert it to hexadecimal format
         StringBuilder sb = new StringBuilder();
         for(int i=0; i< bytes.length ;i++)
         {
             sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
         }
         //Get complete hashed password in hex format
         return sb.toString();
    	 }
    	 catch(Exception e)
    	 {
    		 return e.toString();
    	 }
     }
		  
    
  }

class UserMapper implements RowMapper<User> {
public User mapRow(ResultSet rs, int arg1) throws SQLException {
  User user = new User();
  user.setUsername(rs.getString("username"));
  user.setPassword(rs.getString("password"));
  user.setFirstname(rs.getString("firstname"));
  user.setLastname(rs.getString("lastname"));
    return user;
}
}


