import java.util.*;

public class Solution {
	public static ArrayList<Integer> getResults(int n, int k) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		if (k == 0) {
			for (int i = 1; i <= n; i++) {
				results.add(i);
			}
			return results;
		} else if (n % (2 * k) == 0) {

			int startIndex = 1;
			int endIndex = k;

			for (int j = 1; j <= n / (2 * k); j++) {
				
				for (int i = startIndex; i <= endIndex; i++) {
					results.add(i + k);
				}
				startIndex = endIndex + 1;
				endIndex += k;
				for (int i = startIndex; i <= endIndex; i++) {
					results.add(i - k);
				}
				startIndex = endIndex + 1;
				endIndex += k;
			}
			return results;
		}

		results.add(-1);
		return results;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int testCases = reader.nextInt();
		HashMap<Integer, ArrayList<Integer>> totalResults = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < testCases; i++) {
			int n = reader.nextInt();
			int k = reader.nextInt();

			ArrayList<Integer> result = getResults(n, k);
			totalResults.put(i, result);
		}

		for (Integer n : totalResults.keySet()) {
			System.out.println(totalResults.get(n).toString().replace(",", "").replace("[", "").replace("]", ""));
		}
	}
}
