import java.util.*;

public class Selection{

    public void select(int[] l, int si, int ei){
	int pivot = l[si];
	int[] d = new int[l.length];

	//copy elements outside si and ei into new array 
	for (int a = 0; a < l.length;a++){
	    if (a < si && a > ei){
		d[a] = l[a];
	    }
	}
	//elements between si and ei
	//less than pivot, add to left side
	//greater than pivot, add to right side
	int i = si + 1;
	int end = ei;
	while (i <= end){
	    if (l[i] < pivot){
		d[si] = l[i];
		si++;
	    }
	    else{
		d[ei] = l[i];
		ei--;
	    }
	    i++;
	}
	//pivot value goes into sorted location
	d[si] = pivot;

	//System.out.println(Arrays.toString(l));
	//System.out.println(Arrays.toString(d));					  
    }

    public static void main(String[] args){
	Selection s = new Selection();
	int[] test = {15,6,9,18,4,21,2};
        s.select(test, 0, test.length - 1);
    }
}
