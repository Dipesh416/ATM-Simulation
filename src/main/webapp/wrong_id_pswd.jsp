<!DOCTYPE html>
<%@page import="com.nt.service.CheckBalanceServlet"%>
<%@page import="com.nt.service.WithdrawServlet"%>
<html>
<head>
    <title>ATM Simulation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        
        header {
            background-color: #333;
            padding: 20px;
            color: #fff;
            text-align: center;
        }
        
        h1 {
            margin: 0;
        }
        
        main {
            padding: 20px;
            text-align: center;
        }
        
        label {
            display: block;
            margin-bottom: 10px;
        }
        
        input[type="text"],
        input[type="password"] {
            width: 200px;
            padding: 5px;
            font-size: 16px;
        }
        
        input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #333;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        
        footer {
            background-color: #333;
            padding: 10px;
            color: #fff;
            text-align: center;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to the ATM</h1>
    </header>
    
    <main>
        <h2>ATM Simulation</h2><br>
        
        <h3>Wrong Account Number and Password</h3><br><br>
       
       
       <button><a href="index.html">EXIT</a></button>
       
        <!-- <form id="atmForm" action="findaccount" method="get">
            <label for="accnumber">Enter Account Number:</label>
            <input type="text" id="accnumber" name="accnumber" required>
            <br>
            <label for="pin">Enter PIN:</label>
            <input type="password" id="pin" name="pin" required>
            <br>
            <input type="submit" value="Submit">
        </form>
 -->   
  </main>
    
    <footer>
        &copy; 2023 My ATM. All rights reserved.
    </footer>
    
    <!-- <script>
        document.getElementById("atmForm").addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent form submission
            
            var pin = document.getElementById("pin").value;
            
            // Perform ATM simulation logic here
            
            // Clear the PIN input field
            document.getElementById("pin").value = "";
        });
    </script> -->
</body>
</html>
