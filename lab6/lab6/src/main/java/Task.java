package lab6.lab6.src.main.java;

import java.util.Arrays;

public class Task {
    public static float[] fillArray1(int size){
        long startTime = System.currentTimeMillis();
        float[] array = new float[size];
        Arrays.fill(array, 1.0f);
        for (int i = 0; i < size; i++) {
            array[i] = (float )(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i  / 5) * Math.cos(0.4f + i  / 2));
        }
        long finalTime = System.currentTimeMillis();
        System.out.println("Время выполнения в 1 потоке: "+ (finalTime - startTime));
        return array;
    }
    public static float[] fillArray2(int size){
        long startTime = System.currentTimeMillis();
        float[] array = new float[size];
        Arrays.fill(array, 1.0f);
        float[] a1 = Arrays.copyOfRange(array, 0, size / 2 );
        float[] a2 = Arrays.copyOfRange(array, size / 2, size );
        Thread t1 = new Thread(() ->{
            for(int i = 0; i < a1.length; i++){
                a1[i] = (float )(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i  / 5) * Math.cos(0.4f + i  / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = a2.length; i < a2.length * 2; i++){
                a2[i - a2.length] = (float )(a2[i - a2.length] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {

        }
        System.arraycopy(a1, 0, array, 0, a1.length);
        System.arraycopy(a2, 0, array, a2.length , a2.length);
        long finalTime = System.currentTimeMillis();
        System.out.println("Время выполнения в 2 потоках: "+(finalTime - startTime));
        return array;
    }
    public static float[] fillArray3(int size){
        long startTime = System.currentTimeMillis();
        float[] array = new float[size];
        Arrays.fill(array, 1.0f);
        float[] a1 = Arrays.copyOfRange(array, 0, size / 3 );
        float[] a2 = Arrays.copyOfRange(array, size / 3, size*2/3);
        float[] a3 = Arrays.copyOfRange(array, size*2/3 , size/1);
        Thread t1 = new Thread(() ->{
            for(int i = 0; i < a1.length; i++){
                a1[i] = (float )(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i  / 5) * Math.cos(0.4f + i  / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = a2.length; i < a2.length*2 ; i++){
                a2[i - a2.length] = (float )(a2[i - a2.length] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t3 = new Thread(() -> {
            for(int i = a3.length*2; i < a3.length*3 ; i++){
                a3[i - a3.length*2] = (float )(a3[i - a3.length*2] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e) {

        }
        System.arraycopy(a1, 0, array, 0, a1.length);
        System.arraycopy(a2, 0, array, a2.length , a2.length);
        System.arraycopy(a3, 0, array, a3.length*2 , a3.length);
        long finalTime = System.currentTimeMillis();
        System.out.println("Время выполнения в 3 потоках: "+(finalTime - startTime));
        return array;
    }
    public static float[] fillArray4(int size){
        long startTime = System.currentTimeMillis();
        float[] array = new float[size];
        Arrays.fill(array, 1.0f);
        float[] a1 = Arrays.copyOfRange(array, 0, size / 4 );
        float[] a2 = Arrays.copyOfRange(array, size / 4, size/2);
        float[] a3 = Arrays.copyOfRange(array, size/2 , size*3/4);
        float[] a4 = Arrays.copyOfRange(array, size*3/4 , size/1);
        Thread t1 = new Thread(() ->{
            for(int i = 0; i < a1.length; i++){
                a1[i] = (float )(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i  / 5) * Math.cos(0.4f + i  / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = a2.length; i < a2.length*2 ; i++){
                a2[i - a2.length] = (float )(a2[i - a2.length] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t3 = new Thread(() -> {
            for(int i = a3.length*2; i < a3.length*3 ; i++){
                a3[i - a3.length*2] = (float )(a3[i - a3.length*2] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t4 = new Thread(() -> {
            for(int i = a4.length*3; i < a4.length*4 ; i++){
                a4[i - a4.length*3] = (float )(a4[i - a4.length*3] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch (InterruptedException e) {

        }
        System.arraycopy(a1, 0, array, 0, a1.length);
        System.arraycopy(a2, 0, array, a2.length , a2.length);
        System.arraycopy(a3, 0, array, a3.length*2 , a3.length);
        System.arraycopy(a4, 0, array, a4.length*3 , a4.length);
        long finalTime = System.currentTimeMillis();
        System.out.println("Время выполнения в 4 потоках: "+(finalTime - startTime));
        return array;
    }
}
