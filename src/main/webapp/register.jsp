<%-- 
    Document   : register1
    Created on : Dec 13, 2023, 12:19:40 AM
    Author     : thine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Design by foolishdeveloper.com -->
        <title>Glassmorphism login Form Tutorial in html css</title>

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
        <!--Stylesheet-->
        <style media="screen">
            .error-message {
                color: red;
                /* Màu chữ */
                background-color: #ffd6d6;
                border: 1px solid red;
                padding: 10px;
                margin: 4px 0;
                border-radius: 5px;
                display: none;
            }

            *,
            *:before,
            *:after {
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }

            body {
                background-color: #080710;
            }

            .background {
                width: 430px;
                height: 520px;
                position: absolute;
                transform: translate(-50%, -50%);
                left: 50%;
                top: 50%;
            }

            .background .shape {
                height: 200px;
                width: 200px;
                position: absolute;
                border-radius: 50%;
            }

            .shape:first-child {
                background: linear-gradient(#1845ad,
                    #23a2f6);
                left: -80px;
                top: -80px;
            }

            .shape:last-child {
                background: linear-gradient(to right,
                    #ff512f,
                    #f09819);
                right: -30px;
                bottom: -80px;
            }

            form {
                height: 660px;
                width: 400px;
                background-color: rgba(255, 255, 255, 0.13);
                position: absolute;
                transform: translate(-50%, -50%);
                top: 50%;
                left: 50%;
                border-radius: 10px;
                backdrop-filter: blur(10px);
                border: 2px solid rgba(255, 255, 255, 0.1);
                box-shadow: 0 0 40px rgba(8, 7, 16, 0.6);
                padding: 50px 35px;
            }

            form * {
                font-family: 'Poppins', sans-serif;
                color: #ffffff;
                letter-spacing: 0.5px;
                outline: none;
                border: none;
            }

            form h3 {
                font-size: 32px;
                font-weight: 500;
                line-height: 42px;
                text-align: center;
            }

            label {
                display: block;
                margin-top: 16px;
                font-size: 16px;
                font-weight: 500;
            }

            input {
                display: block;
                height: 50px;
                width: 100%;
                background-color: rgba(255, 255, 255, 0.07);
                border-radius: 3px;
                padding: 0 10px;
                margin-top: 4px;
                font-size: 14px;
                font-weight: 300;
            }

            ::placeholder {
                color: #e5e5e5;
            }

            .button1 {
                margin-top: 20px;
                width: 100%;
                background-color: #ffffff;
                color: #080710;
                padding: 12px 0;
                font-size: 18px;
                font-weight: 600;
                border-radius: 5px;
                cursor: pointer;
            }

            .button2 {
                margin-top: 10px;
                width: 100%;
                background-color: #ffffff;
                color: #080710;
                padding: 12px 0;
                font-size: 18px;
                font-weight: 600;
                border-radius: 5px;
                cursor: pointer;
            }

            .social {
                margin-top: 30px;
                display: flex;
            }

            .social div {
                background: red;
                width: 150px;
                border-radius: 3px;
                padding: 5px 10px 10px 5px;
                background-color: rgba(255, 255, 255, 0.27);
                color: #eaf0fb;
                text-align: center;
            }

            .social div:hover {
                background-color: rgba(255, 255, 255, 0.47);
            }

            .social .fb {
                margin-left: 25px;
            }

            .social i {
                margin-right: 4px;
            }
        </style>
    </head>

    <body>
        <div class="background">
            <div class="shape"></div>
            <div class="shape"></div>
        </div>
        <form method="post" action="register" class="register-form"
              id="register-form">
            <h3>Register</h3>
            <div id="error-message" class="error-message"></div>
            <label for="username">Username</label>
            <input type="text" placeholder="Email or Phone" name="username" id="username">

            <label for="password">Password</label>
            <input type="password" placeholder="Password" name="password" id="password">

            <label for="Repeatpassword">Repeat password</label>
            <input type="password" placeholder="Repeat password" id="Repeatpassword">

            <button type='button' name="signin" id="register"
                    class="button1" >Register</button>
            <button class="button2" type='button' id='login'>Log In</button>

            <div class="social">
                <div class="go"><i class="fab fa-google"></i> Google</div>
                <div class="fb"><i class="fab fa-facebook"></i> Facebook</div>
            </div>
        </form>
    </body>
    <script>
        var register = document.getElementById('register').onclick = function handleRegister() {
            var form = document.getElementById('register-form');
            var password = document.getElementById('password');
            var repeatPassword = document.getElementById('Repeatpassword');
            var errorMessage = document.getElementById('error-message');

            if (password.value === repeatPassword.value) {
                form.submit();
            } else {
                errorMessage.innerText = 'Mật khẩu và mật khẩu nhập lại không trùng';
                errorMessage.style.display = 'block';
            }
        }

        var btnLogin = document.getElementById('login').onclick = function handleLogin() {
            window.location.href = "http://localhost:8080/Trang-chu/login";
        }
    </script>

</html>