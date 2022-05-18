package leetcode.thread;

public class OfferFoo_1114_3 implements Runnable{

//    @Override
//    public void run() {
//        while (OfferFooHelp.getSecondDone().get()!=1){
//        }
//        System.out.println("--------3----------");
//    }

    @Override
    public void run() {
        while (true){
            if (OfferFooHelp.getFirstDone().get()%3==2) {
                System.out.println("--------3----------");
                OfferFooHelp.getFirstDone().incrementAndGet();
            }
        }
    }
}