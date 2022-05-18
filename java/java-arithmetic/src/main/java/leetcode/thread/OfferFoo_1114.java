package leetcode.thread;

public class OfferFoo_1114 {


    public static void main(String[] args) {
        new Thread(new OfferFoo_1114_3()).start();
        new Thread(new OfferFoo_1114_2()).start();
        new Thread(new OfferFoo_1114_1()).start();
    }


//    private AtomicInteger firstDone=new AtomicInteger(0);
//    private AtomicInteger secondDone=new AtomicInteger(0);
//    public OfferFoo_1114() {
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        firstDone.incrementAndGet();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        while (firstDone.incrementAndGet()!=1){
//        }
//        printSecond.run();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        // printThird.run() outputs "third". Do not change or remove this line.
//        while (secondDone.incrementAndGet()!=1){
//        }
//        printThird.run();
//    }


}
