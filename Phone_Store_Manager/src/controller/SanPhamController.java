/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JButton;
import javax.swing.JTextField;
import model.SanPham;

/**
 *
 * @author Minh Hoanfg
 */
public class SanPhamController {
    ///Mã sản phẩm, tên sản phẩm, Hãng, Ngày nhập, Số lượng, Đơn giá/1sp, Trạng thái.
    JTextField maSP, tenSP, hangSP, daySP, soLuongSP, giaSP, trangThaiSP;
    JButton btnAdd;

    public SanPhamController(JTextField maSP, JTextField tenSP, JTextField hangSP, JTextField daySP, JTextField soLuongSP, JTextField giaSP, JTextField trangThaiSP, JButton btnAdd) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.hangSP = hangSP;
        this.daySP = daySP;
        this.soLuongSP = soLuongSP;
        this.giaSP = giaSP;
        this.trangThaiSP = trangThaiSP;
        this.btnAdd = btnAdd;
    }
    
    public void setView(SanPham sanPham){
        maSP.setText(sanPham.getMaSP());
        tenSP.setText(sanPham.getTenSP());
        hangSP.setText(sanPham.getHangSP());
        daySP.setText(sanPham.getNgayNhap());
        soLuongSP.setText(sanPham.getSoLuongSP());
        giaSP.setText(sanPham.getGiaSP());
        trangThaiSP.setText(sanPham.getTrangThaiSP());
    }
}
