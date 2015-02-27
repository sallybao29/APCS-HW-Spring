import java.util.*; 

public class Mergesort{

    public ArrayList<Integer> mergesort(ArrayList<Integer> data){
        ArrayList<Integer> a = new ArrayList<Integer>(data.subList(0,data.size()/2));
	ArrayList<Integer> b = new ArrayList<Integer>(data.subList(data.size()/2,data.size()));
	if (a.size() == 1 && b.size() == 1){
	    return merge(a, b);
	}
	else {
	    return merge(mergesort(a), mergesort(b));
	}
    }


    public ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
	ArrayList<Integer> result = new ArrayList<Integer>();
	while(a.size() > 0 || b.size() > 0){    
	    if (a.size() <= 0){
		result.add(b.remove(0));
	    } 
	    else  if (b.size() <= 0){
		result.add(a.remove(0));
	    }
	    else if (a.get(0) > b.get(0)){
		result.add(b.remove(0));
	    }
	    else {
		result.add(a.remove(0));
	    }
	}
	return result;
    }

    public static void main (String args[]){
	Mergesort test = new Mergesort();
	//ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,5,37,47));
	//ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(2,8,23));
	//System.out.println(test.merge(a, b));

	ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(2,55,8,23,1,14,0,46));
	System.out.println(test.mergesort(b));
    }
}
