public class Router extends Node  implements Identifiable {
    private String address;
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Router{" +
                "name='" + name + '\'' +
                '}';
    }
}
