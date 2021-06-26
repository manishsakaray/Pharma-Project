<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.pharma.model.CustomerOffers" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>offers</title>
    <link rel="stylesheet" href="./css/offers.css" />
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
    <form action="offerscustomer" method="post">
    <input type="hidden" name="manish" value="manish"/>
    <input type="submit" value="refresh">
    </form>
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
    <th>Store Name</th><th>Product Name</th><th>Actual price</th><th>Store price</th>
    </tr>
    
    <%
      	List<CustomerOffers> cust_offers = (ArrayList<CustomerOffers>)session.getAttribute("cust_offers");
      	if(cust_offers != null){
      	for(int i=0; i<cust_offers.size(); i++){
    %>
    
    <tr class="retrieveddata" style="background-color: rgba(255, 255, 255, 0.808);
	border-radius: 6px;
	height: 80px;
	text-align: center;
	">
      		<td style="border-left: 2px solid orange;" class="retrieveddata"><%= cust_offers.get(i).getStore_name() %>
      		</td>
      		
      		<td class="retrieveddata"><%= cust_offers.get(i).getProd_name() %></td>
      		<td class="retrieveddata"><%= cust_offers.get(i).getCost() %></td>
      		
      		
      		<td style="border-right: 2px solid orange;" class="retrieveddata">
      		    <%= cust_offers.get(i).getCost() - cust_offers.get(i).getCost()*cust_offers.get(i).getDiscount()/100 %>
      			 <input type="hidden" name="latitude" value="<%= cust_offers.get(i).getLatitude() %>"/>
      			 <input type="hidden" name="longitude" value="<%= cust_offers.get(i).getLongitude() %>"/>
      			 
      	    </td>
      	</tr>
      	
      	<%
    } 
      	session.removeAttribute("cust_offers");
    }
       %>
      </table>
    
  </body>
</html>
