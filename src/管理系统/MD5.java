package 管理系统;


import java.math.BigInteger;

public class MD5 {

    public static String encrypt(String s){
        if(s == null)
            return "";
        if(s.length() == 0)
        {
            return "";
        } else
        {
            BigInteger biginteger = new BigInteger(s.getBytes());
            BigInteger biginteger1 = new BigInteger("142536");
            System.out.println("亦或1"+biginteger);
            System.out.println("亦或2"+biginteger1);
            BigInteger biginteger2 = biginteger1.xor(biginteger);
            return biginteger2.toString(16);
        }
    }


    public static String decrypt(String s){
        if(s == null)
            return "";
        if(s.length() == 0)
            return "";
        BigInteger biginteger = new BigInteger("hmh010329");
        try
        {
            BigInteger biginteger1 = new BigInteger(s, 16);
            BigInteger biginteger2 = biginteger1.xor(biginteger);
            return new String(biginteger2.toByteArray());
        }
        catch(Exception exception)
        {
            return "";
        }
    }



}
