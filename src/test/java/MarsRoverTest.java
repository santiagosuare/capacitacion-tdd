import org.example.Command;
import org.example.Direction;
import org.example.MarsRover;
import org.example.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {
    private final Position INIT_POSITION = new Position(0, 0, Direction.NORTH);

    @Test
    void createNewMars() {
        MarsRover marsRover = new MarsRover(INIT_POSITION);
        assertNotNull(marsRover);
    }

    @Test
    void comparePosition() {
        MarsRover marsRover = new MarsRover(INIT_POSITION);
        boolean equalPositions = marsRover.comparePosition(INIT_POSITION);
        assertTrue(equalPositions);
    }

    @Test
    void turnLeft() {
        MarsRover marsRover = new MarsRover(INIT_POSITION);
        marsRover.move(new Command[]{Command.LEFT});
        Position newPosition = new Position(0, 0, Direction.WEST);
        boolean equalPositions = marsRover.comparePosition(newPosition);
        assertTrue(equalPositions);
    }

    @Test
    void turnRight() {
        MarsRover marsRover = new MarsRover(INIT_POSITION);
        marsRover.move(new Command[]{Command.RIGHT});
        Position newPosition = new Position(0, 0, Direction.EAST);
        boolean equalPositions = marsRover.comparePosition(newPosition);
        assertTrue(equalPositions);
    }

    @Test
    void moveForward() {
        MarsRover marsRover = new MarsRover(INIT_POSITION);
        marsRover.move(new Command[]{Command.FORWARD});
        Position newPosition = new Position(0, 1, Direction.NORTH);
        boolean equalPositions = marsRover.comparePosition(newPosition);
        assertTrue(equalPositions);
    }

    @Test
    void moveBackward() {
        MarsRover marsRover = new MarsRover(INIT_POSITION);
        marsRover.move(new Command[]{Command.BACKWARD});
        Position newPosition = new Position(0, -1, Direction.NORTH);
        boolean equalPositions = marsRover.comparePosition(newPosition);
        assertTrue(equalPositions);
    }

    @Test
    void script_FB() {
        Position initPosition = new Position(1, 1, Direction.NORTH);
        MarsRover marsRover = new MarsRover(initPosition);
        marsRover.move(new Command[]{Command.FORWARD, Command.BACKWARD});
        Position expectedPosition = new Position(1, 1, Direction.NORTH);
        boolean equalPositions = marsRover.comparePosition(expectedPosition);
        assertTrue(equalPositions);
    }

    @Test
    void script_LFR() {
        Position initPosition = new Position(1, 1, Direction.NORTH);
        MarsRover marsRover = new MarsRover(initPosition);
        Command[] commands = {Command.LEFT, Command.FORWARD, Command.RIGHT};
        marsRover.move(commands);
        Position expectedPosition = new Position(0, 1, Direction.NORTH);
        boolean equalPositions = marsRover.comparePosition(expectedPosition);
        assertTrue(equalPositions);
    }

    @Test
    void script_FFRFFLFRFF() {
        Position initPosition = new Position(1, 1, Direction.NORTH);
        MarsRover marsRover = new MarsRover(initPosition);
        Command[] commands = {
                Command.FORWARD, Command.FORWARD, Command.RIGHT, Command.FORWARD,
                Command.FORWARD, Command.LEFT, Command.FORWARD, Command.RIGHT,
                Command.FORWARD, Command.FORWARD
        };
        marsRover.move(commands);
        Position expectedPosition = new Position(5, 4, Direction.EAST);
        boolean equalPositions = marsRover.comparePosition(expectedPosition);
        assertTrue(equalPositions);
    }

    @Test
    void script_FBBLRR() {
        Position initPosition = new Position(1, 1, Direction.NORTH);
        MarsRover marsRover = new MarsRover(initPosition);
        Command[] commands = {
                Command.FORWARD, Command.BACKWARD, Command.BACKWARD, Command.LEFT,
                Command.RIGHT, Command.RIGHT
        };
        marsRover.move(commands);
        Position expectedPosition = new Position(1, 0, Direction.EAST);
        boolean equalPositions = marsRover.comparePosition(expectedPosition);
        assertTrue(equalPositions);
    }
}

