package test_db.JPanelModel.product;

import trido_main.Const;
import trido_main.SqlServerConnectorHolder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductQueries extends SqlServerConnectorHolder {

    public List<ProductDto> getAllProducts() throws Exception {
        String query = "SELECT * FROM [dbo].["+ Const.SANPHAM.TABLE_NAME +"]";

        Connection connection = connector.init();
        ResultSet rs = connection.createStatement().executeQuery(query);

        ArrayList<ProductDto> productDtos = new ArrayList<>();

        while (rs.next()) {
            productDtos.add(new ProductDto(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDate(4),
                    rs.getInt(5),
                    rs.getFloat(6),
                    rs.getBoolean(7)
            ));
        }
        connection.close();

        return productDtos;

    }

}
