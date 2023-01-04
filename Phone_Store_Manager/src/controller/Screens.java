/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.DanhMuc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import test_db.JPanelModel.GioHangJPanel;
import test_db.JPanelModel.HoaDonJPanel;
import test_db.JPanelModel.KhachHangJPanel;
import test_db.JPanelModel.NhanVienJPanel;
import test_db.JPanelModel.SanPhamJPanel;
import test_db.JPanelModel.ThongKeJPanel;
import test_db.JPanelModel.TroGiupJPanel;

/**
 *
 * @author Minh Hoanfg
 */
public class Screens {

    private final JPanel root;
    private String kindSelected = "";

    List<DanhMuc> listDanhMuc = null;

    public Screens(JPanel root) {
        this.root = root;
    }

    public void setView(JPanel jpnJpanel, JLabel jlblJLabel) {
        //kindSelected = "KhachHang";

        jpnJpanel.setBackground(new Color(96, 100, 191));
        jlblJLabel.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new GioHangJPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMuc> list) {
        this.listDanhMuc = list;

        for (DanhMuc dm : listDanhMuc) {
            dm.getJpn().addMouseListener(new LabelEvent(dm.getKindString(), dm.getJlb(), dm.getJpn()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private final String kind;
        private final JLabel jlblItem;
        private final JPanel jpnItem;

        public LabelEvent(String kind, JLabel jlblItem, JPanel jpnItem) {
            this.kind = kind;
            this.jlblItem = jlblItem;
            this.jpnItem = jpnItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
//            int choice = JOptionPane.showConfirmDialog(e.getComponent(), "Bạn chưa hoàn tất hóa đơn. Bạn có muốn rời mà không hoàn tất không?", "Rời khỏi trang ?",
//                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//            if (choice == 0) {
                node = switch (kind) {
                    case "KhachHang" ->
                        new KhachHangJPanel();
                    case "GioHang" ->
                        new GioHangJPanel();
                    case "HoaDon" ->
                        new HoaDonJPanel();
                    case "ThongKe" ->
                        new ThongKeJPanel();
                    case "TroGiup" ->
                        new TroGiupJPanel();
                    case "NhanVien" ->
                        new NhanVienJPanel();
                    case "SanPham" ->
                        new SanPhamJPanel();
                    default ->
                        new GioHangJPanel();
                };
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(node);
                root.validate();
                root.repaint();
                setChangeBackground(kind);
//            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlblItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlblItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(255, 204, 51));
                jlblItem.setBackground(new Color(255, 204, 51));
            }
        }

        private void setChangeBackground(String kind) {
            for (DanhMuc dm : listDanhMuc) {
                if (dm.getKindString().equalsIgnoreCase(kind)) {
                    dm.getJpn().setBackground(new Color(96, 100, 191));
                    dm.getJlb().setBackground(new Color(96, 100, 191));
                } else {
                    dm.getJpn().setBackground(new Color(255, 204, 51));
                    dm.getJlb().setBackground(new Color(255, 204, 51));
                }
            }
        }
    }

}
