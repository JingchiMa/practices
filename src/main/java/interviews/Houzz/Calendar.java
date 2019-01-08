package interviews.Houzz;

public class Calendar {

    private static final int[] normal = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] leap = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int year;
    private int month;
    private int day;

    public Calendar(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String addDays(int daysToAdd) {
        year += (daysToAdd / (365 * 3 + 366)) * 4;
        daysToAdd %= (365 * 3 + 366);
        while (daysToAdd > 0) {
            daysToAdd = helper(daysToAdd);
        }
        return date();
    }

    private int helper(int daysToAdd) {
        int[] table = getTable();
        while (month <= 12 && day < 31 && daysToAdd > 0) {
            if (day + daysToAdd <= table[month]) {
                day += daysToAdd;
                daysToAdd = 0;
            } else {
                daysToAdd -= (table[month] - day);
                month++;
                day = 0;
            }
        }
        if (daysToAdd > 0) {
            year++;
            month = 1;
            day = 0;
        }
        return daysToAdd;
    }

    private int[] getTable() {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return leap;
        } else {
            return normal;
        }
    }

    public String date() {
        return year + "/" + month + "/" + day;
    }
}
