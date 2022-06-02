/**
 * @author Catalina
 */

import java.util.Arrays;

public class Problem {
    public Event[] events;
    public Room[] rooms;
    /**
     * Constructor pentru obiecte de tipul Problem,nu este nevoie intializarea acestuia
     */
    public Problem() {
    }
    /**
     * set events
     * @param events
     */
    public void setEvents(Event[] events) {
        this.events = events;
    }
    /**
     *set rooms
     * @param rooms
     */
    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }
    /**
     *get events
     * @return
     */
    public Event[] getEvents() {
        return events;
    }
    /**
     *get rooms
     * @return
     */
    public Room[] getRooms() {
        return rooms;
    }

    /**
     * return o instanta de tip problem
     * @return
     */
    @Override
    public String toString() {
        return "Problem{" +
                "events=" + Arrays.toString(events) +
                ", rooms=" + Arrays.toString(rooms) +
                '}';
    }
    /**
     * initializez obiectele si le afisez
     * metoda genereaza o rezolvare a problemei
     *  verific pentru fiecare eveniment in care camera se poate incarda
     *  iau in considerare start si end time si capacitatea necesara pentru eveniment
     */
    public void rezolvProblem (){
        // declaram obiecte de tipul event ,room si le initializam

        Event[] events=new Event[5];
        events[0]= new Event("C1",100,8,10);
        events[1]= new Event("C2",100,10,12);
        events[2]= new Event("L1",30,8,10);
        events[3]= new Event("L2",30,8,10);
        events[4]= new Event("L3",30,10,12);

        Room[] rooms = new Room[4];
        rooms[0]= new ComputerLab("401",30);
        rooms[1]= new ComputerLab("403",30);
        rooms[2]= new ComputerLab("405",30);
        rooms[3]= new LectureHall("309",100);

        for(int index2=0;index2<5;index2++){
            System.out.println(events[index2]);
        }

        for(int index1=0;index1<4;index1++){
            System.out.println(rooms[index1]);
        }
        int end=0;
        int sizee=0;
        for(int index3 = 0;index3 < 5; index3++)
            for (int index4 = 0; index4 < 4; index4++) {
                if (events[index3].size <= rooms[index4].capacity) {
                    if (events[index3].startTime >= end || rooms[index4].capacity!=sizee ) {
                        end = events[index3].endTime;
                        sizee=rooms[index4].capacity;
                        System.out.println(events[index3].name + "->" + rooms[index4].name); break;
                    }
                }
            }
    }

}