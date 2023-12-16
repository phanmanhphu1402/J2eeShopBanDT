<%-- 
    Document   : order
    Created on : Nov 28, 2023, 2:44:30 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<main>
    <div class="container pt-4">
        <section class="mb-4">
            <div class="card"> 
                <div class="card-header py-3">
                    <h5 class="mb-0 text-center"><strong>Quản lý Hóa Đơn</strong></h5>
                </div>

                <div class="row">
                    <div class="col-sm-12 text-left">
                        <form action="xuatExcelTop10ProductControl" method="get"> 
                            <button type="submit" class="mb-0 text-center btn btn-primary" style="width: 150px;height: 40px">Xuất file Excel</button> 
                        </form>    
                    </div>
                </div>

                <c:if test="${mess!=null }">
                    <div class="alert alert-success" role="alert">
                        ${mess}
                    </div>
                </c:if>
                <div class="panel-heading" style="display: flex; justify-content: space-between;">
                    <form action="/J2eeDoAn/OrderManagerServlet" method="post">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search by Nhân viên" name="maNV" required>
                            <div class="input-group-btn">
                                <input type="hidden" value="SearchByMaNhanVien" name="action">
                                <button class="btn btn-default" type="submit">
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <br>
                    <form action="/J2eeDoAn/OrderManagerServlet" method="post">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search by Khách hàng" name="maKH" required>
                            <div class="input-group-btn">
                                <input type="hidden" value="SearchByMaKhachHang" name="action">
                                <button class="btn btn-default" type="submit">
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <br>
                    <form action="/J2eeDoAn/OrderManagerServlet" method="post">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search by mã khuyến mãi" name="maKM" required>
                            <div class="input-group-btn">
                                <input type="hidden" value="SearchByMaKhuyenMai" name="action">
                                <button class="btn btn-default" type="submit">
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <form action="/J2eeDoAn/OrderManagerServlet" method="post">
                        <div class="input-group">
                            <input type="date" class="form-control" placeholder="Search" name="date" required>
                            <div class="input-group-btn">
                                <input type="hidden" value="SearchByDate" name="action">
                                <button class="btn btn-default" type="submit">
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <button type="button" class="btn btn-success">Advance</button>												    	
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-hover table-bordered table-striped text-nowrap">
                            <thead>
                                <tr class="info">
                                    <th>Mã Hóa Đơn</th>
                                    <th>Người nhập</th>
                                    <th>Khách hàng</th>
                                    <th>Mã khuyến mãi áp dụng</th>
                                    <th>Tổng tiền</th>
                                    <th>Ngày tạo</th>
                                    <th colspan="3" style="text-align: center">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="order" items="${LIST_ORDER}">

                                    <tr>
                                        <td>${order.maHD }</td>
                                        <td>${order.maNV }</td>
                                        <td>${order.maKH }</td>
                                        <td>${order.maKM }</td>
                                        <td>${order.tongTien } VND</td>
                                        <td>${order.ngayTao }</td>
                                        <td><a href="OrderManagerServlet?action=Detail&orderId=${order.maHD}" class="btn btn-success" style="width: 90px;height: 40px">Chi tiết</a></td>
                                        <td><a href="OrderManagerServlet?action=Update&orderId=${order.maHD}" class="btn btn-success" style="width: 120px;height: 40px">Chưa xử lý</a></td>
                                        <td><a class="mb-0 text-center btn btn-danger" onclick="confirmDeleteOrder('${order.maHD}')" style="width: 80px;height: 40px">Xóa</a></td>
                                
                                    </tr>

                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <!--Section: Quan Ly tai Khoan-->
    </div>
</main>



<script src="js/manager.js" type="text/javascript"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!--Main layout-->
<!-- SCRIPTS -->
<!-- JQuery -->
<script src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
<!-- MDB Ecommerce JavaScript -->
<script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
<!-- MDB -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Custom scripts -->
<script type="text/javascript" src="js/script.js"></script>
<script src="https://mdbootstrap.com/api/snippets/static/download/MDB5-Free_3.8.1/js/mdb.min.js"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>


<script type="text/javascript" src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/plugins/mdb-plugins-gathered.min.js"></script>
<!-- MDB -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Custom scripts -->
<script type="text/javascript" src="js/script.js"></script>
