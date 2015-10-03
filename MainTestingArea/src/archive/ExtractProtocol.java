package archive;

//Make another version that would streamline the process - get a word, check in the array - replace if needed.
//Current solution would NOT be efficient (i think) if the text is too large - we create a new string every time we use replaceAll
//import java.util.Arrays;

public class ExtractProtocol {

	public static void main(String[] args) {
		// ***************************f6**********************************
		String str = new String("http://www.devbg.org/forum/index.php");
		//String[] resultArray = str.split("//");
		int endProtocol = str.indexOf("://");
		int endServer = str.substring(endProtocol+3).indexOf('/');
		String protocol = str.substring(0, endProtocol);
		String server= str.substring(endProtocol+3,endProtocol+3+endServer);
		String resource= str.substring(endProtocol+endServer+3);

		System.out.printf("Protocol %s , Server %s, Resource %s",protocol,server,resource);
	}

	// ***************************************************************
}
