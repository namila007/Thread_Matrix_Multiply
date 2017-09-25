import java.util.Arrays;

/**
 * Created by Namila on 9/24/2017.
 */
public class ControlMatrix  {
    private float[][] A,B;
    private MatrixData finalmatrix;
    private Threading threading1,threading2;
    private int []rangeValues1,rangeValues2;


    public ControlMatrix(float[][] A,float[][] B, MatrixData finalmatrix){
        int Alength=A.length,Blength=B[0].length;
        this.A=A;
        this.B=B;
        this.finalmatrix=finalmatrix;
        if(A.length%2!=0 )Alength=A.length+1;
        if(B[0].length%2!=0)Blength=B[0].length+1;

        rangeValues1=new int[]{0,A.length/2,0,B[0].length/2};
        rangeValues2=new int[]{A.length/2,Alength,B[0].length/2,Blength};

        System.out.println(Arrays.toString(rangeValues1)+" ee "+Arrays.toString(rangeValues2));

    }
    void executeThreads(){
        Thread t1=new Thread(new Threading(A,B,finalmatrix,rangeValues1));
        Thread t2=new Thread(new Threading(A,B,finalmatrix,rangeValues2));
        //threading1=new Threading(A,B,finalmatrix,rangeValues1);
        //threading2=new Threading(A,B,finalmatrix,rangeValues2);
        //threading1.start();
       // threading2.start();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // threading1.run();
        //threading2.run();

    }




}
