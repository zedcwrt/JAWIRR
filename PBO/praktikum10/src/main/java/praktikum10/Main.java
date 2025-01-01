package praktikum10;

interface Pembayaran {
    double hitungPajak(double harga);
}

class Elektronik implements Pembayaran {
    @Override
    public double hitungPajak(double harga) {
        return harga * 0.10; 
    }
}

class Makanan implements Pembayaran {
    @Override
    public double hitungPajak(double harga) {
        return harga * 0.05; 
    }
}

public class Main {
    public static void main(String[] args) {
        Pembayaran produkElektronik = new Elektronik();
        Pembayaran produkMakanan = new Makanan();
        

        double hargaElektronik = 500000; 
        double hargaMakanan = 24000;     
        
        // Menghitung dan menampilkan pajak untuk Elektronik
        double pajakElektronik = produkElektronik.hitungPajak(hargaElektronik);
        System.out.println("Pajak untuk Elektronik (harga: " + hargaElektronik + "): " + pajakElektronik);
        
        // Menghitung dan menampilkan pajak untuk Makanan
        double pajakMakanan = produkMakanan.hitungPajak(hargaMakanan);
        System.out.println("Pajak untuk Makanan (harga: " + hargaMakanan + "): " + pajakMakanan);
    }
}
