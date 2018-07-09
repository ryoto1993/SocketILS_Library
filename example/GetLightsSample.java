import LightingSystem.Light;
import LightingSystem.SocketClient;

import java.net.InetSocketAddress;
import java.util.ArrayList;

public class GetLightsSample {
    private static ArrayList<Light> lights = new ArrayList<>();

    public static void main(String[] args) {
        SocketClient.setEndpoint(new InetSocketAddress("172.20.11.58", 44344));

        // Get Lights information from server
        lights = SocketClient.getLights();

        // Print lights information
        for (Light l: lights) {
            System.out.println("ID:" + l.getId() + "\t" + "Lum:" + l.getLumPct() + "\t" + "Tmp:" + l.getTemperature());
        }

    }
}
