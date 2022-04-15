public interface Toy {
    void setPrice(double price);
    void setColor(String color);
}

public interface ToyCar {
    void move();
}

public interface TorPlane {
    void fly();
}

public class ToyHouse implements Toy {
    double price;
    String color;
    @Override
    public void setPrice(double price) {
    this.price = price;
    }

    @Override
    public void setColor(String color) {
    this.color=color;
    }

}

