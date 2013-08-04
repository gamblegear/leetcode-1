public class Solution {
    public String addBinary(String a, String b) {
        String longer = a;
        String shorter = b;

        if (longer.length() < shorter.length())
        {
            longer = b;
            shorter = a;
        }

        // padding zeros 
        StringBuilder zeros = new StringBuilder();
        for (int i=0; i < longer.length() - shorter.length(); i++)
            zeros.insert(0, "0");

        shorter = zeros.toString() + shorter;

        StringBuilder s = new StringBuilder();
        boolean carry = false;
        for (int i=longer.length()-1; i>= 0; i--)
        {
            // mistake 2:  if you don't convert to toCharArray, you need charAt()
            if (longer.charAt(i) == '0' && shorter.charAt(i) == '0')
            {
                // mistake 1: string prepend function is actually insert
                if (carry)
                    s.insert(0, "1");
                else
                    s.insert(0, "0");

                carry = false;
            }
            else if (longer.charAt(i) == '1' && shorter.charAt(i) == '1')
            {
                if (carry)
                    s.insert(0, "1");
                else
                    s.insert(0, "0");

                carry = true;
            }
            else
            {
                if (carry)
                {
                    s.insert(0, "0");
                    carry = true;
                }
                else
                {
                    s.insert(0, "1");
                    carry = false;
                }
            }
        }

        if (carry)
            s.insert(0, "1");

        return s.toString();
    }
}