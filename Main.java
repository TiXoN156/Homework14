package com.company;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10;

    public static void main(String[] args) throws InterruptedException {

        //Работа с массивом в одном потоке
        float[] arrOne = new float[SIZE];

        fillArray(arrOne);

        MyThread myThread = new MyThread();

        long startTime1 = System.currentTimeMillis();
        Thread thread = new Thread(() -> myThread.run(arrOne));
        thread.start();
        long finishTime1 = System.currentTimeMillis();

        System.out.println(finishTime1 - startTime1);
        System.out.println(Arrays.toString(arrOne));

        //Работа с массивом в двух потоках
        float[] arrTwo = new float[SIZE];
        float[] arr1 = new float[SIZE / 2];
        float[] arr2 = new float[SIZE / 2];

        fillArray(arrTwo);

        System.arraycopy(arrTwo, 0, arr1, 0, SIZE / 2);
        System.arraycopy(arrTwo, SIZE / 2, arr2, 0, SIZE / 2);

        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        long startTime2 = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> myThread1.run(arr1));
        Thread thread2 = new Thread(() -> myThread2.run(arr2));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        long finishTime2 = System.currentTimeMillis();

        System.arraycopy(arr1, 0, arrTwo, 0, SIZE / 2);
        System.arraycopy(arr2, 0, arrTwo, SIZE / 2, SIZE / 2);

        System.out.println(finishTime2 - startTime2);
        System.out.println(Arrays.toString(arrTwo));
    }

    public static void fillArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

}
