/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Global_variable;

/**
 *
 * @author Minh Hoanfg
 */
public class DateRange {
    private Integer month = null;
    private Integer year = null;

    public DateRange(Integer month, Integer year) {
        this.month = month;
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        if (month <= 0 || month > 12) {
            throw new RuntimeException("month <=0 || month > 12");
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
