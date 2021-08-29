package activities;


public class activity12 {
	
	public static void main (String[] args)
	
	{
		Addable ad1 = (a,b) -> (a+b);
		System.out.println(ad1.add(40, 50));
	
	    Addable ad2 = (int m, int n) -> {return (m+n);
	    };
	    System.out.println(ad2.add(17, 52));
		
	}

}
