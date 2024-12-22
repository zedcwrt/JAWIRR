package praktikum9;


public class Main {
    public static void main(String[] args) {
        Hewan kucing = new Kucing();
        Hewan anjing = new Anjing();

        System.out.println("Kucing mengeluarkan suara: " + kucing.suara());
        System.out.println("Anjing mengeluarkan suara: " + anjing.suara());
    }
}
