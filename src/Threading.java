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
        this.startvalB=values[2];
        this.endvalB=values[3];
    }



    @Override
    public void run() {
       // System.out.println(Thread.getName()+" running");


             System.out.println(Thread.currentThread()+"now running");

                for(int row=startvalA;row<endvalA;row++) {
                    int interestedcol=0;
                    for (int col = 0; col < B[0].length; col++) {


                            float[] rowMatrix = A[row];
                            float[] columnMatrix = getColumn(B,interestedcol++);
                             //System.out.println("row:" + row + " " + "col" + col);
                           // System.out.println(Arrays.toString(rowMatrix) + " col:" + Arrays.toString(columnMatrix));
                            columnMultiply = new ColumnMultiply(rowMatrix, columnMatrix);
                            try {
                                finalmatrix.setMatrix(row, col, columnMultiply.multiplySum());

                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println(e);
                            }



                    }
                }



    }
    /*
    public void start(){

            thread1=new Thread(this);
        System.out.println(thread1.getName()+" started");


    }
    */

    private float[] getColumn(float[][]matrix,int row){
        float[]columnMatrix=new float[matrix.length];

        for(int col=0;col<matrix.length;col++) {
            columnMatrix[col]=matrix[col][row];
        }
        return columnMatrix;
    }
}
