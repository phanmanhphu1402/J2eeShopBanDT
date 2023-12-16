package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Database.DBContext;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thine
 */
public class AccountDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Account> getAll() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Taikhoan";
        try {
            Connection conn = DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("Quyen"),
                        rs.getInt("TrangThai")
                );
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Account> searchByUsername(String search) {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Taikhoan where Username like ? ";
        try {
            Connection conn = DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + search + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("Quyen"),
                        rs.getInt("TrangThai")
                );
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public Account findByUsername(String username) {
        String sql = "select * from Taikhoan where Username = ? ";
        try {
            Connection conn = DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            Account a = null;

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    a = new Account(rs.getInt("UserID"),
                            rs.getString("Username"),
                            rs.getString("Password"),
                            rs.getInt("Quyen"),
                            rs.getInt("TrangThai")
                    );
                }
            } catch (SQLException e1) {
            }
            return a;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    public Account checkLogin(String username, String password) {
        String sql = "SELECT * FROM Taikhoan WHERE Username = ? AND Password = ?";
        try {
            Connection conn = DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("Quyen"),
                        rs.getInt("TrangThai"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean registerAccount(String username, String password) throws SQLException {
        String query = "insert into TaiKhoan(Username, Password, Quyen, TrangThai) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = DBContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, 3); // Giá trị mặc định cho quyen
            ps.setInt(4, 1); // Giá trị mặc định cho trangThai

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void deleteAccount(int userId) {
        String query = "DELETE FROM TaiKhoan WHERE UserID = ?";

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
        }
    }

    // lay value
    public Account getAccountById(int userId) {
        Account account = null;
        String query = "SELECT * FROM TaiKhoan WHERE UserID = ?";

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Lấy thông tin từ ResultSet và tạo đối tượng Account
                    int userID = rs.getInt("UserID");
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    int quyen = rs.getInt("Quyen");
                    int trangThai = rs.getInt("TrangThai");

                    // Tạo đối tượng Account từ thông tin lấy được
                    account = new Account(userID, username, password, quyen, trangThai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
        }
        return account;
    }

    public void updateAccount(Account account) {
        String query = "UPDATE TaiKhoan SET Username=?, Password=?, Quyen=?, TrangThai=? WHERE UserID=?";

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getQuyen());
            ps.setInt(4, account.getTrangThai());
            ps.setInt(5, account.getUserID()); // UserID dùng để xác định tài khoản cần cập nhật

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Thông tin tài khoản đã được cập nhật thành công.");
            } else {
                System.out.println("Không thể cập nhật thông tin tài khoản.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
        }
    }

    public int checkAccountAdmin(int userID) {

        String query = "select quyen from taikhoan where [userID]=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public static void main(String[] args) throws SQLException {
        /*  AccountDAO a = new AccountDAO();
        List<Account> list = a.getAll();
         for (Account account : list) {
            System.out.println("UserID: " + account.getUserID());
            System.out.println("Username: " + account.getUsername());
            System.out.println("Password: "+ account.getPassword());
            System.out.println("quyen: " + account.getQuyen());
            System.out.println("trangthai: "+ account.getTrangThai());
           
         }
         */

 /*
        int userIdToDelete = 5; // Thay đổi userId này thành ID thực tế cần xóa

        AccountDAO accountDAO = new AccountDAO();
        accountDAO.deleteAccount(userIdToDelete);

        System.out.println("Account with ID " + userIdToDelete + " deleted successfully.");
         */
        AccountDAO accountDAO = new AccountDAO();
        boolean result = accountDAO.registerAccount("thi1", "123");
        System.out.println(result);

        /*
  //lay value ở list
  AccountDAO accountDAO = new AccountDAO();
        
        // ID của tài khoản cần lấy thông tin
        int userId = 13; // Thay thế bằng ID thực tế
        
        // Gọi phương thức để lấy thông tin tài khoản
        Account account = accountDAO.getAccountById(userId);
        
        // Kiểm tra nếu tài khoản không null, in thông tin tài khoản
        if (account != null) {
            System.out.println("Thông tin tài khoản:");
            System.out.println("User ID: " + account.getUserID());
            System.out.println("Username: " + account.getUsername());
            System.out.println("Password: " + account.getPassword());
            System.out.println("Quyen: " + account.getQuyen());
            System.out.println("Trang Thai: " + account.getTrangThai());
        } else {
            System.out.println("Không tìm thấy tài khoản với ID: " + userId);
        }
         */
        //ham cap nhat account
        /* AccountDAO accountDAO = new AccountDAO();

        // Tạo đối tượng Account mới với thông tin cần cập nhật
        Account updatedAccount = new Account();
        updatedAccount.setUserID(10); // UserID của tài khoản cần cập nhật
        updatedAccount.setUsername("pori");
        updatedAccount.setPassword("111");
        updatedAccount.setQuyen(1); // Giá trị mới của Quyen
        updatedAccount.setTrangThai(1); // Giá trị mới của TrangThai

        // Gọi hàm updateAccount để cập nhật thông tin tài khoản
        accountDAO.updateAccount(updatedAccount);
         */
    }

}
