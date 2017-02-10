/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

import java.util.Arrays;

/**
 *
 * @author christianchavarria
 */
public class Palindrome {
    
    protected String[] basePalindrome;
    protected int position;
    protected int theNumber;
    protected int BaseLimit;
    
    /**
     *  Since the most common base conversions are from two to sixteen 
     *  I limited to until the last one, but it can be change in there
     *  (Since the arrays start at zero, is the limit is plus one).
     */
    public Palindrome(){
        this.BaseLimit = 17;
    }
    
    public int getTheNumber(){
        return theNumber;
    }
    
    public String[] getBasePalindrome(){
        return this.basePalindrome;
    }
    
    /**
     * This function will transform the desired number from base two to sixteen when the selected number is grather 
     * than sixteen; otherwise, it will tranform until the number itself
     * @param number The number in question that will be used to find the lowest base N palindrome and all the possible
     */
    
    public void getAllPalindromes(int number){
        int index, limit;
        
        this.basePalindrome = new String[this.BaseLimit];
        this.position = 0;
        this.theNumber = number;
        limit = this.basePalindrome.length;
        
        if(number < this.basePalindrome.length){
            limit = number;
        }
        
        for(index = 2; index <= limit; index++){
            this.baseNConverter(number, index); 
        }
    }
    
    /**
     * This function will transform the selected number into the specific base and add it into an array.
     * @param number The scope number to be userd to convert
     * @param base The base N to convert
     * 
     */
    public void baseNConverter(int number, int base){
        String res, out;
        int index, remainder;
        int[] digit, tmp;
        
        index = 0;
        tmp = new int[100];
        out = "";
        while(number != 0){
            remainder = number % base;
            number = number / base;
            tmp[ index ] = remainder ;
            index ++ ;
            out = out + remainder;
        }
        
        digit = new int[index];
        remainder = digit.length-1;
        for(index = 0; index < digit.length; index++){
            digit[remainder] = tmp[index];
            remainder--;
        }
        
        res = (Arrays.toString(digit)).replaceAll(",|\\[|\\]| ", "");
        if(out.equals(res)){
            this.basePalindrome[position] = "\t - " + base + " {" + res + "," + out + "}" + "\n";
            position++;
        }
        
    }
    
    /**
     * This function transform the array with all the palindromes into a most readable print
     */
    public void printPalindrome(){
        String out;
        
        out = "";
        if(this.basePalindrome[0] != null){
            out = "The lowest Base Palindrome of number " + this.theNumber + " is " + this.basePalindrome[0].replace("\t - ", "");
            
            if(!this.basePalindrome[0].equals( (Arrays.toString(this.basePalindrome)).replaceAll("\\[|\\]|null|, ", "") ) )
                out = out + "All Base palindromes are: \n" + (Arrays.toString(this.basePalindrome)).replaceAll("\\[|\\]|null|, ", "") ;
            System.out.print(out+ "**************************************************************\n");
        }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Palindrome pal;
        int limit;
        
        limit = 1000;
        pal = new Palindrome();
        for(int i = 2; i <= limit; i++){
            pal.getAllPalindromes(i);
            pal.printPalindrome();
        }
        
    }
    
}
