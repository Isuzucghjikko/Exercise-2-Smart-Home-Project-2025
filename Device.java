import java.util.*;

public interface Device {
    String getId();
    String getType();
    void on();
    void off();
    boolean isOn();
}
