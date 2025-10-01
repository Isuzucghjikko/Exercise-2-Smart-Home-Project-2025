// Thermostat.java
public class Thermostat implements Device {
    private final String id;
    private boolean active;
    
    public Thermostat(String id) { 
        this.id = id; 
    }
    
    @Override
    public String getId() { return id; }
    
    @Override
    public String getType() { return "Thermostat"; }
    
    @Override
    public void on() { 
        active = true; 
        System.out.println(id + " Thermostat ACTIVE"); 
    }
    
    @Override
    public void off() { 
        active = false; 
        System.out.println(id + " Thermostat IDLE"); 
    }
    
    @Override
    public boolean isOn() { return active; }
}
