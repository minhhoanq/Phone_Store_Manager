package test_db.JPanelModel.product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    private static final List<ProductDto> PRODUCT_DTOS = new ArrayList<>();

    private static final ProductQueries productQueries = new ProductQueries();

    public static void refresh(){
        try {
            PRODUCT_DTOS.clear();
            PRODUCT_DTOS.addAll(productQueries.getAllProducts());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ProductDto findProductById(int id) {

        for (ProductDto productDto : PRODUCT_DTOS) {
            if (productDto.getMaSp() == id) {
                return productDto;
            }
        }

        return null;
    }

    public static List<ProductDto> getAllProducts(){
        refresh();
        return PRODUCT_DTOS;
    }

}
