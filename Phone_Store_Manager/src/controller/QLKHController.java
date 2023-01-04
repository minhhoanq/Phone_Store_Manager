/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Service.IKhachHangService;
import Service.KhachHangService;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.KhachHang;
import test_db.JFrameModel.KhachHangJFrame;
import ubility.ClassTableModel;

/**
 *
 * @author Minh Hoanfg
 */
public class QLKHController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private int index = -1;

    private IKhachHangService ikhachHangService = null;

    private String[] listColumn = { "STT", "Mã khách hàng", "Họ và tên", "Số điện thoại", "Địa chỉ", "Ghi chú"};

    private TableRowSorter<TableModel> rowSorter = null;

    public QLKHController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;

        this.ikhachHangService = new KhachHangService();
    }

    public QLKHController() {
    }

    public void setDataModel() {
        List<KhachHang> listItem = ikhachHangService.getList();

        DefaultTableModel model = new ClassTableModel().setTableKhacHang(listItem, listColumn);

        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        //724, 500
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);
                    
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(model.getValueAt(selectedRowIndex, 1).toString().trim());
                    kh.setHoTen(model.getValueAt(selectedRowIndex, 2).toString());
                    kh.setSDT(model.getValueAt(selectedRowIndex, 3).toString());
                    kh.setAddress(model.getValueAt(selectedRowIndex, 4).toString());
                    kh.setGhichu(model.getValueAt(selectedRowIndex, 5).toString());
                    
                    KhachHangJFrame khachHangJFrame = new KhachHangJFrame(kh);
                    khachHangJFrame.setTitle("Thông tin khách hàng");
                    khachHangJFrame.setResizable(false);
                    khachHangJFrame.setLocationRelativeTo(null);
                    khachHangJFrame.setVisible(true);
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300, 400));

        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }
    
    public void setDataModelKHChoose() {
        List<KhachHang> listItem = ikhachHangService.getList();

        DefaultTableModel model = new ClassTableModel().setTableKhacHang(listItem, listColumn);

        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        //724, 500
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1 && table.getSelectedRow() != -1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);
                    
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(model.getValueAt(selectedRowIndex, 1).toString().trim());
                    kh.setHoTen(model.getValueAt(selectedRowIndex, 2).toString());
                    kh.setSDT(model.getValueAt(selectedRowIndex, 3).toString());
                    kh.setAddress(model.getValueAt(selectedRowIndex, 4).toString());
                    kh.setGhichu(model.getValueAt(selectedRowIndex, 5).toString());
                    
                    setIndex(selectedRowIndex);
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(300, 250));

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

    public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
               KhachHangJFrame frame = new KhachHangJFrame(new KhachHang());
               frame.setTitle("Thêm thông tin khách hàng");
               frame.setLocationRelativeTo(null);
               frame.setResizable(false);
               frame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
    }
}
