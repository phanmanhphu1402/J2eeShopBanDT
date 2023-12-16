<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
            <!--Main layout-->
            <main>
                <div class="container pt-4">

                    <!-- Section: Main chart -->
                    <section class="mb-4" id="doanhThuThu">
                        <div class="card">
                            <div class="card-header py-3">
                                <h5 class="mb-0 text-center"><strong>Doanh thu theo thứ</strong></h5>
                            </div>
                            <div class="card-body">
                                <canvas class="my-4 w-100" id="polarArea" height="680"></canvas>
                            </div>
                        </div>
                    </section>
                    <!-- Section: Main chart -->
                </div>
            </main>

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
            <script>// Graph
                //polarArea
                const CHART_COLORS = {
                    red: 'rgba(255, 99, 132, 0.5)',
                    orange: 'rgba(255, 159, 64, 0.5)',
                    yellow: 'rgba(255, 205, 86, 0.5)',
                    green: 'rgba(75, 192, 192, 0.5)',
                    blue: 'rgba(54, 162, 235, 0.5)',
                    purple: 'rgba(153, 102, 255, 0.5)',
                    grey: 'rgba(201, 203, 207, 0.5)'
                };
                var ctxP = document.getElementById("polarArea").getContext('2d');

                var myPolarChart = new Chart(ctxP, {
                    type: 'polarArea',
                    data: {
                        labels: ["Sunday", "Saturday", "Friday", "Thursday", "Wednesday", "Tuesday", "Monday"],
                        datasets: [{
                                data: [${totalMoney1}, ${totalMoney7}, ${totalMoney6}, ${totalMoney5}, ${totalMoney4}, ${totalMoney3}, ${totalMoney2}],
                                backgroundColor: [
                                    CHART_COLORS.red,
                                    CHART_COLORS.orange,
                                    CHART_COLORS.yellow,
                                    CHART_COLORS.green,
                                    CHART_COLORS.blue,
                                    CHART_COLORS.purple,
                                    CHART_COLORS.grey
                                ]
                            }]
                    },
                    options: {
                        responsive: true
                    }
                });

        </script>

        <script type="text/javascript" src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/plugins/mdb-plugins-gathered.min.js"></script>
        <!-- MDB -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
        <!-- Custom scripts -->
        <script type="text/javascript" src="js/script.js"></script>
    </body>
</html>