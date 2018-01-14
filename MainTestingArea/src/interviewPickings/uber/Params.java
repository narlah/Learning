package interviewPickings.uber;

import archive.TreeNode;
import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Params {
    private int sumSoFar = 0;
    private int searchFor;
    private TreeNode endNode;
    private ArrayList<TreeNode> pathSoFar;


    HashMap<TreeNode, ArrayList<ArrayList<TreeNode>>> pathsPerNode;

    public Params(TreeNode endNode, int searchFor) {
        if (pathSoFar == null) {
            this.pathSoFar = new ArrayList<>();
        }
        this.searchFor = searchFor;
        this.endNode = endNode;
        pathsPerNode = new HashMap<>();
    }

    public Params(ArrayList<TreeNode> pathSoFar, TreeNode endNode, int sumSoFar, int searchFor) { //  HashMap<TreeNode>ArrayList<ArrayList<TreeNode>>>  map
        if (pathSoFar == null) {
            this.pathSoFar = new ArrayList<>();
        } else
            this.pathSoFar = pathSoFar;
        this.sumSoFar = sumSoFar;
        this.searchFor = searchFor;
        this.endNode = endNode;
        //pathsPerNode = map;
    }

    public Params cloneToLeft() {
        return new Params(cloneArrayList(pathSoFar), pathSoFar.get(pathSoFar.size() - 1).left, sumSoFar, searchFor); // pathsPerNode
    }

    public Params cloneToRight() {
        return new Params(cloneArrayList(pathSoFar), pathSoFar.get(pathSoFar.size() - 1).right, sumSoFar, searchFor); // , pathsPerNode
    }

    public void setSumSoFar(int sumSoFar) {
        this.sumSoFar = sumSoFar;
    }

    public int getSumSoFar() {
        return sumSoFar;
    }

    public int getSearchFor() {
        return searchFor;
    }

    public TreeNode getEndNode() {
        return endNode;
    }

    public TreeNode getFirstNode() {
        TreeNode first = pathSoFar.get(0);
        if (!pathsPerNode.containsKey(first)) {
            pathsPerNode.put(first, new ArrayList<>());
        }
        return pathSoFar.get(0);
    }

    public ArrayList<TreeNode> getPathSoFar() {
        return pathSoFar;
    }

    public String getPathSoFarAsString() {
        String delim = "";
        StringBuilder sb = new StringBuilder();
        for (TreeNode pathNode : pathSoFar) {
            sb.append(delim).append(pathNode.getValue());
            delim = "->";
        }
        return sb.toString();
    }

    public ArrayList<TreeNode> cloneArrayList(List<TreeNode> list) {
        ArrayList<TreeNode> clone = new ArrayList<>(list.size());
        clone.addAll(list);
        return clone;
    }

    public boolean checkSum() {
        return sumSoFar == searchFor;
    }

    public void removeFirstNode() {
        if (pathSoFar.get(0) == null) return;
        sumSoFar -= pathSoFar.get(0).getValue();
        pathSoFar.remove(0);
    }


    public HashMap<TreeNode, ArrayList<ArrayList<TreeNode>>> getPathsPerNode() {
        return pathsPerNode;
    }

    public void setPathsPerNode(HashMap<TreeNode, ArrayList<ArrayList<TreeNode>>> pathsPerNode) {
        this.pathsPerNode = pathsPerNode;
    }
}