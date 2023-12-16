/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thine
 */
public class Account {
    private  int UserID;
    private String Username;
    private String Password;
    private int Quyen;
    private  int TrangThai;

    public Account() {
    }

    public Account(int UserID, String Username, String Password, int Quyen, int TrangThai) {
        this.UserID = UserID;
        this.Username = Username;
        this.Password = Password;
        this.Quyen = Quyen;
        this.TrangThai = TrangThai;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getQuyen() {
        return Quyen;
    }

    public void setQuyen(int Quyen) {
        this.Quyen = Quyen;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "Account{" + "UserID=" + UserID + ", Username=" + Username + ", Password=" + Password + ", Quyen=" + Quyen + ", TrangThai=" + TrangThai + '}';
    }

    

 

    
    
    
    
    
}
