package su.dataStructure;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 1/27/13
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Stack<T> {

    public Stack(int size) {
        this.maxSize = size;
        this.size = 0;
        this.top = null;
    }

    private Link top;
    private int maxSize;
    private int size;

    public void push(T data){
        if(size < maxSize){
            if(top == null){
                top = new Link(data);
            }else{
                top.next = new Link(data);
                top.next.previous = top;
                top = top.next;
                top.next = null;
            }
            size++;
        }else{
            throw new RuntimeException("stack max size reached !!");
        }
    }

    public T pop(){
        if(size > 0){
            T element = (T) top.getData();
            top = top.previous;
            if(top != null){
                top.next = null;
            }
            size--;
            return element;
        }else{
            throw new RuntimeException("stack is empty, nothing to pop !!");
        }
    }

    public boolean isEmpty() {
        return this.size == 0;  //To change body of created methods use File | Settings | File Templates.
    }
}
