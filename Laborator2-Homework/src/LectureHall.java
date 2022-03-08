/**
 * @author Catalina
 */
public class LectureHall extends Room{
    /**
     *
     * @param name of room
     * @param capacity of room
     */
    public LectureHall(String name, int capacity) {
        super(name, capacity);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "LectureHall{" +
                "name='" + name + '\'' + ",capacity=" +capacity +
                '}';
    }
}
