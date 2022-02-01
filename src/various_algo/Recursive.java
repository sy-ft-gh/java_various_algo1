package various_algo;

public class Recursive {
	public String label;
	public Recursive parent_item;
	public Recursive child_item;
	
	private static void printFoward(Recursive target) {
		System.out.print(target.label + " ");
		if (target.child_item != null)
			printFoward(target.child_item);
	}
	private static void printReverse(Recursive target) {
		System.out.print(target.label + " ");
		if (target.parent_item != null)
			printReverse(target.parent_item);
	}
	public static void main(String[] args) {
		Recursive rcs = new Recursive();
		Recursive calc = rcs;
		for (int i = 0; i < 100; i++) {
			calc.label = "Number:" + i;
			calc.child_item = new Recursive();
			calc.child_item.parent_item = calc;
			calc = calc.child_item;
		}
		System.out.println("‡•ûŒü");
		printFoward(rcs);
		System.out.println("");
		System.out.println("‹t•ûŒü");
		printReverse(calc);
		
	}
	
}
