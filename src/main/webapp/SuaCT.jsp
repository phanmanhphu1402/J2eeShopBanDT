<%-- 
    Document   : SuaCT
    Created on : 15 thg 12, 2023, 22:14:28
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
    </head>
    <body>
        <div class="container">
            <form action="Sua-chi-tiet" method="post">
                    <input type="hidden" name="mact" value="${ct.getMact()}">
                    <input type="hidden" name="masp" value="${ct.getMasp()}">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="row col-md-6 border border-2 border-black ">
					<div class="col-md-6 ">
						Màu
						<br><input class="m-1" stype="text" name="mau" cols="30" value="${ct.getMau()}"><br>
						Số lượng
						<br><input tyle="text" class="m-1" name="soluong" cols="30" value="${ct.getSoluong()}"><br>
					</div>
					<div class="col-md-6">
						Giá nhập
						<br><input type="text" class="m-1" name="gianhap" cols="30" value="${ct.getGiaNhap()}"><br>
						Giá bán
						<br><input tyle="text" class="m-1" name="giaban" cols="30" value="${ct.getGiaBan()}"></textarea><br>
					</div>
				<div class="d-flex justify-content-center">
                                            <button style="width: 100px;" type="submit" name="action" value="submit" class="btn btn-primary">Xác nhận</button>
					<button style="width: 100px;" type="submit"  name="action" value="cancel" class="btn btn-danger ms-4">Huỷ</button>
				</div>
				</div>
				<div class="col-md-3"></div>
			</div>
		</form>
	</div>
    </body>
</html>
