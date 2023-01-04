/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Minh Hoanfg
 */
public class SanPham {
    ///Mã sản phẩm, tên sản phẩm, Hãng, Ngày nhập, Số lượng, Đơn giá/1sp, Trạng thái.
    private String maSP, tenSP, hangSP, ngayNhap, soLuongSP, giaSP, trangThaiSP;

    public SanPham(String maSP, String tenSP, String hangSP, String ngayNhap, String soLuongSP, String giaSP, String trangThaiSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.hangSP = hangSP;
        this.ngayNhap = ngayNhap;
        this.soLuongSP = soLuongSP;
        this.giaSP = giaSP;
        this.trangThaiSP = trangThaiSP;
    }

    public SanPham() {
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHangSP() {
        return hangSP;
    }

    public void setHangSP(String hangSP) {
        this.hangSP = hangSP;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(String soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public String getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }

    public String getTrangThaiSP() {
        return trangThaiSP;
    }

    public void setTrangThaiSP(String trangThaiSP) {
        this.trangThaiSP = trangThaiSP;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", hangSP=" + hangSP + ", ngayNhap=" + ngayNhap + ", soLuongSP=" + soLuongSP + ", giaSP=" + giaSP + ", trangThaiSP=" + trangThaiSP + '}';
    }
}
