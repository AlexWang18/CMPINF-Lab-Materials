public class Car {
    private int serial;
    private String company;
    private String model;
    private String color;

    public Car() {
    }

    public Car(int serial, String company, String model, String color) {
        this.serial = serial;
        this.company = company;
        this.model = model;
        this.color = color;
    }

    public int getSerial() {
        return this.serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return serial == car.serial && Objects.equals(company, car.company) && Objects.equals(model, car.model) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial, company, model, color);
    }

    @Override
    public String toString() {
        return "{" +
            " serial='" + getSerial() + "'" +
            ", company='" + getCompany() + "'" +
            ", model='" + getModel() + "'" +
            ", color='" + getColor() + "'" +
            "}";
    }

}