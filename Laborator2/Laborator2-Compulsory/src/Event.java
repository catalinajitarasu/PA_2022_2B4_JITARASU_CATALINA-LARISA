public class Event {
    public String name;
    public int size;
    public int startTime;
    public int endTime;
    //constructorul care initializeaza atributele clasei
    public Event(String name,int size,int startTime, int endTime) {
        this.name = name;
        this.size=size;
        this.startTime=startTime;
        this.endTime=endTime;
    }
    public Event(String name){
        this.name=name;
    }
    public Event(int size){
        this.size=size;
    }
    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setStartTime(int startTime){
        this.startTime=startTime;
    }
    public void setEndTime(int endTime){
        this.endTime=endTime;
    }
    public void setSize(int size){
        this.size=size;
    }
    //getters
    public String getName(){
        return name;
    }
    public int getStartTime(){
        return startTime;
    }
    public int getEndTime(){
        return endTime;
    }
    public int getSize(){
        return size;
    }
    @Override
    public String toString() {
        return "Event{" + "name='" + name + '\'' + ", size=" + size + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }
    public static void main(String[] args) {
        // declaram obiectele
        Event eventOne = new Event("C1", 100, 8,10);
        Event eventTwo = new Event("C2", 100, 10,12);
        Event eventThree = new Event("L1", 30, 8,10);
        Event eventFour = new Event("L2", 30, 8,10);
        Event eventFive = new Event("L3", 30, 10,12);
        System.out.println(eventOne);
        System.out.println(eventTwo);
        System.out.println(eventThree);
        System.out.println(eventFour);
        System.out.println(eventFive);
    }
}
