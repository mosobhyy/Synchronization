public class Router
{

    Semaphore semaphore;

    public void occupy() throws InterruptedException
    {
        semaphore.Wait();
    }

    public void release() throws InterruptedException
    {
        semaphore.Signal();
    }

    public Router(int maxNumOfDevices)
    {
        semaphore = new Semaphore(maxNumOfDevices);
    }
}
