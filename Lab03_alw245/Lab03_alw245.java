import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Lab03_alw245 {

    private List<House> homes;

    public Lab03_alw245(String file) throws FileNotFoundException {
        homes = readListings(new Scanner(new File(file)));
        Collections.sort(homes); // by price
        mainMenu();
    }

    private ArrayList<House> readListings(Scanner fileR) {
        ArrayList<House> homes = new ArrayList<House>();
        String labels = fileR.nextLine(); // eat the first line

        while (fileR.hasNextLine()) {
            String str = fileR.nextLine();
            homes.add(new House(str));
        }

        return homes;
    }

    void mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to my Real Estate Company!\nChoose a price range");
        System.out.print("From: ");
        int lower = Integer.parseInt(sc.nextLine());
        System.out.print("To: ");
        int upper = Integer.parseInt(sc.nextLine());

        sc.close();

        if (upper < lower) {
            System.err.println("Upper bound is smaller than lower");
            return;
        }

        if (homes.get(homes.size() - 1).price() < lower) {
            System.out.println("All homes are cheaper than lower bound");
            return;
        }

        for (House house : homes) { // by sorting it, we iterate less
            if (house.price() >= lower && house.price() <= upper) {
                house.print();
                System.out.println("================================");
            }
            if (house.price() > upper)
                break; // doneeee
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 1) {
            new Lab03_alw245("real_estate_listing.txt");
        } else
            new Lab03_alw245(args[0]);

    }

}