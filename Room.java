import java.util.ArrayList;
import java.util.List;

public class Room {
    private final String id;
    private boolean occ = false;
    private final List<OccupancyObserver> observers = new ArrayList<>();
    
    public Room(String id) { 
        this.id = id; 
    }
    
    public void setOccupancy(boolean o) {
        if (occ != o) { 
            occ = o; 
            // Notify Observers
            observers.forEach(x -> x.changed(id, occ)); 
        }
    }
    
    public void register(OccupancyObserver o) { 
        observers.add(o); 
    }
}
