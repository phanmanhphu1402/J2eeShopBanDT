<%-- 
    Document   : product
    Created on : Nov 27, 2023, 2:34:57 PM
    Author     : ACER
--%>
<%@page import="model.sanpham,DAO.sanphamDAO,java.util.List,java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section id="mobile-products" class="product-store position-relative padding-large no-padding-top">
    <div class="container">
        <div class="row">
            <div class="display-header d-flex justify-content-between pb-3">
                <h2 class="display-7 text-dark text-uppercase">Product</h2>
            </div>

            <div class="swiper product-swiper">
                <div class="swiper-wrapper container">
                    <div class="row">
                        <%
                        List<sanpham> list = new sanphamDAO().findAll();
                        int i=0;
                        for (sanpham product:list){
                        %>
                        <div class="col-xl-2 col-lg-3 col-md-4 border border-2 m-3 rounded">
                            <form action="/Trang-chu/Chi-tiet-san-pham" method="get">
                                <input type="hidden" name="masp" value="<%=product.getMasp()%>">
                                <input type="hidden" name="choise" value="0">
                                <div class="swiper-slide">
                                    <div class="product-card position-relative">
                                        <div class="image-holder m-2">
                                            <img src="images<%=product.getHinhanh()%>" alt="product-item" class="img-fluid">
                                        </div>
                                        <div class="cart-concern position-absolute">
                                            <div class="cart-button d-flex">
                                                <button type="submit" class="btn btn-medium btn-black"><i class="fas fa-shopping-cart"></i> Add to Cart</button>
                                            </div>
                                        </div>
                                        <div class="card-detail d-flex justify-content-between align-items-baseline pt-3">
                                            <h3 class="card-title text-uppercase align-content-center">
                                                <%=product.getTensp()%>
                                            </h3>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <%}%>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>

