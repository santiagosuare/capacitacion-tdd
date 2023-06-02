package org.example;

public class MarsRover {
    private final Position position;

    public MarsRover(Position position) {
        this.position = position;
    }

    public void move(Command[] commands) {
        for (Command command : commands) {
            turn(command);
        }
    }

    private void turn(Command command) {
        switch (command) {
            case LEFT:
                turnLeft();
                break;
            case RIGHT:
                turnRight();
                break;
            case FORWARD:
                moveForward();
                break;
            case BACKWARD:
                moveBackward();
                break;
            default:
                throw new IllegalArgumentException("Invalid command");
        }
    }

    private void turnRight() {
        switch (position.getDirection()) {
            case NORTH:
                position.setDirection(Direction.EAST);
                break;
            case EAST:
                position.setDirection(Direction.SOUTH);
                break;
            case SOUTH:
                position.setDirection(Direction.WEST);
                break;
            case WEST:
                position.setDirection(Direction.NORTH);
                break;
        }
    }

    private void turnLeft() {
        switch (position.getDirection()) {
            case NORTH:
                position.setDirection(Direction.WEST);
                break;
            case EAST:
                position.setDirection(Direction.NORTH);
                break;
            case SOUTH:
                position.setDirection(Direction.EAST);
                break;
            case WEST:
                position.setDirection(Direction.SOUTH);
                break;
        }
    }

    private void moveForward() {
        switch (position.getDirection()) {
            case NORTH:
                position.setY(position.getY() + 1);
                break;
            case EAST:
                position.setX(position.getX() + 1);
                break;
            case SOUTH:
                position.setY(position.getY() - 1);
                break;
            case WEST:
                position.setX(position.getX() - 1);
                break;
        }
    }

    private void moveBackward() {
        switch (position.getDirection()) {
            case NORTH:
                position.setY(position.getY() - 1);
                break;
            case EAST:
                position.setX(position.getX() - 1);
                break;
            case SOUTH:
                position.setY(position.getY() + 1);
                break;
            case WEST:
                position.setX(position.getX() + 1);
                break;
        }
    }

    public boolean comparePosition(Position otherPosition) {
        return position.getX() == otherPosition.getX() &&
                position.getY() == otherPosition.getY() &&
                position.getDirection() == otherPosition.getDirection();
    }
}


