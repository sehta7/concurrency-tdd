package com.ja.app;

public class SorryImNull {

    static private String[] strArr = new String[3];
    public static void main(String[] args)  {

        Thread thread1 = new Thread(
                ()->{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    strArr[0]= new String("1");
                }
        );

        Thread thread2 = new Thread(
                ()->{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    strArr[1]= new String("2");
                }
        );

        Thread thread3 = new Thread(
                ()->{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    strArr[2]= new String("3");
                }
        );

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("strArr[0] ="+strArr[0].toString()+" strArr[1] = "+strArr[1].toString()+" strArr[2] = "+strArr[2].toString() );
    }
}
