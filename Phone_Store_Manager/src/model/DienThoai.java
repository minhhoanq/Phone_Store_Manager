/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Minh Hoanfg
 */
public class DienThoai {
    private String maDienThoai, loai, hang, ghichu;
    private  float gia;

    public DienThoai(String maDienThoai, String loai, String hang, String ghichu, float gia) {
        this.maDienThoai = maDienThoai;
        this.loai = loai;
        this.hang = hang;
        this.ghichu = ghichu;
        this.gia = gia;
    }

    public DienThoai() {
    }

    public String getMaDienThoai() {
        return maDienThoai;
    }

    public void setMaDienThoai(String maDienThoai) {
        this.maDienThoai = maDienThoai;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    
    
}
