public class AddANumber {
    int a;
    int b;
    public static void AddANumber(int a, int b){
        int tot=a+b;
        System.out.println(tot);
    }
    public static void main (String args[]){
        AddANumber(2,5);
        AddANumber addANumber=new AddANumber();
        addANumber(3,4);
    }
    private static int addANumber(int a, int c) {
        return a+c;
    }
}
