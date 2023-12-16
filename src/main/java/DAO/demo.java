/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.nio.file.Path;
import java.util.List;
import model.chitietsanpham;
import model.loaisanpham;
import model.sanpham;

/**
 *
 * @author lythanhphat9523
 */
public class demo {


    public static void main(String[] args) {
        sanpham sp = new sanpham();
        int a=1;
//        int b=Integer.parseInt(a);
        List<sanpham> list = new sanphamDAO().findAll();
        for (sanpham product:list){
            System.out.println(product.getHinhanh()+" "+ product.getTensp());
        }
    }
}