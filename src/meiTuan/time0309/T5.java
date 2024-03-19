package meiTuan.time0309;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T5 {


    public int find(int[] parent, int element) {
        while (element != parent[element]) {
            element = parent[element];
        }
        return element;
    }

    public boolean isConnected(int[] parent, int firstElement, int secondElement) {
        return find(parent, firstElement) == find(parent, secondElement);
    }

    public void unionElements(int[] parent, int firstElement, int secondElement) {
        int firstRoot = find(parent, firstElement);
        int secondRoot = find(parent, secondElement);
        if (firstRoot == secondRoot) {
            return;
        }
        parent[firstRoot] = secondRoot;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        


        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for


    }



}
