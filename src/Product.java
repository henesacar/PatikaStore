public abstract class Product{
    private String name;
    private double price;
    private int discount;
    private int stock;
    private String brand;
    private double screen;
    private String storage;
    private String ram;

    public Product(String name, double price, int discount, int stock, String brand, double screen, String storage, String ram) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.brand = brand;
        this.screen = screen;
        this.storage = storage;
        this.ram = ram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getScreen() {
        return screen;
    }

    public void setScreen(double screen) {
        this.screen = screen;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
