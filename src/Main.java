
import java.util.Scanner;


public class Main {

    static int[] sirala(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] >= arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                counter++;
            }
            ;
        }
        int length = arr.length - counter;
        int[] arr2 = new int[length];

        counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr2[counter] = arr[i];
                counter++;
            }

        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        return arr2;
    } //arrayi sıralıyoruz ve sıralı arrayi tekrar eden çift sayıların boyutuna göre yeni bir arraye atıyoruz

    static int[] tekrarEdenCiftSayilariDiziyeAt(int[] arr) {
        int[] arr2 = new int[10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((i != j) && (arr[i] == arr[j]) && (arr[i] % 2 == 0)) {
                    arr2[i] = arr[i]; //tekrar eden çift sayıları yeni bir diziye atıyoruz
                }
            }
        }
        return arr2;
    }//tekrar eden çift sayıları diziye atıyoruz ayrıca boş kalan diğer indexlerede default 0 değeri atanıyor

    static void printInfo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int counter = 1;

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        counter++;
                    } else {
                        break;
                    }
                }
                i = i + counter - 1;
                System.out.println(arr[i] + " sayisi dizi içerisinde " + counter + " defa tekrar eden çift sayidir");
            
        }
    }// tekrar eden çift sayıların bulunduğu sıralı dizideki değerleri ve tekrar sayılarını yazdırıyoruz

    public static void main(String[] args) {

        int[] arr = new int[10];
        int[] arr2 = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Sıfır haricinde bir sayı giriniz: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Dizinin " + (i + 1) + ". elemanini giriniz: ");
            arr[i] = sc.nextInt();
            if (arr[i] == 0) {
                System.out.println("0 girilmez");
                i--;
            }
        }
        System.out.println("");

        arr2 = tekrarEdenCiftSayilariDiziyeAt(arr);

        System.out.println("Tekrar eden çift sayıları yeni bir dizi içerisine attık ");

        arr2 = sirala(arr2);

        System.out.println();
        System.out.println("==========================================================");

        printInfo(arr2);


    }
}
