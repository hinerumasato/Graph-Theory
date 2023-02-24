import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class GraphUtils {

    public static boolean isUnDirectedGraph(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++)
            for(int j = i+1; j < matrix[i].length; j++)
                if(matrix[i][j] != matrix[j][i])
                    return false;
        return true;
    }

    public static Graph readFromFile(String path) {
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            int n = sc.nextInt();
            sc.nextLine();
            int[][] matrix = new int[n][n];
            int count = 0;

            while(sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" ");
                int[] row = new int[line.length];
                for(int i = 0; i < row.length; i++)
                    row[i] = Integer.parseInt(line[i]);
                matrix[count] = row;
                count++;
            }
            sc.close();

            if (isUnDirectedGraph(matrix))
                return new UnDirectedGraph(n, matrix);
            else return new DirectedGraph(n, matrix);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void generateRandomUnDirectedMatrixToFile(String path, int n) {
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(path);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            Random rd = new Random();
            int[][] matrix = new int[n][n];

            
            for(int i = 0; i < n; i++)
                for(int j = i+1; j < n; j++) {
                    matrix[i][j] = rd.nextInt(2);
                    matrix[j][i] = matrix[i][j];
                }
            
            printWriter.println(n);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++)
                    printWriter.print(matrix[i][j] + " ");
                printWriter.println();
            }

            printWriter.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void generateRandomDirectedMatrixToFile(String path, int n) {
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(path);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            Random rd = new Random();
            int[][] matrix = new int[n][n];

            
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = rd.nextInt(2);
                }
            
            printWriter.println(n);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++)
                    printWriter.print(matrix[i][j] + " ");
                printWriter.println();
            }

            printWriter.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
