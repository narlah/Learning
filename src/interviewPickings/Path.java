package interviewPickings;

public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public static void main(String[] args) {
        // interviewPickings.Path path = new interviewPickings.Path("/a/b/c/d");
        Path path = new Path("/a/b/c/d");
        path.cd("../x");
        System.out.println(path.getPath());
    }

    public String getPath() {
        return path;
    }

    private void cd(String newPath) {
        if (newPath.length() < 1) return;

        if (newPath.startsWith("..") && path.length() > 2) {
            String trimmedNewPath = newPath.substring(newPath.contains("/") ? 3 : 2);
            path = this.path.substring(0, this.path.lastIndexOf("/"));
            cd(trimmedNewPath);
        } else
            path += '/' + newPath;
    }
}
