<%-- 
    Document   : accountnew
    Created on : Dec 14, 2023, 2:18:55 AM
    Author     : ACER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<main>
                <div class="container pt-4">



                    <!-- Section: Main chart 2 -->
                    <section class="sign-in">
                        <div class="container mt-3">
                            <div class="row">

                                <div class="col-md-6">
                                 
                                    <form class="input-group mb-3" action="qlac" method="get">
                                        <input name="search" type="text" class="form-control" placeholder="Tìm kiếm">
                                        <button name="action"  type="submit" class="mb-0 text-center btn btn-primary" style="width: 100px;height: 40px">Tìm kiếm</button>
                                    </form>
                            </div>
                        </div>
                    </div>
                    <div class="container mt-1">
                        <div class="list-group overflow-auto border border-secondary" style="max-height: 600px;height: 600px;">
                            <table class="table table-striped">
                                <tr class="bg-grey">
                                    <th>User ID</th>
                                    <th>Username</th>
                                    <th>Password</th>
                                    <th>Permission</th>
                                    <th>Status</th>
                                    <th class="tieude">Sửa</th>
                                    <th class="tieude">Xóa</th>
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
                                                <button class=" test mb-0 text-center btn btn-primary" style="width: 100px;height: 40px" type="submit" name="action"><i class="fas fa-plus"></i>
                                                    update</button>
                                            </form>
                                        </td>
                                        <td>
                                            <form action="deleteAc" method="post">
                                                <input type="hidden" name="id" value="${account.userID}">  
                                                <button class="test mb-0 text-center btn btn-danger" style="width: 100px;height: 40px" type="submit" name="action"><i
                                                        class="fas fa-minus"></i>
                                                    Delete</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
            </div>
        </section>

        <!-- Section: Main chart 2 -->






    </div>
</main>

<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!--Main layout-->
<!-- SCRIPTS -->
<!-- JQuery -->
<script
src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript"
src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript"
src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript"
src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
<!-- MDB Ecommerce JavaScript -->
<script type="text/javascript"
src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
<!-- MDB -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Custom scripts -->
<script type="text/javascript" src="js/script.js"></script>
<script
src="https://mdbootstrap.com/api/snippets/static/download/MDB5-Free_3.8.1/js/mdb.min.js"></script>
<script
src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>

<script>// Graph
    //Horizontal Bar Chart
    new Chart(document.getElementById("horizontalBar"), {
        "type": "horizontalBar",
        "data": {
            "labels": ["Tháng 12", "Tháng 11", "Tháng 10", "Tháng 9", "Tháng 8", "Tháng 7", "Tháng 6", "Tháng 5", "Tháng 4", "Tháng 3", "Tháng 2", "Tháng 1"],
            "datasets": [{
                    "label": "Doanh thu $",
                    "data": [${totalMoneyMonth12}, ${totalMoneyMonth11}, ${totalMoneyMonth10}, ${totalMoneyMonth9}, ${totalMoneyMonth8}, ${totalMoneyMonth7}, ${totalMoneyMonth6}, ${totalMoneyMonth5}, ${totalMoneyMonth4}, ${totalMoneyMonth3}, ${totalMoneyMonth2}, ${totalMoneyMonth1}],
                    "fill": false,
                    "backgroundColor": ["rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.2)",
                        "rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.2)", "rgba(54, 162, 235, 0.2)",
                        "rgba(153, 102, 255, 0.2)", "rgba(201, 203, 207, 0.2)", "#99FF99", "#FFFF99", "#FFC1C1", "#FFB5C5", "#DDC488"
                    ],
                    "borderColor": ["rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)",
                        "rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)", "rgb(201, 203, 207)", "	#66FF99", "#FFFF66", "#EEB4B4", "#EEA9B8", "#ECAB53"
                    ],
                    "borderWidth": 1
                }]
        },
        "options": {
            "scales": {
                "xAxes": [{
                        "ticks": {
                            "beginAtZero": true
                        }
                    }]
            }
        }
    });
</script>
<script type="text/javascript"
src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/plugins/mdb-plugins-gathered.min.js"></script>
<!-- MDB -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Custom scripts -->
<script type="text/javascript" src="js/script.js"></script>
