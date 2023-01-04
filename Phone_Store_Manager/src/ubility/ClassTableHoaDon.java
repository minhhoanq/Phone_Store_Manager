/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;

/**
 *
 * @author Minh Hoanfg
 */
public class ClassTableHoaDon {

    public static HoaDon hd_temp = null;
    
    public DefaultTableModel setTableHoaDon(List<HoaDon> listItem, String[] listColumn) {
        DefaultTableModel df = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        df.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                HoaDon hd = listItem.get(i);
                hd_temp = hd;
                obj = new Object[columns];
                obj[0] = (i + 1);
                obj[1] = hd.getMaHD();
                obj[2] = hd.getMaKH();
                obj[3] = hd.getMaNV();
                obj[4] = hd.getNgayTao();
                obj[5] = hd.getTongTien();
                obj[6] = hd.getThanhToan();
                if (hd.getHtGH() == 1) {
                    obj[7] = "Mua trực tiếp";
                } else {
                    obj[7] = "Giao hàng";
                }

                if (hd.getHtTT() == 1) {
                    obj[8] = "Tiền mặt";
                } else if (hd.getHtTT() == 2) {
                    obj[8] = "Quẹt thẻ";
                } else {
                    obj[8] = "Chuyển khoản";
                }

                if (hd.getTtTT() == 1) {
                    String s = "Đã thanh toán";
                    obj[9] = s;
                } else if (hd.getTtTT() == 2){
                    String s = "Chưa thanh toán";
                    obj[9] = s;
                } else {
                    String s = "Đã hủy";
                    obj[9] = s;
                }
                obj[10] = hd.getGhiChu();
                df.addRow(obj);
            }
        }
        return df;
    }

    public DefaultTableModel setTableHoaDonCho(List<HoaDon> listItem, String[] listColumnHDcho) {
        DefaultTableModel df = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        df.setColumnIdentifiers(listColumnHDcho);
        int columns = listColumnHDcho.length;
        Object[] obj = null;
        int rows = listItem.size();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                HoaDon hd = listItem.get(i);
                obj = new Object[columns];
                obj[0] = hd.getMaHD();
                obj[1] = hd.getMaKH();
                obj[2] = hd.getMaNV();
                obj[3] = hd.getNgayTao();
                df.addRow(obj);
            }
        }
        return df;
    }
}
