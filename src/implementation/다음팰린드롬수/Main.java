package implementation.다음팰린드롬수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] ch = input.toCharArray();
        char[] ch1 = new char[ch.length];
        String s = "";
        for(int i=0; i<(ch.length+1)/2; i++){
            ch1[ch.length-i-1] = ch1[i] =  ch[i];
        }
        BigInteger b1 = new BigInteger(new String(ch1));
        BigInteger b2 = new BigInteger(input);
        while(true){
            if(b1.compareTo(b2)>0) break;
            b1 = palindrome(b1);
        }

        System.out.println(b1);

        br.close();
    }

    public static BigInteger palindrome(BigInteger b){
        char[] ch = b.toString().toCharArray();
        char[] ch1 = new char[ch.length];
        String s = "";
        int len = ch.length;
        for(int i=0; i<(ch.length+1)/2; i++){
            s += ch[i];
        }
        int len1  = s.length();
        s = new BigInteger(s).add(BigInteger.ONE).toString();
        int len2 = s.length();

        if(len1 + 1 == len2){
            len++;
        }
        char[] ch2 = new char[len];
        for(int i=0;i<(ch2.length+1)/2;i++){
            ch2[i] = ch2[ch2.length-i-1] = s.charAt(i);
        }

        return new BigInteger(new String(ch2));
    }

}
