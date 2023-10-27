import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeOfDayTest {
    public TimeOfDay timeOfDay = new TimeOfDay();
    @Test
    void stateOfDay_getTimeOfDays_Night() {
        assertEquals("Night", timeOfDay.getTimeOfDays(1));
    }
    @Test
    void stateOfDay_getTimeOfDays_Morning() {
        assertEquals("Morning", timeOfDay.getTimeOfDays(7));
    }
    @Test
    void stateOfDay_getTimeOfDay_Afternoon() {
        assertEquals("Afternoon", timeOfDay.getTimeOfDays(13));
    }
    @Test
    void stateOfDay_getTimeOfDay_Evening() {
        assertEquals("Evening", timeOfDay.getTimeOfDays(19));
    }
}