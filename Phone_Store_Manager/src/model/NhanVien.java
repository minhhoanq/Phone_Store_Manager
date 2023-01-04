/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import trido_main.Helper;

/**
 *
 * @author Minh Hoanfg
 */
public class NhanVien {

    private int maNV;
    private String tenNV;
    private String passwordNV;
    private boolean gioiTinhNV;

    private int ageNV;
    private String emailNV;
    private String sdtNV;

    private String diaChiNV = "";

    public NhanVien() {
    }

    public NhanVien(int maNV, String tenNV, String passwordNV, boolean gioiTinhNV, int ageNV, String emailNV, String sdtNV, String diaChiNV) {
        this.maNV = maNV;
        this.tenNV = tenNV.toLowerCase();
        this.passwordNV = Helper.clearSpace(passwordNV);
        this.gioiTinhNV = gioiTinhNV;
        this.ageNV = ageNV;
        this.emailNV = emailNV.toLowerCase();
        this.sdtNV = sdtNV;
        this.diaChiNV = diaChiNV;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) throws Exception {
        this.tenNV = tenNV.toLowerCase();
    }

    public String getPasswordNV() {
        return passwordNV;
    }

    public boolean setPasswordNV(String passwordNV) {
        if (passwordNV.length() < 6) {
            return false;
        }
        this.passwordNV = Helper.clearSpace(passwordNV);

        return true;
    }

    public boolean isGioiTinhNV() {
        return gioiTinhNV;
    }

    public void setGioiTinhNV(boolean gioiTinhNV) {
        this.gioiTinhNV = gioiTinhNV;
    }

    public int getAgeNV() {
        return ageNV;
    }

    public void setAgeNV(int ageNV) throws Exception {
        if (ageNV < 18 || ageNV > 65) {
            throw new Exception("age < 18 || age > 65");
        }
        this.ageNV = ageNV;
    }

    public String getEmailNV() {
        return emailNV;
    }

    public void setEmailNV(String emailNV) throws Exception {
        if (!Helper.isEmail(emailNV)) {
            throw new Exception("input is not email");
        }
        this.emailNV = emailNV.toLowerCase();
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) throws Exception {
        if (!Helper.isTelNumber(sdtNV)) {
            throw new Exception("input is not tel number");
        }
        this.sdtNV = sdtNV;
    }

    public String getDiaChiNV() {
        return diaChiNV;
    }

    public void setDiaChiNV(String diaChiNV) {
        this.diaChiNV = diaChiNV;
    }
}
