import java.util.*;


public class Main {
    public static class MainThread extends Thread {

        ArrayList<Integer> nums;
        int time=100;
        // int n = 10
        MainThread(String name, ArrayList<Integer> numer,int timer){
            super(name);
            this.nums=numer;
            this.time=timer;
        }
        public void run(){
            Random random = new Random();
            while(true)
            {
                System.out.print(Thread.currentThread().getName());
                synchronized(nums)
                {
                    //производитель
                    if(Thread.currentThread().getName()=="Kecha") // Кеша докидывает в массив циферки, производитель
                    {
                        if(nums.size()<10) // если вдруг надо будет другое, можно другое значение n
                        {
                            nums.add(random.nextInt(10));
                            System.out.println(nums.size());
                        }
                        else
                            System.out.println("Full");
                    }
                    else
                    {
                        //потре бители
                        if(nums.size()>0)
                        {
                            System.out.print(nums.get(0));
                            nums.remove(0); // кушают
                            System.out.println(nums.size());
                        }
                        else
                            System.out.println(" Hungry");
                    }
                }
                try{
                    Thread.sleep(random.nextInt(time));
                }
                catch(InterruptedException e){
                    System.out.println("Thread has been interrupted");
                }
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> numsik=new ArrayList<Integer>();
        MainThread thread1 = new MainThread("Peter", numsik,300);
        MainThread thread2 = new MainThread("Lucy", numsik,100);
        MainThread thread3 = new MainThread("Kecha", numsik,10);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}