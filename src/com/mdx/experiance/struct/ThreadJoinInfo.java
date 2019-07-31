package com.mdx.experiance.struct;

/**
 * 实现描述：
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/30
 */
public class ThreadJoinInfo {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            MyThread t = new MyThread();
            t.start();
            /**
             * 调用start之后，isAlive方法返回true，之后会wait调用该方法的线程（也就是main线程）
             * 先打印子线程
             * The notify() for this is handled by the Thread subsystem.
             * When the run() method finishes, the  notify() is called on the Thread object.
             * I'm not sure if the code that actually calls notify() can be seen -- it seems to be done in native code
             * It is important to note that this behavior should probably not be relied upon.
             * The notify() call is internal to the thread system.
             * You should use join() if you are waiting for a thread to finish.
             */
//            t.join();
            System.out.println("主线程执行完毕");
            System.out.println("~~~~~~~~~~~~~~~");

        }
    }
}


class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("子线程执行完毕");
    }

}
