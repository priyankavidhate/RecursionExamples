import java.util.ArrayList;
import java.util.List;

public class GenerateSubset {
	static String[] generate_all_subsets(String s) {
		char[] array = s.toCharArray();
		char[] result = new char[array.length];
		List<String> subsets = new ArrayList<String>();
		subsets = generate_all_subsets_helper(array, 0, result, 0, subsets);
		return subsets.toArray(new String[0]);
	}

	static List<String> generate_all_subsets_helper(char[] array, int i, char[] result, int j, List<String> subsets) {
		if (i == array.length) {
			String s = new String(result, 0, j);
			subsets.add(s);
			return subsets;
		}

		// not include the ith element
		generate_all_subsets_helper(array, i + 1, result, j, subsets);
		// include the ith element
		result[j] = array[i];
		generate_all_subsets_helper(array, i + 1, result, j + 1, subsets);

		return subsets;
	}

}
