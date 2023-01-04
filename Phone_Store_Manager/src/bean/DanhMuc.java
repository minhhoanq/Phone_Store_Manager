/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Minh Hoanfg
 */
public class DanhMuc {

    private String kindString;
    private JPanel jpn;
    private JLabel jlb;

    public DanhMuc(String kindString, JPanel jpn, JLabel jlb) {
        this.kindString = kindString;
        this.jpn = jpn;
        this.jlb = jlb;
    }

    public DanhMuc() {
    }

    public String getKindString() {
        return kindString;
    }

    public void setKindString(String kindString) {
        this.kindString = kindString;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }

}
