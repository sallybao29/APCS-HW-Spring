import java.util.*;
import java.io.*;
public class QuickSort{

    public int partition(int[] a, int l, int r) {
	int tmp;
	int pivotIndex=l;
	int pivot = a[pivotIndex];
	tmp = a[r];
	a[r] = a[pivotIndex];
	a[pivotIndex]=tmp;
				
	int wall=l;
	for (int i=l;i<r;i++) {
	    if (a[i]<pivot) {
		tmp = a[i];
		a[i]=a[wall];
		a[wall]=tmp;
		wall++;
	    }
	}
	// now copy over all the pivots
	int rwall=wall;
	tmp = a[rwall];
	a[wall]=a[r];
	a[r]=tmp;
	rwall++;
	for (int i=rwall+1;i<=r;i++) {
	    if (a[i]==pivot) {
		tmp = a[rwall];
		a[rwall]=a[i];
		a[i]=tmp;
		rwall++;
	    }
	}
	return (wall+rwall)/2;
    }

		
		
    public int[] qsort(int[] a, int l, int h){
	if (l < h){
	    int pi = partition(a,l,h);
	    qsort(a, l, pi - 1);
	    qsort(a, pi + 1, h);
	}
        return a;
    }
    public static void main(String[] args){
	QuickSort q = new QuickSort();
	int[] a = {3,2,7,29,1,3,12};
	System.out.println(Arrays.toString(a));
	System.out.println(Arrays.toString(q.qsort(a, 0, a.length - 1)));
    }
		
}
		
