// DeviceFactory.java
public class DeviceFactory {
    // Requires access to Device, Light, and Thermostat classes
    public static Device create(String type, String id) {
        return switch (type.toLowerCase()) {
            case "light" -> new Light(id);
            case "thermostat" -> new Thermostat(id);
            default -> throw new IllegalArgumentException("Unknown device type: " + type);
        };
    }
}
