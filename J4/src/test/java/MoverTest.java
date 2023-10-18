import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MoverTest {
    @Test
    void move() {
        Mover mover = new Mover();
        mover.move(mover.getDirection());
        assertEquals(mover.getDirection(), mover.getLastDirection());
        assertEquals(mover.getLastMovingTime().getSecond(), LocalDateTime.now().getSecond());
    }
}