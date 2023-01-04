/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Minh Hoanfg
 */
public class KhachHang {

    private String maKH, HoTen, SDT, address, ghichu;

    public KhachHang(String maKH, String HoTen, String SDT, String address, String ghichu) {
        this.maKH = maKH;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.address = address;
        this.ghichu = ghichu;
    }

    public KhachHang() {
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", HoTen=" + HoTen + ", SDT=" + SDT + ", address=" + address + ", ghichu=" + ghichu + '}';
    }
}
