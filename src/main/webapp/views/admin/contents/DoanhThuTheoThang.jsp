<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
            <!--Main layout-->
            <main>
                <div class="container pt-4">
                    <!-- Section: Main chart 2 -->
                    <section class="mb-4" id="doanhThuThang">
                        <div class="card">
                            <div class="card-header py-3">
                                <h5 class="mb-0 text-center">
                                    <strong>Doanh thu theo tháng</strong>
                                </h5>
                            </div>
                            <div class="card-body">
                                <canvas id="barchart"></canvas>
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
                new Chart(document.getElementById("barchart"), {
                    "type": "bar",
                    "data": {
                        "labels": ["Tháng 12", "Tháng 11", "Tháng 10", "Tháng 9", "Tháng 8", "Tháng 7", "Tháng 6", "Tháng 5", "Tháng 4", "Tháng 3", "Tháng 2", "Tháng 1"],
                        "datasets": [{
                                "label": "Doanh thu VND",
                                "data": [${totalMoneyMonth12}, ${totalMoneyMonth11}, ${totalMoneyMonth10}, ${totalMoneyMonth9}, ${totalMoneyMonth8}, ${totalMoneyMonth7}, ${totalMoneyMonth6}, ${totalMoneyMonth5}, ${totalMoneyMonth4}, ${totalMoneyMonth3}, ${totalMoneyMonth2}, ${totalMoneyMonth1}],
                                "backgroundColor": [
                                    "rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.5)",
                                    "rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.5)",
                                    "rgba(54, 162, 235, 0.2)", "rgba(153, 102, 255, 0.5)",
                                    "rgba(201, 203, 207, 0.2)", "#99FF99", "#FFFF99", "#FFC1C1", "#FFB5C5", "#DDC488"
                                ],
                                "borderColor": [
                                    "rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)",
                                    "rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)",
                                    "rgb(201, 203, 207)", "#66FF99", "#FFFF66", "#EEB4B4", "#EEA9B8", "#ECAB53"
                                ],
                                "borderRadius": "20",
                                "borderWidth": "2",
                                "borderSkipped": false
                            }]
                    },
                    "options": {
                        "responsive": true,
                        "plugins": {
                            "legend": {
                                "position": 'top'
                            },
                            "title": {
                                "display": true,
                                "text": "Doanh thu VND"
                            }
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
    </body>
</html>