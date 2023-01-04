package test_db.JPanelModel.statistic;



import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import test_db.JPanelModel.bill.BillDto;
import test_db.JPanelModel.bill.BillsManager;
import test_db.JPanelModel.bill.TrangThaiThanhToan;
import test_db.JPanelModel.cthd.ChiTietHoaDonDto;
import test_db.JPanelModel.cthd.CthdManager;
import test_db.JPanelModel.product.ProductDto;
import test_db.JPanelModel.product.ProductManager;

public class StatisticManager {

    public static final Map<Integer, ProductStats> productStatsMap = new HashMap<>();
    private static List<ChiTietHoaDonDto> cthds = new ArrayList<>();

    private static float revenues = 0;
    private static int billCount = 0;
    private static int cancelBillCount = 0;
    private static int totalClientCount = 0;

    public static float getRevenues() {
        return revenues;
    }

    public static int getBillCount() {
        return billCount;
    }

    public static int getCancelBillCount() {
        return cancelBillCount;
    }

    public static int getTotalClientCount() {
        return totalClientCount;
    }

    public static void refresh() {
        CthdManager.refresh();
    }


    // -----------------------------------------------------------------------------------------------------------------

    // tong doanh thu, so hoa don, so hang huy, tong ket
    public static void filterBy(Integer month, Integer year) throws Exception {
        refresh();
        cthds = CthdManager.getAllCthds();
        ProductManager.refresh();

        List<BillDto> billDtos = BillsManager.getAllBills();

        if (month != null && year == null) {
            billDtos = billDtos.stream().filter(it -> {
                LocalDate localDate = it.getDateTime().toLocalDate();
                return localDate.getMonthValue() >= month;
            }).collect(Collectors.toList());
        } else if (year != null && month == null) {
            billDtos = billDtos.stream().filter(it -> {
                LocalDate localDate = it.getDateTime().toLocalDate();
                return localDate.getYear() >= year;
            }).collect(Collectors.toList());
        } else if (month != null && year != null) {
            billDtos = billDtos.stream().filter(it -> {
                LocalDate localDate = it.getDateTime().toLocalDate();
                return localDate.getYear() >= year && localDate.getMonthValue() >= month;
            }).collect(Collectors.toList());
        }

        Set<Integer> clientIds = new HashSet<>();
        int hangHuys = 0;

        for (BillDto billDto : billDtos) {
            if (billDto.getId_trangThaiThanhToan() == TrangThaiThanhToan.Huy) {
                hangHuys++;
            }
            clientIds.add(billDto.getClientId());

            for (ChiTietHoaDonDto cthd : CthdManager.filterCthdByBillId(billDto.getId())) {

                ProductDto productDto = ProductManager.findProductById(cthd.getMaDienThoai());

                if (productDto == null) {
                    System.out.println("product null: " + cthd.getMaDienThoai());
                    continue;
                }

                ProductStats productStats = productStatsMap.get(cthd.getMaDienThoai());

                ProductStats newProductStats = new ProductStats(productDto.getTen(), cthd.getSoLuong(), productDto.getGia(), cthd.getTongGia());

                if (productStats == null) {
                    productStatsMap.put(cthd.getMaDienThoai(), newProductStats);
                } else {
                    productStatsMap.put(cthd.getMaDienThoai(), productStats.plusWith(newProductStats));
                }
            }

        }

        // update values
        revenues = getTongDoanhThu(month, year);
        billCount = billDtos.size();
        cancelBillCount = hangHuys;
        totalClientCount = clientIds.size();

    }

    public static Map<Integer, ProductStats> filterByName(String name){
        return productStatsMap.entrySet().stream().filter(it ->{
            return it.getValue().name.toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT));
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static float getTongDoanhThu(Integer month, Integer year) {
        try {
            float doanhThu = 0f;
            List<ChiTietHoaDonDto> cthds = CthdManager.getAllCthds();

            BillsManager.refresh();

            cthds = cthds.stream().filter(it -> {
                BillDto billDto = BillsManager.findBillById(it.getMaHoaDon());
                if (billDto == null) {
                    return false;
                }
                LocalDate localDate = billDto.getDateTime().toLocalDate();

                if (month != null && year == null) {
                    return localDate.getMonthValue() >= month;
                } else if (year != null && month == null) {
                    return localDate.getYear() >= year;
                } else if (month != null && year != null) {
                    return localDate.getMonthValue() >= month && localDate.getYear() >= year;
                }

                return true;

            }).collect(Collectors.toList());


            for (final ChiTietHoaDonDto cthd : cthds) {
                doanhThu += cthd.getTongGia();
            }

            return doanhThu;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // so hoa don, hoa don bi huy, tong khach hang
    public static List<Integer> soHoaDon() {
        Set<Integer> intSet = new HashSet<>();
        int soHoaDon = 0;
        int soHoaDonHuy = 0;
        List<BillDto> billDtos = BillsManager.getAllBills();
        for (final BillDto billDto : billDtos) {
            soHoaDon++;
            if (billDto.getId_trangThaiThanhToan() == TrangThaiThanhToan.Huy) {
                soHoaDonHuy++;
            }
            intSet.add(billDto.getClientId());
        }
        return List.of(soHoaDon, soHoaDonHuy, intSet.size());
    }
}
