package Core;

/**
 * Created by Namila on 9/23/2017.
 */
public class MatrixData {
    public float[][]matrix;
    public MatrixData(int m,int n){
        matrix=new float[m][n];
    }

    public float[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int row,int col,float val) {
        this.matrix[row][col]=val;
    }
}
