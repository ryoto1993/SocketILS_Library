import LightingSystem.Light;
import LightingSystem.SocketClient;

import java.net.InetSocketAddress;
import java.util.ArrayList;

public class SocketTest {
    static ArrayList<Light> lights = new ArrayList<>();

    public static void main(String[] args) {
        for (int i=0; i<36; i++) {
            Light l = new Light();
            l.setLumPct(100);
            l.setTemperature(6000);
            lights.add(l);
        }

        ArrayList<Light> dimLights = new ArrayList<>();
        dimLights.add(lights.get(5));
        dimLights.add(lights.get(11));

        dimLights.forEach(light -> light.setTemperature(3000));

        SocketClient.setEndpoint(new InetSocketAddress("localhost", 44344));
        System.out.println(SocketClient.dimByLights(dimLights));
    }
}
