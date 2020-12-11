
import java.util.*;

public class FindDestinationGraph {

	public static void main(String[] args) {
		Solution sol = new Solution();

		// Test Case #1
		ArrayList<List<String>> routes = new ArrayList<List<String>>();
		routes.add(Arrays.asList("C", "D"));
		System.out.println(sol.getDestination(routes)=="D");

		// Test Case #2
		routes = new ArrayList<List<String>>();
		System.out.println(sol.getDestination(routes)==null);
		
		// Test Case #3
		routes = new ArrayList<List<String>>();
		routes.add(Arrays.asList("X", "Y"));
		routes.add(Arrays.asList("Y", "K"));
		System.out.println(sol.getDestination(routes)=="K");

		// Test Case #4
		routes = new ArrayList<List<String>>();
		routes.add(Arrays.asList("X", "Y"));
		routes.add(Arrays.asList("Y", "K"));
		routes.add(Arrays.asList("K", "W"));
		routes.add(Arrays.asList("W", "Z"));
		routes.add(Arrays.asList("Z", "A"));
		System.out.println(sol.getDestination(routes)=="A");

		// Test Case #5
		routes = new ArrayList<List<String>>();
		routes.add(Arrays.asList("X", "Y"));
		routes.add(Arrays.asList("Y", "K"));
		routes.add(Arrays.asList("K", "W"));
		routes.add(Arrays.asList("W", "Z"));
		System.out.println(sol.getDestination(routes)=="Z");

		//Test Case #6
		routes = new ArrayList<List<String>>();
		routes.add(Arrays.asList("X", "Y"));
		routes.add(Arrays.asList("Y", "K"));
		routes.add(Arrays.asList("K", "W"));
		routes.add(Arrays.asList("W", "Z"));
		routes.add(Arrays.asList("A", "K"));
		routes.add(Arrays.asList("B", "W"));
		routes.add(Arrays.asList("C", "Y"));
		System.out.println(sol.getDestination(routes)=="Z");
}
}

class Solution {
	private Map<String, List<String>> towns = new HashMap<String, List<String>>();

	/*
	 * PURPOSE:
	 *		Add new town to HashMap towns.
	 * PARAMETER:
	 *		String vertex, if towns doesn't have a same name of town, make new map with town name.
	 */
	private void add(String vertex) {
		if (!towns.containsKey(vertex))
			towns.put(vertex, new ArrayList<String>());
	}

	/*
	 * PURPOSE:
	 *		Add town and outdegree to town's String List.
	 * PARAMETER:
	 *		String from, starting town 
	 *		String to, destination town
	 */
	private void addOutdegree(String from, String to) {
		this.add(from);
		this.add(to);
		towns.get(from).add(to);
	}

	/*
	 * PURPOSE:
	 *		Get every possible outdegrees of towns.
	 * RETURN:
	 *		Map<String, Integer> result, return a map with every town with possible number of outdegrees.
	 */
	private Map<String, Integer> getOutdegree() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (String vertex : towns.keySet())
			result.put(vertex, towns.get(vertex).size());
		return result;
	}

	/*
	 * PURPOSE:
	 *		Get the town that has no outdegrees.
	 * PARAMETERS:
	 *		List<List<String>> routes, List of possible routes. 
	 * RETURN:
	 *		Return the destination town that has no outdegrees.	
	 */
	public String getDestination(List<List<String>> routes) {
		String result = null;
		for (List<String> route : routes) {
			this.addOutdegree(route.get(0), route.get(1));
		}
		Map<String, Integer> outDegree = this.getOutdegree();
		for (Map.Entry<String, Integer> entry : outDegree.entrySet()) {
			if (entry.getValue() == 0) {
				result = entry.getKey();
			}
		}
		towns = new HashMap<String, List<String>>();
		return result;
	}
}
