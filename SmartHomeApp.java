import java.util.Scanner;

public class SmartHomeApp {
    public static void main(String[] args) {
        SmartHomeHub hub = SmartHomeHub.get();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Smart Home Console (help for commands)");
        
        // Requirement b: The program is expected to run for a long time
        while (true) { 
            System.out.print("> ");
            
            try { // Graceful Exception Handling for the main loop
                String[] c = sc.nextLine().split(" ");
                if (c[0].equals("exit")) break;
                
                switch (c[0]) {
                    case "help" -> System.out.println("add_room <r>, add_device <r> <type> <suf> <role>, occupy <r> <true/false>, list, on <id>, off <id>, exit");
                    case "add_room" -> hub.addRoom(c[1]);
                    case "add_device" -> hub.addDevice(c[1], c[2], c[3], c[4]);
                    case "list" -> hub.listDevices().forEach(d -> 
                        System.out.println(d.getId() + " " + d.getType() + " " + (d.isOn() ? "ON" : "OFF"))
                    );
                    case "occupy" -> hub.setRoomOccupancy(c[1], Boolean.parseBoolean(c[2]));
                    case "on" -> hub.getDevice(c[1]).on();
                    case "off" -> hub.getDevice(c[1]).off();
                    default -> System.out.println("Unknown command.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // Handling missing command arguments (Defensive Programming)
                System.err.println("Error: Missing arguments for the command. Use 'help' to see syntax.");
            } catch (Exception e) {
                // General error handler
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
