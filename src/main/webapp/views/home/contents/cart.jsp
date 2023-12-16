<%-- 
    Document   : cart
    Created on : Nov 27, 2023, 2:50:39 PM
    Author     : ACER
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="container" style="padding-top:100px">    
    <h1>Your Shopping Cart</h1>
    <c:set var="shop" value="${sessionScope.SHOP }"/>
    <c:if test="${not empty shop }">
        <form action="CartServlet" method="post">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <td>No.</td>
                        <td>Image</td>
                        <td>Name</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <td>Total Price</td>
                        <td>Remove</td>
                    </tr>
                </thead>
                <tbody>

                    <c:set var="count" value="0"/>
                    <c:forEach var="rows" items="${shop }">
                        <c:set var="count" value="${count+1}"/>
                        <tr>
                            <td>${count }</td>
                            <td style="width: 20%"><img src="images${rows.value.sanpham.hinhanh}" alt="product-item" class="img-fluid" ></td>
                            <td>${rows.value.sanpham.tenSP}</td>
                            <td>${rows.value.sanpham.gia}</td>
                            <td style="width: 15%"><input type="number" value="${rows.value.soluong}" name="quantity" min="1" required><input type="hidden" value="${rows.value.sanpham.maSP}" name="code"></td>
                            <td>${rows.value.sanpham.giaBan * rows.value.soluong} VND<input type="hidden" value="${rows.value.sanpham.giaBan * rows.value.soluong}" name="price"></td>
                            <td><input type="checkbox" name="rmv" value="${rows.value.sanpham.maSP}" /></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td><input type="submit" value="Update" name="action"/></td>
                        <td><input type="submit" value="Remove" name="action"/></td>
                    </tr>

                </tbody>
            </table>
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <td><input type="submit" value="Buy" name="action"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </c:if>
    <c:if test="${empty shop }">
        <h2>Your Cart Is Empty ! <a class="nav-link me-4 active" href="/Trang-chu" style="color: lightblue">Shopping</a></h2>
    </c:if>

</div><br><br>
