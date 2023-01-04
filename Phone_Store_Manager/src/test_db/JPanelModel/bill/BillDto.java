package test_db.JPanelModel.bill;

import java.sql.Date;

public class BillDto {

    private int id;

    private int clientId;
    private int employeeId;
    private Date dateTime;
    private Float total;
    private Float pay;

    private int id_hinhThucGiaoHang;
    private int id_hinhThucThanhToan;
    private int id_trangThaiThanhToan;

    private String ghiChu;

    public BillDto(int id, int clientId, int employeeId, Date dateTime, Float total, Float pay, int id_hinhThucGiaoHang, int id_hinhThucThanhToan, int id_trangThaiThanhToan, String ghiChu) {
        this.id = id;
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.dateTime = dateTime;
        this.total = total;
        this.pay = pay;
        this.id_hinhThucGiaoHang = id_hinhThucGiaoHang;
        this.id_hinhThucThanhToan = id_hinhThucThanhToan;
        this.id_trangThaiThanhToan = id_trangThaiThanhToan;
        this.ghiChu = ghiChu;
    }

    public BillDto(int clientId, int employeeId, Date dateTime, Float total, Float pay, int id_hinhThucGiaoHang, int id_hinhThucThanhToan, int id_trangThaiThanhToan, String ghiChu) {
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.dateTime = dateTime;
        this.total = total;
        this.pay = pay;
        this.id_hinhThucGiaoHang = id_hinhThucGiaoHang;
        this.id_hinhThucThanhToan = id_hinhThucThanhToan;
        this.id_trangThaiThanhToan = id_trangThaiThanhToan;
        this.ghiChu = ghiChu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getPay() {
        return pay;
    }

    public void setPay(Float pay) {
        this.pay = pay;
    }

    public int getId_hinhThucGiaoHang() {
        return id_hinhThucGiaoHang;
    }

    public void setId_hinhThucGiaoHang(int id_hinhThucGiaoHang) {
        this.id_hinhThucGiaoHang = id_hinhThucGiaoHang;
    }

    public int getId_hinhThucThanhToan() {
        return id_hinhThucThanhToan;
    }

    public void setId_hinhThucThanhToan(int id_hinhThucThanhToan) {
        this.id_hinhThucThanhToan = id_hinhThucThanhToan;
    }

    public int getId_trangThaiThanhToan() {
        return id_trangThaiThanhToan;
    }

    public void setId_trangThaiThanhToan(int id_trangThaiThanhToan) {
        this.id_trangThaiThanhToan = id_trangThaiThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
