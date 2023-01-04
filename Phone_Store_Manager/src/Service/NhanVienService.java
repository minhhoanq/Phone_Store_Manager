/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DAO.INhanVien;
import DAO.NhanVienDAO;
import java.util.List;
import model.NhanVien;

/**
 *
 * @author Minh Hoanfg
 */
public class NhanVienService implements INhanVienService{

    INhanVien inhanvien = null;

    public NhanVienService() {
        inhanvien = new NhanVienDAO();
    }
    
    @Override
    public List<NhanVien> getListNVService() {
        return inhanvien.getListNV();
    }
    
}
