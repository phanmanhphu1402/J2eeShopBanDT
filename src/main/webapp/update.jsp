<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Update Account </title>

        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 20px;
            }
            h1 {
                text-align: center;
                color:firebrick;
            }
            form {
                max-width: 500px;
                margin: 0 auto;
                background: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            label {
                display: block;
                margin-bottom: 5px;
            }
            input[type="text"] {
                width: calc(100% - 12px);
                padding: 8px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }
            button[type="submit"] {
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 3px;
                cursor: pointer;
            }
            button[type="submit"]:hover {
                background-color: #0056b3;
            }

           
        </style>
    </head>
    <body>
        <h1>Update Account </h1>
       
        <c:if test="${not empty accountToUpdate}">
            <form action="UpdateAccountServlet" method="post">
                <input type="hidden" name="id" value="${accountToUpdate.userID}">
                <label for="newUsername">New Username:</label>
                <input type="text" name="newUsername" value="${accountToUpdate.username}">
                <br>
                <label for="newPassword">New Password:</label>
                <input type="text" name="newPassword" value="${accountToUpdate.password}">
                <br>
                <label for="newQuyen">New Quyen:</label>
                <input type="text" name="newQuyen" value="${accountToUpdate.quyen}">
                <br>
                <label for="newTrangThai">New TrangThai:</label>
                <input type="text" name="newTrangThai" value="${accountToUpdate.trangThai}">
                <br>
                <button type="submit">Update</button>
            </form>
        </c:if>
    </body>
</html>
