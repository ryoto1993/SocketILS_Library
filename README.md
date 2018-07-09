# Socket Lighting Control System Client Library
Author: Ryoto Tomioka @ISDL 20th

## Download
[Lighting Client library 1.2.0 (Java)](https://github.com/ryoto1993/SocketILS_Library/raw/master/download/LightingClient_1.2.0.jar)


## 1. Overview
By using this library, you can manage socket control lighting
system very easily in your own apps.

This library includes,
- Common __"Light"__ class of __LightingClient__ module.
- Get lights information from server via JSON and reflect in __Light__ class
- Send uniform dim command by luminosity percent and c.c.t.
(correlated color temperature)
- Send individual dim command by Listed Light object
(you can use `List<Light>` or `ArrayList<Light>`)


## 2. Usage
### 1. Setting SocketClient
First of all, you need to set the host name and port number of 
socket client in your apps.  
To configure socket client, use the following code.
~~~
InetSocketAddress endpoint = new InetSocketAddress("192.168.10.1", 44344)
SocketClient.setEndpoint(endpoint);
~~~

### 2. Creating List of Light object
Then, you should make ArrayList of __Light__ object.
~~~
static ArrayList<Light> lights = new ArrayList<>();
~~~ 
You can fetch lighting information including ID,
Luminance percent, color temperature and light position
by using `getLights()`.
~~~
lights = SocketClient.getLights();
~~~

If you want generate Light object manually, without using server information,
append required number of Light instance into ArrayList as in the following code.
~~~
for (int i=0; i<36; i++) {
    Light l = new Light();
    lights.add(l);
}
~~~
If you want to initialize light's luminosity and color temperature
at this point, use the following code.
~~~
for (int i=0; i<36; i++) {
    Light l = new Light();
    l.setLumPct(100);
    l.setTemperature(6000);
    lights.add(l);
}
~~~

### 3. Dimming
Now, all preparation is complete!  
You can dim lighting fixtures in two ways.
- `dimAllByLumCct(double Luminocity, double Cct)`: dim all lighting fixtures uniformly
by using luminosity percent and c.c.t. (correlated color temperature)
- `dimByLights(ArrayList<Light> lights)`: dim lighting fixtures by ArrayList of Light object

In the case you want to dim all lights uniformly,
for example you need to initialize or reset lighting environment,
you can use the following code.
~~~
double luminosityPercent = 50.0;
double cct = 5000.0;

System.out.println(SocketClient.dimAllByLumCct(luminosityPercent, cct));
~~~
If the method succeeds in dimming, it returns a String "OK".
If some problem has been occurred in your apps or server,
the method returns error message by String.  

In the case you need to dim lights individually,
follow the example bellow.
~~~
ArrayList<Light> dimLights = new ArrayList<>();
dimLights.add(lights.get(5));
dimLights.add(lights.get(11));

dimLights.forEach(light -> light.setTemperature(3000));

System.out.println(SocketClient.dimByLights(dimLights));
~~~
In this codes, only two lighting fixtures are dimmed.
