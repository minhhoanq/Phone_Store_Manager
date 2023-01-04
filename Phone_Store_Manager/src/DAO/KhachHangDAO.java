/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author Minh Hoanfg
 */
public class KhachHangDAO implements IKhachHang{

    @Override
    public List<KhachHang> getListKH() {    
        try {
            Connection cons = (Connection) dbConnect.getConnection();
            String sql = "Select * from KHACHHANG";
            List<KhachHang> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MAKHACHHANG"));
                kh.setHoTen(rs.getString("HOVATEN"));
                kh.setSDT(rs.getString("SODIENTHOAI"));
                kh.setAddress(rs.getString("DIACHI"));
                kh.setGhichu(rs.getString("GHICHU"));
                list.add(kh);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        IKhachHang iKhachHang = new KhachHangDAO();
        System.out.println(iKhachHang.getListKH());
    }
}
