/*Find all palindromic decompositions of a given string s.
A palindromic decomposition of string is a decomposition of 
the string into substrings, such that all those substrings 
are valid palindromes.
Example
Input: "abracadabra"
Output: [ "a|b|r|a|c|a|d|a|b|r|a", "a|b|r|a|c|ada|b|r|a", "a|b|r|aca|d|a|b|r|a" ]
*/

import java.util.ArrayList;
import java.util.List;

public class PalindromeDecomposition {
	static String[] generate_palindromic_decompositions(String s) {
		List<String> res = new ArrayList<>();
		dfs(s, 0, "", res);
		return res.toArray(new String[0]);
	}

	static void dfs(String s, int pos, String partial, List<String> res) {
		// base case
		if (pos == s.length()) {
			res.add(partial);
			return;
		}

		for (int i = pos; i < s.length(); ++i) {
			String prefix = s.substring(pos, i + 1);

			if (isPalin(prefix)) {
				if (pos == 0)
					dfs(s, i + 1, prefix, res);
				else
					dfs(s, i + 1, partial + "|" + prefix, res);
			}
		}
	}

	static boolean isPalin(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
}
