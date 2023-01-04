package test_db.JPanelModel.cthd;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trido_main.Const;
import trido_main.SqlServerConnectorHolder;

public class CthdQueries extends SqlServerConnectorHolder {

    public static int index = 0;

    public List<ChiTietHoaDonDto> getAllChiTietHoaDon() throws Exception {

        final List<ChiTietHoaDonDto> chiTietHoaDonDtos = new ArrayList<>();

        String query = "SELECT * FROM [dbo].[" + Const.CTHD.TABLE_NAME + "]";
        Connection connection = connector.init();
        ResultSet rs = connection.createStatement().executeQuery(query);

        while (rs.next()) {
            chiTietHoaDonDtos.add(new ChiTietHoaDonDto(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getFloat(4),
                    rs.getString(5)
            ));
        }
        connection.close();

        return chiTietHoaDonDtos;
    }

    public List<ChiTietHoaDonDto> getCthdByHoaDonId(int id) throws Exception {
        var cthds = getAllChiTietHoaDon();
        final List<ChiTietHoaDonDto> rs = new ArrayList<>();
        for(final var cthd: cthds){
            if(cthd.getMaHoaDon() == id){
                rs.add(cthd);
            }
        }
        return rs;
    }

    public void addChiTietHoaDon(ChiTietHoaDonDto chiTietHoaDonDto) throws Exception {

        Connection con = connector.init();

        PreparedStatement preparedStatement = con.prepareStatement(
                "INSERT INTO [dbo].[" + Const.CTHD.TABLE_NAME + "] VALUES(?,?,?,?,?)"
        );
        preparedStatement.setInt(1, chiTietHoaDonDto.getMaHoaDon());
        preparedStatement.setInt(2, chiTietHoaDonDto.getMaDienThoai());
        preparedStatement.setInt(3, chiTietHoaDonDto.getSoLuong());
        preparedStatement.setFloat(4, chiTietHoaDonDto.getTongGia());
        preparedStatement.setString(5, chiTietHoaDonDto.getGhiChu());

        preparedStatement.execute();

        con.close();

    }

}
