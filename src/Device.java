public class Device
{
    private String name, type;

    public void connect()
    {
        System.out.println(getName() + " Occupied");
    }

    public void performActivity()
    {
        System.out.println(getName() + " Performs online activity");
    }

    public void logout()
    {
        System.out.println(getName() + " Logged out");
    }

    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Device(String name, String type)
    {
        setName(name);
        setType(type);
    }
}
