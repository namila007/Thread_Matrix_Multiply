/**
 * Created by Namila on 9/23/2017.
 */
public class ColumnMultiply {

    private float[] A,B;
    private float value=0;
    public ColumnMultiply(float[] a,float[]b){
        this.A=a;
        this.B=b;


    }

    public synchronized float  multiplySum() throws ArrayIndexOutOfBoundsException{

        for(int i=0;i<A.length;i++){

                value+=A[i]*B[i];

        }
        return value;
    }

}
