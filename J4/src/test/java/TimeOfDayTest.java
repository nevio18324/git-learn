import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

class TimeOfDayTest {
    public TimeOfDay timeOfDay = new TimeOfDay();
    @Test


    void getTimeOfDay() {
        assertEquals("Afternoon", timeOfDay.getTimeOfDays(LocalDateTime.now()));
    }
}