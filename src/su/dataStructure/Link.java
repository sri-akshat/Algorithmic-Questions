package su.dataStructure;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 1/27/13
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Link<T> {

    private T data;

    public Link(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }

    public Link(T data){
        this.data = data;
    }

    private int number;
    private int frequency;
    public Link next = null;
    public Link previous = null;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String toString(Link header) {
        StringBuilder sb = new StringBuilder();
        Link current = header;
        while(current!=null){
            for(int i=0;i<current.frequency;i++){
                sb.append(current.number+",");
            }
            current = current.next;
        }
        return sb.toString();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
