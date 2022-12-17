package leetcode.editor.cn;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.stream.LongStream;

/**
 * @ClassName: Test
 * @Package: leetcode.editor.cn
 * @Description:
 * @Datetime: 2022/8/16   18:09
 * @Author: YuHan.Kang@outlook.com
 */
public class Test {
    public static void main(String[] args) throws IOException {
        LongStream.rangeClosed(1, 1000).reduce(0, Long::sum);
    }

    public static void print(Consumer<String> c1, Consumer<String> c2) {
        c1.accept("hh");
        c2.accept("hh");
    }


}
