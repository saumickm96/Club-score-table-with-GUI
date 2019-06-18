package pack2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Club implements Comparable<Club>{
	private int position;
	private String club;
	private int played;
	private int won;
	private int drawn;
	private int lost;
	private int conf;
	private int home;
	private int away;

public Club(int position, String club, int played, int won, int drawn,
		int lost, int conf, int home, int away)
	{
	 this.position = position;
	 this.club = club;
	 this.played = played;
	 this.won = won;
	 this.drawn = drawn;
	 this.lost = lost;
	 this.conf = conf;
	 this.home = home;
	 this.away = away;
	}

public String toString() {
return String.format("%-3d%-20s%10d%10d%10d%10d%10d", position, club, conf,
home, lost, away, won, drawn, played );
}

public int compareTo(Club c) {
 return ((Integer) conf).compareTo(c.conf);
}

public int getWon()
{
	return won;
}

public int getLost()
{
	return lost;
}
public static void main(String[] args) throws IOException
{
	List<Club> table = Arrays.asList(
	new Club(1, "Warriors", 60, 57, 1, 2, 52, 30, 27),
	new Club(2, "Nuggets", 60, 54, 0, 6, 48, 34, 20),
	new Club(3, "Trail Blazers", 60, 53, 1, 6, 42, 32, 21),
	new Club(4, "Rockets", 60, 53, 1, 6, 40, 31, 22),
	new Club(5, "Jazz", 60, 50, 2, 8, 40, 29, 21),
	new Club(6, "Thunder", 60, 50, 2, 8, 38, 27, 23),
	new Club(7, "Spurs", 60, 49, 0, 11, 36, 32, 17),
	new Club(8, "Clippers", 60, 48, 0, 12, 35, 20, 28),
	new Club(9, "Kingsr", 60, 48, 1, 11, 32, 26, 22),
	new Club(10, "Lakers", 60, 39, 1, 20, 27, 26, 13),
	new Club(11, "Timberwolves", 60, 37, 1, 22, 21, 20, 17),
	new Club(12, "Grizzlies", 60, 36, 0, 24, 11, 22, 14));
	
	
	functionalList(table);
	streamToList();
	integerStreams(table);
	reduceStream(table);
	transformStream(table);
    customisedSorting();
	processFile();
	

    }

public static void functionalList(List<Club>clist)
{
	Stream<Club>aStream = clist.stream();
	aStream.forEach(club ->System.out.println(club));

}

public static void streamToList()
{
	List<String> names = Stream.of("Warriors", "Lakers", "Trail Blazers", "Grizzlies")
			           .collect(Collectors.toList());
	//Collectors - a final class. Has methods to accumulate elements into collections
			     System.out.println("names is of type " + names.getClass().getName());
			     for(String name: names){
			       System.out.println(name);
			     }
}

public static void integerStreams(List<Club>clist)
{
	int a[] = new int [10];
	for(int x = 0; x < a.length; x++)
		a[x] = clist.get(x).won;

	   System.out.printf("%d elements \n", Arrays.stream(a).count());
	   System.out.printf("sum is %d\n", Arrays.stream(a).sum());
	   //OptionalInt - class introduced in Java 8.
	   //min instance may or may not contain an integer
	     OptionalInt min = Arrays.stream(a).min();
	     if (min.isPresent()) {
	       System.out.printf("min is %d\n", min.getAsInt());
	     } else
	     {
	       System.out.println("min failed");
	     }
}

public static void reduceStream(List<Club>clist)
{
	int a[] = new int [10];
	for(int x = 0; x < a.length; x++)
		a[x] = clist.get(x).won;

	OptionalInt i = Arrays.stream(a)
	                  .reduce((left, right) -> left + right);

	     if(i.isPresent()){
	      System.out.println("result is " + i.getAsInt());
	    }
	     else
	    {
	       System.out.println("result is not present");
	     }
  }

public static void transformStream(List<Club>clist)
{
	int a[] = new int [10];
	for(int x = 0; x < a.length; x++)
		a[x] = clist.get(x).won;

	     System.out.println("elements");
	     Arrays.stream(a).forEach(System.out::println); //x->System.out.println(x)

	     System.out.println("\ndistinct");
	     Arrays.stream(a)
	           .distinct()
	           .forEach(i -> System.out.println(i));


	     System.out.println("\nsorted");
	    Arrays.stream(a)
	           .sorted()
	           .forEach(i -> System.out.println(i));

	     System.out.println("\ndistinct sorted");
	     Arrays.stream(a)
	           .distinct()
	           .sorted()
	           .forEach(i -> System.out.println(i));
	     System.out.println("\ndistinct sorted limited");
	          Arrays.stream(a)
	                .distinct()
	                .sorted()
	                .limit(3)//?
	                .forEach(i -> System.out.println(i));

	          System.out.println("\ndistinct sorted skipped");
	          Arrays.stream(a)
	                .distinct()
	                .sorted()
	                .skip(2)//?
	              .forEach(i -> System.out.println(i));
   }

public static void customisedSorting() throws IOException
{
	URL url = Club.class.getResource("club.txt");
	File cfile = null;
	try { 
		cfile = new File (url.toURI());
	} catch (URISyntaxException e) {
		e.printStackTrace();
	}
	
	
	BufferedReader r =new BufferedReader(new FileReader(cfile));
	r.lines()
	      .sorted((a,b) -> {
	       if(a.length() == b.length())
	         return 0;
	       if(a.length() < b.length())
	            return 1;
	        return -1;
	      })
	     .forEach(l -> System.out.println(l));

	    r.close();
}

public static void processFile() throws IOException
{
	URL url = Club.class.getResource("club.txt");
	File cfile = null;
	try { 
		cfile = new File (url.toURI());
	} catch (URISyntaxException e) {
		e.printStackTrace();
	}
	

	
	BufferedReader r =new BufferedReader(new FileReader(cfile));
	System.out.println("Lines "+r.lines().count());//count number of lines
	r.lines()
		.forEach(l -> System.out.println(l));


	 r.close();

}





 }
