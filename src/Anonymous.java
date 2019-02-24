
public class Anonymous { // Tries to see if a message can be made (not case sensitive) from the letters provided
	public int howMany(String[] headlines, String[] messages) {
        int counts[] = new int[256];
        //System.out.print(counts[255]);
        for(String s : headlines) { // Establishes all the given letters 
        	for(char ch : s.toLowerCase().toCharArray()) {
        		if (ch == ' ') continue; // Ignore spaces
        		counts[ch] = counts[ch] + 1;
        	}
        }
        boolean success = true;
        int counter = 0;
        int ccopy[] = counts.clone();
        for(String t : messages) { // Checks how many letters are needed
        	for(char nch : t.toLowerCase().toCharArray()) {
        		if (nch == ' ') continue; // Ignore spaces
        		counts[nch] = counts[nch] - 1; // Keep track of how many are used of each letter
        		//System.out.print(counts[nch]);
        		if (counts[nch] < 0) {
        			success = false;
        			break; // If you run out of letters, it doesn't work
        		}
        		//System.out.print("\n");
        	}
        	//System.out.println(t);
        	if (success) {
        		//System.out.println(t);
        		counter++;
        	}
        	success = true;
        	counts = ccopy.clone(); // Resets counts with the copy made earlier
        }
        //System.out.print("\n\n");
        return counter;
  }
}
