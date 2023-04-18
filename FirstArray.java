import java.util.Random;

public class FirstArray {
    int[][] array = new int[4][4];

    public int[][] createArray() {
        for(int i=0;i<4;i++)
        {
            for (int j=0;j<4;j++){
                Random rand = new Random();
                array[i][j]=rand.nextInt(100) + 1;
            }
        }
        for(int i=0;i<4;i++)
        {
            for (int j=0;j<4;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        return array;
    }


    public static void main(String args[]) throws InterruptedException {
        FirstArray f1=new FirstArray();
        SortArray s1=new SortArray();
        s1.sort(f1.createArray());
    }
}
