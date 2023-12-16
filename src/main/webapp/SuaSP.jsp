<%-- 
    Document   : SuaSP
    Created on : 15 thg 12, 2023, 19:42:11
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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
        <title>Document</title>
    </head>
    <body>
        <div class="container">
            <div class="text-center title mt-3">Sửa sản phẩm </div>
            <form action="Sua-san-pham" method="post">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="row col-md-6 border border-2 border-black">
                        <div class="col-md-6">
                            <input type="hidden" name="masp" value="${sp.getMasp()}">
                            Tên sản phẩm
                            <br><input class="m-1" stype="text" name="tensp" cols="30" value="${sp.getTensp()}"><br>
                            Loại sản phẩm
                            <br><select class="m-1" id="loai" name="loai">
                                <%List<loaisanpham> list=new loaisanphamDAO().findAll();
                                    sanpham sp = (sanpham) request.getAttribute("sp");
                                    for (loaisanpham a:list){
                                    Boolean isSelected = a.getTenloai().equals(sp.getTenloai());
                                %>
                                <option value="<%=a.getMaloai()%>" <% if (isSelected) out.print("selected"); %>><%=a.getTenloai()%></option>
                                <%}%>
                            </select><br>
                            Mô tả
                            <br><textarea style="resize:none;" class="m-1" name="mota" row="4" cols="30">${sp.getMota()}</textarea><br>
                            <button style="width: 100px;" type="submit" name="action" value="submit" class="btn btn-primary">Xác nhận</button>
                            <button style="width: 100px;" type="submit" name="action" value="cancel" class="btn btn-danger ms-4">Huỷ</button>
                        </div>
                            <input type="hidden" name="hinhanh" value="${sp.getHinhanh()}">
                        <div class="col-md-6">
                            <div class="container m-2">
                                <div class="form-group d-flex justify-content-center align-items-center">
                                    <div id="image-container" class="d-flex align-items-center justify-content-center" onclick="chooseFile()">
                                        <img id="selected-image" src="images${sp.getHinhanh()}" class="img-thumbnail">
                                        <input type="file" id="file-input" style="display: none;" class="form-control-file" onchange="displayImage()">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3"></div>
                </div>
            </form>
        </div>
    </body>
</html>
