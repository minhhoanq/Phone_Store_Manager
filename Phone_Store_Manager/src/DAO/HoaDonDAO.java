/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;

/**
 *
 * @author Minh Hoanfg
 */
public class HoaDonDAO implements IHoaDon{

    @Override
    public List<HoaDon> getListHD() {
        try {
            Connection cons = dbConnect.getConnection();
            String sql = "Select * From HOADON";
            List<HoaDon> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MAHOADON"));
                hd.setMaKH(rs.getInt("MAKHACHHANG"));
                hd.setMaNV(rs.getInt("MANHANVIEN"));
                hd.setNgayTao(rs.getDate("NGAYTAO"));
                hd.setTongTien(rs.getFloat("TONGTIEN"));
                hd.setThanhToan(rs.getFloat("THANHTOAN"));
                hd.setHtGH(rs.getInt("FK_HINHTHUCGIAOHANG"));
                hd.setHtTT(rs.getInt("FK_HINHTHUCTHANHTOAN"));
                hd.setTtTT(rs.getInt("FK_TRANGTHAITHANHTOAN"));
                hd.setGhiChu(rs.getString("GHICHU"));
                list.add(hd);
            }
            rs.close();
            ps.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        IHoaDon iHoaDon = new HoaDonDAO();
        System.out.println(iHoaDon.getListHD());
    }
}
