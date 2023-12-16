<%-- 
    Document   : newjsp
    Created on : 9 thg 12, 2023, 15:27:53
    Author     : lythanhphat9523
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="model.sanpham" %>
<%@ page import="model.loaisanpham" %>
<%@ page import="DAO.sanphamDAO" %>
<%@ page import="DAO.loaisanphamDAO"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Statistic</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport"
              content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <%
            // Lấy thông báo từ session
            String loginSuccessMessage = (String)session.getAttribute("loginSuccessMessage");
            // Kiểm tra nếu thông báo tồn tại thì hiển thị nó
            if (loginSuccessMessage != null && !loginSuccessMessage.isEmpty()) {
        %>
    <div class="alert alert-success">
        <%= loginSuccessMessage %>
    </div>
    <%
        // Xóa thông báo khỏi session để tránh hiển thị nó lần tiếp theo
        session.removeAttribute("loginSuccessMessage");
    }
    %>
    <!-- Font Icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="css/qlac.css" rel="stylesheet" type="text/css"/>
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
        <link
            href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            rel="stylesheet" id="bootstrap-css">
        <script
        src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script
        src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ------>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
              rel="stylesheet"
              integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
              crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css" />



        <!-- Font Awesome -->
        <script src="https://kit.fontawesome.com/bf8f778c02.js" crossorigin="anonymous"></script>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet"
              href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">
        <!-- Material Design Bootstrap -->
        <link rel="stylesheet"
              href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
        <!-- Material Design Bootstrap Ecommerce -->
        <link rel="stylesheet"
              href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">
        <!-- Your custom styles (optional) -->
        <link
            href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            rel="stylesheet" id="bootstrap-css">
        <script
        src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script
        src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ------>
        <link
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            rel="stylesheet"
            integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
            crossorigin="anonymous">
        <link href="css/sb-admin-2.css" rel="stylesheet" type="text/css" />
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css"
              href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
        <link rel="stylesheet" type="text/css"
              href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&amp;display=swap">
        <link rel="stylesheet" type="text/css"
              href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/mdb5/3.8.1/compiled.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/mdb-plugins-gathered.min.css">
        <style>
                        #myForm,#myFormFix {
                display: none;
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: #fff;
                border: 1px solid #ccc;
                border-radius: 8px;
                padding: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            
            body {
                background-color: #fbfbfb;
                margin: 0;
                padding: 0;
            }

            @media ( min-width : 991.98px) {
                main {
                    padding-left: 240px;
                }
            }

            /* Sidebar */
            .sidebar {
                position: fixed;
                top: 0;
                bottom: 0;
                left: 0;
                padding: 58px 0 0; /* Height of navbar */
                box-shadow: 0 2px 5px 0 rgb(0 0 0/ 5%), 0 2px 10px 0 rgb(0 0 0/ 5%);
                width: 240px;
                z-index: 600;
            }

            @media ( max-width : 991.98px) {
                .sidebar {
                    width: 100%;
                }
            }

            .sidebar .active {
                border-radius: 5px;
                box-shadow: 0 2px 5px 0 rgb(0 0 0/ 16%), 0 2px 10px 0 rgb(0 0 0/ 12%);
            }

            .sidebar-sticky {
                position: relative;
                top: 0;
                height: calc(100vh - 48px);
                padding-top: 0.5rem;
                overflow-x: hidden;
                overflow-y: auto;
                /* Scrollable contents if viewport is shorter than content. */
            }
            </style>
    </head>

    <body class="bg-light">
        <jsp:include page="views/admin/components/LeftAdmin.jsp"></jsp:include>
            <main>
                <div class="container rounded ml-3 ">
                    <div class="text-center title">Danh sách sản phẩm</div>
                    <div class="container mt-3">
                        <form action="Danh-sach-san-pham" method="post">
                            <div class="row">
                                <div class="col-md-3">
                                    <button type="button"
                                            class="btn btn-secondary btn-fixed-size dropdown-toggle bg-white text-body"
                                            id="selectedStyle" data-bs-toggle="dropdown">
                                        --Kiểu tìm kiếm--
                                    </button>
                                    <ul name="Style" class="dropdown-menu">
                                        <li><a class="dropdown-item"
                                               onclick="updateStyle('--Kiểu tìm kiếm--')">--Không--</a>
                                        </li>
                                        <li><a class="dropdown-item"
                                               onclick="updateStyle('Mã sản phẩm')">Mã
                                                sản phẩm</a></li>
                                        <li><a class="dropdown-item"
                                               onclick="updateStyle('Tên sản phẩm')">Tên sản
                                                phẩm</a>
                                        </li>
                                        <input type="hidden" name="style" id="hiddenStyle" value="">
                                        <input type="hidden" name="action" value="action1">
                                    </ul>
                                </div>
                                <div class="col-md-9">
                                    <div class="input-group mb-3">
                                        <input type="input" name="text" class="form-control" placeholder="Tìm kiếm">
                                        <button class="btn btn-success bg-blue" type="submit">Tìm kiếm</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <div class="container mt-1">
                            <div class="list-group overflow-auto border border-secondary" style="max-height: 600px;height: 600px;">
                                <table class="table table-striped">
                                    <tr class="bg-grey">
                                        <th>Hình ảnh</th>
                                        <th>Mã sản phẩm</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Loại Sản Phẩm</th>
                                        <th>Mô tả</th>
                                        <th>Xem</th>
                                        <th>Sửa</th>
                                        <th>Xóa</th>
                                    </tr>
                                <c:forEach items="${products}" var="sp">
                                    <tr>
                                        <td><img src="images${sp.getHinhanh()}" style="height: 40px;width: 30px;" alt="${sp.getTensp()}" class="img-fluid"></td>
                                        <td>${sp.getMasp()}</td>
                                        <td>${sp.getTensp()}</td>
                                        <td>${sp.getTenloai()}</td>
                                        <td>${sp.getMota()}</td>
                                        <td>
                                            <form action="Chi-tiet" method="get">
                                                <input type="hidden" name="id" value="${sp.getMasp()}">
                                                <button style="sumit" class="btn btn-secondary size d-flex align-items-center justify-content-center">
                                                    <i class="fas fa-bars"></i>
                                                </button>
                                            </form>
                                        </td>
                                        <td>
                                            <form action="Danh-sach-san-pham" method="post">
                                                <input type="hidden" name="id" value="${sp.getMasp()}">
                                                <input type="hidden" name="action" value="action2">
                                                <button style="submit" name="action" class="btn btn-primary size d-flex align-items-center justify-content-center">
                                                    <i class="fas fa-tools"></i>
                                                </button>
                                            </form>
                                        </td>
                                        <td>
                                            <form action="Danh-sach-san-pham" method="post">
                                                <input type="hidden" name="id" value="${sp.getMasp()}">
                                                <input type="hidden" name="action" value="action3">
                                                <button style="submit" name="action" class="btn btn-danger size d-flex align-items-center justify-content-center">
                                                    <i class="fa fa-trash-alt"></i>
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                    <div class="d-grid">
                        <button type="button" id="toggleForm" class="btn btn-primary btn-block m-2 bg-blue"><i class="fas fa-plus"></i>
                            Thêm
                            sản
                            phẩm</button>                  
                    </div>
                </div>

                <form id="myForm" action="Danh-sach-san-pham" method="post" enctype="multipart/form-data" style="width:800px;">
                    <input type="hidden" name="action" value="action4">
                    <div class="text-center title">Thêm sản phẩm</div>
                    <!-- Nội dung form -->
                    <div class="container-fluid m-0 p-0">
                        <div class="row">
                            <div class="col-md-6">
                                Tên sản phẩm
                                <br><input class="m-1" stype="text" name="tensp" cols="30"><br>
                                Loại sản phẩm
                                <br><select class="m-1" id="loai" name="cars">
                                    <%List<loaisanpham> list=new loaisanphamDAO().findAll();
                                for (loaisanpham a:list){%>
                                    <option value="<%=a.getMaloai()%>"><%=a.getTenloai()%></option>
                                    <%}%>
                                </select><br>
                                Mô tả
                                <br><textarea style="resize:none;" class="m-1" name="mota" row="4" cols="30"></textarea><br>

                                <button style="width: 100px;" type="submit" class="btn btn-primary" id="submit">Xác nhận</button>
                                <button style="width: 100px;" type="button" class="btn btn-danger ms-4" id="cancel">Huỷ</button>
                            </div>
                            <div class="col-md-6">
                                <div class="container m-2">
                                    <div class="form-group d-flex align-items-center justify-content-center" onclick="chooseFile()">
                                        <div id="image-container" class="d-flex align-items-center justify-content-center">
                                            <img id="selected-image" src="#" alt="Selected Image" class="img-thumbnail">
                                            <input type="file" name="hinhanh" id="file-input" style="display: none;" class="form-control-file" onchange="displayImage()">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <form id="myFormFix" action="Danh-sach-san-pham" method="post" enctype="multipart/form-data" style="weight:300px;">
                    <input type="hidden" name="action" value="action4">
                    <div class="text-center title">Sửa sản phẩm</div>
                    <!-- Nội dung form -->
                    <div class="container-fluid m-0 p-0">
                        <div class="row">
                            <c:set var="myVariable" value="${requestScope.myValue}" />
                            <div class="col-md-6">
                                Tên sản phẩm
                                <br><input class="m-1" stype="text" name="tensp" cols="30"><br>
                                Loại sản phẩm
                                <br><select class="m-1" id="loai" name="cars">
                                    <%List<loaisanpham> list1=new loaisanphamDAO().findAll();
                                for (loaisanpham a:list1){%>
                                    <option value="<%=a.getMaloai()%>"><%=a.getTenloai()%></option>
                                    <%}%>
                                </select><br>
                                Mô tả
                                <br><textarea style="resize:none;" class="m-1" name="mota" row="4" cols="30"></textarea><br>

                                <button style="width: 100px;" type="submit" class="btn btn-primary" id="submit">Xác nhận</button>
                                <button style="width: 100px;" type="button" class="btn btn-danger ms-4" id="cancel">Huỷ</button>
                            </div>
                            <div class="col-md-6">
                                <div class="container m-2">
                                    <div class="form-group d-flex align-items-center justify-content-center" onclick="chooseFile()">
                                        <div id="image-container" class="d-flex align-items-center justify-content-center">
                                            <img id="selected-image" src="#" alt="Selected Image" class="img-thumbnail">
                                            <input type="file" name="hinhanh" id="file-input" style="display: none;" class="form-control-file" onchange="displayImage()">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <script>
                    function updateStyle(value) {
                        var selectedStyleElement = document.getElementById("selectedStyle");
                        var hiddenStyleInput = document.getElementById("hiddenStyle");

                        selectedStyleElement.innerHTML = value;

                        // Cập nhật giá trị trong input hidden
                        hiddenStyleInput.value = value;
                    }

                    $(document).ready(function () {
                        $("#toggleForm").click(function () {
                            $("#myForm").fadeToggle();
                            resetForm();
                        });

                        $("#cancel").click(function () {
                            $("#myForm").fadeToggle();
                            resetForm();
                        });
                        $("#Fix").click(function () {
                            $("#myFormFix").fadeToggle();
                            resetForm();
                        });


                    });

                    function chooseFile() {
                        document.getElementById('file-input').click();
                    }

                    function displayImage() {
                        var input = document.getElementById('file-input');
                        var imageContainer = document.getElementById('image-container');
                        var selectedImage = document.getElementById('selected-image');
                        var uploadIcon = document.getElementById('upload-icon');

                        var file = input.files[0];

                        if (file) {
                            var reader = new FileReader();
                            reader.onload = function (e) {
                                selectedImage.src = e.target.result;
                                uploadIcon.style.display = 'none';
                            };
                            reader.readAsDataURL(file);
                        } else {
                            selectedImage.src = '#';
                            uploadIcon.style.display = 'block';
                        }
                    }

                    function resetForm() {
                        // Thiết lập giá trị các trường form về rỗng
                        document.getElementsByName('tensp')[0].value = '';
                        document.getElementById('loai').value = 'IP';
                        document.getElementsByName('mota')[0].value = '';
                        document.getElementById('selected-image').src = '#';
                    }


                </script>
        </main>
        <!--Sản phẩm-->
    </body>
</html>
