/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import model.NhanVien;

/**
 *
 * @author Minh Hoanfg
 */
public class ClassTableNV {
    public DefaultTableModel setTableNhanVien(List<NhanVien> listItem, String[] listColumn){
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
                NhanVien nv = listItem.get(i);
                obj = new Object[columns];
                obj[0] = (i+1);
                obj[1] = nv.getMaNV();
                obj[2] = nv.getTenNV();
                obj[3] = nv.getAgeNV();
                obj[4] = nv.getSdtNV();
                obj[5] = nv.getDiaChiNV();
                obj[6] = nv.getEmailNV();
                if(nv.isGioiTinhNV() == true){
                    obj[7] = "Nam";
                }else{
                    obj[7] = "Nữ";
                }
                
                df.addRow(obj);
            }
        }
        return df;
    }
}
