package interviewPickings.uber;

import archive.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Params {
    private int sumSoFar = 0;
    private int searchFor;
    private TreeNode endNode;
    private ArrayList<TreeNode> pathSoFar;
    private ArrayList<ArrayList<TreeNode>> result;


    public Params(TreeNode endNode, int searchFor) {
        if (pathSoFar == null) {
            this.pathSoFar = new ArrayList<>();
            this.result = new ArrayList<>();
        }
        this.searchFor = searchFor;
        this.endNode = endNode;
    }

    private Params(ArrayList<TreeNode> pathSoFar, TreeNode endNode, int sumSoFar, int searchFor, ArrayList<ArrayList<TreeNode>> result) {
        this.sumSoFar = sumSoFar;
        this.searchFor = searchFor;
        this.endNode = endNode;
        this.pathSoFar = pathSoFar;
        this.result = result;
    }

    public Params cloneToLeft() {
        return new Params(cloneArrayList(pathSoFar), pathSoFar.get(pathSoFar.size() - 1).left, sumSoFar, searchFor, result);
    }

    public Params cloneToRight() {
        return new Params(cloneArrayList(pathSoFar), pathSoFar.get(pathSoFar.size() - 1).right, sumSoFar, searchFor, result);
    }

    public void setSumSoFar(int sumSoFar) {
        this.sumSoFar = sumSoFar;
    }

    public void setSearchFor(int searchFor) {
        this.searchFor = searchFor;
    }

    public void setEndNode(TreeNode endNode) {
        this.endNode = endNode;
    }

    public void setPathSoFar(ArrayList<TreeNode> pathSoFar) {
        this.pathSoFar = pathSoFar;
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

    public ArrayList<TreeNode> getPathSoFar() {
        return pathSoFar;
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
        sumSoFar -= pathSoFar.get(0).getValue();
        pathSoFar.remove(0);
    }

    public ArrayList<ArrayList<TreeNode>> getResult() {
        return result;
    }

    public void setResult(ArrayList<ArrayList<TreeNode>> result) {
        this.result = result;
    }
}