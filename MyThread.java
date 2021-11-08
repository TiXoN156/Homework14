package com.company;

public class MyThread{

    public void run(float[] arr){
        float temp;
        for (int i = 0; i < arr.length; i++) {
            temp = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            arr[i] = temp;
        }
      }

}
