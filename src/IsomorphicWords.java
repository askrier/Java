
public class IsomorphicWords {
	// Objective is to check how many pairs of isomorphic words there are in a given String array
	// ex. deed, sees, and toot are all isomorphic because they all have the pattern abba
	public String iso(String message) {
		// iso changes the String given to its abba equivalent so that words can be compared
		int[]chars = new int[256];
		String finale = new String();
		char[] ch = new char[message.toCharArray().length];
		ch = message.toCharArray(); // String is now a Character Array
		char letter = 'a';
				
		for(int k = 0; k < ch.length; k++) {
			if(chars[ch[k]] == 0) { // If this character has not been replaced yet
				chars[ch[k]] = letter; // Give it a replacement
				letter++; // Iterates through letters, starting at 'a'
			}
			finale += (char) chars[ch[k]]; // Replace the letter
		}
		return finale; // Return fully replaced string
	}
	
	public int countPairs(String[] words) {
        // This is the main function of the class
		int total = 0;
        
        for(int j=0; j < words.length; j += 1) { // for loops iterate through all of the possible word pairs
        	String jword = iso(words[j]); // To abba equivalent
        	for(int k=j+1; k < words.length; k += 1) { // The j+1 ensures no repeat pairs are counted
        		String kword = iso(words[k]); // To abba equivalent
        		if(jword.contentEquals(kword)) {
        			total += 1; // Counts the actual amount of isomorphic pairs
        		}
        	}
        }
        return total; // Returns # of pairs
     }
}
