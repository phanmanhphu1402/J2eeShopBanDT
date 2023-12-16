<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main style="padding-left: 250px">
<h1>Update Account Information</h1>
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
</main>

