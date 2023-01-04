/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietHoaDon;

/**
 *
 * @author Minh Hoanfg
 */
public class CTHD_Queries {

    public List<ChiTietHoaDon> getAllChiTietHoaDon() throws Exception {

        final List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();

        String query = "SELECT * FROM [dbo].[CHITIETHOADON2]";
        Connection cons = (Connection) dbConnect.getConnection();
        ResultSet rs = cons.createStatement().executeQuery(query);

        while (rs.next()) {
            chiTietHoaDons.add(new ChiTietHoaDon(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getFloat(4),
                    rs.getString(5)
            ));
        }
        cons.close();

        return chiTietHoaDons;
    }

    public void addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws Exception {

        Connection cons = (Connection) dbConnect.getConnection();

        PreparedStatement preparedStatement = cons.prepareStatement(
                "INSERT INTO [dbo].[CHITIETHOADON2] VALUES(?,?,?,?,?)"
        );
        preparedStatement.setInt(1, chiTietHoaDon.getMaHoaDon());
        preparedStatement.setInt(2, chiTietHoaDon.getMaDienThoai());
        preparedStatement.setInt(3, chiTietHoaDon.getSoLuong());
        preparedStatement.setFloat(4, chiTietHoaDon.getTongGia());
        preparedStatement.setString(5, chiTietHoaDon.getGhiChu());

        preparedStatement.execute();

        cons.close();

    }

}
