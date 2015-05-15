import java.util.*;

public class MinHeap{
    private ArrayList<Integer> heap;
    private int root, last;

    public MinHeap(){
	heap = new ArrayList<Integer>();
	last = -1;
    }

    public MinHeap(int size){
	heap = new ArrayList<Integer>();
	for (int i = 0;i < size; i++)
	    heap.add((int)(Math.random() * 50 + 1));
	root = heap.get(0);
	last = size - 1;
    }

    public void pushdown(int i){
	int index = i + 1;
	int tmp;
	while (index * 2 <= last &&
	       (heap.get(index - 1) > heap.get(index * 2) ||
		heap.get(index - 1) > heap.get(index * 2 - 1))){
	    tmp = heap.get(index - 1);
	    if (heap.get(index * 2) < heap.get(index * 2 - 1)){
		heap.set(index - 1, heap.get(index * 2));
		heap.set(index * 2, tmp);
		index = index * 2 + 1;
	    }
	    else {
		heap.set(index - 1, heap.get(index * 2 - 1));
		heap.set(index * 2 - 1, tmp);
		index = index * 2;
	    }
	}
	if (heap.get((last + 1) / 2) > heap.get(last)){
	    tmp = heap.get(last);
	    heap.set(last, heap.get((last + 1)/ 2));
	    heap.set((last + 1)/ 2, tmp);
	} 
    }

    public void siftup(int i){
	int index = i + 1;
	int tmp;
	while (index / 2 != 0 && 
	       heap.get(index - 1) < heap.get(index / 2 - 1)){
	    tmp = heap.get(index - 1);
	    heap.set(index - 1, heap.get(index / 2 - 1));
	    heap.set(index / 2 - 1, tmp);
	    index = index / 2 - 1;
	}
    }

    public void insert(int i){
	heap.add(i);
	last++;
	siftup(last);
    }

    public void buildHeap(){
	for (int i = last; i >= 0; i--){
	    pushdown(i);
	}
    }

    public String toString(){
	String s = "[";
	for (int i = 0; i <= last; i++){
	    s += heap.get(i);
	    if (i != last)
		s += ", ";
	}
	s += "]";
	return s;
    }

    public static void main(String[] args){
	MinHeap m = new MinHeap();
	m.insert(3);
	m.insert(8);
	m.insert(15);
	m.insert(12);
	m.insert(36);
	m.insert(18);
	m.insert(25);
	m.insert(10);
	System.out.println(m);
    }
}
