/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Global_variable.DateRange;
import Global_variable.MoneyRange;
import Service.HoaDonService;
import Service.IHoaDonService;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
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
import model.HoaDon;
import ubility.ClassTableHoaDon;
import java.time.LocalDate;

/**
 *
 * @author Minh Hoanfg
 */
public class QLHDController {

    private JPanel jpnView;
    private JTextField jtfSearch;
    public static HoaDon chooseHD = null;
    
    public int Index = -1;
    private IHoaDonService iHoaDonService = null;

    private String[] listColumn = {"STT", "Mã Hóa Đơn", "Mã khách hàng", "Mã nhân viên", "Ngày tạo", "Tổng tiền", "Thanh toán", "Hình thức giao hàng", "Hình thức thanh toán", "Trạng thái thanh toán", "Ghi Chú"};

    private String[] listColumnHDcho = {"Mã Hóa Đơn", "Mã khách hàng", "Mã nhân viên", "Ngày tạo"};

    private TableRowSorter<TableModel> rowSorter = null;

    public QLHDController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;

        this.iHoaDonService = new HoaDonService();

        setIndex(iHoaDonService.getListHD().size());
    }

    public void setDataModel() {
        List<HoaDon> listItem = iHoaDonService.getListHD();

        DefaultTableModel model = new ClassTableHoaDon().setTableHoaDon(listItem, listColumn);
        
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

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && table.getSelectedRow() != -1) {
                    
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);

                    ///Mã sản phẩm, tên sản phẩm, Hãng, Ngày nhập, Số lượng, Đơn giá/1sp, Trạng thái.
                    HoaDon hd = new HoaDon();
                    hd.setMaHD((int) model.getValueAt(selectedRowIndex, 1));
                    hd.setMaKH((int) model.getValueAt(selectedRowIndex, 2));
                    hd.setMaNV((int) model.getValueAt(selectedRowIndex, 3));
                    hd.setNgayTao((Date) model.getValueAt(selectedRowIndex, 4));
                    hd.setTongTien((float) model.getValueAt(selectedRowIndex, 5));
                    hd.setThanhToan((float) model.getValueAt(selectedRowIndex, 6));
                    hd.setHtGH(ClassTableHoaDon.hd_temp.getHtGH());
                    hd.setHtTT(ClassTableHoaDon.hd_temp.getHtTT());
                    hd.setTtTT(ClassTableHoaDon.hd_temp.getTtTT());
                    hd.setGhiChu((String) model.getValueAt(selectedRowIndex, 10));
                    
                    chooseHD = hd;
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

    //Get and Set for Index
    public int getIndex() {
        return Index;
    }

    public void setIndex(int Index) {
        this.Index = Index;
    }
    
    //--------------------------------------------------------------------------
    
    public void setDataJcombobox(List<HoaDon> list) {
        List<HoaDon> listItem = list;

        DefaultTableModel model = new ClassTableHoaDon().setTableHoaDon(listItem, listColumn);

        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300, 400));

        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }

    //Fuc xử lí JCOMBOBOX
    public List<HoaDon> filterByTrangThaiThanhToan(int trangThaiThanhToan) {
        List<HoaDon> listItem = iHoaDonService.getListHD();
        return listItem.stream().filter(item -> item.getTtTT() == trangThaiThanhToan).collect(Collectors.toList());
    }
    
    public List<HoaDon> filterByHinhThucGiaoHang(int hinhThucGiaoHang) {
        List<HoaDon> listItem = iHoaDonService.getListHD();
        return listItem.stream().filter(item -> item.getHtGH()== hinhThucGiaoHang).collect(Collectors.toList());
    }

    public List<HoaDon> filterByHinhThucThanhToan(int hinhThucThanhToan) {
        List<HoaDon> listItem = iHoaDonService.getListHD();
        return listItem.stream().filter(item -> item.getHtTT() == hinhThucThanhToan).collect(Collectors.toList());
    }
    
    public List<HoaDon> filterByMoneyRange(int moneyRange) {
        List<HoaDon> listItem = iHoaDonService.getListHD();
        switch (moneyRange) {
            case MoneyRange.From_0_to_1000k:
                return listItem.stream().filter(item -> item.getThanhToan() > 0 && item.getThanhToan() <= 1_000_000f).collect(Collectors.toList());
            case MoneyRange.From_1000k_to_3m:
                return listItem.stream().filter(item -> item.getThanhToan() > 1_000_000f && item.getThanhToan() <= 3_000_000f).collect(Collectors.toList());
            case MoneyRange.From_3m_to_10m:
                return listItem.stream().filter(item -> item.getThanhToan() > 3_000_000f && item.getThanhToan() <= 10_000_000f).collect(Collectors.toList());
            case MoneyRange.From_10m:
                return listItem.stream().filter(item -> item.getThanhToan() > 10_000_000f).collect(Collectors.toList());
            default:
                throw new RuntimeException("money not in range");
        }   
    }
    
    public List<HoaDon> filterByDateRange(DateRange dateRange) {
        List<HoaDon> listItem = iHoaDonService.getListHD();
        List<HoaDon> rs = listItem;
        if (dateRange.getMonth() != null && dateRange.getYear() != null) {
            rs = listItem.stream().filter(item -> {
                LocalDate localDate = item.getNgayTao().toLocalDate();
                return localDate.getMonthValue() == dateRange.getMonth() && localDate.getYear() == dateRange.getYear();
            }).collect(Collectors.toList());
        } else if (dateRange.getMonth() != null && dateRange.getYear() == null) {
            rs = listItem.stream().filter(item -> {
                LocalDate localDate = item.getNgayTao().toLocalDate();
                return localDate.getMonthValue() == dateRange.getMonth();
            }).collect(Collectors.toList());
        } else if (dateRange.getMonth() == null && dateRange.getYear() != null) {
            rs = listItem.stream().filter(item -> {
                LocalDate localDate = item.getNgayTao().toLocalDate();
                return localDate.getYear() == dateRange.getYear();
            }).collect(Collectors.toList());
        }
        return rs;
    }
}
