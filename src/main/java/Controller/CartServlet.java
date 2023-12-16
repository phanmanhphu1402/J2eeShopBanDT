package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAO.DetailOrderDAO;
import DAO.KhuyenMaiDAO;
import DAO.OrderDAO;
import DAO.sanphamDAO;
import model.Cart;
import model.DetailOrder;
import model.khachhang;
import model.KhuyenMai;
import model.Order;
import model.ProductDTO;
import model.sanpham;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static List<ProductDTO> ls = new ArrayList<ProductDTO>();
    String urlSanPham = "/views/home/contents/product.jsp";
    String urlGioHang = "/views/home/contents/cart.jsp";
    String urlDonHang = "/views/home/contents/information.jsp";
    String urlThanhToan = "/views/home/contents/cash.jsp";
    String urlTrangChu = "/index.jsp";
    String urlSection1 = "/views/home/components/section1.jsp";
    String urlSection2 = "/views/home/components/section2.jsp";
    String urlConfirmed = "/views/home/contents/confirmed.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void changeQuantity(HttpServletRequest request, HttpServletResponse response) {
        String[] listQuantity = request.getParameterValues("quantity");
        String[] listCode = request.getParameterValues("code");
        if (listQuantity != null) {
            HttpSession session1 = request.getSession();
            if (session1 != null) {
                Cart shop = (Cart) session1.getAttribute("SHOP");
                if (shop != null) {
                    for (int i = 0; i < shop.size(); i++) {
                        shop.updateCart(listCode[i], Integer.parseInt(listQuantity[i]));
                    }
                    session1.setAttribute("SHOP", shop);
                }
            }
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // TODO Auto-generated method stub
//        try {
//            String action = request.getParameter("action");
//            if (action.equals("AddToCart")) {
//                request.setAttribute("VIEW", urlGioHang);
//                HttpSession session = request.getSession(true);
//                Cart shop = (Cart) session.getAttribute("SHOP");
//                if (shop == null) {
//                    shop = new Cart();
//                }
//                String code = request.getParameter("productid");
//                sanphamDAO spDAO = new sanphamDAO();
//
//                sanpham sp = spDAO.findById(code);
//                ProductDTO spDTO = new ProductDTO(sp);
//                shop.addCart(spDTO);
//                session.setAttribute("SHOP", shop);
//                RequestDispatcher rd = request.getRequestDispatcher(urlTrangChu);
//                rd.forward(request, response);
//            } else if (action.equals("View Cart")) {
//                request.setAttribute("VIEW", urlGioHang);
//                RequestDispatcher rd = request.getRequestDispatcher(urlTrangChu);
//                rd.forward(request, response);
//            } else if (action.equals("Remove")) {
//                String[] list = request.getParameterValues("rmv");
//                if (list != null) {
//                    HttpSession session = request.getSession();
//                    if (session != null) {
//                        Cart shop = (Cart) session.getAttribute("SHOP");
//                        if (shop != null) {
//                            for (int i = 0; i < list.length; i++) {
//                                shop.removeCart(list[i]);
//                            }
//                            session.setAttribute("SHOP", shop);
//                        }
//                    }
//                }
//                String url = "CartServlet?action=View Cart";
//                RequestDispatcher rd = request.getRequestDispatcher(url);
//                rd.forward(request, response);
//            }
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "Detail":

                    break;
                default:
                    throw new AssertionError();
            }
