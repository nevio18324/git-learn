import java.time.LocalDateTime;

public class TimeOfDay {
    public String getTimeOfDays(LocalDateTime time) {
        if (time.getHour()+2 < 6) {
            return "Night";
        }
        if (time.getHour()+2 < 12) {
            return "Morning";
        }
        if (time.getHour()+2 < 18) {
            return "Afternoon";
        }
        return "Evening";
    }
}
