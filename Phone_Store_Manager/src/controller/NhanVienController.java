/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JButton;
import javax.swing.JTextField;
import model.KhachHang;
import model.NhanVien;

/**
 *
 * @author Minh Hoanfg
 */
public class NhanVienController {
    private JTextField maNV, tenNV, ageNV, sdtNV, diaChiNV, emailNV, passNV, gioiTinhNV;
    
    private JButton btnAdd;

    public NhanVienController(JTextField maNV, JTextField tenNV, JTextField ageNV, JTextField sdtNV, JTextField diaChiNV, JTextField emailNV, JTextField passNV, JTextField gioiTinhNV, JButton btnAdd) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ageNV = ageNV;
        this.sdtNV = sdtNV;
        this.diaChiNV = diaChiNV;
        this.emailNV = emailNV;
        this.passNV = passNV;
        this.gioiTinhNV = gioiTinhNV;
        this.btnAdd = btnAdd;
    }
    
    public void setViewNV(NhanVien nhanvien){
        maNV.setText(String.valueOf(nhanvien.getMaNV()));
        tenNV.setText(nhanvien.getTenNV());
        sdtNV.setText(nhanvien.getSdtNV());
        ageNV.setText(String.valueOf(nhanvien.getAgeNV()));
        diaChiNV.setText(nhanvien.getDiaChiNV());
        emailNV.setText(nhanvien.getEmailNV());
        passNV.setText(nhanvien.getPasswordNV());
        gioiTinhNV.setText(String.valueOf(nhanvien.isGioiTinhNV()));
    }
}
