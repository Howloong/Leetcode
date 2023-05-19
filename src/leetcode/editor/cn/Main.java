package leetcode.editor.cn;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

    }
}


class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                Long start = System.currentTimeMillis();
                while (true) {
                    Long current = System.currentTimeMillis();
                    if ((current - start) > 1000) {
                        return 1;
                    }
                }
            }
        };
        Future future = executorService.submit(callable);

        try {
            Integer result = (Integer) future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
