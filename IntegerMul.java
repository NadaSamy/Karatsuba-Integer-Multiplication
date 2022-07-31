import java.math.BigInteger;
public class IntegerMul {
    

    public BigInteger karatsuba(BigInteger x, BigInteger y)
    {
        BigInteger base = new BigInteger("10");
        

        if( (x.compareTo(base) == -1) || (y.compareTo(base) == -1))
        {
            return x.multiply(y);
        }
        
        int length = Math.max(String.valueOf(x).length(), String.valueOf(y).length());
        int halfLength = length / 2;
        BigInteger pow1 = base.pow(halfLength);
        BigInteger pow2 = base.pow(2* halfLength);


        BigInteger x_high = x.divide(pow1);
        BigInteger x_low = x.mod(pow1);

        BigInteger y_high = y.divide(pow1);
        BigInteger y_low = y.mod(pow1);

        BigInteger z0 = karatsuba(x_low, y_low);
        BigInteger z1 = karatsuba( x_low.add(x_high), y_low.add(y_high));
        BigInteger z2 = karatsuba(x_high, y_high);

        //int fullLength = halfLength * 2;
        //int temp = (int) Math.pow(10, fullLength);
        //BigInteger BI_temp = BigInteger.valueOf(temp);

        BigInteger val0 = z2.multiply(pow2);

        BigInteger val1 = z1.subtract(z2);
        BigInteger val11 = val1.subtract(z0);
        BigInteger val1_final = val11.multiply(pow1);

        BigInteger val2 = val0.add(val1_final);
        BigInteger res = val2.add(z0);

        return res;
    }
    public static void main(String[] args) {
        IntegerMul obj = new IntegerMul();

        BigInteger x = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger y = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");

        BigInteger result = obj.karatsuba(x, y);
        System.out.println(result);
    }
}
