import Core.ControlMatrix;
import Core.MatrixData;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Namila on 9/24/2017.
 */
public class MatrixMultiplication {

    private static String WRITEFILE="output.txt",FILE_A="A.txt",FILE_B="B.txt";


    public static void main(String[] args) {
        int m1,n1,m2,n2,threadcount;
        MatrixData matrixDataA,matrixDataB,finalmatrix;
        Scanner scanner;
        BufferedReader bufferedReader;


        try {
            bufferedReader = new BufferedReader(new FileReader(FILE_A));
            //reading file and getting row and column size of the matrix
            m1 = Integer.parseInt(bufferedReader.readLine());
            n1 = Integer.parseInt(bufferedReader.readLine());
            matrixDataA = new MatrixData(m1, n1);
            for (int row = 0; row < m1; row++) {
                for (int col = 0; col < n1; col++) {
                    //taking matrix values
                    if(bufferedReader.equals(null))throw new NullPointerException();
                    float val = Float.parseFloat(bufferedReader.readLine());
                    matrixDataA.setMatrix(row,col,val);
                }
            }
            bufferedReader.close();

            bufferedReader = new BufferedReader(new FileReader(FILE_B));
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

            if(n1!=m2) {
                //checking wheteher matrix can be multiply
                System.out.println("Cant multiply the given matrix A="+m1+"x"+n1+" B="+m2+"x"+n2);
                System.exit(-1);
            }

            //creating final matrix with the dimension of m1*n2
            finalmatrix = new MatrixData(m1, n2);
            scanner = new Scanner(System.in);
            //getting thread count
            threadcount=scanner.nextInt();
            scanner.close();

            if(threadcount>m1) {
                //if threadcount> row count of matrix A, exit
                System.out.println("Thread count is larger than given Matrix row size.");
                System.out.println("Row Count="+m1+" Thread Count="+threadcount);
                System.exit(-1);

            }

            //calling and running
            ControlMatrix controlMatrix = new ControlMatrix(threadcount,matrixDataA.getMatrix(), matrixDataB.getMatrix(), finalmatrix);
            controlMatrix.executeThreads();

            //writing data
            BufferedWriter br=new BufferedWriter(new FileWriter(WRITEFILE));
            controlMatrix.writeMatrixData(br);
            br.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }



}
