/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Minh Hoanfg
 */
public class GioHang {
    private String mSP, tSP, donGiaSP;
    private int slSP;

    public GioHang(String mSP, String tSP, String donGiaSP, int slSP) {
        this.mSP = mSP;
        this.tSP = tSP;
        this.donGiaSP = donGiaSP;
        this.slSP = slSP;
    }

    public GioHang() {
    }

    public void setmSP(String mSP) {
        this.mSP = mSP;
    }

    public void settSP(String tSP) {
        this.tSP = tSP;
    }

    public void setDonGiaSP(String donGiaSP) {
        this.donGiaSP = donGiaSP;
    }

    public void setSlSP(int slSP) {
        this.slSP = slSP;
    }

    public String getmSP() {
        return mSP;
    }

    public String gettSP() {
        return tSP;
    }

    public String getDonGiaSP() {
        return donGiaSP;
    }

    public int getSlSP() {
        return slSP;
    }

    @Override
    public String toString() {
        return "GioHang{" + "mSP=" + mSP + ", tSP=" + tSP + ", donGiaSP=" + donGiaSP + ", slSP=" + slSP + '}';
    }
    
    
}
