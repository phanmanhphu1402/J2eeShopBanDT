<%-- 
    Document   : products
    Created on : Dec 13, 2023, 2:26:52 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.sanpham" %>
<%@ page import="DAO.sanphamDAO" %>
<div class="container" style="padding-left: 100px">
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
                        <input type="hidden" name="action" value="action0">
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
                                <form action="Danh-sach-san-pham" method="post">
                                    <input type="hidden" name="id" value="${sp.getMasp()}">
                                    <input type="hidden" name="action" value="action1">
                                    <button style="sumit" class="btn btn-danger size d-flex align-items-center justify-content-center">
                                        <i class="fas fa-bars"></i>
                                    </button>
                                </form>
                            </td>
                            <td>
                                <form action="Danh-sach-san-pham" method="post">
                                    <input type="hidden" name="id" value="${sp.getMasp()}">
                                    <input type="hidden" name="action" value="action2">
                                    <div class="d-flex justify-content-center"><a href="#" class="btn btn-primary size d-flex align-items-center justify-content-center"><i
                                                class="fa fa-pencil-alt"></i></a></div>
                                </form>
                            </td>
                            <td>
                                <form action="Danh-sach-san-pham" method="post">
                                    <input type="hidden" name="id" value="${sp.getMasp()}">
                                    <input type="hidden" name="action" value="action3">
                                    <button style="sumit" name="action" class="btn btn-danger size d-flex align-items-center justify-content-center">
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
            <button type="button" class="btn btn-primary btn-block m-2 bg-blue"><i class="fas fa-plus"></i>
                Thêm
                sản
                phẩm</button>                  
        </div>
    </div>
</div>

<script>
    const toggleButtons = document.querySelectorAll('#toggleButton');

    toggleButtons.forEach((button) => {
        const toggleIcon = button.querySelector('i');

        button.addEventListener('click', function () {
            button.classList.toggle('active');
            toggleIcon.classList.toggle('fa-check');
            toggleIcon.classList.toggle('fa-dash');
        });
    });

    function updateButtonText(selectedText, id) {
        document.getElementById(id).innerText = selectedText;
    }

</script>
