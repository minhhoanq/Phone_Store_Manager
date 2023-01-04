/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Emplyee_Manager;

import DAO.INhanVien;
import DAO.NhanVienDAO;
import model.NhanVien;

/**
 *
 * @author Minh Hoanfg
 */
public class NhanVienManager {

    static private final INhanVien auth = new NhanVienDAO();

    public static boolean register(NhanVien nhanvien) throws Exception {
        return auth.register(nhanvien);
    }

    public static NhanVien logIn(String email, String password) throws Exception {

        NhanVienLoginInfor info = new NhanVienLoginInfor(email, password);

        NhanVien dao = auth.logIn(info);

        if (dao != null) {
            System.out.println("login success");
            System.out.println("name is: " + dao.getTenNV());
            return dao;
        } else {
            System.out.println("login failed");
            return null;
        }
    }
    
    // 

//    static private final Auth auth = new SqlServerAuth();
//
//    public static boolean register(EmployeeDto nvdao) throws Exception {
//        return auth.register(nvdao);
//    }
//
//    public static EmployeeDto logIn(String email, String password) throws Exception {
//
//        EmployeeLogInInfo info = new EmployeeLogInInfo(email, password);
//
//        EmployeeDto dao = auth.logIn(info);
//
//        if (dao != null) {
//            System.out.println("login success");
//            System.out.println("name is: " + dao.getName());
//            return dao;
//        } else {
//            System.out.println("login failed");
//            return null;
//        }
//    }

}
