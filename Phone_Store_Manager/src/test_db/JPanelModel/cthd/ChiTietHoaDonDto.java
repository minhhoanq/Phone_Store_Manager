package test_db.JPanelModel.cthd;

public class ChiTietHoaDonDto {

    private int maHoaDon;
    private int maDienThoai;

    private int soLuong;
    private float tongGia;
    private String ghiChu;

    public ChiTietHoaDonDto(int maHoaDon, int maDienThoai, int soLuong, float tongGia, String ghiChu) {
        this.maHoaDon = maHoaDon;
        this.maDienThoai = maDienThoai;
        this.soLuong = soLuong;
        this.tongGia = tongGia;
        this.ghiChu = ghiChu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setMaDienThoai(int maDienThoai) {
        this.maDienThoai = maDienThoai;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTongGia(float tongGia) {
        this.tongGia = tongGia;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public int getMaDienThoai() {
        return maDienThoai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public float getTongGia() {
        return tongGia;
    }
}
