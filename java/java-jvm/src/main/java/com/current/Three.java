package com.current;

public class Three {

    private int flag = 0;

    public synchronized void printa() throws InterruptedException {
        while (true)
        {
            if(flag ==0)
            {
                System.out.print("A");
                flag = 1;
                notifyAll();
            }
            wait();
        }
    }
    public synchronized void printb() throws InterruptedException {
        while (true)
        {
            if(flag ==1)
            {
                System.out.print("B");
                flag = 2;
                notifyAll();
            }
            wait();
        }
    }
    public synchronized void printc() throws InterruptedException {
        while (true) {
            if (flag == 2) {
                System.out.println("C");
                Thread.sleep(1000);
                flag = 0;
                notifyAll();
            }
            wait();
        }
    }


    public static void main(String[] args) {
        Three three = new Three();
        new Thread(()->{
            try {
                three.printa();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                three.printb();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                three.printc();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
