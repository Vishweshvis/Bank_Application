<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" 
          content="width=device-width, initial-scale=1.0">
    <title>Online Payment-Page</title>
    <link rel="stylesheet" href="style.css">
</head>
<input type="hidden", id="status" values="<%=request.getAttribute("success") %>">
<body>
<script type="text/javascript">
var status = document.getElementById("status").value;
if(status=="success") {
	 window.location.href = "account.jsp";
}
</script>

<input >
    <div class="container">

        <form action="registration1" method="post">

            <div class="row">

                <div class="col">
                    <h3 class="title">
                        Billing Address
                    </h3>

                    <div class="inputBox">
                        <label for="name">
                              Full Name:
                          </label>
                        <input type="text" id="name" name="name" 
                               placeholder="Enter your full name" 
                               required>
                    </div>

                    <div class="inputBox">
                        <label for="email">
                              Email:
                          </label>
                        <input type="text" name="email" id="email" 
                               placeholder="Enter email address" 
                               required>
                    </div>

                    <div class="inputBox">
                        <label for="address">
                              Address:
                          </label>
                        <input type="text" id="address" 
                            name="address"   placeholder="Enter address" 
                               required>
                    </div>

                    <div class="inputBox">
                        <label for="city">
                              City:
                          </label>
                        <input type="text" id="city" name="city" 
                               placeholder="Enter city" 
                               required>
                    </div>

                    <div class="flex">

                        <div class="inputBox">
                            <label for="state">
                                  State:
                              </label>
                            <input type="text" id="state" name="state"
                                   placeholder="Enter state" 
                                   required>
                        </div>

                        <div class="inputBox">
                            <label for="zip">
                                  Zip Code:
                              </label>
                            <input type="number" name="zipcode" id="zip" 
                                   placeholder="123 456" 
                                   required>
                        </div>

                    </div>

                </div>
                <div class="col">
                    <h3 class="title">Payment</h3>

                    <div class="inputBox">
                        <label for="name">
                              Card Accepted:
                          </label>
                        <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20240715140014/Online-Payment-Project.webp" 
                             alt="credit/debit card image">
                    </div>

                    <div class="inputBox">
                        <label for="cardName">
                              Initial Amount:
                          </label>
                        <input type="number" id="cardName" name="amount"
                               placeholder="Initial Amount" 
                               required>
                    </div>

                    <div class="inputBox">
                        <label for="cardNum">
                             Pan number
                          </label>
                        <input type="number"cardNum" 
                               placeholder="1111-2222-3333" 
                               maxlength="12" required>
                    </div>

                    <div class="inputBox">
                        <input type="date" id="birthday" name="dob">
                    </div>


                    <div class="flex">
                        <div class="inputBox">
                            <label for="">Type of Account:</label>
                            <select name="typeofaccount" id="">
                                <option value="">Choose Acoount type</option>
                                <option value="2023">Savings</option>
                                <option value="2024">current</option>
                                
                            </select>
                        </div>

                        <div class="inputBox">
                            <label for="idproof">ID Proof</label>
                           <select name="idproof" id="">
                                <option value="">Select IdProof</option>
                                <option value="Aadhar number">  Aadhar number</option>
                                <option value="pan card"> pancard</option>
                               <option value="Driver license</">Driver license</option>
                                
                                
                            </select>
                        </div>
                    </div>

                </div>

            </div>

            <input type="submit" value="Proceed to Checkout" 
                   class="submit_btn">
        </form>

    </div>
    <script type="text/javascript" src="index.js"></script>
</body>

</html>
    