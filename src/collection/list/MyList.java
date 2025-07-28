package collection.list;

public interface MyList<E> {
  abstract int size();

  abstract void add(E e);

  abstract void add(int index, E e);

  abstract E get(int index);

  abstract E set(int index, E element);

  abstract E remove(int index);

  abstract int indexOf(E o);

}

/*
package collection.list;

public interface MyList<E> {

  abstract int size();

  abstract void add(E e);

  abstract void add(int index, E e);

  abstract E get(int index);

  abstract E set(int index, E element);

  abstract E remove(int index);

  abstract int indexOf(E o);

}

 */
