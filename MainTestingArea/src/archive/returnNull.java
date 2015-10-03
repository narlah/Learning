package archive;
public class returnNull {
	public static void main(String[] args) {
		System.out.println(Myfunc().toString());
	}

	private static Object Myfunc() {
		StringBuilder builder = new StringBuilder();

		try {
			builder.append("A");
			return builder.append("B");
		} finally {
			builder = null;
		}
	}

}