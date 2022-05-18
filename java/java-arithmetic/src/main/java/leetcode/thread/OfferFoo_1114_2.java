package leetcode.thread;

public class OfferFoo_1114_2 implements Runnable{

//    @Override
//    public void run() {
//        while (OfferFooHelp.getFirstDone().get()!=1){
//        }
//        System.out.println("--------2----------");
//        OfferFooHelp.getSecondDone().incrementAndGet();
//    }

    @Override
    public void run() {
        while (true){
            if(OfferFooHelp.getFirstDone().get()%3==1) {
                System.out.println("--------2----------");
                OfferFooHelp.getFirstDone().decrementAndGet();
            }
        }
    }
}