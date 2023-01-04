/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;

/**
 *
 * @author Minh Hoanfg
 */
public class ClassTableModel {
    public DefaultTableModel setTableKhacHang(List<KhachHang> listItem, String[] listColumn){
        DefaultTableModel df = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        df.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0){
            for(int i = 0; i < rows; i++){
                KhachHang kh = listItem.get(i);
                obj = new Object[columns];
                obj[0] = (i+1);
                obj[1] = kh.getMaKH();
                obj[2] = kh.getHoTen();
                obj[3] = kh.getSDT();
                obj[4] = kh.getAddress();
                obj[5] = kh.getGhichu();
                df.addRow(obj);
            }
        }
        return df;
    }
}
