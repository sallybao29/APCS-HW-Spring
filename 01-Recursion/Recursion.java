public class Recursion{
    public int fib(int n){
	if (n == 1){
	    return 1;
	}
	else if (n == 2){
	    return 1;
	}
	else{
	    return fib(n - 1) + fib(n - 2);
	}
    }

    public int len(String s){
	if (s.equals("")){
	    return 0;
	}
	else{
	    return 1 + len(s.substring(1));
	}
    }

    public int count(String s, char c){
	if (s.equals("")){
	    return 0;
	}
	else if (s.charAt(0) == c){ 
	    return 1 + count(s.substring(1), c);
	}
	else {
	    return count(s.substring(1), c);
	}
    }

    public int bunnyEars2(int bunnies){
	if (bunnies == 0){
	    return 0;
	}
	else if (bunnies % 2 == 0){
	    return 3 + bunnyEars2(bunnies - 1);
	}
	else {
	    return 2 + bunnyEars2(bunnies - 1);
	}
    }

    public int strCount(String str, String sub) {
	if (str.equals("")){
	    return 0;
	}
	else if (str.length() < sub.length()){
	    return 0;
	}
	else if (sub.equals(str.substring(0, sub.length()))){
	    return 1 + strCount(str.substring(sub.length()), sub);
	}
	else {
	    return strCount(str.substring(1), sub);
	}
    }

    public int sumDigits(int n) {
	if (n < 10){
	    return n;
	}
	else {
	    return n % 10 + sumDigits(n / 10);
	}
    }

    public String allStar(String str) {
	if (str.equals("")){
	    return "";
	}
	else if (str.length() == 1){
	    return str.charAt(0) + allStar(str.substring(1));
	}
	else {
	    return str.charAt(0) + "*" + allStar(str.substring(1));
	}
    }

    public static void main(String[] args){
	Recursion r = new Recursion();
	System.out.println(r.count("Hello", 'l'));
	System.out.println(r.count("Hello", 'a'));
    }
}
  
