package Core;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by Namila on 9/28/2017.
 */
public class Single_Thread {
    private float[][] A,B;
    private MatrixData finalmatrix;
    private ColumnMultiply columnMultiply;



    public Single_Thread ( float[][] A, float[][] B, MatrixData finalmatrix, BufferedWriter bw){
        this.A = A;
        this.B = B;
        this.finalmatrix = finalmatrix;

        for(int row=0;row<A.length;row++){
            int interestedcol=0;
            for(int col=0;col<B[0].length;col++){
                float[] rowMatrix = A[row];//creating row matrix
                float[] columnMatrix = getColumn(B,interestedcol++);//creating column matrix
                columnMultiply = new ColumnMultiply(rowMatrix, columnMatrix);
                finalmatrix.setMatrix(row, col, columnMultiply.multiplySum());
            }
        }
        try {
            bw.write(finalmatrix.getMatrix().length + "");
            bw.newLine();
            bw.write(finalmatrix.getMatrix()[0].length + "");
            bw.newLine();
            for (int m = 0; m < finalmatrix.getMatrix().length; m++) {
                for (int n = 0; n < finalmatrix.getMatrix()[0].length; n++) {
                    bw.write(String.format("%.4f", finalmatrix.getMatrix()[m][n]));
                    bw.newLine();
                }
            }
        }catch (IOException e){
                    e.printStackTrace();
        }

    }


    private float[] getColumn(float[][]matrix,int row){
        float[]columnMatrix=new float[matrix.length];
        //getting the column from 2d matrix
        for(int col=0;col<matrix.length;col++) {
            columnMatrix[col]=matrix[col][row];
        }
        return columnMatrix;
    }
}
