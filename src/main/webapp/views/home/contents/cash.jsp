<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="container-fluid" style="padding-top:100px">



    <div class="col-sm-8">
        <h1>Your Shopping Cart</h1>
        <c:set var="shop" value="${sessionScope.SHOP }"/>
        <c:if test="${not empty shop }">
            <form action="CartServlet" method="post">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <td>No.</td>
                            <td>Image</td>
                            <td>Name</td>
                            <td>Price</td>
                            <td>Quantity</td>
                            <td>Total Price</td>
                        </tr>
                    </thead>
                    <tbody>

                        <c:set var="count" value="0"/>
                        <c:forEach var="rows" items="${shop }">
                            <c:set var="count" value="${count+1}"/>
                            <tr>
                                <td>${count }</td><input type="hidden" value="${rows.value.sanpham.maSP}" name="coded">
                                <td style="width: 20%"><img src="images${rows.value.sanpham.hinhanh}" alt="product-item" class="img-fluid" ></td>
                                <td>${rows.value.sanpham.tenSP}<input type="hidden" value="${rows.value.sanpham.tenSP}" name="named"></td>
                                <td>${rows.value.sanpham.gia} <input type="hidden" value="${rows.value.sanpham.giaBan}" name="priced"></td>
                                <td>${rows.value.soluong}<input type="hidden" value="${rows.value.soluong}" name="quantityd"></td>
                                <td>${rows.value.sanpham.giaBan * rows.value.soluong} VND<input type="hidden" value="${rows.value.sanpham.giaBan * rows.value.soluong}" name="price"></td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
        </c:if>
    </div>
    <div class="col-sm-4 sidenav">
        <div class="container-fluid">
            <h2>Your Information</h2>
            <form action="CartServlet" style="padding-bottom: 10px" method="post">
                <div class="form-group">
                    <label for="email">Fullname:</label>
                    <input type="hidden" class="form-control" name="name">
                    <p>Tang Xuan Thuy</p>

                </div>
                <div class="form-group">
                    <label for="email">Email Address:</label>
                    <input type="hidden" class="form-control" name="email">
                    <p>thuy@gmail.com</p>
                </div>
                <div class="form-group">
                    <label for="email">Phone Number:</label>
                    <input type="hidden" class="form-control" name="phone">
                    <p>0987654321</p>
                </div>
                <div class="form-group">
                    <label for="pwd">Address:</label>
                    <input type="hidden" class="form-control" name="address">
                    <p>TP HCM, Q12</p>
                </div>
                <div class="form-group">
                    <label for="email">Discount Code:</label>
                    <div class="form-group">
                        <label for="sel1">Select list:</label>
                        <select class="form-control" name="maKM">
                            <c:forEach var="km" items="${LIST_KHUYENMAI}">
                                <option value="${km.maKM}" >${km.maKM } %${km.tileKM *100}</option>
                            </c:forEach>
                        </select>
                        <p>${MAKM}</p>
                    </div>
                    <input type="hidden" class="form-control" name="total" value="${TOTAL}">
                    <input name="action" value="Apply Code" type="submit">
                </div>
                <div class="form-group">
                    <label for="pwd">Total Price:</label>

                    <p>${REALPRICE} VND</p>
                    <c:forEach var="rows" items="${shop }">
                        <input type="hidden" value="${rows.value.sanpham.maSP}" name="coded">
                        <input type="hidden" value="${rows.value.sanpham.tenSP}" name="named">
                        <input type="hidden" value="${rows.value.sanpham.giaBan}" name="priced">
                        <input type="hidden" value="${rows.value.soluong}" name="quantityd">
                        <input type="hidden" value="${rows.value.sanpham.giaBan * rows.value.soluong}" name="price">
                    </c:forEach>
                    <input type="hidden" value="${REALPRICE}" name="totalprice">
                    <input type="hidden" value="${MAKM1}" name="codediscount">
                </div>
                <input class="btn btn-primary" value="Confirm" name="action" type="submit">
            </form>    	
        </div>
    </div>

</div>