<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
            <!--Main layout-->
            <main>
                <div class="container pt-4">
                    <!--Section: Quan Ly tai Khoan-->
                    <section class="mb-4">
                        <div class="card">
                            <div class="card-header py-3">
                                <h5 class="mb-0 text-center"><strong>Top 5 nhân viên bán hàng xuất sắc</strong></h5>
                            </div>

                            <div class="row py-3">
                                <div class="col-sm-12 text-left">
                                    <form action="ExportTop5NV" method="get"> 
                                        <button type="submit" class="mb-0 text-center btn btn-primary">Xuất file Excel</button> 
                                    </form>    
                                </div>
                            </div>

                        <c:if test="${mess!=null }">
                            <div class="alert alert-success" role="alert">
                                ${mess}
                            </div>
                        </c:if>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover text-nowrap">
                                    <thead>
                                        <tr>
                                            <th scope="col">Mã Nhân Viên</th>
                                            <th scope="col">Tên Nhân Viên</th>
                                            <th scope="col">Địa chỉ Email</th>
                                            <th scope="col">Tổng bán hàng</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listTop5NhanVien}" var="t">
                                            <c:forEach items="${listNhanVien}" var="o">
                                                <c:if test="${t.userID==o.maNV }">
                                                    <c:if test="${t.tongBanHang!=0.0 }">
                                                        <tr>
                                                            <td>${o.maNV}</td>
                                                            <td>${o.hoTen}</td>
                                                            <td>${o.email}</td>
                                                            <td>${t.tongBanHang}</td>
                                                        </tr>
                                                    </c:if>
                                                </c:if>
                                            </c:forEach>
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
    </body>
</html>