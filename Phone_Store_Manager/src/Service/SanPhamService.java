/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DAO.ISanPham;
import DAO.SanPhamDAO;
import java.util.List;
import model.SanPham;

/**
 *
 * @author Minh Hoanfg
 */
public class SanPhamService implements ISanPhamService{
    ISanPham iSanPham = null;

    public SanPhamService() {
        iSanPham = new SanPhamDAO();
    }

    @Override
    public List<SanPham> listSPService() {
        return iSanPham.getListSP();
    }
    
}
