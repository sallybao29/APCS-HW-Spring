import java.util.*; 

public class Mergesort2{

    public int[] mergesort(int[] data){
        int[] a = Arrays.copyOfRange(data, 0, data.length/2);
        int[] b = Arrays.copyOfRange(data, data.length/2,data.length);
	if (a.length == 1 && b.length == 1){
	    return merge(a, b);
	}
	else {
	    return merge(mergesort(a), mergesort(b));
	}
    }



    public int[] merge(int[] a, int[] b){
        int[] result = new int[a.length + b.length];
	int ai = 0;
	int bi = 0;
	int i = 0;
	while(ai < a.length || bi < b.length){    
	    if (ai == a.length){		
		result[i] = b[bi];
		bi++;
	    } 
	    else if (bi == b.length){
		result[i] = a[ai];
		ai++;
	    }
	    else if (b[bi] < a[ai]){
		result[i] = b[bi];
		bi++;
	    }
	    else{
		result[i] = a[ai];
		ai++;
	    }
	    i++;
	}
	return result;
    }

    public static void main (String args[]){
	Mergesort2 test = new Mergesort2();
        int[] a = {1,2,5,37,47};
        int[] b = {2,8,23};
	//System.out.println(Arrays.toString(test.merge(a, b)));

        int[] c = {2,55,8,23,1,14,0,46};
	System.out.println(Arrays.toString(test.mergesort(c)));
    }
}
