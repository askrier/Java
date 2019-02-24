
import java.util.*;

public class MemberCheck { // When ran, this code checks if anyone in a list for each club went to multiple in the same day
	public Set<String> intersection(Set<String> s1, Set<String> s2){ // Checks the intersection of the two sets
		
		Set<String> set1 = new HashSet<String>(s1);
		
		set1.retainAll(s2);
		
		return set1;
	}

	public String[] whosDishonest(String[] club1, 
            					  String[] club2, 
            					  String[] club3) {
	        
		Set<String> result = new HashSet<>();
		Set<String> s1 = new HashSet<>(Arrays.asList(club1));
		Set<String> s2 = new HashSet<>(Arrays.asList(club2));
		Set<String> s3 = new HashSet<>(Arrays.asList(club3));
	        
		result.addAll(intersection(s1, s2));
		result.addAll(intersection(s1, s3));
		result.addAll(intersection(s2, s3)); // Compiles the full list of repeats
		String[] ret = result.toArray(new String[0]);
		Arrays.sort(ret);
		
		return ret; // Returns an alphabetical list of the repeats
	}
}
