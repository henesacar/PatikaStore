import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NoteBook extends Product {
    private TreeMap<Integer, NoteBook> laptop = new TreeMap<>();
    Scanner scn = new Scanner(System.in);

    public NoteBook(String name, int price, int discount, int stock, String brand, double screen, String storage, String ram) {
        super(name, price, discount, stock, brand, screen, storage, ram);
    }

    public TreeMap<Integer, NoteBook> getLaptop() {
        return laptop;
    }

    public void setLaptop(TreeMap<Integer, NoteBook> laptop) {
        this.laptop = laptop;
    }

    public void createBookList() {
        this.getLaptop().put(2101, new NoteBook("HUAWEI Matebook 14", 7000, 0, 15, "Huawei", 14.0, "512 GB", "16 GB"));
        this.getLaptop().put(2102, new NoteBook("LENOVO V14 IGL", 3699, 0, 3, "Lenovo", 14.0, "1024 GB", "8 GB"));
        this.getLaptop().put(2103, new NoteBook("ASUS Tuf Gaming", 8199, 0, 5, "Asus", 15.6, "2048 GB", "32 GB"));
    }

    public void notebookList() {
        System.out.println("Notebook Listesi");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                        | Fiyat     | Marka     | Hafıza    | Ekran     | RAM    |");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Map.Entry<Integer, NoteBook> entry : this.getLaptop().entrySet()) {
            int k = entry.getKey();
            NoteBook n = entry.getValue();
            System.out.printf("|%2d  | %-30s| %.1f    | %-9s  | %6s    | %7.1f   | %-6s |\n", k, n.getName(), n.getPrice(), n.getBrand(), n.getStorage(), n.getScreen(), n.getRam());
            System.out.println("-----------------------------------------------------------------------------------------------");
        }


    }

    public void addNotebook() {
        System.out.print("ürün adını giriniz: ");
        String isim = scn.nextLine();
        System.out.print("Ürün fiyatını giriniz: ");
        int fiyat = scn.nextInt();
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
        this.getLaptop().put(this.getLaptop().lastKey()+1,new NoteBook(isim,fiyat,ind,stock,marka,ekran,depo,ram));
    }
    public void deleteNotebook(){
        for (Map.Entry<Integer, NoteBook> entry : this.getLaptop().entrySet()
        ) {
            int k = entry.getKey();
            NoteBook n = entry.getValue();
            System.out.println("ID: " + k + " " + n.getName());
        }

        System.out.print("Silmek istediğiniz ürün ID'sini girin: ");
        int delete = scn.nextInt();
        scn.nextLine();
        if (this.getLaptop().containsKey(delete)) {
            this.getLaptop().remove(delete);
            System.out.println("Silme işlemi başarı ile sonuçlandı.\n" +
                    "Üst menüye yönlendiriliyorsunuz.");
        } else {
            System.out.println("Böyle bir ID kayıtlı değil.\n" +
                    "Üst menüye yönlendiriliyorsunuz.");
        }
    }
    public void notebookChoice() {
        System.out.println("Notebook işlemlerine hoşgeldiniz.\n" +
                "1 - Notebookları listele\n" +
                "2 - Notebook ekle\n" +
                "3 - Notebook Sil\n" +
                "4 - Geri dön");
        int choice = scn.nextInt();
        scn.nextLine();
        switch (choice) {
            case 1:
                this.notebookList();
                this.notebookChoice();
                break;
            case 2:
                this.addNotebook();
                this.notebookChoice();
                break;
            case 4:
                Store back = new Store();
                back.choice();
                break;
            case 3:
                this.deleteNotebook();
                this.notebookChoice();
                break;
        }
    }
    public void realNotebookChoice(){
        this.createBookList();
        this.notebookChoice();
    }


    }

