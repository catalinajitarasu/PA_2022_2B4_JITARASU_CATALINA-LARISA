package homework;

public class Computer extends Node implements Identifiable, Storage{
    private String address;
    private int storageCapacity;
    //constructor, settere, gettere

    public Computer(String address, int storageCapacity){
        this.address=address;
        this.storageCapacity=storageCapacity;
    }
    public Computer(){
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setStorageCapacity(int storageCapacity){

        this.storageCapacity=storageCapacity;
    }
    @Override
    public String getAddress() {

        return address;
    }
    @Override
    public int getStorageCapacity() {

        return storageCapacity;
    }

    @Override
    public String toString() {
        return "Computer{" + "name= " + name + "," + "cost=" + cost + "}";
    }

}
