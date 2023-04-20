package leetcode.editor.cn;

import java.io.IOException;

/**
 * @ClassName: Test
 * @Package: leetcode.editor.cn
 * @Description:
 * @Datetime: 2022/8/16   18:09
 * @Author: YuHan.Kang@outlook.com
 */
public abstract class Test {
    public static void main(String[] args) throws IOException {

    }

}

class Singleton {
    private static final Singleton singleton = new Singleton();

    private Singleton() {

    }

    public static Singleton getSingleton() {
        return singleton;
    }
}

class Resource {
    public static Resource getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    /**
     * 枚举类型是线程安全的，并且只会装载一次
     */
    private enum Singleton {
        INSTANCE;

        private final Resource instance;

        Singleton() {
            instance = new Resource();
        }

        private Resource getInstance() {
            return instance;
        }
    }
}
