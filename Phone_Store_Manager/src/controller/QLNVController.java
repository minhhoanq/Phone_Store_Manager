/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Service.INhanVienService;
import Service.NhanVienService;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import model.NhanVien;
import test_db.JFrameModel.NhanVienJFrame;
import ubility.ClassTableNV;

/**
 *
 * @author Minh Hoanfg
 */
public class QLNVController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private JComboBox jcbfindbysex;

    private INhanVienService iNhanVienService = null;

    private String[] listColumn = {"STT", "Mã nhân viên", "Họ và tên", "Tuổi", "Số điện thoại", "Địa chỉ", "Email", "Giới tính"};

    private TableRowSorter<TableModel> rowSorter = null;

    public QLNVController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch, JComboBox jcbfindbysex) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.jcbfindbysex = jcbfindbysex;

        this.iNhanVienService = new NhanVienService();
    }

    public void setDataModel() {
        List<NhanVien> listItem = iNhanVienService.getListNVService();

        DefaultTableModel model = new ClassTableNV().setTableNhanVien(listItem, listColumn);

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

        jcbfindbysex.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String c = (String) jcbfindbysex.getSelectedItem();
                if (c.equals("Nam")) {
                    rowSorter.setRowFilter(RowFilter.regexFilter("Nam"));
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("Nữ"));
                }
            }

        });

        String c = (String) jcbfindbysex.getSelectedItem();
        if (c.equals("Nam")) {
            rowSorter.setRowFilter(RowFilter.regexFilter("Nam"));
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("Nữ"));
        }

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

                    // "STT", "Mã nhân viên", "Họ và tên", "Tuổi", "Số điện thoại", "Địa chỉ", "Email", "Giới tính"
                    NhanVien nv = new NhanVien();
                    try {
                        nv.setMaNV((int) model.getValueAt(selectedRowIndex, 1));
                        nv.setTenNV((String) model.getValueAt(selectedRowIndex, 2));
                        nv.setAgeNV((int) model.getValueAt(selectedRowIndex, 3));
                        nv.setSdtNV(model.getValueAt(selectedRowIndex, 4).toString());
                        nv.setDiaChiNV(model.getValueAt(selectedRowIndex, 5).toString());
                        nv.setEmailNV(model.getValueAt(selectedRowIndex, 6).toString());
                        nv.setGioiTinhNV((boolean) model.getValueAt(selectedRowIndex, 7));
                    } catch (Exception ex) {
                        Logger.getLogger(QLNVController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    NhanVienJFrame nhanVienJFrame = new NhanVienJFrame(nv);
                    nhanVienJFrame.setTitle("Thông tin nhân viên");
                    nhanVienJFrame.setResizable(false);
                    nhanVienJFrame.setLocationRelativeTo(null);
                    nhanVienJFrame.setVisible(true);
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

    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NhanVienJFrame frame = new NhanVienJFrame(new NhanVien());
                frame.setTitle("Thêm thông tin nhân viên");
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
