package Core;

import java.util.Arrays;

/**
 * Created by Namila on 9/24/2017.
 */
public class Threading implements Runnable {
    private float[][] A,B;
    private MatrixData finalmatrix;
    private ColumnMultiply columnMultiply;
    private int startvalA,startvalB,endvalA,endvalB;

    public Threading(float[][]A,float[][]B,MatrixData finalmatrix ,int[]values){
        this.A=A;
        this.B=B;
        this.finalmatrix=finalmatrix;
        this.startvalA=values[0];
        this.endvalA=values[1];

    }



    @Override
    public void run() {
          for(int row=startvalA;row<endvalA;row++) {
            int interestedcol=0;
            for (int col = 0; col < B[0].length; col++) {
                float[] rowMatrix = A[row];//creating row matrix
                float[] columnMatrix = getColumn(B,interestedcol++);//creating column matrix

                columnMultiply = new ColumnMultiply(rowMatrix, columnMatrix);
                    try {
                        finalmatrix.setMatrix(row, col, columnMultiply.multiplySum());

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(e);
                    }

            }
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
