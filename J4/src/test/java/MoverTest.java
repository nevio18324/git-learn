import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MoverTest {
    @Test
    void changeDirection_move_ChangeDirection() {
        Mover mover = new Mover();
        mover.move(Mover.Direction.NORTH);
        assertEquals(Mover.Direction.NORTH, mover.getLastDirection());
    }
    @Test
    void changeDirection_move_NotChangedDirection(){
        Mover mover = new Mover();
        mover.move(Mover.Direction.NORTH);
        Mover.Direction secondLastDirection = mover.getLastDirection();
        mover.move(Mover.Direction.NORTH);
        assertEquals(secondLastDirection, mover.getLastDirection());
    }
}