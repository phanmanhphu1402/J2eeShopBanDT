package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Statement;
import java.text.SimpleDateFormat;

import model.khachhang;
import model.Order;
import Database.DataBase;

public class OrderDAO {
//	public ArrayList<Order> ls = new ArrayList();

    public ArrayList<Order> selectAllOrder() {
        ArrayList<Order> ls = new ArrayList<Order>();
        try {
            Connection conn = DataBase.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM HoaDonBan";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString("MaHDB");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                String maKM = rs.getString("MaKM");
                int tongTien = rs.getInt("TongTien");
                Date ngayTao = rs.getDate("NgayTao");
                Order ord = new Order(maHD, maNV, maKH, maKM, tongTien, ngayTao);
                ls.add(ord);

            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Cant connect BD");
        }

        return ls;
    }

    public Order searchOrder(String id) {
        Order order = new Order();
        try {
            Connection conn = DataBase.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM HoaDonBan WHERE MaHDB ='" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString("MaHDB");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                String maKM = rs.getString("MaKM");
                int tongTien = rs.getInt("TongTien");
                Date ngayTao = rs.getDate("NgayTao");
                Order ord = new Order(maHD, maNV, maKH, maKM, tongTien, ngayTao);
                order = ord;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Cant connect BD");
        }
        return order;
    }

    public ArrayList<Order> searchOrderByMaKH(String id) {
        ArrayList<Order> ls = new ArrayList<Order>();
        try {
            Connection conn = DataBase.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM HoaDonBan WHERE MaKH ='" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString("MaHDB");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                String maKM = rs.getString("MaKM");
                int tongTien = rs.getInt("TongTien");
                Date ngayTao = rs.getDate("NgayTao");
                Order ord = new Order(maHD, maNV, maKH, maKM, tongTien, ngayTao);
                ls.add(ord);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Cant connect BD");
        }
        return ls;
    }

    public ArrayList<Order> searchOrderByMaKM(String id) {
        ArrayList<Order> ls = new ArrayList<Order>();
        try {
            Connection conn = DataBase.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM HoaDonBan WHERE MaKM ='" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString("MaHDB");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                String maKM = rs.getString("MaKM");
                int tongTien = rs.getInt("TongTien");
                Date ngayTao = rs.getDate("NgayTao");
                Order ord = new Order(maHD, maNV, maKH, maKM, tongTien, ngayTao);
                ls.add(ord);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Cant connect BD");
        }
        return ls;
    }

    public ArrayList<Order> searchOrderByDate(String date) {
        ArrayList<Order> ls = new ArrayList<Order>();
        try {
            Connection conn = DataBase.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM HoaDonBan WHERE NgayTao ='" + date + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString("MaHDB");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                String maKM = rs.getString("MaKM");
                int tongTien = rs.getInt("TongTien");
                Date ngayTao = rs.getDate("NgayTao");
                Order ord = new Order(maHD, maNV, maKH, maKM, tongTien, ngayTao);
                ls.add(ord);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Cant connect BD");
        }
        return ls;
    }

    public ArrayList<Order> searchOrderByMaNV(String id) {
        ArrayList<Order> ls = new ArrayList<Order>();
        try {
            Connection conn = DataBase.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM HoaDonBan WHERE MaNV ='" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString("MaHDB");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                String maKM = rs.getString("MaKM");
                int tongTien = rs.getInt("TongTien");
                Date ngayTao = rs.getDate("NgayTao");
                Order ord = new Order(maHD, maNV, maKH, maKM, tongTien, ngayTao);
                ls.add(ord);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Cant connect BD");
        }
        return ls;
    }

    public String createNewMaHD() {
        OrderDAO ordDAO = new OrderDAO();
        ArrayList<Order> ls = ordDAO.selectAllOrder();
        ArrayList<Integer> lsMaHD = new ArrayList<Integer>();
        if (ls.size() >= 1) {
            for (int i = 0; i < ls.size(); i++) {
                lsMaHD.add(Integer.parseInt((ls.get(i).getMaHD().substring(4)).trim()));
            }
            String kitu = "HD00";
            int max = lsMaHD.get(0);
            for (int i = 0; i < lsMaHD.size(); i++) {
                if (lsMaHD.get(i) > max) {
                    max = lsMaHD.get(i);
                }
            }
            int so = max;
            so++;
            String newMaHD = kitu + so;
            return newMaHD;
        } else {
            return "HD001";
        }
    }

    public int addOrder(Order order) {
        try {
            Connection conn = DataBase.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO HoaDonBan (MaHDB, MaNV, MaKH, MaKM, TongTien, NgayTao) VALUES ('" + order.getMaHD() + "','" + order.getMaNV() + "','" + order.getMaKH() + "','" + order.getMaKM() + "','" + order.getTongTien() + "','" + order.getNgayTao() + "')";
            ResultSet rs = stmt.executeQuery(sql);
//			stmt.executeQuery(sql);
            conn.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Cant connect BD");
            return 0;
        }
    }

    public void deleteOrder(String id) {
        try {
            Connection conn = DataBase.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM HoaDonBan WHERE MaHDB ='" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
//			stmt.executeQuery(sql);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Cant connect BD");
        }
    }
public void sendEmail(HttpServletRequest request, HttpServletResponse response, khachhang kh, Order order) {
    	final String username = "thuythatthanthanh@gmail.com";// email
		final String password = "werr iryb ckcf xipx";//email app password
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
                prop.put("mail.smtp.ssl.trust", "*");
		prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(prop, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		//dang nhap dc email
		String emailTo = kh.getEmail();
		String emailSubject = "Email xác nhận đặt hàng";
		String emailContent = "Mã Đơn hàng: "+order.getMaHD()+" Tổng giá: "+order.getTongTien()+" giao đến cho anh/chị: "+kh.getHoTen()+
				" địa chỉ email là: "+kh.getEmail()+" Số điện thoại "+kh.getSDT()+". Đơn hàng sẽ giao tới trong vòng 2 ngày nữa. Cảm ơn quý khách đã mua hàng";
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(
					Message.RecipientType.TO, 
					InternetAddress.parse(emailTo)
			);
			message.setSubject(emailSubject);
			message.setText(emailContent);
			Transport.send(message);
			System.out.print("Done");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    }
//	public static void main(String[] args) {
//		long millis = System.currentTimeMillis();
//        java.sql.Date sqlDate = new java.sql.Date(millis);
//		OrderDAO ordDAO = new OrderDAO();
//		String maHD = ordDAO.createNewMaHD();
//		System.out.print(maHD);
//		Order order = new Order(maHD,"NV1","KH1","KM1",100000000, sqlDate);
//		ordDAO.addOrder(order);
//		
//		
//	}
}
