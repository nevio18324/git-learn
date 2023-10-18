import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeOfDayTest {
    public TimeOfDay timeOfDay = new TimeOfDay();
    @Test


    void getTimeOfDay() {
        assertEquals("Afternoon", timeOfDay.getTimeOfDays(LocalDateTime.now()));
    }
}