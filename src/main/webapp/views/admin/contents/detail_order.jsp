<%-- 
    Document   : detail_order
    Created on : Nov 28, 2023, 2:45:07 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="panel-body" style="padding-left: 250px">
    <table class="table table-hover table-bordered">
        <thead>
            <tr class="info">
                <th>Tên Sản Phẩm</th>
                <th>Hình ảnh</th>
                <th>Đơn giá</th>
                <th>Số lượng</th>
                <th>Tổng tiền</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${LIST_DETAILORDER}">

                <tr>
                    <td>${order.tenSP }</td>
                    <td style="width: 20%"><img src="images${order.hinhanh}" alt="product-item" style="width: 50%"></td>
                    <td>${order.donGia } VND</td>
                    <td>${order.soLuong }</td>
                    <td>${order.tongTien } VND</td>
                </tr>

            </c:forEach>

        </tbody>
    </table>			  		    	
</div>
