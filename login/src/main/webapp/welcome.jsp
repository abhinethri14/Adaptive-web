<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<style type="text/css">
    .fieldset-auto-width {
         display: inline-block;
    }
    .button3 {
    background-color: #4CAF50;
    width: 500px;
    height: 50px;
    text-align:center;
    margin-left: 23%;
    } 
    .button1 {
    background-color: #4CAF50;
    width: 100px;
    height: 30px;
    float: right;
    }
    td
    {
    text-align: center;
    }
    .userform {
     margin: 0 auto;
     width: 960px; 
     height: 400px;
     #userlabel {
color: #B4886B;
font-weight: bold;
display: block;
width: 150px;
float: left;
    background-color: yellow;

}
}
</style>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome</title>
</head>
<body>
<div id="container" class="userform center-div"> 
<fieldset> 
<h1 align="center">Welcome ${username}</h1>

<h2 align="left">Firstname: ${firstname}</h2>
<h2 align="left">Lastname: ${lastname}</h2>


<br/>
<form action="Stackoverflow.jsp">
<button type="submit" class="button button3">Click Me to Navigate to Stack Overflow !!</button>
</form>
<br/>
<br/>
<p>
<h2><b>Why do you decide to log these actions?</b></h2>
The actions logged are: <b>Votes, Questions asked, Comments, Shares, edits and View info about other members of Stackoverflow page</b>
<br/>
<br/>
<b>Votes:</b> User votes when the answer solves his query/problem or when he is interested in verifying the answers given by others. If user's significant activity is to vote then this tells that user is interested in verifying the answers and providing feedbacks. If we can model such information in user's profile then we can group such users under one category and when they login we can display a list of questions, where answers have few or zero votes. Questions displayed should be relevant to the previous content with which he interacted.
<br/>
<br/>
<b>Shares:</b> If anyone is sharing the information at high frequency then the chances of him/her being trainer/teacher are high. In this case, we can provide a list of topics relevant to the shared content in the home page because helping such users to get more than what they expected will help to build the trust and also it will help their dependents indirectly, to improve their technical knowledge which is the main motive of the website (i.e spread knowledge).
<br/>
<br/>
<b>Comments:</b> Tracking this info is beneficial for both users and the website because we can provide the list(in the home page) of the questions which are unanswered to the users who answers frequently (should be relevant to the previous content with which user interacted). This step will help website to get the answers as quickly as possible and also users will be satisfied when they get multiple right answers 
<br/>
<br/>
<b>Questions asked:</b> This is one of the most important piece of information because stackoverflow website has been built to aid the users who are in search of the answers for their queries. Such info can be used for business purpose because if company comes up with an idea of premium membership then chances of them buying is high. When such users are targeted, it will be easy to convince because they trust the website, so they are using it quite often to find the answers.
<br/>
<br/>
<b>Edits:</b> Since questions posted can be answered by anyone on the internet, it is required to edit the comments if something is incorrect. If user finds that answer is correct but little correction is required then he can choose to edit instead of adding 1 more comment. Users who prefers editing can be presented with new answers so that they can analyze and do modification.
<br/>
<br/>
<b>View info about other members of Stackoverflow page:</b> Sometimes, recruiters might try to find good candidates on Stackoverflow. If we track this info then we can provide them with the list of users who are knowledgeable based on their past interaction with the website and make their job easy. 
</p>
<br/>
<br/>


<table border="1" >
<tr><th width="300" height="50">User Name</th><th width="300">Activity</th><th width="300">First Name</th>
<%
Connection con = null;
String url = "jdbc:mysql://localhost:3306/";
String db = "adaptive_web";
String driver = "com.mysql.jdbc.Driver";
String userName ="root";
String password="Abhisana@1993";

int sumcount=0;
String user_name=session.getAttribute("user").toString();
Statement st;
try{
Class.forName(driver).newInstance();
con = DriverManager.getConnection(url+db,userName,password);
String query = "select * from activities where username="+"'"+user_name+"'"+" order by date_time desc";
System.out.println(query);
st = con.createStatement();
ResultSet rs = st.executeQuery(query);
while(rs.next()){
%>
<tr><td height="50" ><%=rs.getString(1)%></td>
<td height="50"><%=rs.getString(2)%></td>
<td height="50"><%=rs.getString(3)%></td>
</tr>
<%
}
st.close();
}
catch(Exception e){
e.printStackTrace();
}
%>
</table>

<br/>
<br/>

<form method="POST"  action="logout">
<button type="submit" class="button button1">logout</button>
</form>
</form>

<br/>
</fieldset> 
</div>    
</body>
</html>
