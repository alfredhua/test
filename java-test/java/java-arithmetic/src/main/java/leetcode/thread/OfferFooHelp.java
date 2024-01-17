package leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class OfferFooHelp {


    private static AtomicInteger firstDone=new AtomicInteger(0);
    private static AtomicInteger secondDone=new AtomicInteger(0);

    public static AtomicInteger getFirstDone() {
        return firstDone;
    }

    public static AtomicInteger getSecondDone() {
        return secondDone;
    }

}
