package archive;
import java.util.HashMap;

public class NamesCount {
	private int count;
	private HashMap<String, Integer> counts = new HashMap<String, Integer>();

	/**
	 * Adds the name.
	 * 
	 * @param name
	 *            Name.
	 */
	public void addName(String name) {
		Integer nameCount = counts.get(name);

		if (nameCount == null) {
			counts.put(name, 1);
		} else {
			counts.put(name, ++nameCount);
		}
		count++;
	}

	/**
	 * Returns proportion of parameter name in all calls to addName.
	 * 
	 * @param name
	 *            Name.
	 * @return Double in interval [0, 1]. Returns 0 if AddName has not been
	 *         called.
	 */
	public double nameProportion(String name) {
		if (counts.get(name)==null) return 0;
		return (double) counts.get(name) / (double) count;
	}

	public static void main(String[] args) {
		NamesCount namesCount = new NamesCount();

		namesCount.addName("James");
		namesCount.addName("John");
		namesCount.addName("Mary");
		namesCount.addName("Mary");

		System.out.println("Fraction of Johns: " + namesCount.nameProportion("John"));
		System.out.println("Fraction of Johns: " + namesCount.nameProportion("Gosh"));
		System.out.println("Fraction of Marys: " + namesCount.nameProportion("Mary"));
	}
}