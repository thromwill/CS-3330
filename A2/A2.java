
/**
 * Will Throm
 * WRTKB8
 * 18186744
 */

import java.math.*;

public class A2 {

    //Test arrays
    static int []m_Case1 = {56,48,26,185,128,49,6,155,39,51};
    static int []m_Case2 = {-29,-354,321,-168,271,-443,461};
    static int []m_Case3 = {28646,7445,28214,24359,12634,29601,29785};
    
    public static void main(String args[]) {
        
        //Create a data object for each array
        Data data1 = new Data(m_Case1);
        Data data2 = new Data(m_Case2);
        Data data3 = new Data(m_Case3);
        
        //Print the data
        System.out.println("CASE 1:");
        data1.Print();
        System.out.println("CASE 2:");
        data2.Print();
        System.out.println("CASE 3:");
        data3.Print();
    }
    
    
}




/**
 * Data Class
 * Calculates and contains statistics for an integer array
 */
class Data {
    //Array statistics
    int count, min, max, sum;
    double average;
    //BigInteger must be used for these absurdly large product values because long just isn't long enough :(
    BigInteger product;
    
    public Data(int [] array) {
        this.count = array.length;
        this.min = Min(array);
        this.max = Max(array);
        this.sum = Sum(array);
        this.product = Product(array);
        this.average = Average(this.sum, this.count);
    }
    
    /**
     * Print Method
     * Takes no parameters
     * Formats and prints each statistic within a Data object
     */
    public void Print(){
        System.out.print("Count=" + this.count);
        System.out.print(", Max=" + this.max);
        System.out.print(", Min=" + this.min);
        System.out.print(", Sum=" + this.sum);
        System.out.print(", Product=" + this.product);
        System.out.printf(", Average=%.2f\n", this.average);
    }
    
    /**
     * Min Method
     * Takes an integer array
     * Returns the minimum valued element in the array
     */
    static int Min(int [] array){
        int temp;
        int min = array[0];
        
        for(int i = 1; i < array.length; i++){
            temp = array[i];
            if(temp < min){
                min = temp;
            }
        }
        
        return min;
    }
    
    /**
     * Max Method
     * Takes an integer array
     * Returns the maximum valued element in the array
     */
    static int Max(int [] array){
        int temp;
        int max = array[0];
        
        for(int i = 1; i < array.length; i++){
            temp = array[i];
            if(temp > max){
                max = temp;
            }
        }
        
        return max;
    }
    
    /**
     * Sum Method
     * Takes an integer array
     * Returns the sum of all array elements
     */
    static int Sum(int [] array){
        int sum = 0;
        
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        
        return sum;
    }
    
    /**
     * Product Method
     * Takes an integer array
     * Returns the product of all array elements
     */
    static BigInteger Product(int [] array){
        BigInteger product = BigInteger.ONE;
        
        for(int i = 0; i < array.length; i++){
            int temp = array[i];
            product = product.multiply(BigInteger.valueOf(temp));
        }
        
        return product;
    }
    
    /**
     * Average Method
     * Takes integer sum and count values of an integer array
     * Returns the average value 
     */
    static double Average(int sum, int count){
        double average = (double)sum/count;
        return average;
    }
}