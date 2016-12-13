import java.util.List;

/**
 * Created by Abhishek Jaimini on 01-12-2016.
 */
public class Product {
    String productName;
    double price = Double.MAX_VALUE;
    int noOfBrands;
    List<String> inputData;
    double averagePrice;

    public Product(String productName, List<String> inputData) {
        this.inputData = inputData;
        this.productName = productName;

    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getNoOfBrands() {
        return noOfBrands;
    }

    private double calculateAverage() {
        int typeOfItems = Integer.parseInt(inputData.get(0));
        int totalSurveys = Integer.parseInt(inputData.get(1 + typeOfItems).toString());
        double temp = 0;
        double count = 0;
        for (int i = 0; i < totalSurveys; i++) {
            String[] values = inputData.get(1 + typeOfItems + i + 1).split(" ");

            if (values[0].equals(productName)) {
                temp += Double.parseDouble(values[2]);
                count++;
                averagePrice = temp / count;
            }
        }
        return averagePrice;

    }

    public double calculateLowestPrice() {
        int typeOfItems = Integer.parseInt(inputData.get(0));
        int totalSurveys = Integer.parseInt(inputData.get(1 + typeOfItems).toString());

        for (int i = 0; i < totalSurveys; i++) {
            String[] values = inputData.get(1 + typeOfItems + i + 1).split(" ");
            if (values[0].equals(productName)) {
                double temp = Double.parseDouble(values[2]);
                if ((temp < price) & (((0.5 * calculateAverage()) <= temp) & (temp <= (1.5 * calculateAverage())))) {
                    price = temp;
                }
            }
        }
        return price;
    }
}
