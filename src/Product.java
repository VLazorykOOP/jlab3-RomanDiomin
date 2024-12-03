class Product {
    protected String name;
    protected double price;
    protected String manufacturer;

    public Product(String name, double price, String manufacturer) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public void Show() {
        System.out.println("Товар:");
        System.out.println("Назва: " + name);
        System.out.println("Ціна: " + price + " грн");
        System.out.println("Виробник: " + manufacturer);
    }
}

class Toy extends Product {
    private String ageCategory;
    private String material;

    public Toy(String name, double price, String manufacturer, String ageCategory, String material) {
        super(name, price, manufacturer);
        this.ageCategory = ageCategory;
        this.material = material;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Категорія віку: " + ageCategory);
        System.out.println("Матеріал: " + material);
    }
}

class FoodProduct extends Product {
    private String expirationDate;
    private double weight;

    public FoodProduct(String name, double price, String manufacturer, String expirationDate, double weight) {
        super(name, price, manufacturer);
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Термін придатності: " + expirationDate);
        System.out.println("Вага: " + weight + " кг");
    }
}

class DairyProduct extends FoodProduct {
    private double fatContent;

    public DairyProduct(String name, double price, String manufacturer, String expirationDate, double weight,
            double fatContent) {
        super(name, price, manufacturer, expirationDate, weight);
        this.fatContent = fatContent;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Вміст жиру: " + fatContent + "%");
    }
}

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[3];

        products[0] = new Toy("Конструктор LEGO", 500.0, "LEGO Group", "6+", "Пластик");
        products[1] = new FoodProduct("Хліб", 25.0, "Хлібокомбінат", "2024-12-10", 0.5);
        products[2] = new DairyProduct("Молоко", 30.0, "Молокозавод", "2024-12-05", 1.0, 3.2);

        for (Product product : products) {
            product.Show();
            System.out.println("---------");
        }
    }
}
