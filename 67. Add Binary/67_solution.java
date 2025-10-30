class Solution {
    public String addBinary(String a, String b) {

        int carry = 0;
        int aindex = a.length()-1;
        int bindex = b.length()-1;

        StringBuilder result = new StringBuilder();

        System.out.println("a index: " + aindex);
        System.out.println("b index: " + bindex);
        
        while (aindex >=0 || bindex>= 0 || carry > 0) {
            int sum = carry;
            if (aindex >=0 )
            {
                if (a.charAt(aindex) == '1')
                {
                    sum += 1;
                    aindex--;
                }
                else{
                    sum += 0;
                    aindex--;
                }
            }
            if (bindex>= 0)
            {
                if (b.charAt(bindex) == '1')
                {
                    sum += 1;
                    bindex--;
                }
                else{
                    sum += 0;
                    bindex--;
                }
            }

            int temp = sum % 2;
            carry = sum / 2 ;
            result.append(temp);

        }
        return result.reverse().toString();
    }

}