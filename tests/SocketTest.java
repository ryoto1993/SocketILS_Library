import libs.*;

import java.net.InetSocketAddress;
import java.util.ArrayList;

public class SocketTest {
    static ArrayList<Light> lights = new ArrayList<>();

    public static void main(String[] args) {
        for (int i=0; i<36; i++) {
            lights.add(new Light());
        }

        SocketClient.setEndpoint(new InetSocketAddress("localhost", 44344));
        try {
            SocketClient.dimAllByLumCct(43.0, 3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
