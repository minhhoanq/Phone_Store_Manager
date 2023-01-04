/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JButton;
import javax.swing.JTextField;
import model.KhachHang;

/**
 *
 * @author Minh Hoanfg
 */
public class KhachHangController {
    private JTextField MaKH, TenKH, SdtKH, DiaChiKH, GhiChuKH;
    private JButton CapNhat;

    public KhachHangController(JTextField MaKH, JTextField TenKH, JTextField SdtKH, JTextField DiaChiKH, JTextField GhiChuKH, JButton CapNhat) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SdtKH = SdtKH;
        this.DiaChiKH = DiaChiKH;
        this.GhiChuKH = GhiChuKH;
        this.CapNhat = CapNhat;
    }
    
    public void setView(KhachHang khachHang){
        MaKH.setText(khachHang.getMaKH());
        TenKH.setText(khachHang.getHoTen());
        SdtKH.setText(khachHang.getSDT());
        DiaChiKH.setText(khachHang.getAddress());
        GhiChuKH.setText(khachHang.getGhichu());
    }
    
}
