import java.util.*;

public class Selection{

    public int select(int[] A, int k, int l, int h){
	int li = l;
	int hi = h - 1;
	int pi = li;
	int pivot = A[pi];
	int temp;
	A[pi] = A[h];
	A[h] = pivot;
	pi = h;
	while (hi > li){
	    if (A[li] < pivot){
		li++;
	    }
	    else {
	        temp = A[li];
		A[li] = A[hi];
		A[hi] = temp;
		hi--;
	    }
	}
	if (A[li] > pivot){
	    A[pi] = A[li];
	    A[li] = pivot;
	    pi = li;
	}
	else {
	    A[pi] = A[li + 1];
	    A[li + 1] = pivot;
	    pi = li + 1;
	} 
	System.out.println(Arrays.toString(A));
	if (k == pi){
	    return A[pi];
	}
	else if (pi < k){
	    return select(A, k, l, pi - 1);
	}
	else{
	    return select(A, k, pi + 1, h);
	}   					  
    }

    public static void main(String[] args){
	Selection s = new Selection();
	int[] test = {15,6,9,18,4,21,2};
        System.out.println(s.select(test, 3, 0, test.length - 1));
    }
}
