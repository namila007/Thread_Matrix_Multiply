package Core;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Namila on 9/24/2017.
 */
public class ControlMatrix  {
    private float[][] A,B;
    private MatrixData finalmatrix;
    private Thread [] threads;
    private int threadcount;


    public ControlMatrix(int threadcount,float[][] A,float[][] B, MatrixData finalmatrix){
        this.A=A;
        this.B=B;
        this.finalmatrix=finalmatrix;
        this.threadcount=threadcount;

    }
    public void executeThreads() throws NullPointerException{
        int i=0;
        int Alength=0;
        Alength=A.length/threadcount;//size of the rows


        threads=new Thread[threadcount];

        for(i=0;i<threadcount-1;i++){
            //starting objects
            threads[i]=new Thread(new Threading(A,B,finalmatrix,new int[]{i*Alength,(i+1)*Alength}));
        }
        threads[i]=new Thread(new Threading(A,B,finalmatrix,new int[]{i*Alength,A.length}));
        try {
            for(Thread k:threads){
                k.start();
            }
            for(Thread k:threads){
               k.join();
          }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    public void writeMatrixData(BufferedWriter bw) throws IOException{
        bw.write(finalmatrix.getMatrix().length+"");
        bw.newLine();
        bw.write(finalmatrix.getMatrix()[0].length+"");
        bw.newLine();
        for(int m=0;m<finalmatrix.getMatrix().length;m++){
            for(int n=0;n<finalmatrix.getMatrix()[0].length;n++){
                bw.write(String.format("%.4f",finalmatrix.getMatrix()[m][n]));
                bw.newLine();
            }

        }

    }



}
