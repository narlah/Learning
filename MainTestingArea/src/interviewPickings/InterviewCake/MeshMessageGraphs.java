package interviewPickings.InterviewCake;

import java.util.*;

public class MeshMessageGraphs {

    public static void main(String[] args) {
        MeshMessageGraphs mesh = new MeshMessageGraphs();
        Map<String, String[]> network = new HashMap<>() {{
            put("Min", new String[]{"William", "Jayden", "Omar"});
            put("William", new String[]{"Min", "Noam"});
            put("Jayden", new String[]{"Min", "Amelia", "Ren", "Noam"});
            put("Ren", new String[]{"Jayden", "Omar"});
            put("Amelia", new String[]{"Jayden", "Adam", "Miguel"});
            put("Adam", new String[]{"Amelia", "Miguel", "Sofia", "Lucas"});
            put("Miguel", new String[]{"Amelia", "Adam", "Liam", "Nathan"});
        }};

        System.out.println(Arrays.toString(mesh.mesh(network, "Jayden", "Adam").toArray())); //expected { "Jayden", "Amelia", "Adam" }
        System.out.println(Arrays.toString(mesh.mesh(network, "Jayden", "Liam").toArray()));
    }

    private List<String> mesh(Map<String, String[]> map, String sender, String ender) {
        Queue<String> queue = new LinkedList<>();
        queue.add(sender);
        HashMap<String, ArrayList<String>> paths = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        paths.put(sender, new ArrayList(List.of(sender)));
        String current;
        while (!queue.isEmpty()) {
            current = queue.remove();
            visited.add(current);
            if (current.equals(ender)) {
                return paths.get(ender);
            }
            String[] childs = map.containsKey(current) ? map.get(current) : new String[]{};
            for (String child : childs) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    ArrayList<String> newPath = new ArrayList<>(paths.get(current));
                    newPath.add(child);
                    paths.put(child, newPath);
                    queue.add(child);
                }
            }
        }
        return Collections.emptyList();
    }
}
