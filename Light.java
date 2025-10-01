// Light.java
public class Light implements Device {
    private final String id;
    private boolean on;
    
    // Note: Since this class uses 'Device', you don't need to explicitly import 
    // it if both files are in the same package (default package here).

    public Light(String id) { 
        this.id = id; 
    }
    
    @Override
    public String getId() { return id; }
    
    @Override
    public String getType() { return "Light"; }
    
    @Override
    public void on() { 
        on = true; 
        System.out.println(id + " Light ON"); 
    }
    
    @Override
    public void off() { 
        on = false; 
        System.out.println(id + " Light OFF"); 
    }
    
    @Override
    public boolean isOn() { return on; }
}
