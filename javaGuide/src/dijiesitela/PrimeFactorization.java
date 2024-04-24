package dijiesitela;

import java.util.*;

public class PrimeFactorization {
    public static void main(String[] args) {
        int n = 90;

        // 求解质因子的幂次
        Map<Integer, Integer> factors = primeFactorization(n);

        // 输出质因子的幂相乘的形式
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
            int factor = entry.getKey();
            int power = entry.getValue();
            result.append(factor).append("^").append(power).append(" * ");
        }
        // 去除最后的 " * "
        result.setLength(result.length() - 3);

        System.out.println(n + " 的质因子的幂相乘的形式为：" + result.toString());
    }

    // 求解质因子的幂次
    public static Map<Integer, Integer> primeFactorization(int n) {
        Map<Integer, Integer> factors = new HashMap<>();
        // 从 2 开始找质因子
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        // 如果 n 不为 1，则 n 为最后一个质因子
        if (n > 1) {
            factors.put(n, 1);
        }
        return factors;
    }
}
