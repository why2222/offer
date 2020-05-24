public class Singleton {

//    /**
//     * 静态内部类模式
//     */
//    private Singleton() {
//
//    }
//
//    public static Singleton getSingleton() {
//        return Inner.instance;
//    }
//
//    private static class Inner {
//        private static final Singleton instance = new Singleton();
//    }


    /**
     * 双重检查模式
     */
    private static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
