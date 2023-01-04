/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Emplyee_Manager.NhanVienLoginInfor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;
import java.sql.ResultSet;

/**
 *
 * @author Minh Hoanfg
 */
public class NhanVienDAO implements INhanVien {

    @Override
    public List<NhanVien> getListNV() {
        try {
            Connection cons = dbConnect.getConnection();
            String sql = "Select * From NHANVIEN";
            List<NhanVien> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getInt("MANHANVIEN"));
                nv.setTenNV(rs.getString("HOTENNHANVIEN"));
                nv.setAgeNV(rs.getInt("TUOI"));
                nv.setSdtNV(rs.getString("SODIENTHOAI"));
                nv.setDiaChiNV(rs.getString("DIACHI"));
                nv.setEmailNV(rs.getString("EMAIL"));
                nv.setPasswordNV(rs.getString("MATKHAU"));
                nv.setGioiTinhNV(rs.getBoolean("GIOITINH"));
                list.add(nv);
            }
            rs.close();
            ps.close();
            cons.close();
            return list;
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        INhanVien iNhanVien = new NhanVienDAO();
        System.out.println(iNhanVien.getListNV());
    }

    @Override
    public boolean register(NhanVien nhanvien) throws Exception {
        List<NhanVien> list = getListNV();

        for (NhanVien existedNhanvien : list) {
            if (existedNhanvien.getEmailNV().equals(nhanvien.getEmailNV())) {
                System.out.println("nhan vien da ton tai, email=" + existedNhanvien.getEmailNV());
                return false;
            }
        }

        Connection cons = dbConnect.getConnection();
        if (cons == null) {
            System.out.println("con = null");
            return false;
        }
        try {
            PreparedStatement preparedStatement = cons.prepareStatement(
                    "INSERT INTO [dbo].[NHANVIEN] VALUES(?,?,?,?,?,?,?,?)"
            );
            preparedStatement.setInt(1, nhanvien.getMaNV());
            preparedStatement.setString(2, nhanvien.getTenNV());
            preparedStatement.setString(3, nhanvien.getPasswordNV());
            preparedStatement.setString(4, nhanvien.getEmailNV());
            preparedStatement.setInt(5, nhanvien.getAgeNV());
            preparedStatement.setBoolean(6, nhanvien.isGioiTinhNV());
            preparedStatement.setString(7, nhanvien.getSdtNV());
            preparedStatement.setString(8, nhanvien.getDiaChiNV());

            preparedStatement.execute();

            cons.close();

            System.out.println("dang ky nhan vien thanh cong");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public NhanVien logIn(NhanVienLoginInfor employeeLogInInfo) throws Exception {
        List<NhanVien> daos = getListNV();

        for (NhanVien dao : daos) {
            boolean emailValid = employeeLogInInfo.getEmail().equals(dao.getEmailNV());
            boolean passwordValid = employeeLogInInfo.getPassword().equals(dao.getPasswordNV());
            if (emailValid && passwordValid) {
                return dao;
            }
        }

        return null;
    }

    @Override
    public boolean logOut() throws Exception {
        return false;
    }
}
