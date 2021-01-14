import java.util.LinkedList;
import java.util.Scanner;

public class Network
{
    public static void main(String[] args)
    {
        LinkedList<Device> allDevices = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is number of WI-FI Connections ?");
        int maxDevicesForRouter = scanner.nextInt();
        Router router = new Router(maxDevicesForRouter);
        System.out.println("What is number of devices Clients want to connect?");
        int numOfDevices = scanner.nextInt();
        for (int i = 0; i < numOfDevices; i++)
        {
            String deviceName = scanner.next();
            String deviceType = scanner.next();
            allDevices.add(new Device(deviceName, deviceType));
        }
        for (int i = 0; i < numOfDevices; i++)
        {
            deviceThread device = new deviceThread(router, allDevices.getFirst());
            device.setName(allDevices.getFirst().getName() + " (" + allDevices.getFirst().getType() + ")");
            allDevices.removeFirst();
            device.start();
        }
    }
}

class deviceThread extends Thread
{
    Router router;
    Device device;

    public deviceThread(Router router, Device device)
    {
        this.router = router;
        this.device = device;
    }

    @Override
    public void run()
    {
        try
        {
            router.occupy();
            device.connect();
            Thread.sleep(5);
            device.performActivity();
            Thread.sleep(5);
            device.logout();
            router.release();
        }
        catch (InterruptedException e)
        {
            System.out.println("Exception has been caught !");
        }
    }
}
