package various_algo;

public class Hanoi {
	public static void main (String[] args) {
		hanoi(3, 'A', 'B', 'C');
	}
	static void hanoi (int n, char x, char y, char z) {
		if (n > 0) {
			hanoi(n - 1, x, z, y);
			System.out.println(x + " to " + z);
			hanoi(n - 1, y, x, z);
		}
	}
}
