package test_db.JPanelModel.statistic;

public class ProductStats {

    public final String name;
    public final int quantity;
    public final float priceOfOne;
    public final float totalRevenues;

    public ProductStats(String name, int quantity, float priceOfOne, float totalRevenues) {
        this.name = name;
        this.quantity = quantity;
        this.priceOfOne = priceOfOne;
        this.totalRevenues = totalRevenues;
    }

    public ProductStats plusWith(ProductStats productStats) {
        return new ProductStats(
                productStats.name,
                quantity + productStats.quantity,
                productStats.priceOfOne,
                this.totalRevenues + productStats.totalRevenues
        );
    }

    @Override
    public String toString() {
        return name + "/" + quantity + "/" + priceOfOne + "/" + totalRevenues;
    }
}
