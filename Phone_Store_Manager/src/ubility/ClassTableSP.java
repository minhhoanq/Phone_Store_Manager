/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;
import model.SanPham;

/**
 *
 * @author Minh Hoanfg
 */
public class ClassTableSP {

    public DefaultTableModel setTableSanPham(List<SanPham> listItem, String[] listColumn) {
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
                SanPham sp = listItem.get(i);
                obj = new Object[columns];
                obj[0] = (i + 1);
                obj[1] = sp.getMaSP();
                obj[2] = sp.getTenSP();
                obj[3] = sp.getHangSP();
                obj[4] = sp.getNgayNhap();
                obj[5] = sp.getSoLuongSP();
                obj[6] = sp.getGiaSP();
                if(Integer.parseInt(sp.getSoLuongSP()) != 0){
                    sp.setTrangThaiSP("Còn hàng");
                    obj[7] = sp.getTrangThaiSP();
                }else{
                    sp.setTrangThaiSP("Hết hàng");
                    obj[7] = sp.getTrangThaiSP();
                }
                df.addRow(obj);
            }
        }
        return df;
    }
}
