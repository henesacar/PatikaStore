import java.util.Scanner;

public class Store {
    Scanner scn = new Scanner(System.in);

    public void choice(){
        System.out.println("Mağazaya hoşgeldiniz. Lütfen yapmak istediğiniz işlemi seçiniz:\n" +
                "1 - Cep Telefonu İşlemleri\n" +
                "2 - Notebook İşlemleri\n" +
                "3 - Marka İşlemleri\n" +
                "0 - Çıkış");
        int choice = scn.nextInt();
        scn.nextLine();
        switch (choice){
            case 1:
                Phone tlfn = new Phone("0",0,0,0,"0",0.0,"0","0","0","0");
                tlfn.realPhoneChoice();
                break;
            case 2:
                NoteBook nb = new NoteBook("0",0,0,0,"0",0.0,"0","0");
                nb.realNotebookChoice();
                break;
            case 3:
                Brand brd = new Brand(0,"00");
                brd.realChoice();
                break;
            case 4:
                System.exit(0);}
        }

    }


