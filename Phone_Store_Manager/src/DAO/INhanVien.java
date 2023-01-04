/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Emplyee_Manager.NhanVienLoginInfor;
import java.util.List;
import model.NhanVien;

/**
 *
 * @author Minh Hoanfg
 */
public interface INhanVien {

    boolean register(NhanVien employeeDao) throws Exception;

    NhanVien logIn(NhanVienLoginInfor employeeLogInInfo) throws Exception;

    boolean logOut() throws Exception;

    public List<NhanVien> getListNV();
}
