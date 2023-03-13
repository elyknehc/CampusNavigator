public class Location {
    private int x, y, roomNum, floor;
    private String building;
    
    public static void main(String[] args) {
        Location loc = new Location(1, 2, 3, 4, "asd");
        System.out.println(loc);
    }

    public Location(int x, int y, int roomNum, int floor, String building) {
        this.x = x;
        this.y = y;
        this.roomNum = roomNum;
        this.floor = floor;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Location Info:\n x: " + x + "\n" + " y: " + y + "\n" + " roomNum: " + roomNum
                + "\n" + " floor: " + floor;
    }




    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRoomNum() {
        return this.roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getBuilding() {
        return this.building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }       
}
