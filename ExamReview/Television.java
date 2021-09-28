import java.util.Objects;

public class Television {
    private String manufacturer;
    private int size;
    public String name;
    public String type;
    private double price;
    private final String COUPON_CODE = "Banana";


    public Television() {
        this ("Panasonic", 58, "Class 4K Crystal UHD", "LED Smart TV", 567.99);
    }

    public Television(String line) {
        String[] tokens = line.split(",");
        this.manufacturer = tokens[0];
        this.size = toInt(tokens[1]);
        this.name = tokens[2];
        this.type = tokens[3];
        this.price = Double.parseDouble(tokens[4]);
    }

    private int toInt(String str) {
        return Integer.parseInt(str);
    }

    public Television(String manufacturer, int size, String name, String type, double price) {
        this.manufacturer = manufacturer;
        this.size = size;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public void applyCoupon(String code) {
        if (code.equals(COUPON_CODE)) 
            setPrice(price * .9);
        else 
            System.out.println("Coupon is invalid");
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Television)) {
            return false;
        }
        Television television = (Television) o;
        return size == television.size && Objects.equals(type, television.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, size, name, type, price);
    }

    @Override
    public String toString() {
        return "{" +
            " manufacturer='" + getManufacturer() + "'" +
            ", size='" + getSize() + "'" +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }
}
