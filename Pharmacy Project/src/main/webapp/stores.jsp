<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.pharma.model.CustomerStore" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>stores</title>
    <link rel="stylesheet" href="./css/stores.css" />
    <style>
    	.mapsbutton{
	font-family: Georgia, "Times New Roman", Times, serif;
  font-weight: 400;
  width: 120px;
  height: 35px;
  border: 1px solid green;
  border-radius: 20px;
  outline: none;
  background-color: rgba(0, 128, 0, 0.61);
  cursor: pointer;
  font-size: 18px;
}
    </style>
  </head>
  <body>
    <header>
      <div>
        <a href="./index.html"
          ><img id="logo" src="./images/logo.png" alt="logo"
        /></a>
        <ul>
          <li>
            <a href="./stores.jsp" >Stores</a>
            <a href="./offers.jsp" >Offers</a>
            
            <a href="./index.html">Home</a>
            <a href="./contacts.html">Contact</a>
            <a href="./register.html">Register</a>
            <span>|</span>
            <a id="last" href="./login.html"
              >Log in<img
                id="profile"
                src="./images/profile_image.png"
                alt="login"
            /></a>
          </li>
        </ul>
      </div>
    </header>
    <div style="width: 100%;
  height: 60px;
  background-color: rgba(255, 255, 255, 0.808);
  border: 2px solid rgba(255, 255, 255, 0.822);
  border-radius: 6px;
  margin-top: 10px;
  color: red;
  line-height: 60px;">
      <marquee direction="left"
        >Note: This page could be empty because the owner might not have
        responded yet or you might not have searched for a medicine!</marquee
      >
    </div>
    
    <table class="data" style="border-collapse: separate;
    border-spacing: 0 10px;
    width: 70%;
    margin: 20px auto;">
    
    <tr style="background-color: rgba(255, 255, 255, 0.808);
	border-radius: 6px;
	height: 80px;
	text-align: center;
	width: 70%;
	margin: 20px auto;">
    <th>Store Name</th><th>Searched Product</th><th>Time Stamp</th><th>Availability</th><th>Location</th>
    </tr>
    
    <%
        ArrayList<CustomerStore> cust_store = (ArrayList<CustomerStore>)session.getAttribute("cust_store");
      	if(cust_store != null){
      	for(int i=0; i<cust_store.size(); i++){
    %>
    
    <tr class="retrieveddata" style="background-color: rgba(255, 255, 255, 0.808);
	border-radius: 6px;
	height: 80px;
	text-align: center;
	">
      		<td style="border-left: 2px solid orange;" class="retrieveddata"><%= cust_store.get(i).getStore_name() %>
      		</td>
      		<td class="retrieveddata"><%= cust_store.get(i).getMessage() %></td>
      		<td class="retrieveddata"><%= cust_store.get(i).getTime_stamp() %></td>
      		<td class="retrieveddata"> <%= cust_store.get(i).getAvailability() %></td>
      		
      		
      		<td style="border-right: 2px solid orange;" class="retrieveddata">
      		    <form action="custstore" method="post">
      			 <input type="hidden" name="latitude" value="<%= cust_store.get(i).getLatitude() %>"/>
      			 <input type="hidden" name="longitude" value="<%= cust_store.get(i).getLongitude() %>"/>
      			 <input type="submit" class="mapsbutton"value="Get Location" name="getStoreLocation">
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
    