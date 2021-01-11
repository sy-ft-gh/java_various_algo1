package various_algo;

public class FizzBuzz {
	
	private static void FizzBuzz1(int num) {
        for(int i = 1; i <= num; i++){
            System.out.println((i % 3 == 0 ? "Fizz" : "") + (i % 5 == 0 ? "Buzz" : i % 3 > 0 ? i : ""));
        }
	}
	private static void FizzBuzz2(int num) {
        for(int i = 1; i <= num; i++){
        	String line = String.valueOf(i);
        	if (i % 15 == 0) 
        		line = "FizzBuzz";
        	else if (i % 3 == 0) 
        		line = "Fizz";
        	else if (i % 5 == 0 ) 
        		line = "Buzz";
        	System.out.println(line);
        }
	}
    public static void main(String[] args){
        int num = 100;
        FizzBuzz2(num);
    }
}
