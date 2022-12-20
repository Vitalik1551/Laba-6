package lab6.lab6.src.main.java;

public class Main {
    public static void main(String[] args) {
        int sizeArray = 60_000_000;
        float[] arr = Task.fillArray1(sizeArray);
        System.out.println(arr[sizeArray - 1]);

        float[] arr1 = Task.fillArray2(sizeArray);
        System.out.println(arr1[sizeArray - 1]);

        float[] arr2 = Task.fillArray3(sizeArray);
        System.out.println(arr2[sizeArray-1]);

        float[] arr3 = Task.fillArray4(sizeArray);
        System.out.println(arr3[sizeArray-1]);

    }
}
