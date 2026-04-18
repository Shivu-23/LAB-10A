<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Form</title>

    <script>
        function validateForm() {
            let username = document.forms["userForm"]["username"].value;
            let email = document.forms["userForm"]["email"].value;
            let designation = document.forms["userForm"]["designation"].value;

            if (username === "" || email === "" || designation === "") {
                alert("All fields are required!");
                return false;
            }

            let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
            if (!email.match(emailPattern)) {
                alert("Invalid email format!");
                return false;
            }

            return true;
        }
    </script>

    <style>
        .box {
            width: 350px;
            margin: 80px auto;
            padding: 20px;
            border: 1px solid gray;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="box">
    <h2>User Data Form</h2>

    <form name="userForm" action="processUser" method="post" onsubmit="return validateForm()">

        Username: <br>
        <input type="text" name="username"><br><br>

        Email: <br>
        <input type="text" name="email"><br><br>

        Designation: <br>
        <input type="text" name="designation"><br><br>

        <input type="submit" value="Submit">
    </form>
</div>

</body>
</html>