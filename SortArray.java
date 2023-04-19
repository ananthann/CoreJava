import java.util.Arrays;

public class SortArray extends Thread {
    public void sort(int[][] arr) throws InterruptedException {

        int temp=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                Thread.sleep(2000);
                temp=arr[i][j];
                for(int k=0;k<4;k++)
                {
                    for(int l=0;l<4;l++)
                    {
                        if (arr[k][l] > temp)
                        {
                            arr[i][j] = arr[k][l];
                            arr[k][l] = temp;
                            temp = arr[i][j];
                            System.out.println();
                            for(int m=0;m<4;m++)
                            {
                                for (int n=0;n<4;n++)
                                {
                                    System.out.print(arr[m][n]+" ");
                                }
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }

    }
}