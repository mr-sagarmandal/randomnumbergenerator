
public class LCG{

    public static double LCGOperation (double twentyFourBitNumber){
        double returnVal= ((0x43fd43fd)*twentyFourBitNumber+0xc39ec3)%(Math.pow(2,24));
        returnVal=returnVal/(Math.pow(2,24));
        return returnVal;
    }

    public static void main (String[] args){
        double Number= 0xaaaa;
        double[] tossArray= new double[10000];
        for (int i=0;i<10;i++){
            Number=LCGOperation(Number);
            System.out.println(Number);
        }
    }
}
