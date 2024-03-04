<!DOCTYPE html>
<html>
<head>
    <title>ATM Withdrawal</title>
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
        
        input[type="text"] {
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
        <h2>Withdrawal</h2>
        <form action="WithdrawServlet" method="post">
            <label for="amount">Withdrawal Amount:</label>
            <input type="text" id="amount" name="amount" required>
            <br>
            <input type="submit" value="Withdraw">
        </form>
    </main>
    
    <footer>
        &copy; 2023 My ATM. All rights reserved.
    </footer>
</body>
</html>
