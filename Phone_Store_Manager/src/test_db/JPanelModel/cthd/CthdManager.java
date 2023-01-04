package test_db.JPanelModel.cthd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CthdManager {

    private static final List<ChiTietHoaDonDto> cthdsHolder = new ArrayList<>();

    private static final CthdQueries queries = new CthdQueries();

    public static void refresh() {
        try {
            cthdsHolder.clear();
            cthdsHolder.addAll(queries.getAllChiTietHoaDon());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<ChiTietHoaDonDto> getAllCthds() {
        return cthdsHolder;
    }

    public static List<ChiTietHoaDonDto> filterCthdByBillId(int maHd) {
        List<ChiTietHoaDonDto> cthds = new ArrayList<>();
        for (ChiTietHoaDonDto cthd : cthdsHolder) {
            if (cthd.getMaHoaDon() == maHd) {
                cthds.add(cthd);
            }
        }

        return cthds;
    }

    public static void addChiTietHoaDon(ChiTietHoaDonDto cthd) {
        try {
            queries.addChiTietHoaDon(cthd);
            refresh();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void addChiTietHoaDon(Collection<ChiTietHoaDonDto> inputCthds) {
        try {
            for (final var cthd : inputCthds) {
                queries.addChiTietHoaDon(cthd);
            }
            refresh();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
