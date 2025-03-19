import java.util.Random;

public class MatrixPlusShape {

    private static final int WIDTH = 25;
    private static final int HEIGHT = 15;
    private static final String MARK = "+"; // Bintang/Bisa pakai lain seperti +

    public static void main(String[] args) {
        int[][] matrix = new int[HEIGHT][WIDTH];
        fillMatrix(matrix);
        markMatrix(matrix);
        displayMatrix(matrix);
    }

    // Masukkan nilai matriks secara random dari 0 dan 1
    private static void fillMatrix(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                matrix[i][j] = random.nextInt(2); // keluar nilai 0 atau 1
            }
        }
    }

    // Tandai matriks angka 1
    private static void markMatrix(int[][] matrix) {
        boolean[][] marked = new boolean[HEIGHT][WIDTH];

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (matrix[i][j] == 1 && !marked[i][j]) {
                    markSeries(matrix, marked, i, j);
                }
            }
        }
    }

    // Membuat matriks x dan y dari posisi 1 sampai sekian (misal: x=15 y=25)
    private static void markSeries(int[][] matrix, boolean[][] marked, int startX, int startY) {
        int x = startX;
        int y = startY;

        // buat horizontal
        while (y < WIDTH && matrix[x][y] == 1 && !marked[x][y]) {
            marked[x][y] = true;
            y++;
        }

        // jika nilai baris x (Horizontal) sudah mencapai nilai n tersebut maka ganti baris selanjutnya
        if (y == WIDTH || matrix[x][y] == 0) {
            x++;
            y = 0;
        }

        // jika nilai baris y (Vertikal) sudah mencapai nilai n tersebut maka ganti baris selanjutnya
        while (x < HEIGHT && matrix[x][y] == 1 && !marked[x][y]) {
            marked[x][y] = true;
            x++;
        }
    }

    // Menampilkan hasil program secara acak
    private static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (matrix[i][j] == 1) {
                    System.out.print(MARK + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}