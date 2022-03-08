/**
 * @author Catalina
 */

import java.util.Objects;

public class Event {
    public String name;
    public int size;
    public int startTime;
    public int endTime;
    /**
     * constructorul care initializeaza atributele clasei
     *
     * @param name
     * @param size
     * @param startTime
     * @param endTime
     */
    public Event(String name,int size,int startTime, int endTime) {
        this.name = name;
        this.size=size;
        this.startTime=startTime;
        this.endTime=endTime;
    }
    /**
     *set name
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * set startTime
     * @param startTime
     */
    public void setStartTime(int startTime){
        this.startTime=startTime;
    }

    /**
     *set endTime
     * @param endTime
     */
    public void setEndTime(int endTime){
        this.endTime=endTime;
    }

    /**
     *set size of event
     * @param size
     */
    public void setSize(int size){
        this.size=size;
    }
    /**
     *
     * @return name of the event
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return startTime
     */
    public int getStartTime(){
        return startTime;
    }

    /**
     *
     * @return end Time
     */
    public int getEndTime(){
        return endTime;
    }

    /**
     *
     * @return size
     */
    public int getSize(){
        return size;
    }

    /**
     *
     * @return events
     */
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * verific evenimentele astfel incat sa nu fie de mai multe ori acelasi
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Event)) {
            return false;
        }
        Event other = (Event) obj;
        return name.equals(other.name);
    }
}
