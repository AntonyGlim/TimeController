package glim.antony.timecontroller.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static glim.antony.timecontroller.utils.constants.TimeValues.*;

@Getter @Setter
public class TimeUnit {
    private LocalDateTime dateTime;
    private int year;
    private int month;
    private int lastMonthOfYear = MONTH_OF_YEAR_NUMBER;
    private int week;
    private int lastWeekOfYear = WEEK_OF_YEAR_NUMBER;
    private int dayOfMonth;
    private int lastDayOfMonth;
    private int dayOfWeek;
    private int lastDayOfWeek = DAYS_OF_WEEK_NUMBER;
    private int dayOfYear;
    private int lastDayOfYear;

    public TimeUnit(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        this.year = this.dateTime.getYear();
        this.month = this.dateTime.getMonth().getValue();
        this.week = this.dateTime.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
        this.dayOfMonth = this.dateTime.getDayOfMonth();
        this.lastDayOfMonth = this.dateTime.toLocalDate().lengthOfMonth();
        this.dayOfWeek =  this.dateTime.getDayOfWeek().getValue();
        this.dayOfYear =  this.dateTime.getDayOfYear();
        this.lastDayOfYear = this.dateTime.toLocalDate().lengthOfYear();
    }
    //Год 2020 | Месяц 5/12 | Неделя 19/52 | День месяца 4/31 | День недели 1/7 | День года 125/366 | Время 12:44
}
