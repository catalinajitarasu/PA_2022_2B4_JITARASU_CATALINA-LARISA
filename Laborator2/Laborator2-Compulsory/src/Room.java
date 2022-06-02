public class Room {
    public String name;
    public int capacity;
    public RoomType type;
    //constructorul
    public Room(String name, RoomType type, int capacity) {
        this.name = name;
        this.capacity=capacity;
        this.type = type;
    }
    //gettere
    public String getName(){
        return name;
    }
    public RoomType getType(){
        return type;
    }
    public int getCapacity(){
        return capacity;
    }
    //settere
    public void setName(String name){
        this.name=name;
    }
    public void setType(RoomType type) {
        this.type = type;
    }
    public void setCapacity(int capacity){
        this.capacity=capacity;
    }
    @Override
    public String toString() {
        return "Room{" + "name='" + name + '\'' + ", type=" + type + ", capacity=" + capacity + '}';
    }
    public static void main(String[] args) {
        // declaram obiectele
        Room r1 = new Room("401",RoomType.LAB,30);
        Room r2 = new Room("403",RoomType.LAB,30);
        Room r3 = new Room("405",RoomType.LAB,30);
        Room r4 = new Room("309",RoomType.LECTURE_HALL,100);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);

    }
}
