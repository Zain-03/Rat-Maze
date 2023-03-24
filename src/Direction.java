public class Direction {
    public static final int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;
    private int direction;


    public Direction(int direction) {
        if(direction < 0 || direction > 3){
            throw new IllegalArgumentException();
        }
        this.direction = direction;
    }
    public int getDirection() {
        return direction;
    }

    
    
}
