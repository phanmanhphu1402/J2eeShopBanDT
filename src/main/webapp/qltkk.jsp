<%-- 
    Document   : newjsp
    Created on : 9 thg 12, 2023, 15:27:53
    Author     : lythanhphat9523
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.sanpham" %>
<%@ page import="DAO.sanphamDAO" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
        <title>Document</title>
    </head>

    <body class="bg-light">
        <header>
            <jsp:include page="LeftAdmin.jsp"></jsp:include>


            </header>
            <!--Sản phẩm-->
            <main>
                <div class="container pt-4 rounded ml-3 col-md-10">

                    <div class="text-center title">Danh sách sản phẩm</div>
                    <div class="container mt-3">
                        <div class="row">
                            <div class="col-md-3">
                                <button type="button"
                                        class="btn btn-secondary btn-fixed-size dropdown-toggle bg-white text-body"
                                        id="dropdownMenuButton1" data-bs-toggle="dropdown">
                                    --Kiểu tìm kiếm--
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item"
                                           onclick="updateButtonText('--Kiểu tìm kiếm--', 'dropdownMenuButton1')">--Không--</a>
                                    </li>
                                    <li><a class="dropdown-item"
                                           onclick="updateButtonText('Mã sản phẩm', 'dropdownMenuButton1')">Mã
                                            sản phẩm</a></li>
                                    <li><a class="dropdown-item"
                                           onclick="updateButtonText('Tên sản phẩm', 'dropdownMenuButton1')">Tên sản
                                            phẩm</a>
                                    </li>
                                    <li><a class="dropdown-item" onclick="updateButtonText('Màu sắc', 'dropdownMenuButton1')">Màu
                                            sắc</a></li>
                                </ul>
                            </div>
                            <div class="col-md-3">
                                <button type="button"
                                        class="btn btn-secondary btn-fixed-size dropdown-toggle bg-white text-body"
                                        id="dropdownMenuButton2" data-bs-toggle="dropdown">
                                    --Mức giá--
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item"
                                           onclick="updateButtonText('--Mức giá--', 'dropdownMenuButton2')">--Không--</a>
                                    </li>
                                    <li><a class="dropdown-item"
                                           onclick="updateButtonText('Dưới 10.000.000 vnđ', 'dropdownMenuButton2')">Dưới
                                            10.000.000
                                            vnđ</a></li>
                                    <li><a class="dropdown-item"
                                           onclick="updateButtonText('Dưới 20.000.000 vnđ', 'dropdownMenuButton2')">Dưới
                                            20.000.000
                                            vnđ</a></li>
                                    <li><a class="dropdown-item"
                                           onclick="updateButtonText('trên 20.000.000 vnđ', 'dropdownMenuButton2')">Trên
                                            20.000.000
                                            vnđ</a></li>
                                </ul>
                            </div>
                            <div class="col-md-6">
                                <div class="input-group mb-3">
                                    <input type="text" class="form-control" placeholder="Tìm kiếm">
                                    <button class="btn btn-success bg-blue" type="submit">Tìm kiếm</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container mt-1">
                        <div class="list-group overflow-auto border border-secondary" style="max-height: 600px;height: 600px;">
                            <table class="table table-striped">
                                <tr class="bg-grey">
                                    <th></th>
                                    <th>User ID</th>
                                    <th>Username</th>
                                    <th>Password</th>
                                    <th>Permission</th>
                                    <th>Status</th>
                                    <th>Sửa</th>
                                    <th>Xóa</th>
                                </tr>

                                <c:forEach items="${accounts}" var="account">
                                <tr>
                                    <td>${account.userID}</td>
                                    <td>${account.username}</td>
                                    <td>${account.password}</td>
                                <c:choose>
                                    <c:when test="${account.quyen == 1}">
                                        <td>Admin</td>
                                    </c:when>
                                    <c:when test="${account.quyen == 2}">
                                        <td>Nhân viên</td>
                                    </c:when>
                                    <c:when test="${account.quyen == 3}">
                                        <td>Khách</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Unknown</td>
                                    </c:otherwise>
                                </c:choose>


                                <c:choose>
                                    <c:when test="${account.trangThai == 1}">
                                        <td>hoạt động</td>
                                    </c:when>
                                    <c:when test="${account.trangThai == 0}">
                                        <td> đã ngừng</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Unknown</td>
                                    </c:otherwise>
                                </c:choose>



                                <td>
                                    <form action="qlac" method="post">
                                        <input type="hidden" name="id" value="${account.userID}">
                                        <button type="submit" name="action">Update</button>
                                    </form>
                                </td>
                                <td>
                                    <form action="deleteAc" method="post">
                                        <input type="hidden" name="id" value="${account.userID}">
                                        <button type="submit" name="action" value="delete">Delete</button>
                                    </form>
                                </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>


            </div></main>

    </body>
</html>
