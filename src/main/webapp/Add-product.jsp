<%-- 
    Document   : Add-product
    Created on : 15 thg 12, 2023, 14:42:54
    Author     : lythanhphat9523
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" />
        <title>Document</title>
        <style>
            #myForm {
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
        </style>
    </head>

    <body class="bg-light ">
        <div class="container">
            <button id="toggleForm" class="btn btn-primary mt-3"><i class="fas fa-comment"></i> Hiển thị Form</button>
            <form id="myForm" style="weight:300px;">
                <!-- Nội dung form -->
                <div class="container-fluid m-0 p-0">
                    <div class="row">
                        <div class="col-md-6">
                            Tên sản phẩm
                            <br><input class="m-1" stype="text" name="tensp" cols="30"><br>
                            Loại sản phẩm
                            <br><select class="m-1" id="cars" name="cars">
                                <option value="IP">Iphone</option>
                                <option value="Samsung">Samsung</option>
                                <option value="Oppo">Oppo</option>
                                <option value="Xiaomi">Xiaomi</option>
                            </select><br>
                            Mô tả
                            <br><textarea style="resize:none;" class="m-1" name="tensp" row="4" cols="30"></textarea><br>

                            <button style="width: 100px;" type="button" class="btn btn-primary">Xác nhận</button>
                            <button style="width: 100px;" type="button" class="btn btn-danger ms-4">Huỷ</button>
                        </div>
                        <div class="col-md-6">
                        <div class="container m-2">
                            <div class="form-group d-flex align-items-center justify-content-center" onclick="chooseFile()">
                                <div id="image-container" class="d-flex align-items-center justify-content-center">
                                    <img id="selected-image" src="#" alt="Selected Image" class="img-thumbnail">
                                    <input type="file" id="file-input" style="display: none;" class="form-control-file" onchange="displayImage()">
                                </div>
                            </div>
                        </div>
                    </div>

                    </div>
                </div>
            </form>
        </div>

            <script>
                $(document).ready(function () {
                    $("#toggleForm").click(function () {
                        $("#myForm").fadeToggle();
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
            </script>
    </body>
</html>
