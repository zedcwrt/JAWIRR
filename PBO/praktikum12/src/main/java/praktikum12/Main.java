package praktikum12;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Kelas Buku
class Buku implements Serializable {
    private String judul;
    private String pengarang;
    private int tahunTerbit;

    public Buku(String judul, String pengarang, int tahunTerbit) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    @Override
    public String toString() {
        return "Judul: " + judul + ", Pengarang: " + pengarang + ", Tahun Terbit: " + tahunTerbit;
    }
}

public class Main {
    private static final String FILE_TEXT = "buku.txt";
    private static final String FILE_SERIAL = "buku.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Buku> daftarBuku = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Buku Baru dan Simpan ke File buku.txt");
            System.out.println("2. Simpan Objek Buku ke File buku.ser");
            System.out.println("3. Tampilkan Daftar Buku dari File buku.txt");
            System.out.println("4. Tampilkan Daftar Buku dari File buku.ser");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Judul Buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Pengarang: ");
                    String pengarang = scanner.nextLine();
                    System.out.print("Masukkan Tahun Terbit: ");
                    int tahunTerbit = scanner.nextInt();

                    Buku buku = new Buku(judul, pengarang, tahunTerbit);
                    daftarBuku.add(buku);

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_TEXT, true))) {
                        writer.write(buku.toString());
                        writer.newLine();
                        System.out.println("Buku berhasil disimpan ke buku.txt");
                    } catch (IOException e) {
                        System.out.println("Terjadi kesalahan saat menyimpan ke buku.txt: " + e.getMessage());
                    }
                    break;

                case 2:
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_SERIAL))) {
                        oos.writeObject(daftarBuku);
                        System.out.println("Objek Buku berhasil disimpan ke buku.ser");
                    } catch (IOException e) {
                        System.out.println("Terjadi kesalahan saat menyimpan ke buku.ser: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\nDaftar Buku dari buku.txt:");
                    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_TEXT))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        System.out.println("Terjadi kesalahan saat membaca buku.txt: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("\nDaftar Buku dari buku.ser:");
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_SERIAL))) {
                        @SuppressWarnings("unchecked")
                        ArrayList<Buku> bukuDariFile = (ArrayList<Buku>) ois.readObject();
                        for (Buku b : bukuDariFile) {
                            System.out.println(b);
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Terjadi kesalahan saat membaca buku.ser: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Keluar dari program.");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
                    break;
            }
        }

        scanner.close();
    }
}
