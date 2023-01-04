/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.GioHang;
import model.SanPham;

/**
 *
 * @author Minh Hoanfg
 */
public class ClassTableGioHang {
     public DefaultTableModel setTableGioHang(List<GioHang> listItem, String[] listColumn) {
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
                GioHang gh = listItem.get(i);
                obj = new Object[columns];
                obj[0] = (i + 1);
                obj[1] = gh.getmSP();
                obj[2] = gh.gettSP();
                obj[3] = gh.getDonGiaSP();
                obj[4] = gh.getSlSP();
                df.addRow(obj);
            }
        }
        return df;
    }
}
