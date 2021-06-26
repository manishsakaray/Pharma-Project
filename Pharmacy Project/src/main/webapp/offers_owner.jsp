<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.pharma.model.RetrieveOffers" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>requests</title>
    <link rel="stylesheet" href="./css/offers_owner.css" />
    <script>
      function offerValidation() {
        var name = document.getElementById(offersproductname).value;
        var cost = document.getElementById(offersproductcost).value;
        var discount = document.getElementById(offersproductdiscount).value;
        if (name == "" || cost == "" || discount == "") {
          alert("please fill the empty fields");
        }
        if (discount > 100) {
          alert("invalid discount!! value should be below 100");
        }
      }
    </script>
  </head>
  <body>
    <header>
      <div>
        <img id="logo" src="./images/logo.png" alt="logo" />

        <ul>
          <li>
            <a href="./offers_owner.jsp">Offers</a>
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
    <main>
      <div id="outerdiv">
        <div id="innerdiv">
          <form action="offersowner" method="post">
          <table>
            <tr>
              <td>
                <label for="name">Product name<span>*</span>: </label>
                <input
                  id="offersproductname"
                  type="text"
                  placeholder="eg: dettol handwash"
                  name="offersproductname"
                />
              </td>
            </tr>
            <tr>
              <td>
                <label for="cost">Product MRP<span>*</span>: </label>
                <input
                  id="offersproductcost"
                  type="number"
                  placeholder="in Rupees"
                  name="offersproductcost"
                />
              </td>
            </tr>

            <tr>
              <td>
                <label for="discount">Discount<span>*</span>: </label>
                <input
                  id="offersproductdiscount"
                  type="number"
                  placeholder="in percentage(%)"
                  name="offersproductdiscount"
                />
              </td>
            </tr>

            <tr>
              <td align="center">
                <button id="offersproductbutton" type="submit" onclick="offerValidation()">
                  Add Offer
                </button>
              </td>
            </tr>
          </table>
          </form>
          <script>
          function offerValidation(){
          var a=document.getElementById(offersproductname).value  ;
          var b=document.getElementById(offersproductcost).value ;
          var c=document.getElementById(offersproductdiscount).value ;
          if( a=="" || b=="" || c="") alert("please enter the details");
          }
          </script>
        </div>
      </div>
      
      <br><br>
      
      <table class="data" style="border-collapse: separate;
    border-spacing: 0 10px;">
      
       <tr style="background-color: rgba(255, 255, 255, 0.808);
	border-radius: 6px;
	height: 80px;
	text-align: center;">
        	<th>product ID</th><th>Proudct Name</th><th>Actual Price</th><th>Our Price</th><th>Discount (%)</th>
        </tr>
      	<%
      	List<RetrieveOffers> offers = (ArrayList<RetrieveOffers>)session.getAttribute("owner_offers");
      	if(offers != null){
      	for(RetrieveOffers offer : offers){
        %>
        
      	<tr class="retrieveddata" style="background-color: rgba(255, 255, 255, 0.808);
	border-radius: 6px;
	height: 80px;
	text-align: center;">
      		<td style="border-left: 2px solid orange;" class="retrieveddata"><%= offer.getProd_id() %></td>
      		<td class="retrieveddata"><%= offer.getName() %></td>
      		<td class="retrieveddata"><%= offer.getCost() %> </td>
      		<td class="retrieveddata"><%= offer.getCost() - offer.getCost()*offer.getDiscount()/100 %></td>
      		<td style="border-right: 2px solid orange;" class="retrieveddata"><%= offer.getDiscount() %></td>
      	</tr>
      	<%} session.removeAttribute("owner_offers"); } %>
      </table>
      
    </main>
  </body>
</html>