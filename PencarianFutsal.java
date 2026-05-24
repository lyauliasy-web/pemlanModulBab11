import java.util.ArrayList;
import java.util.Collections;

public class PencarianFutsal {

    public static void main(String[] args) {
        // --- SOAL a) Implementasikan ArrayList Terpisah ---
        ArrayList<Integer> tinggiA = new ArrayList<>();
        ArrayList<Integer> beratA = new ArrayList<>();
        ArrayList<Integer> tinggiB = new ArrayList<>();
        ArrayList<Integer> beratB = new ArrayList<>();

        // Input data Tim A dari tabel sebelumnya
        int[][] dataTimA = {
            {168, 50}, {170, 60}, {165, 56}, {168, 55}, {172, 60},
            {170, 70}, {169, 66}, {165, 56}, {171, 72}, {166, 56}
        };
        for (int[] p : dataTimA) {
            tinggiA.add(p[0]);
            beratA.add(p[1]);
        }

        // Input data Tim B dari tabel sebelumnya
        int[][] dataTimB = {
            {170, 66}, {167, 60}, {165, 59}, {166, 58}, {168, 58},
            {175, 71}, {172, 68}, {171, 68}, {168, 65}, {169, 60}
        };
        for (int[] p : dataTimB) {
            tinggiB.add(p[0]);
            beratB.add(p[1]);
        }

        // WAJIB: Sortir semua ArrayList sebelum melakukan Binary Search
        Collections.sort(tinggiA);
        Collections.sort(beratA);
        Collections.sort(tinggiB);
        Collections.sort(beratB);


        // --- SOAL b) Cari jumlah pemain Tim B dengan tinggi 168 cm dan 160 cm ---
        System.out.println("=== b) PENCARIAN TINGGI BADAN TIM B ===");
        int t168 = hitungJumlahDgnBinarySearch(tinggiB, 168);
        int t160 = hitungJumlahDgnBinarySearch(tinggiB, 160);
        System.out.println("Jumlah pemain Tim B dengan tinggi 168 cm: " + t168 + " orang");
        System.out.println("Jumlah pemain Tim B dengan tinggi 160 cm: " + t160 + " orang\n");


        // --- SOAL c) Cari jumlah pemain Tim A dengan berat 56 kg dan 53 kg ---
        System.out.println("=== c) PENCARIAN BERAT BADAN TIM A ===");
        int b56 = hitungJumlahDgnBinarySearch(beratA, 56);
        int b53 = hitungJumlahDgnBinarySearch(beratA, 53);
        System.out.println("Jumlah pemain Tim A dengan berat 56 kg : " + b56 + " orang");
        System.out.println("Jumlah pemain Tim A dengan berat 53 kg : " + b53 + " orang\n");


        // --- SOAL d) Apakah ada pemain Tim A yang tinggi/beratnya sama dengan Tim B? ---
        System.out.println("=== d) VALIDASI KESAMAAN DATA TIM A & TIM B ===");
        
        boolean adaTinggiSama = cekKesamaanData(tinggiA, tinggiB);
        boolean adaBeratSama = cekKesamaanData(beratA, beratB);

        System.out.println("Apakah ada pemain di Tim A yang TINGGI BADANNYA sama dengan pemain di Tim B? -> " + (adaTinggiSama ? "ADA" : "TIDAK ADA"));
        System.out.println("Apakah ada pemain di Tim A yang BERAT BADANNYA sama dengan pemain di Tim B?  -> " + (adaBeratSama ? "ADA" : "TIDAK ADA"));
    }

    /**
     * Method untuk menghitung jumlah kemunculan nilai menggunakan prinsip Binary Search.
     * Jika nilai ditemukan, program akan mengecek ke kiri dan kanan indeks tersebut 
     * untuk menghitung elemen duplikatnya.
     */
    public static int hitungJumlahDgnBinarySearch(ArrayList<Integer> list, int target) {
        int indeks = Collections.binarySearch(list, target);
        
        // Jika hasil negatif, berarti target tidak ditemukan di dalam list
        if (indeks < 0) {
            return 0; 
        }

        int jumlah = 1;

        // Cek ke arah kiri dari indeks yang ditemukan
        int kiri = indeks - 1;
        while (kiri >= 0 && list.get(kiri) == target) {
            jumlah++;
            kiri--;
        }

        // Cek ke arah kanan dari indeks yang ditemukan
        int kanan = indeks + 1;
        while (kanan < list.size() && list.get(kanan) == target) {
            jumlah++;
            kanan++;
        }

        return jumlah;
    }

    /**
     * Method untuk mengecek apakah ada elemen di listA yang juga eksis di listB
     * memanfaatkan efisiensi Binary Search.
     */
    public static boolean cekKesamaanData(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        for (int nilai : listA) {
            // Mencari setiap elemen listA di dalam listB menggunakan Binary Search
            if (Collections.binarySearch(listB, nilai) >= 0) {
                return true; // Langsung return true jika ditemukan satu saja yang sama
            }
        }
        return false;
    }
}