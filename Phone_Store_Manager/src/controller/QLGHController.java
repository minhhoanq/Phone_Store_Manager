/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.GioHang;
import ubility.ClassTableGioHang;

/**
 *
 * @author Minh Hoanfg
 */
public class QLGHController {

    private JPanel jpnView;

    private static int index = -1;

    ///Mã sản phẩm, tên sản phẩm, Hãng, Ngày nhập, Số lượng, Đơn giá/1sp, Trạng thái.
    private String[] listColumn = {"STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng"};

    private TableRowSorter<TableModel> rowSorter = null;

    public QLGHController(JPanel jpnView) {
        this.jpnView = jpnView;
    }

    public void setDataModel(List<GioHang> list) {
        List<GioHang> listItem = list;
        DefaultTableModel model = new ClassTableGioHang().setTableGioHang(listItem, listColumn);

        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(200, 100));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);

                    ///Mã sản phẩm, tên sản phẩm, Hãng, Ngày nhập, Số lượng, Đơn giá/1sp, Trạng thái.
                    GioHang gh = new GioHang();
                    gh.setmSP(model.getValueAt(selectedRowIndex, 1).toString().trim());
                    gh.settSP(model.getValueAt(selectedRowIndex, 2).toString());
                    gh.setDonGiaSP(model.getValueAt(selectedRowIndex, 3).toString());
                    gh.setSlSP(Integer.valueOf(model.getValueAt(selectedRowIndex, 4).toString()));

                    setIndex(selectedRowIndex);
                }
//                
//                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
//                    DefaultTableModel model = (DefaultTableModel) table.getModel();
//                    int selectedRowIndex = table.getSelectedRow();
//                    selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);
//
//                    ///Mã sản phẩm, tên sản phẩm, Hãng, Ngày nhập, Số lượng, Đơn giá/1sp, Trạng thái.
//                    GioHang gh = new GioHang();
//                    gh.setmSP(model.getValueAt(selectedRowIndex, 1).toString().trim());
//                    gh.settSP(model.getValueAt(selectedRowIndex, 2).toString());
//                    gh.setDonGiaSP(model.getValueAt(selectedRowIndex, 3).toString());
//                    gh.setSlSP(Integer.valueOf(model.getValueAt(selectedRowIndex, 4).toString()));
//
//                    setIndex(selectedRowIndex);
//                }
            }
        });
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
