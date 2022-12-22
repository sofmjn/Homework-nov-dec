public class Main {
    public static class  MainThread extends Thread {

        MainThread(String name){
            super(name);
        }
        public void run(){
            while(true)
            {
                System.out.print(Thread.currentThread().getName());
                try{
                    Thread.sleep(500);
                }
                catch(InterruptedException e){
                    System.out.println("Thread has been interrupted");
                }
            }
        }
    }
    public static void main(String[] args) {
        MainThread thread1 = new MainThread("Peter");
        MainThread thread2 = new MainThread("Kecha");
        thread1.start();
        thread2.start();
    }
}