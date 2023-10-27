import java.time.LocalDateTime;

public class TimeOfDay {
    public String getTimeOfDays(int hour) {
        if (hour < 6) {
            return "Night";
        }
        if (hour < 12) {
            return "Morning";
        }
        if (hour < 18) {
            return "Afternoon";
        }
        return "Evening";
    }
}
