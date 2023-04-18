public class SortArray extends Thread {

    public void sort(int arr[][])
    {
        int temp;
        int sorted[][] = new int[4][4];
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                 temp=arr[i][j];
                 for(int k=0;k<4;k++)
                 {
                     if(temp>arr[j][k])
                     {
                         temp=arr[j][k];
                     }
                 }

            }
        }
        for(int i=0;i<4;i++)
        {
            for (int j=0;j<4;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

