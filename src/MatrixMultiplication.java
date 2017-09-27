import Core.ControlMatrix;
import Core.MatrixData;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Namila on 9/24/2017.
 */
public class MatrixMultiplication {

    private static String WRITEFILE="output.txt";

    public static void main(String[] args) {
        int m1,n1,m2,n2,threadcount;
        MatrixData matrixDataA,matrixDataB,finalmatrix;
        Scanner scanner;
        BufferedReader bufferedReader;


        try {
            bufferedReader = new BufferedReader(new FileReader("D:\\UoP\\Programming\\Java\\Thread_Matrix\\src\\A.txt"));

            // m1= scanner.nextInt();
            //n1=scanner.nextInt();
            m1 = Integer.parseInt(bufferedReader.readLine());
            n1 = Integer.parseInt(bufferedReader.readLine());
            matrixDataA = new MatrixData(m1, n1);
            for (int row = 0; row < m1; row++) {
                for (int col = 0; col < n1; col++) {
                    if(bufferedReader.equals(null))throw new NullPointerException();
                    float val = Float.parseFloat(bufferedReader.readLine());
                    matrixDataA.setMatrix(row,col,val);
                }
            }
            bufferedReader.close();

            bufferedReader = new BufferedReader(new FileReader("D:\\UoP\\Programming\\Java\\Thread_Matrix\\src\\B.txt"));
            m2 = Integer.parseInt(bufferedReader.readLine());
            n2 = Integer.parseInt(bufferedReader.readLine());
            matrixDataB = new MatrixData(m2, n2);
            for (int row = 0; row < m2; row++) {
                for (int col = 0; col < n2; col++) {
                    float val = Float.parseFloat(bufferedReader.readLine());
                    matrixDataB.setMatrix(row,col,val);
                }
            }
            bufferedReader.close();

            finalmatrix = new MatrixData(m1, n2);
            scanner = new Scanner(System.in);
            threadcount=scanner.nextInt();
            scanner.close();

            if(n1!=m2) {
                System.out.println("Cant multiply the given matrix A="+m1+"x"+n1+" B="+m2+"x"+n2);
                System.exit(-1);
            }
            if(threadcount>m1) {
                System.out.println("Thread count is larger than given Matrix row size.");
                System.out.println("Row Count="+m1+" Thread Count="+threadcount);
                System.exit(-1);

            }

            ControlMatrix controlMatrix = new ControlMatrix(threadcount,matrixDataA.getMatrix(), matrixDataB.getMatrix(), finalmatrix);
            controlMatrix.executeThreads();
            BufferedWriter br=new BufferedWriter(new FileWriter(WRITEFILE));
            controlMatrix.writeMatrixData(br);
            br.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }



}
