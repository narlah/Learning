public class Path {
	private String path;

	public Path(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public Path cd(String newPath) {
		if (newPath.equals("") || newPath.equals(" ") || (newPath.startsWith("..") && this.path.length() == 1))
			return this;
		if (newPath.equals("..") && path.length() > 1) {
			return new Path(this.path.substring(0, this.path.lastIndexOf("/"))); // removed
		}
		if (newPath.startsWith("..")) {
			String str = newPath.substring(3); // without the ../
			String trim = this.path.substring(0, this.path.lastIndexOf("/")); // removed
			return new Path(trim + "/" + str);
			//recursiveGo(newPath);
			//return new Path(this.path);
		} else {
			if (this.path.length() == 1) {
				return new Path(this.path.concat(newPath));
			} else
				return new Path(this.path.concat("/" + newPath));
		}

	}
private void recursiveGo(String newPath){
	if (newPath.equals("") || newPath.length()<=1) return;
	
	if (newPath.startsWith("../") && newPath.length()>3 && path.length()>2){
		int firstDash = newPath.substring(3).indexOf('/')-1;
		String str = newPath.substring(3,firstDash); 
		String trim = this.path.substring(0, this.path.lastIndexOf("/"));
		this.path = trim + "/" + str;
		recursiveGo(newPath.substring(3, firstDash));
	}
	
}
	public static void main(String[] args) {
		// Path path = new Path("/a/b/c/d");
		Path path = new Path("/");
		System.out.println(path.cd("x").getPath());
	}
}