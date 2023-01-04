package test_db.JPanelModel.bill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BillsManager {

    private static final List<BillDto> STORED_BILL_DTOS = new ArrayList<>();

    private static final BillsQueries billsQueries = new BillsQueries();

    public static List<BillDto> getAllBills() {
        refresh();
        return STORED_BILL_DTOS;
    }

    public static BillDto findBillById(int id) {
        for (BillDto billDto : STORED_BILL_DTOS) {
            if (billDto.getId() == id) {
                return billDto;
            }
        }
        return null;
    }

    public static void refresh() {
        try {
            List<BillDto> billDtos = billsQueries.getAllBills();
            STORED_BILL_DTOS.clear();
            STORED_BILL_DTOS.addAll(billDtos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void addBill(BillDto billDto) {
        try {
            billsQueries.addBill(billDto);
            refresh();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<BillDto> filterByTrangThaiThanhToan(int trangThaiThanhToan) {
        return STORED_BILL_DTOS.stream().filter(item -> item.getId_trangThaiThanhToan() == trangThaiThanhToan).collect(Collectors.toList());
    }

    public static List<BillDto> filterByHinhThucGiaoHang(int hinhThucGiaoHang) {
        return STORED_BILL_DTOS.stream().filter(item -> item.getId_hinhThucGiaoHang() == hinhThucGiaoHang).collect(Collectors.toList());
    }

    public static List<BillDto> filterByHinhThucThanhToan(int hinhThucThanhToan) {
        return STORED_BILL_DTOS.stream().filter(item -> item.getId_hinhThucThanhToan() == hinhThucThanhToan).collect(Collectors.toList());
    }

    public static List<BillDto> findByMaHoaDon(int maHoaDon) {
        return STORED_BILL_DTOS.stream().filter(item -> item.getId() == maHoaDon).collect(Collectors.toList());
    }

    public static List<BillDto> filterByMoneyRange(int moneyRange) {
        switch (moneyRange) {
            case MoneyRange.From_0_to_500k:
                return STORED_BILL_DTOS.stream().filter(item -> item.getTotal() > 0 && item.getTotal() <= 500_000f).collect(Collectors.toList());
            case MoneyRange.From_500k_to_1m:
                return STORED_BILL_DTOS.stream().filter(item -> item.getTotal() > 500_000f && item.getTotal() <= 1_000_000f).collect(Collectors.toList());
            case MoneyRange.From_1m_to_5m:
                return STORED_BILL_DTOS.stream().filter(item -> item.getTotal() > 1_000_000f && item.getTotal() <= 5_000_000f).collect(Collectors.toList());
            case MoneyRange.From_5m_to_10m:
                return STORED_BILL_DTOS.stream().filter(item -> item.getTotal() > 5_000_000f && item.getTotal() <= 10_000_000f).collect(Collectors.toList());
            case MoneyRange.From_10m_to_X:
                return STORED_BILL_DTOS.stream().filter(item -> item.getTotal() > 10_000_000f).collect(Collectors.toList());
//            case MoneyRange.From_10m_to_20m:
//                return STORED_BILL_DTOS.stream().filter(item -> item.getTotal() > 10_000_000f && item.getTotal() <= 20_000_000f).collect(Collectors.toList());
//            case MoneyRange.From_20m_to_50m:
//                return STORED_BILL_DTOS.stream().filter(item -> item.getTotal() > 20_000_000f && item.getTotal() <= 50_000_000f).collect(Collectors.toList());
//            case MoneyRange.From_50m_to_100m:
//                return STORED_BILL_DTOS.stream().filter(item -> item.getTotal() > 50_000_000f && item.getTotal() <= 100_000_000f).collect(Collectors.toList());
            default:
                throw new RuntimeException("money not in range");
        }
    }

    public static List<BillDto> filterByDateRange(DateRange dateRange) {
        List<BillDto> rs = STORED_BILL_DTOS;
        if (dateRange.getMonth() != null && dateRange.getYear() != null) {
            rs = STORED_BILL_DTOS.stream().filter(item -> {
                LocalDate localDate = item.getDateTime().toLocalDate();
                return localDate.getMonthValue() == dateRange.getMonth() && localDate.getYear() == dateRange.getYear();
            }).collect(Collectors.toList());
        } else if (dateRange.getMonth() != null && dateRange.getYear() == null) {
            rs = STORED_BILL_DTOS.stream().filter(item -> {
                LocalDate localDate = item.getDateTime().toLocalDate();
                return localDate.getMonthValue() == dateRange.getMonth();
            }).collect(Collectors.toList());
        } else if (dateRange.getMonth() == null && dateRange.getYear() != null) {
            rs = STORED_BILL_DTOS.stream().filter(item -> {
                LocalDate localDate = item.getDateTime().toLocalDate();
                return localDate.getYear() == dateRange.getYear();
            }).collect(Collectors.toList());
        }
        return rs;
    }

}
