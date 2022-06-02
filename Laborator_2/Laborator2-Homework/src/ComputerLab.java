/**
 * @author Catalina
 */
public class ComputerLab extends Room{
    /**
     *
     * @param name numele camerei
     * @param capacity capacitatea camerei
     */
    public ComputerLab(String name, int capacity) {
        super(name, capacity);
    }

    /**
     * @return - returneaza stringul cu informatiile
     */
    @Override
    public String toString() {
        return "ComputerLab{" +
                "name='" + name + '\'' + ",capacitaty=" + capacity +
        '}';
    }
}
