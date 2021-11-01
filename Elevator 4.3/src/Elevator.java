public class Elevator {
    public int currentFloor = 1;
    private int maxFloor;
    private int minFloor;
    public int floor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
        return currentFloor;
    }

    public int moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
        return currentFloor;
    }

    public void move(int floor) {
        if (minFloor > floor || floor > maxFloor) {
            System.out.println("Error");
        }
        while (floor < getCurrentFloor()) {
            moveDown();
            System.out.println(getCurrentFloor());
        }
        while (floor > getCurrentFloor()) {
            moveUp();
            System.out.println(getCurrentFloor());
        }

    }
}