//            if (action.equals("Add To Cart")) {
//                request.setAttribute("VIEW", urlGioHang);
//                HttpSession session = request.getSession(true);
//                Cart shop = (Cart) session.getAttribute("SHOP");
//                if (shop == null) {
//                    shop = new Cart();
//                }
//
//                String code = request.getParameter("txtCode");
//                String name = request.getParameter("txtName");
//                String price = request.getParameter("txtPrice");
//                String type = request.getParameter("txtCodeType");
//                String image = request.getParameter("txtPicture");
//                String priceEx = request.getParameter("txtPriceEx");
//                int iprice = Integer.valueOf(price);
//                int ipriceEx = Integer.valueOf(priceEx);
//                sanpham sp = new sanpham(code, name, type, ipriceEx, iprice, image, "Awnsome");
//                ProductDTO spDTO = new ProductDTO(sp);
//
//                shop.addCart(spDTO);
//                session.setAttribute("SHOP", shop);
//                RequestDispatcher rd = request.getRequestDispatcher(urlTrangChu);
//                rd.forward(request, response);
//            } else if (action.equals("View Cart")) {
//                changeQuantity(request, response);
//                request.setAttribute("VIEW", urlGioHang);
//                RequestDispatcher rd = request.getRequestDispatcher(urlTrangChu);
//                rd.forward(request, response);
//            } else if (action.equals("Remove")) {
//                String[] list = request.getParameterValues("rmv");
//                if (list != null) {
//                    HttpSession session = request.getSession();
//                    if (session != null) {
//                        Cart shop = (Cart) session.getAttribute("SHOP");
//                        if (shop != null) {
//                            for (String list1 : list) {
//                                shop.removeCart(list1);
//                            }
//                            session.setAttribute("SHOP", shop);
//                        }
//                    }
//                }
//                String url = "CartServlet?action=View Cart";
//                RequestDispatcher rd = request.getRequestDispatcher(url);
//                rd.forward(request, response);
//            } else if (action.equals("Update")) {
//                changeQuantity(request, response);
//                String url = "CartServlet?action=View Cart";
//                RequestDispatcher rd = request.getRequestDispatcher(url);
//                rd.forward(request, response);
//            } else if (action.equals("Buy")) {
//                changeQuantity(request, response);
//                KhuyenMai km = new KhuyenMai();
//                KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
//                ArrayList<KhuyenMai> ls = kmDAO.selectAllKhuyenMai();
//                request.setAttribute("LIST_KHUYENMAI", ls);
//                String[] listPrice = request.getParameterValues("price");
//                int totalPrice = 0;
//                for (int i = 0; i < listPrice.length; i++) {
//                    totalPrice += Integer.valueOf(listPrice[i]);
//                }
////				request.setAttribute("KM_APPLY", 1);
//                request.setAttribute("TOTAL", totalPrice);
//                request.setAttribute("REALPRICE", totalPrice);
//                request.setAttribute("VIEW", urlThanhToan);
//                RequestDispatcher rd = request.getRequestDispatcher(urlTrangChu);
//                rd.forward(request, response);
//            } else if (action.equals("Apply Code")) {
//                KhuyenMai km = new KhuyenMai();
//                KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
//                ArrayList<KhuyenMai> ls = kmDAO.selectAllKhuyenMai();
//                request.setAttribute("LIST_KHUYENMAI", ls);
//                String maKM = request.getParameter("maKM");
//                km = kmDAO.searchByMaxKhuyenMai(maKM);
//                float tileKM = km.getTileKM();
//                float totalPrice = Float.parseFloat(request.getParameter("total"));
//                float realPrice = totalPrice * tileKM;
//                System.out.print(maKM);
//                System.out.print(totalPrice);
//                System.out.print(tileKM);
//                System.out.print(realPrice);
//                request.setAttribute("MAKM", "Your Are Applying " + maKM);
//                request.setAttribute("MAKM1", maKM);
//                request.setAttribute("TOTAL", totalPrice);
//                request.setAttribute("REALPRICE", realPrice);
//                request.setAttribute("VIEW", urlThanhToan);
//                RequestDispatcher rd = request.getRequestDispatcher(urlTrangChu);
//                rd.forward(request, response);
//            } else if (action.equals("Confirm")) {
//                String[] listProductCode = request.getParameterValues("coded");
//                String[] listProductName = request.getParameterValues("named");
//                String[] listProductPrice = request.getParameterValues("priced");
//                String[] listProductQuantity = request.getParameterValues("quantityd");
//                String[] listProductTotalPrice = request.getParameterValues("price");
//                String maKH = "MKH003";
//                String maNV = "";
//                String maKM = request.getParameter("codediscount");
//                float totalPrice = Float.valueOf(request.getParameter("totalprice"));
//                int totalPrice1 = (int) totalPrice;
//                long millis = System.currentTimeMillis();
//                java.sql.Date today = new java.sql.Date(millis);
//                OrderDAO orderDAO = new OrderDAO();
//                String maHD = orderDAO.createNewMaHD();
//                Order order = new Order(maHD, maNV, maKH, maKM, totalPrice1, today);
//                khachhang kh = new khachhang("MKH005", "nguyen ha", "123124123", "thuythatthanthanh@gmail.com", today, "10");
//                orderDAO.addOrder(order);
//
//                DetailOrderDAO detailOrderDAO = new DetailOrderDAO();
//                for (int i = 0; i < listProductCode.length; i++) {
//                    DetailOrder detailOrder = new DetailOrder(maHD, listProductCode[i], Integer.parseInt(listProductPrice[i]), Integer.parseInt(listProductQuantity[i]), Integer.parseInt(listProductTotalPrice[i]));
//                    detailOrderDAO.addDetailOrder(detailOrder, i + 1);
//                }
//                orderDAO.sendEmail(request, response, kh, order);
//                HttpSession session1 = request.getSession(true);
//                Cart shop = (Cart) session1.getAttribute("SHOP");
//                shop.clear();
//                request.setAttribute("VIEW", urlConfirmed);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
