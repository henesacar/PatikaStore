import java.util.*;

public class Brand {
    private int id;
    private String name;
    private ArrayList<Brand> brands = new ArrayList<>();
    Scanner scn = new Scanner(System.in);

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArrayList<Brand> getBrands() {
        return brands;
    }

    public void setBrands(ArrayList<Brand> brands) {
        this.brands = brands;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void giveBrand() {
        brands.add(new Brand(0, "INVALID"));
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));

    }

    public void addBrand() {
        String isim = "";
        boolean asd = false;
        while (!asd) {
            System.out.print("Marka ismini yazınız: ");
            isim = scn.next();
            for (int j = 0; j < this.getBrands().size(); j++) {
                if (isim.equalsIgnoreCase(this.getBrands().get(j).getName())) {
                    System.out.println("Bu marka zaten kayıtlı");
                    break;
                } else {
                    asd = true;
                }
            }
        }
        int i = this.getBrands().size();
        System.out.println("Sistem tarafından atanan marka kodu: "+i);
        Brand brand = new Brand(i, isim);
        brands.add(brand);
        System.out.println("Marka ekleme işlemi başarılı.\n" +
                "Marka işlemlerine yönlendiriliyorsunuz.");
    }

    public void listBrand() {
        this.getBrands().sort(new Comparator<Brand>() {
            @Override
            public int compare(Brand o1, Brand o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        int i = 1;
        System.out.printf("%-10s", "Marka Adı");
        System.out.println();
        System.out.println("*********************");
        for (Brand brd : this.getBrands()
        ) {
            if (brd.getId() == 0) {
                continue;
            } else {
                System.out.printf("%-5s%-5s", i, brd.getName());
                i++;
                System.out.println();
                ;
            }
        }
    }

    public void brandChoice() {
        System.out.println("Marka işlemlerine hoşgeldiniz.\n" +
                "1 - Markaları listele\n" +
                "2 - Marka ekle\n" +
                "3 - Geri dön");
        int choice = scn.nextInt();
        switch (choice) {
            case 1:
                this.listBrand();
                this.brandChoice();
                break;
            case 2:
                this.addBrand();
                this.brandChoice();
                break;
            case 3:
                Store back = new Store();
                back.choice();
                break;
        }


    }

    public void realChoice() {
        this.giveBrand();
        this.brandChoice();
    }
}
