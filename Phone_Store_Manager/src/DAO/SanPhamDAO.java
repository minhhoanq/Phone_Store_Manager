/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Minh Hoanfg
 */
public class SanPhamDAO implements ISanPham {

    @Override
    public List<SanPham> getListSP() {
        try {
            Connection cons = dbConnect.getConnection();
            String sql = "SELECT * FROM SANPHAM";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            ///Mã sản phẩm, tên sản phẩm, Hãng, Ngày nhập, Số lượng, Đơn giá/1sp, Trạng thái.
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MASANPHAM"));
                sp.setTenSP(rs.getString("TENSANPHAM"));
                sp.setHangSP(rs.getString("HANG"));
                sp.setNgayNhap(rs.getString("NGAYNHAP"));
                sp.setSoLuongSP(rs.getString("SOLUONG"));
                sp.setGiaSP(rs.getString("DONGIA"));
                sp.setTrangThaiSP(rs.getString("TRANGTHAI"));

                list.add(sp);
            }

            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ISanPham iSanPham = new SanPhamDAO();
        System.out.println(iSanPham.getListSP());
    }
}
