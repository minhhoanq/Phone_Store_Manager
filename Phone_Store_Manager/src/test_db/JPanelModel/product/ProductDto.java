package test_db.JPanelModel.product;

import java.sql.Date;

public class ProductDto {

    private int maSp;
    private String ten;
    private String hang;
    private Date ngayNhap;
    private int soLuong;
    private float gia;
    private boolean conHang;

    public ProductDto(int maSp, String ten, String hang, Date ngayNhap, int soLuong, float gia, boolean conHang) {
        this.maSp = maSp;
        this.ten = ten;
        this.hang = hang;
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
        this.gia = gia;
        this.conHang = conHang;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public boolean isConHang() {
        return conHang;
    }

    public void setConHang(boolean conHang) {
        this.conHang = conHang;
    }
}
