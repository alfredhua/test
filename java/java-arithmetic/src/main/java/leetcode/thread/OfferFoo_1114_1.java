package leetcode.thread;

public class OfferFoo_1114_1 implements Runnable{

//    @Override
//    public void run() {
//        System.out.println("--------1----------");
//        OfferFooHelp.getFirstDone().incrementAndGet();
//    }


    @Override
    public void run() {
        while (true){
            if (OfferFooHelp.getFirstDone().get()%3==0) {
                System.out.println("--------1----------");
                OfferFooHelp.getFirstDone().incrementAndGet();
            }
        }
    }
}