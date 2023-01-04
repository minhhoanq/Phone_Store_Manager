/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Minh Hoanfg
 */
public class HoaDon {
    private int maHD, maKH, maNV, htGH, htTT, ttTT;
    private String ghiChu;
    private float tongTien, thanhToan;
    private Date timeDate;

    public HoaDon(int maHD, int maKH, int maNV, int htGH, int htTT, int ttTT, Date timeDate, String ghiChu, float tongTien, float thanhToan) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.htGH = htGH;
        this.htTT = htTT;
        this.ttTT = ttTT;
        this.timeDate = timeDate;
        this.ghiChu = ghiChu;
        this.tongTien = tongTien;
        this.thanhToan = thanhToan;
    }

    public HoaDon() {
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getHtGH() {
        return htGH;
    }

    public void setHtGH(int htGH) {
        this.htGH = htGH;
    }

    public int getHtTT() {
        return htTT;
    }

    public void setHtTT(int htTT) {
        this.htTT = htTT;
    }

    public int getTtTT() {
        return ttTT;
    }

    public void setTtTT(int ttTT) {
        this.ttTT = ttTT;
    }

    public Date getNgayTao() {
        return timeDate;
    }

    public void setNgayTao(Date timeDate) {
        this.timeDate = timeDate;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(float thanhToan) {
        this.thanhToan = thanhToan;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", maKH=" + maKH + ", maNV=" + maNV + ", htGH=" + htGH + ", htTT=" + htTT + ", ttTT=" + ttTT + ", ngayTao=" + timeDate + ", ghiChu=" + ghiChu + ", tongTien=" + tongTien + ", thanhToan=" + thanhToan + '}';
    }
    
}
