package su;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 2/20/13
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImmutableList {

    /**
     * @serial include
     *//*
    static class UnmodifiableList<E> extends UnmodifiableCollection<E>
            implements List<E> {
        static final long serialVersionUID = -283967356065247728L;
        final List<? extends E> list;

        UnmodifiableList(List<? extends E> list) {
            super(list);
            this.list = list;
        }

        public boolean equals(Object o) {return o == this || list.equals(o);}
        public int hashCode() 		{return list.hashCode();}

        public E get(int index) {return list.get(index);}
        public E set(int index, E element) {
            throw new UnsupportedOperationException();
        }
        public void add(int index, E element) {
            throw new UnsupportedOperationException();
        }
        public E remove(int index) {
            throw new UnsupportedOperationException();
        }
        public int indexOf(Object o)            {return list.indexOf(o);}
        public int lastIndexOf(Object o)        {return list.lastIndexOf(o);}
        public boolean addAll(int index, Collection<? extends E> c) {
            throw new UnsupportedOperationException();
        }
        public ListIterator<E> listIterator() 	{return listIterator(0);}

        public ListIterator<E> listIterator(final int index) {
            return new ListIterator<E>() {
                ListIterator<? extends E> i = list.listIterator(index);

                public boolean hasNext()     {return i.hasNext();}
                public E next()		     {return i.next();}
                public boolean hasPrevious() {return i.hasPrevious();}
                public E previous()	     {return i.previous();}
                public int nextIndex()       {return i.nextIndex();}
                public int previousIndex()   {return i.previousIndex();}

                public void remove() {
                    throw new UnsupportedOperationException();
                }
                public void set(E e) {
                    throw new UnsupportedOperationException();
                }
                public void add(E e) {
                    throw new UnsupportedOperationException();
                }
            };*/
}
