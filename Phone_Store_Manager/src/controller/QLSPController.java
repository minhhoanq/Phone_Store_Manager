/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Service.ISanPhamService;
import Service.SanPhamService;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import model.SanPham;
import test_db.JFrameModel.FixSLSPJFrame;
import test_db.JFrameModel.SanPhamJFrame;
import ubility.ClassTableSP;

/**
 *
 * @author Minh Hoanfg
 */
public class QLSPController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private int index = -1;

    private ISanPhamService iSanPhamService = null;
    ///Mã sản phẩm, tên sản phẩm, Hãng, Ngày nhập, Số lượng, Đơn giá/1sp, Trạng thái.
    private String[] listColumn = {"STT", "Mã sản phẩm", "Tên sản phẩm", "Hãng", "Ngày nhập", "Số lượng", "Đơn giá/1 sản phẩm", "Trạng thái"};

    private TableRowSorter<TableModel> rowSorter = null;

    public QLSPController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;

        this.iSanPhamService = new SanPhamService();
    }

    public QLSPController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        this.iSanPhamService = new SanPhamService();
    }

    public void setDataModel() {
        List<SanPham> listItem = iSanPhamService.listSPService();

        DefaultTableModel model = new ClassTableSP().setTableSanPham(listItem, listColumn);

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

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);

                    ///Mã sản phẩm, tên sản phẩm, Hãng, Ngày nhập, Số lượng, Đơn giá/1sp, Trạng thái.
                    SanPham sp = new SanPham();
                    sp.setMaSP(model.getValueAt(selectedRowIndex, 1).toString().trim());
                    sp.setTenSP(model.getValueAt(selectedRowIndex, 2).toString());
                    sp.setHangSP(model.getValueAt(selectedRowIndex, 3).toString());
                    sp.setNgayNhap(model.getValueAt(selectedRowIndex, 4).toString());
                    sp.setSoLuongSP(model.getValueAt(selectedRowIndex, 5).toString());
                    sp.setGiaSP(model.getValueAt(selectedRowIndex, 6).toString());
                    sp.setTrangThaiSP(model.getValueAt(selectedRowIndex, 7).toString());

                    SanPhamJFrame sanPhamJFrame = new SanPhamJFrame(sp);
                    sanPhamJFrame.setTitle("Thông tin sản phẩm");
                    sanPhamJFrame.setResizable(false);
                    sanPhamJFrame.setLocationRelativeTo(null);
                    sanPhamJFrame.setVisible(true);
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

    public void setDataModelGioHang() {
        List<SanPham> listItem = iSanPhamService.listSPService();

        DefaultTableModel model = new ClassTableSP().setTableSanPham(listItem, listColumn);

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

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);

                    ///Mã sản phẩm, tên sản phẩm, Hãng, Ngày nhập, Số lượng, Đơn giá/1sp, Trạng thái.
                    SanPham sp = new SanPham();
                    sp.setMaSP(model.getValueAt(selectedRowIndex, 1).toString().trim());
                    sp.setTenSP(model.getValueAt(selectedRowIndex, 2).toString());
                    sp.setHangSP(model.getValueAt(selectedRowIndex, 3).toString());
                    sp.setNgayNhap(model.getValueAt(selectedRowIndex, 4).toString());
                    sp.setSoLuongSP(model.getValueAt(selectedRowIndex, 5).toString());
                    sp.setGiaSP(model.getValueAt(selectedRowIndex, 6).toString());
                    sp.setTrangThaiSP(model.getValueAt(selectedRowIndex, 7).toString());

                    setIndex(selectedRowIndex);
                }
            }

        });

        //724, 500
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(50, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(200, 300));

        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setIndex(int pos){
        this.index = pos;
    }
    
    public int getIndex(){
        return this.index;
    }
    
    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SanPhamJFrame frame = new SanPhamJFrame(new SanPham());
                frame.setTitle("Thêm thông tin sản phẩm");
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
