<%-- 
    Document   : detail_order
    Created on : Nov 28, 2023, 2:45:07 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Order, model.khachhang, DAO.OrderDAO, DAO.KhachHangDAO" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="panel-body" style="padding-left: 250px">
    <table class="table table-hover table-bordered">
        <thead>
            <tr class="info">
                <th>Tên Sản Phẩm</th>
                <th>Hình ảnh</th>
                <th>Màu</th>
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
                    <td>${order.mau }</td>
                    <td>${order.donGia } VND</td>
                    <td>${order.soLuong }</td>
                    <td>${order.tongTien } VND</td>
                </tr>

            </c:forEach>

        </tbody>
    </table>
        <table class="table table-hover table-bordered">
            <thead>
                <tr class="info">
                    <th>Tên Khách Hàng</th>
                    <th>Địa Chỉ Email</th>
                    <th>Số Điện Thoại</th>
                    <th>Xác Nhận</th>
                </tr>
            </thead>
            <tbody>
                <%
                    HttpSession sessionDangNhap = request.getSession();
                    String id = sessionDangNhap.getAttribute("loginUserID").toString();
                    String maOrder = request.getParameter("orderId");
                    OrderDAO orderDAO = new OrderDAO();
                    KhachHangDAO khDAO = new KhachHangDAO();
                    khachhang kh = khDAO.searchKhachHang(orderDAO.searchOrder(maOrder).getMaKH());
                %>
                    <tr>
                        <td><%=kh.getHoTen()%></td>
                        <td><%=kh.getEmail()%></td>
                        <td><%=kh.getSDT()%></td>
                        <%
                        if(orderDAO.searchOrder(maOrder).isTinhTrang()==false){%>
                            <td><a href="OrderManagerServlet?action=Confirm&nhanvienId=<%=id%>&orderId=<%=maOrder%>" class="btn btn-primary" style="width: 110px;height: 40px">Xác Nhận</a></td>
                        <%}else{%>
                        <td><button class="btn btn-success" style="width: 110px;height: 40px" disabled>Đã Xử Lí</button></td>
                        <%}%>
                    </tr>
            </tbody>
        </table>
</div>
