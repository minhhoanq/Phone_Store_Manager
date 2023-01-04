/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DAO.HoaDonDAO;
import DAO.IHoaDon;
import java.util.List;
import model.HoaDon;

/**
 *
 * @author Minh Hoanfg
 */
public class HoaDonService implements IHoaDonService{
    IHoaDon hoadonDAO = null;

    public HoaDonService() {
        hoadonDAO = new HoaDonDAO();
    }

    @Override
    public List<HoaDon> getListHD() {
        return hoadonDAO.getListHD();
    }
    
}
