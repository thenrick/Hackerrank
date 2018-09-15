package com.henricksen;

import java.util.Scanner;

public class NewYearChaosSolution {
	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		boolean flag = true, swapped = false;
		for (int i = q.length - 1; i >= 0; i--) {
			if (q[i] - (i + 1) > 2) {
				flag = false;
				System.out.println("Too chaotic");
				return;
			}
		}
		if (flag) {
			int swaps = 0;
			for (int i = 0; i < q.length; i++) {
				for (int j = i + 1; j < q.length; j++) {
					if (q[i] > q[j]) {
						int tmp = q[j];
						q[j] = q[i];
						q[i] = tmp;
						swaps++;
					}
				}
				if (swapped)
					swapped = false;
				else
					break;
			}
			System.out.println(swaps);
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int a0 = 0; a0 < T; a0++) {
			int n = in.nextInt();
			int q[] = new int[n];
			for (int q_i = 0; q_i < n; q_i++)
				q[q_i] = in.nextInt();

			int bribe = 0;
			boolean chaotic = false;
			for (int i = 0; i < n; i++) {
				if (q[i] - (i + 1) > 2) {
					chaotic = true;
					break;
				}
				for (int j = Math.max(0, q[i] - 2); j < i; j++)
					if (q[j] > q[i])
						bribe++;
			}
			if (chaotic)
				System.out.println("Too chaotic");
			else
				System.out.println(bribe);
		}
	}
}