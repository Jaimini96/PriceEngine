/**
 * Created by Abhishek Jaimini on 01-12-2016.
 */
public class Logic {
    public static double logic(double price, String D, String S) {
        String demand = D;
        String supply = S;
        double prc = price;
        if (demand.equals("L") & supply.equals("L")) {
            prc = prc + (0.1 * prc);
        } else if (demand.equals("H") & supply.equals("L")) {
            prc = prc - (0.05 * prc);
        } else if (demand.equals("H") & supply.equals("H")) {
            prc = prc;
        } else if (demand.equals("L") & supply.equals("H")) {
            prc = prc + (0.05 * prc);
        }
        return prc;
    }
}
