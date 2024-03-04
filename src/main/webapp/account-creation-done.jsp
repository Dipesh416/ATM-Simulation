<!DOCTYPE html>
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
        <h1>Admin Login</h1>
    </header>
    
    <main>
        
        <h3>Account is created successful.</h3><br><br>
       
       
       <button><a href="admin_login.html">EXIT</a></button>
       
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
        &copy; 2023 Admin Portal. All rights reserved.
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
