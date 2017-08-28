
public class LFSR{
    public static int LFSROperation (int twentyFourBitNumber){
        //getting 24th bit
        int twentyFourthBit= getNthBit(twentyFourBitNumber, 23);
        //getting 23rd bit
        int twentyThirdBit= getNthBit(twentyFourBitNumber, 22);
        //getting 22nd bit
        int twentySecondBit= getNthBit(twentyFourBitNumber, 21);
        //getting 17th bit
        int seventeenthBit= getNthBit(twentyFourBitNumber, 16);

        //Performing XOR operations
        int tempBit= twentyFourthBit^twentyThirdBit;
        tempBit=tempBit^twentySecondBit;
        tempBit=tempBit^seventeenthBit;
        //Shifting the twentyFourBitNumber by 1 and AND with 0xFFF to remove all bits above 24
        twentyFourBitNumber=(twentyFourBitNumber<<1)&(0xFFFFFF);
        //ANDing the new last bit with the twentyFourBitNumber which is shifted
        twentyFourBitNumber=(twentyFourBitNumber)|tempBit;
        //double newTwentyFourBitNumber= (double)twentyFourBitNumber;
        return twentyFourBitNumber;
    }

    public static int getNthBit(int decimal, int N){
         return ((decimal>>N)&1);
    }

    public static void main (String[] args){
        int Number= 0xa4d33d;
        //System.out.print("Initial Number is: ");
        //System.out.println(Integer.toBinaryString(initNumber));
        int counter=0;
        do{
            double tempNum= (double)Number;
            System.out.println(tempNum/(Math.pow(2,24)));
            Number= LFSROperation(Number);
            counter++;
        }while(counter<10);

    }
}
