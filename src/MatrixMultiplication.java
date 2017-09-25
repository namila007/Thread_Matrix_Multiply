import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Namila on 9/24/2017.
 */
public class MatrixMultiplication {


    public static void main(String[] args) {
        int m1,n1,m2,n2;
        MatrixData matrixDataA,matrixDataB,finalmatrix;
        Scanner scanner;

        scanner=new Scanner(System.in);

        m1= scanner.nextInt();
        n1=scanner.nextInt();
        matrixDataA=new MatrixData(m1,n1);
        for(int row=0;row<m1;row++){
            for(int col=0;col<n1;col++){
                float val=scanner.nextFloat();
                matrixDataA.setMatrix(row,col,val);
            }
        }

        m2= scanner.nextInt();
        n2=scanner.nextInt();
        matrixDataB=new MatrixData(m2,n2);
        for(int row=0;row<m2;row++){
            for(int col=0;col<n2;col++){
                float val=scanner.nextFloat();
                matrixDataB.setMatrix(row,col,val);
            }
        }
        finalmatrix=new MatrixData((int)m1,(int)n2);
        ControlMatrix controlMatrix=new ControlMatrix(matrixDataA.getMatrix(),matrixDataB.getMatrix(),finalmatrix);
        controlMatrix.executeThreads();
        System.out.println("sss "+Arrays.deepToString(finalmatrix.getMatrix()));
        //b



    }



}
