/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author christianchavarria
 */
public class PalindromeNGTest {
    
    public PalindromeNGTest() {
    }
    
    /**
     * With this dataset, the 90% of this will be passed
     * @return dataset
     */
    @DataProvider(name = "dataProvider")
    public Object[][] getTestData(){
        Object[][] data;
        
        data = new Object[10][3];
        
        data[0][0] = 2; data[0][1] = "10"; data[0][2] = 0;
        data[1][0] = 3; data[1][1] = "11"; data[1][2] = 2;
        data[2][0] = 4; data[2][1] = "11"; data[2][2] = 3;
        data[3][0] = 5; data[3][1] = "101"; data[3][2] = 2;
        data[4][0] = 6; data[4][1] = "11"; data[4][2] = 5;
        data[5][0] = 7; data[5][1] = "111"; data[5][2] = 2;
        data[6][0] = 8; data[6][1] = "22"; data[6][2] = 3;
        data[7][0] = 9; data[7][1] = "1001"; data[7][2] = 2;
        data[8][0] = 10; data[8][1] = "101"; data[8][2] = 3;
        data[9][0] = 11; data[9][1] = "11"; data[9][2] = 10;
        
        
        return data;
    }

    @Test(dataProvider = "dataProvider")
    public void testIsCorrect(int number, String palindrome, int base) {
        Assert.assertTrue(isPalindrome(number,palindrome,base), "The number " + number + " is not a palindrome");
    }
    
    private boolean isPalindrome(int number, String palindrome, int base){
        Palindrome pal;
        String test,data;
        boolean res;
        
        pal = new Palindrome();
        res = false;
        pal.getAllPalindromes(number);
        data = number + "\t - " + base + " {" + palindrome + "," + palindrome + "}\n";
        test = pal.getTheNumber() + pal.getBasePalindrome()[0];
        if(test.equals(data))
            res = true;
        
        return res;
    }
    
}
