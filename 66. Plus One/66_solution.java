// 1
class Solution {
    public int[] plusOne(int[] digits) {  
        int multiplier  = 1;
        int i = digits.length-1;
        int result = 0;

        while(i >= 0)
        {
            digits[i] = digits[i] * multiplier ;
            result = result + digits[i];
            i--;
            multiplier  =  multiplier * 10;
        }

        result = result + 1;
        System.out.println("Sonuc "+ result);
        int number =result;
        int digitCount = 0;

        while(result>0){
            int temp = result %10;
            result = result /10;
            digitCount++;
        }
        System.out.println("Basamak Sayisi"+ digitCount);

        int[] array = new int[digitCount];
        
        int j = array.length-1; 
        while(j>=0){ 
            array[j]= number % 10; 
            number =number /10; 
            j--; 
        }

        return array; 
    }
}
// 1. Cozumum dogru ancak int turu kullandigim icin sadece kucuk sayilarla (yaklasik 9-10 basamakli) dogru calisir.
// Cunku int veri tipi en fazla 2,147,483,647 degerini tutabilir.
// digits dizisi 100 baamaga kadar cikabildiginden, bu kadar buyuk sayilar int sinirini asar (overflow hatasi).


// 2
import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {  
        BigInteger result = BigInteger.ZERO;
        BigInteger multiplier = BigInteger.ONE;

        int i = digits.length - 1;
        while (i >= 0) {
            result = result.add(BigInteger.valueOf(digits[i]).multiply(multiplier));
            i--;
            multiplier = multiplier.multiply(BigInteger.TEN);
        }

        result = result.add(BigInteger.ONE);
        System.out.println("Result: " + result);

        String resultString = result.toString();
        int digitCount = resultString.length();
        System.out.println("Digit count: " + digitCount);

        int[] array = new int[digitCount];

        for (int j = 0; j < digitCount; j++) {
            array[j] = resultString.charAt(j) - '0'; // resultString'in j. karakterini (ornegin '5') alir,
                                         // karakterin ASCII degerinden '0' karakterinin ASCII degerini cikarir.
                                         // boylece karakter sayisal degere (ornegin '5' - 5) donusturulur
                                         // ve bu deger array[j] elemanina atanir.

        }
        return array;
    }
}

// digits dizisi 100 basamakli olabilir - BigInteger bunu rahatlikla isler.
// Hicbir zaman overflow olmaz.

// 3 Carry Yontemi
class Solution {
    public int[] plusOne(int[] digits) {

        int carry = 1;

        for(int i = digits.length -1 ; i>=0 ; i--){
            int sum = digits[i] + carry ;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if(carry!= 0){
            int[] array = new int[digits.length+1];
            array[0] = carry;

            for(int j = 0; j < digits.length ; j++){
                array[j+1] = digits[j];
            }

            return array;
        }

        return digits;
    }
}

// 100 basamaga kadar olan sayilari tasma olmadan isler.
// Carry (elde) durumunu dogru yonetir; gerekirse yeni bir basamak ekler (orn. [9,9,9] -> [1,0,0,0]).
// Orijinal sayi formatini bozmaz ve gecerli bir int dizisi dondurur.