import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class Phone extends Product {
    private String color;
    private String battery;
    private TreeMap<Integer, Phone> telefon = new TreeMap<>();
    Scanner scn = new Scanner(System.in);

    public Phone(String name, double price, int discount, int stock, String brand, double screen, String storage, String ram, String color, String battery) {
        super(name, price, discount, stock, brand, screen, storage, ram);
        this.color = color;
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public TreeMap<Integer, Phone> getTelefon() {
        return telefon;
    }

    public void setTelefon(TreeMap<Integer, Phone> telefon) {
        this.telefon = telefon;
    }

    public void createList() {
        this.getTelefon().put(1101, new Phone("Samsung Galaxy A15", 3199.0, 0, 15, "Samsung", 6.5, "128 GB", "6 GB", "Siyah", "4000"));
        this.getTelefon().put(1102, new Phone("iPhone 11 64 GB", 7379.0, 0, 21, "Apple", 6.1, "64 GB", "6 GB", "Mavi", "3046"));
        this.getTelefon().put(1103, new Phone("Redmi Note 10 Pro 8GB", 4012, 0, 23, "Xiaomi", 6.5, "128 GB", "12 GB", "Beyaz", "4000"));
    }

    public void phoneList() {
        System.out.println("Cep Telefonu Listesi");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID   | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM       | Pil       | Renk      |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (Map.Entry<Integer, Phone> entry : telefon.entrySet()
        ) {
            int k = entry.getKey();
            Phone p = entry.getValue();
            System.out.printf("|%2d  | %-30s| %.1f    | %-9s | %6s    | %7s   | %-9s | %-9s | %-10s|\n", k, p.getName(), p.getPrice(), p.getBrand(), p.getStorage(), p.getScreen(), p.getRam(), p.getBattery(), p.getColor());
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        }

    }

    public void addPhone() {
        System.out.print("ürün adını giriniz: ");
        scn.nextLine();
        String isim = scn.nextLine();
        System.out.print("Ürün fiyatını giriniz: ");
        double fiyat = scn.nextDouble();
        System.out.print("Varsa indirim miktarını girin:");
        int ind = scn.nextInt();
        System.out.print("Ürün stok miktarını girin: ");
        int stock = scn.nextInt();
        scn.nextLine();
        System.out.print("Ürün markasını giriniz: ");
        String marka = scn.nextLine();
        System.out.print("Ürün depolama büyüklüğünü girin: ");
        String depo = scn.nextLine();
        System.out.print("Ürün ekran boyutunu girin: ");
        double ekran = scn.nextDouble();
        scn.nextLine();
        System.out.print("Ürün RAM miktarını girin: ");
        String ram = scn.nextLine();
        System.out.print("Ürün pil kapasitesini girin: ");
        String pil = scn.next();
        System.out.print("Ürün rengini girin: ");
        String renk = scn.next();
        this.getTelefon().put(this.getTelefon().lastKey() + 1, new Phone(isim, fiyat, ind, stock, marka, ekran, depo, ram, renk, pil));

    }

    public void deletePhone() {
        for (Map.Entry<Integer, Phone> entry : telefon.entrySet()
        ) {
            int k = entry.getKey();
            Phone p = entry.getValue();
            System.out.println("ID: " + k + " " + p.getName());
        }

        System.out.print("Silmek istediğiniz ürün ID'sini girin: ");
        int delete = scn.nextInt();
        scn.nextLine();
        if (this.getTelefon().containsKey(delete)) {
            this.getTelefon().remove(delete);
            System.out.println("Silme işlemi başarı ile sonuçlandı.\n" +
                    "Üst menüye yönlendiriliyorsunuz.");
        } else {
            System.out.println("Böyle bir ID kayıtlı değil.\n" +
                    "Üst menüye yönlendiriliyorsunuz.");
        }
    }

    public void phoneChoice() {
        System.out.println("Telefon işlemlerine hoşgeldiniz.\n" +
                "1 - Telefonları listele\n" +
                "2 - Telefon ekle\n" +
                "3 - Telefon Sil\n" +
                "4 - Geri dön");
        int choice = scn.nextInt();
        scn.nextLine();
        switch (choice) {
            case 1:
                this.phoneList();
                this.phoneChoice();
                break;
            case 2:
                this.addPhone();
                this.phoneChoice();
                break;
            case 4:
                Store back = new Store();
                back.choice();
                break;
            case 3:
                this.deletePhone();
                this.phoneChoice();
                break;
        }
    }
    public void realPhoneChoice(){
        this.createList();
        this.phoneChoice();
    }
}