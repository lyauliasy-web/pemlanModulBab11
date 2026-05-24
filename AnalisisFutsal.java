import java.util.Arrays;

public class AnalisisFutsal {

    public static void main(String[] args) {
        // Data Tim A (Tinggi, Berat) untuk 10 pemain
        int[][] timA = {
            {168, 50}, {170, 60}, {165, 56}, {168, 55}, {172, 60},
            {170, 70}, {169, 66}, {165, 56}, {171, 72}, {166, 56}
        };

        // Data Tim B (Tinggi, Berat) untuk 10 pemain
        int[][] timB = {
            {170, 66}, {167, 60}, {165, 59}, {166, 58}, {168, 58},
            {175, 71}, {172, 68}, {171, 68}, {168, 65}, {169, 60}
        };

        // Menggabungkan data kedua tim untuk pertanyaan 1a dan 1b
        int[] semuaTinggi = new int[20];
        int[] semuaBerat = new int[20];

        for (int i = 0; i < 10; i++) {
            semuaTinggi[i] = timA[i][0];
            semuaBerat[i] = timA[i][1];
            semuaTinggi[i + 10] = timB[i][0];
            semuaBerat[i + 10] = timB[i][1];
        }

        // --- SOAL 1a: Urutkan Tinggi Badan (Ascending & Descending) ---
        System.out.println("=== 1a. PENGURUTAN TINGGI BADAN (SEMUA PEMAIN) ===");
        Arrays.sort(semuaTinggi);
        System.out.println("Ascending  : " + Arrays.toString(semuaTinggi));
        
        System.out.print("Descending : [");
        for (int i = semuaTinggi.length - 1; i >= 0; i--) {
            System.out.print(semuaTinggi[i] + (i == 0 ? "" : ", "));
        }
        System.out.println("]\n");

        // --- SOAL 1b: Urutkan Berat Badan (Ascending & Descending) ---
        System.out.println("=== 1b. PENGURUTAN BERAT BADAN (SEMUA PEMAIN) ===");
        Arrays.sort(semuaBerat);
        System.out.println("Ascending  : " + Arrays.toString(semuaBerat));
        
        System.out.print("Descending : [");
        for (int i = semuaBerat.length - 1; i >= 0; i--) {
            System.out.print(semuaBerat[i] + (i == 0 ? "" : ", "));
        }
        System.out.println("]\n");

        // --- SOAL 1c: Maksimum & Minimum Tinggi & Berat Per Tim ---
        System.out.println("=== 1c. NILAI MAKSIMUM & MINIMUM PER TIM ===");
        tampilkanMinMax("Tim A", timA);
        tampilkanMinMax("Tim B", timB);
        System.out.println();

        // --- SOAL 1d: Copy seluruh anggota Tim B ke Tim C ---
        System.out.println("=== 1d. COPY TIM B KE TIM C ===");
        int[][] timC = new int[timB.length][2];
        
        // Menggunakan System.arraycopy untuk menyalin data array multi-dimensi
        for (int i = 0; i < timB.length; i++) {
            System.arraycopy(timB[i], 0, timC[i], 0, timB[i].length);
        }
        
        // Menampilkan hasil copy Tim C
        System.out.println("Data Tim C berhasil dibuat (Hasil Copy dari Tim B):");
        for (int i = 0; i < timC.length; i++) {
            System.out.printf("Pemain %2d -> Tinggi: %d cm, Berat: %d kg\n", (i + 1), timC[i][0], timC[i][1]);
        }
    }

    // Helper method untuk mencari dan menampilkan min/max (Soal 1c)
    public static void tampilkanMinMax(String namaTim, int[][] dataTim) {
        int maxTinggi = dataTim[0][0], minTinggi = dataTim[0][0];
        int maxBerat = dataTim[0][1], minBerat = dataTim[0][1];

        for (int i = 1; i < dataTim.length; i++) {
            if (dataTim[i][0] > maxTinggi) maxTinggi = dataTim[i][0];
            if (dataTim[i][0] < minTinggi) minTinggi = dataTim[i][0];
            if (dataTim[i][1] > maxBerat) maxBerat = dataTim[i][1];
            if (dataTim[i][1] < minBerat) minBerat = dataTim[i][1];
        }

        System.out.println("[" + namaTim + "]");
        System.out.printf("  Tinggi Badan -> Max: %d cm, Min: %d cm\n", maxTinggi, minTinggi);
        System.out.printf("  Berat Badan  -> Max: %d kg, Min: %d kg\n", maxBerat, minBerat);
    }
}