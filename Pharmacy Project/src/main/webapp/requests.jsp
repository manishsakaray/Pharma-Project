<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.pharma.model.RetrieveRequests" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>requests</title>
    <link rel="stylesheet" href="./css/requests.css" />
    
  </head>
  <body>
    <header>
      <div>
        <img id="logo" src="./images/logo.png" alt="logo" />

        <ul>
          <li>
            <a href="./offers.jsp">Offers</a>
            <a href="./requests.jsp">Requests</a>
            <a id="last" href="./index.html"
              >Log out<img
                id="profile"
                src="./images/profile_image.png"
                alt="login"
            /></a>
          </li>
        </ul>
      </div>
    </header>
    
    
    <table class="data" style="border-collapse: separate;
    border-spacing: 0 10px;">
    <tr style="background-color: rgba(255, 255, 255, 0.808);
	border-radius: 6px;
	height: 80px;
	text-align: center;">
    <th>product Name</th><th>Requested Time Stamp</th><th>Availability</th>
    </tr>
    
    <%
      	List<RetrieveRequests> req_list = (ArrayList<RetrieveRequests>)session.getAttribute("req_list");
      	if(req_list != null){
      	for(int i=0; i<req_list.size(); i++){
    %>
    
    <tr class="retrieveddata" style="background-color: rgba(255, 255, 255, 0.808);
	border-radius: 6px;
	height: 80px;
	text-align: center;">
      		<td style="border-left: 2px solid orange;" class="retrieveddata"><%= req_list.get(i).getMessage() %>
      		</td>
      		
      		<td class="retrieveddata"><%= req_list.get(i).getTime_stamp() %></td>
      		<td style="border-right: 2px solid orange;" class="retrieveddata">
      		    <form action="getRequests" method="post"> 
      			 <input type="hidden" name="hiddenBool" value="<%= req_list.get(i).getReq_id() %>"/>
      			 <input type="hidden" name="filterindex" value="<%= i %>"/>
      			 <input  type="submit" value="yes" name="AvailabilityYes" >
      			 <input  type="submit" value="no" name="AvailabilityNo" >
      			</form> 
      	    </td>
      	</tr>
      	
      	<%
    } 
    }
       %>
      </table>
     
  </body>
</html>