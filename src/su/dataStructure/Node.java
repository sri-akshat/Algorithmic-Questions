package su.dataStructure;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 1/27/13
 * Time: 2:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node implements Cloneable {

    private int level;

    public Node(Object data) {
        this.data = data;
    }

    private Object data;
    private int index;

    public Node(Integer data, int index) {
        this.data = data;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getIntData(){
        return (Integer) data;
    }

    public Node left;
    public Node right;
    public Node parent;

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public boolean isLeaf() {
        return left==null && right==null;
    }
}
