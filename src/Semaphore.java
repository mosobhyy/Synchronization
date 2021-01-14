public class Semaphore
{
    protected int value;

    public Semaphore(int value)
    {
        this.value = value;
    }

    public synchronized void Wait() throws InterruptedException
    {
        value--;
        if (value < 0)
        {
            System.out.println(Thread.currentThread().getName()
                    + " Arrived and waiting !");
            wait();
        }
        else
            System.out.println(Thread.currentThread().getName()
                    + " Arrived !");
    }

    public synchronized void Signal()
    {
        value++;
        if (value <= 0)
            notify();
    }
}
