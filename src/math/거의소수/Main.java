package math.거의소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long lowerLimit = Long.parseLong(input[0]);
        long upperLimit = Long.parseLong(input[1]);

        Set<Long> primePowers = new HashSet<>();
        long maxBase = (long) Math.sqrt(upperLimit); // 2 이상의 제곱근까지만 소수 구하면 됨
        boolean[] isPrime = sieveOfEratosthenes(maxBase);

        for (long base = 2; base <= maxBase; base++) {
            if (isPrime[(int) base]) {
                long power = base * base; // 최소 2제곱부터 시작
                int exponent = 2;

                while (power <= upperLimit) {
                    if (power >= lowerLimit) {
                        primePowers.add(power);
                    }
                    exponent++;
                    power = (long) Math.pow(base, exponent);
                }
            }
        }

        System.out.println(primePowers.size());

        br.close();
    }

    // 에라토스테네스의 체를 사용하여 주어진 범위 내의 소수를 구하는 함수
    private static boolean[] sieveOfEratosthenes(long limit) {
        boolean[] isPrime = new boolean[(int) limit + 1];
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        for (int start = 2; start * start <= limit; start++) {
            if (isPrime[start]) {
                for (int multiple = start * start; multiple <= limit; multiple += start) {
                    isPrime[multiple] = false;
                }
            }
        }

        return isPrime;
    }
}