public class House implements Comparable<House> {
    private String street;
    private String city;
    private int zip;
    private String state;
    private int beds;
    private int baths;
    private int sqFeet;
    private String type;
    private Date saleDate;
    private double price;

    public House(String input) {
        String[] strs = input.split(",");
        street = strs[0];
        city = strs[1];
        zip = Integer.parseInt(strs[2]);
        state = strs[3];
        beds = Integer.parseInt(strs[4]);
        baths = Integer.parseInt(strs[5]);
        sqFeet = Integer.parseInt(strs[6]);
        type = strs[7];
        saleDate = new Date(strs[8]);
        price = Double.parseDouble(strs[9]);
    }

    public double price() {
        return this.price;
    }

    @Override
    public int compareTo(House h) {
        return Double.compare(this.price, h.price);
    }

    public void print() {
        System.out.println("Street: " + street);
        System.out.println("City: " + city);
        System.out.println("Zip: " + zip);
        System.out.println("State: " + state);
        System.out.println("Number of bedrooms: " + beds);
        System.out.println("Number of bathrooms: " + baths);
        System.out.println("Area: " + sqFeet);
        System.out.println("Construction type: " + type);
        saleDate.print();
        System.out.println("Price: $" + price);
    }

    private class Date {
        String dayOfWeek;
        String month;
        int day;
        int[] time;
        int hour;
        int minutes;
        int seconds;
        String timeZone;
        int year;

        Date(String date) {
            String[] data = date.split(" ");
            dayOfWeek = data[0];
            month = data[1];
            day = Integer.parseInt(data[2]);
            String[] nums = data[3].split(":");
            time = new int[3];
            for (int i = 0; i < time.length; i++) {
                time[i] = Integer.parseInt(nums[i]);
            }
            timeZone = data[4];
            year = Integer.parseInt(data[5]);
        }

        public void print() {
            System.out.print("Sale date: " + dayOfWeek + " " + month + " " + day + " ");
            for (int i = 0; i < time.length; i++) {
                System.out.print(time[i] + ":");
            }
            System.out.println(" " + timeZone + " " + year);
        }
    }
}
