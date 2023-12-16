/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author lythanhphat9523
 */
public interface iDAO<T> {
    public int insert(T a);
    public int update(T a);
    public int delete(String a);
    public List<T> findAll();
    public T findById(String id);
}
