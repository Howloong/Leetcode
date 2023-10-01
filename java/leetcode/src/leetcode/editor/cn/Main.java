package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    public volatile List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                System.out.println("t2 start");
                if (main.getSize() != 5) {
                    try {
                        o.wait();
                        System.out.println("t2 end");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                o.notify();
            }
        }, "t2").start();
        new Thread(() -> {
            synchronized (o) {
                System.out.println("t1 start");
                for (int i = 0; i < 10; i++) {
                    main.add(i);
                    System.out.println("add" + i);
                    if (main.getSize() == 5) {
//                        System.out.println("countdown is open");
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
                System.out.println("t1 end");

            }
        }, "t1").start();
    }

    public void add(int i) {
        list.add(i);
    }

    public int getSize() {
        return list.size();
    }
}
