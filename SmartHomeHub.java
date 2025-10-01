import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SmartHomeHub implements OccupancyObserver {
    // Singleton Instance
    private static final SmartHomeHub INSTANCE = new SmartHomeHub();
    
    private final Map<String, Device> devices = new HashMap<>();
    private final Map<String, Room> rooms = new HashMap<>();
    
    // Private constructor
    private SmartHomeHub() {}
    
    // Global access method
    public static SmartHomeHub get() { return INSTANCE; }

    public void addRoom(String id) {
        Room r = new Room(id);
        r.register(this); // The Hub observes the Room
        rooms.put(id, r);
        System.out.println("Room added: " + id);
    }
    
    public void addDevice(String room, String type, String suffix, String role) {
        String id = room + ":" + suffix;
        // Uses Factory and Proxy
        Device d = new DeviceProxy(DeviceFactory.create(type, id), role); 
        devices.put(id, d);
        System.out.println("Device " + id + " added");
    }
    
    public Device getDevice(String id) { return devices.get(id); }
    public Collection<Device> listDevices() { return devices.values(); }
    public void setRoomOccupancy(String room, boolean occ) { 
        rooms.get(room).setOccupancy(occ); 
    }

    // Observer Pattern: Handles state change from the Room
    @Override
    public void changed(String room, boolean occ) {
        System.out.println("Hub: " + room + " occupancy=" + occ);
        
        // Command/Logic for devices in that room
        devices.values().stream()
               .filter(d -> d.getId().startsWith(room + ":"))
               .forEach(d -> { 
                   if (occ) d.on(); 
                   else d.off(); 
               });
    }
}
