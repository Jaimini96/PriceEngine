import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Abhishek Jaimini on 29-11-2016.
 */
public class InputParser {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try {
            try (Stream<String> stream = Files.lines(Paths.get("test.txt"))) {
                double price = Double.MAX_VALUE;
                list = stream.collect(Collectors.toList());
                String[] initLine = list.get(0).split(" ");

                int typeOfItems = Integer.parseInt(initLine[0]);
                int totalSurveys = Integer.parseInt(list.get(1 + typeOfItems).toString());

                //iterating for each product
                for (int j = 0; j < typeOfItems; j++) {
                    String productName = list.get(1 + j).split(" ")[0];
                    Product product = new Product(productName, list);

                    //Getting the Demand and Supply status
                    String D = list.get(1 + j).split(" ")[1];
                    String S = list.get(1 + j).split(" ")[2];

                    price = Logic.logic(product.calculateLowestPrice(), D, S);
                    System.out.println(productName + " " + price);
                    price = Double.MAX_VALUE;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
