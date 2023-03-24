
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    private int m, n;
    private int a[][];
    private static final int OPEN = 0, WALL = 1, TRIED = 2, PATH = 3;

    public Maze(String file) {
        try {
            File mazeFile = new File(file);
            Scanner inputScanner = new Scanner(mazeFile);
            m = Integer.parseInt(inputScanner.nextLine());
            n = Integer.parseInt(inputScanner.nextLine());

            a = new int[m][n];
            int counter = 0;
            String str;
            while (inputScanner.hasNextLine()) {
                str = inputScanner.nextLine();
                for (int i = 0; i < str.length(); i++) {
                    a[counter][i] = Integer.parseInt(str.charAt(i) + "");
                }
                counter++;
            }
            inputScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void print() {
        char chars[] = { ' ', '#', '?', 'o' };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(chars[a[i][j]]);
            }
            System.out.println();
        }
    }

    public int getHeight() {
        return m;
    }

    public int getWidth() {
        return n;
    }

    public boolean isOpen(Location location) {
        return (a[location.getY()][location.getX()] == OPEN);
    }

    public void markMoved(Location location) {
        a[location.getY()][location.getX()] = PATH;
    }

    public void markTried(Location location) {
        a[location.getY()][location.getX()] = TRIED;
    }

}
