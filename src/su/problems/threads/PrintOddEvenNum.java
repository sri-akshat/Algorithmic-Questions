package su.problems.threads;

/**
 * Created by Akshat on 1/29/2015.
 */
public class PrintOddEvenNum {

    static int[] arr = new int[11];

    public int[] execute() throws InterruptedException {

        Thread thread1 = new Thread(new Thread1(),"evenT");
        Thread thread2 = new Thread(new Thread2(),"oddT");

        thread1.start();
        thread2.start();

        thread1.join();

        return arr;
    }

    class Thread1 implements Runnable{

        @Override
        public void run()
        {
            synchronized(PrintOddEvenNum.class){
                for(int i=0;i<11;i=i+2)
                {
                    arr[i] = i;
                    System.out.println(i+"-"+Thread.currentThread().getName());
                    try {
                        PrintOddEvenNum.class.notifyAll();
                        PrintOddEvenNum.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                PrintOddEvenNum.class.notifyAll();
            }
        }

    }

    class Thread2 implements Runnable{

        @Override
        public void run()
        {
            synchronized(PrintOddEvenNum.class){
                for(int i=1;i<10;i=i+2)
                {
                    arr[i] = i;
                    System.out.println(i+"-"+Thread.currentThread().getName());

                    try {
                        PrintOddEvenNum.class.notifyAll();
                        PrintOddEvenNum.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                PrintOddEvenNum.class.notifyAll();
            }
        }

    }
}


