import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StoreSales {
    private Set<String> uniqueProducts;
    private Map<String, Integer> productSales;
    private int totalSales;
    private String mostPopularProduct;
    // uniqueProducts: множество для хранения уникальных продуктов.
    //productSales: для количества проданных единиц каждого продукта.
    //totalSales: общая сумма продаж.
    //mostPopularProduct: наиболее популярный продукт.
    public StoreSales() {
        uniqueProducts = new HashSet<>();
        productSales = new HashMap<>();
        totalSales = 0;
        mostPopularProduct = null;
    }
    // Конструктор инициализирует переменные.
    public void addSale(String product, int price) {
        uniqueProducts.add(product);
        totalSales += price;

        productSales.put(product, productSales.getOrDefault(product, 0) + 1);

        if (mostPopularProduct == null || productSales.get(product) >= productSales.get(mostPopularProduct)) {
            mostPopularProduct = product;
        }
    } // Этот метод добавляет продажу в статистику. Он обновляет множество уникальных продуктов, общую сумму продаж,
    // количество продаж каждого продукта и наиболее популярный продукт.

    public void displaySales() {
        System.out.println("List of unique sold products:");
        for (String product : uniqueProducts) {
            System.out.println(product + " x" + productSales.get(product));
        }

        System.out.println("Total sales amount: $" + totalSales);

        System.out.println("Most popular product: " + mostPopularProduct);
    } // Этот метод выводит текущую статистику продаж.

    public static void main(String[] args) {
        StoreSales store = new StoreSales();
        store.addSale("Apple", 150);
        store.addSale("Banana", 100);
        store.addSale("Banana", 100);
        store.addSale("Apple", 150);
        store.addSale("Orange", 200);

        store.displaySales();
    }
}
//Методы:
//- addSale(String product, int price) — добавляет проданный товар и его цену.
//- displaySales() — выводит список уникальных проданных товаров, общую сумму продаж и наиболее популярный товар.
