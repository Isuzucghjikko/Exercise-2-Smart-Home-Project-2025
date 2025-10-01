// DeviceProxy.java
public class DeviceProxy implements Device {
    private final Device real;
    private final String role;

    public DeviceProxy(Device real, String role) { 
        this.real = real; 
        this.role = role; 
    }
    
    @Override
    public String getId() { return real.getId(); }
    
    @Override
    public String getType() { return real.getType(); }
    
    @Override
    public boolean isOn() { return real.isOn(); }
    
    @Override
    public void on() { 
        if (allowed()) real.on(); 
        else deny(); 
    }
    
    @Override
    public void off() { 
        if (allowed()) real.off(); 
        else deny(); 
    }
    
    // Authorization logic
    private boolean allowed() { 
        // Example: Guests cannot control the Thermostat
        return !("guest".equals(role) && "Thermostat".equals(real.getType())); 
    }
    
    private void deny() { 
        System.out.println("Access denied for " + role + " on " + getType()); 
    }
}
