import java.util.*; // wildcard to import all classes in util class 

public class Driver {
    public static void main(String[] args) {
        Television tv1 = new Television();
        //Television tv2 = new Television(manufacturer, size, name, type, price); I am NOT typing out 25 fields 
        //Television tv5 = new Television("");
        
        List<Television> tvs = new ArrayList<Television>();
        for (Television tv : tvs) {
            System.out.println(tv.toString());
        }
    }

    private void review() {
//        What is the output of the following code?
    	int[] arr = { 1, 3, 5, 7, 9, 11 };
	    for ( int i=0 ; i<arr.length-1 ; ++i )
		    System.out.print( arr[i] + " " );

    }
    
}
