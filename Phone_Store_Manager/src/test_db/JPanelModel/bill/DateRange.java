package test_db.JPanelModel.bill;

public class DateRange {
    private Integer month;
    private Integer year;

    public DateRange(Integer month, Integer year) {
        this.month = month;
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        if (month <= 0 || month > 12) {
            throw new RuntimeException("month > 0 && month <= 12");
        }
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
