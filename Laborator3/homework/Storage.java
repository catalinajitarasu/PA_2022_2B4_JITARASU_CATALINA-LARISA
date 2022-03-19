package homework;
public interface Storage {
    int getStorageCapacity();

    default int storageCapacity(String typeCapacity, int capacity) {
        String str1 = "MB";
        String str2 = "KB";
        String str3 = "Byte";
        if(typeCapacity.equals(str1))
            capacity=capacity*1024;
        if(typeCapacity.equals(str2))
            capacity=capacity*1048576;
        if(typeCapacity.equals(str3))
            capacity=capacity*1073741824;
        return capacity;
    }
}
