public class LightBulb {
    public boolean on;

    public void turnOn() {
        this.on = true;
        System.out.println("LightBulb: Bulb turned on...");
    }

    public void turnOff() {
        this.on = false;
        System.out.println("LightBulb: Bulb turned off...");
    }
}

public class ElectricPowerSwitch {
    public LightBulb lightBulb;
    public boolean on;

    public ElectricPowerSwitch(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
        this.lightBulb.on = false;
    }

    public void press() {
        boolean checkOn = this.lightBulb.on;
        if (checkOn) {
            lightBulb.turnOff();
        } else {
            lightBulb.turnOn();
        }
    }
}
