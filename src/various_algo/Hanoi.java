package various_algo;

public class Hanoi {
	public static void main (String[] args) {
		hanoi(3, 'A', 'B', 'C');
	}
	static void hanoi (int n, char from, char work, char to) {
		if (n > 0) {
			hanoi(n - 1, from, to, work);
			System.out.println(from + " to " + to + "(disk:" + n + ")");
			hanoi(n - 1, work, from, to);
		}
	}
}
