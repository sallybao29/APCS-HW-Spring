import java.util.*;

public class MinHeap{
    private int[] heap;
    private int root, last;

    public MinHeap(){
	this(20);
    }

    public MinHeap(int size){
	heap = new int[size];
	for (int i = 0;i < size; i++)
	    heap[i] = (int)(Math.random() * 50 + 1);
	root = heap[0];
	last = size - 1;
    }

    public void pushdown(int i){
	int index = i + 1;
	int tmp;
	while (index * 2 <= last &&
	       (heap[index - 1] > heap[index * 2] ||
		heap[index - 1] > heap[index * 2 - 1])){
	    tmp = heap[index - 1];
	    if (heap[index * 2] < heap[index * 2 - 1]){
		heap[index - 1] = heap[index * 2];
		heap[index * 2] = tmp;
		index *= 2 + 1;
	    }
	    else {
		heap[index - 1] = heap[index * 2 - 1];
		heap[index * 2 - 1] = tmp;
		index = index * 2;
	    }
	}
    }

    public void buildHeap(){
	for (int i = last; i >= 0; i--){
	    pushdown(i);
	}
    }

    public String toString(){
	String s = "[";
	for (int i = 0; i <= last; i++){
	    s += heap[i];
	    if (i != last)
		s += ", ";
	}
	s += "]";
	return s;
    }

    public static void main(String[] args){
	MinHeap m = new MinHeap(10);
	System.out.println(m);
	m.buildHeap();
	System.out.println(m);
    }
}
