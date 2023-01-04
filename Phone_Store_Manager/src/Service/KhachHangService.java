/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DAO.IKhachHang;
import DAO.KhachHangDAO;
import java.util.List;
import model.KhachHang;

/**
 *
 * @author Minh Hoanfg
 */
public class KhachHangService implements IKhachHangService{

    private IKhachHang khachHangDao = null;
    
    public KhachHangService(){
        khachHangDao = new KhachHangDAO();
    }
    
    @Override
    public List<KhachHang> getList() {
        return khachHangDao.getListKH();
    }
    
}
