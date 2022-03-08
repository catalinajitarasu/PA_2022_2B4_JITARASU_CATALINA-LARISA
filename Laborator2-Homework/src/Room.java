/**
 * @author Catalina
 */

import java.util.Objects;

public abstract class Room {
    public String name;
    public int capacity;
    /**
     *
     * @param name - numele camerei
     * @param capacity - capacitatea camerei
     */
    public Room(String name, int capacity) {
        this.name = name;
        this.capacity=capacity;
    }
    /**
     * get name
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     *get capacity
     * @return
     */
    public int getCapacity(){
        return capacity;
    }
    //settere

    /**
     *set name
     * @param name -numele camerei
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     *set capacity
     * @param capacity  -capacitatea camerei
     */
    public void setCapacity(int capacity){
        this.capacity=capacity;
    }
    /**
     *
     * @return -instante de tip Room
     */
    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
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
     *verifica obiecte de tip Room sa nu se repete
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Room)) {
            return false;
        }
        Room other = (Room) obj;
        return name.equals(other.name);
    }

}
