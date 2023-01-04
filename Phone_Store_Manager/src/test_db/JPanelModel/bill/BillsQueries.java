package test_db.JPanelModel.bill;

import trido_main.Const;
import trido_main.SqlServerConnectorHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillsQueries extends SqlServerConnectorHolder {

    public List<BillDto> getAllBills() throws Exception {
        String query = "SELECT * FROM [dbo].[" + Const.TABLE_HOADON + "]";
        Connection connection = connector.init();
        ResultSet rs = connection.createStatement().executeQuery(query);

        ArrayList<BillDto> billDtos = new ArrayList<>();

        while (rs.next()) {
            billDtos.add(new BillDto(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getByte(3),
                    rs.getDate(4),
                    rs.getFloat(5),
                    rs.getFloat(6),
                    rs.getInt(7),
                    rs.getInt(8),
                    rs.getInt(9),
                    rs.getString(10)
            ));
        }
        connection.close();

        return billDtos;
    }

    public void addBill(BillDto billDto) throws Exception {

        Connection con = connector.init();

        PreparedStatement preparedStatement = con.prepareStatement(
                "INSERT INTO [dbo].[" + Const.TABLE_HOADON + "] VALUES(?,?,?,?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1, billDto.getClientId());
        preparedStatement.setInt(2, billDto.getEmployeeId());
        preparedStatement.setDate(3, billDto.getDateTime());
        preparedStatement.setFloat(4, billDto.getTotal());
        preparedStatement.setFloat(5, billDto.getPay());
        preparedStatement.setInt(6, billDto.getId_hinhThucGiaoHang());
        preparedStatement.setInt(7, billDto.getId_hinhThucThanhToan());
        preparedStatement.setInt(8, billDto.getId_trangThaiThanhToan());
        preparedStatement.setString(9, billDto.getGhiChu());

        preparedStatement.execute();

        con.close();

    }

}
