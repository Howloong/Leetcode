package leetcode.editor.cn;

class FinalReferenceEscapeDemo {
    public static void main(String[] args) {
        final byte a = 1;
        final byte b = 1;
        byte c = a + b;
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.get();
    }
}
