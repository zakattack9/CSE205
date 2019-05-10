// Assignment #: 10
//         Name: Zak Sakata
//    StudentID: 1214985785
//  Lab Lecture: 10:30am
//  Description: A linked list is a sequence of nodes with efficient
//               element insertion and removal.
//               This class contains a subset of the methods of the
//               standard java.util.LinkedList class.

import java.util.NoSuchElementException;

public class LinkedList {
  // nested class to represent a node
  private class Node {
    public Object data;
    public Node next;
  }

  // only instance variable that points to the first node.
  private Node first;

  // Constructs an empty linked list.
  public LinkedList() {
    first = null;
  }

  // Returns the first element in the linked list.
  public Object getFirst() {
    if (first == null) {
      NoSuchElementException ex = new NoSuchElementException();
      throw ex;
    } else
      return first.data;
  }

  // Removes the first element in the linked list.
  public Object removeFirst() {
    if (first == null) {
      NoSuchElementException ex = new NoSuchElementException();
      throw ex;
    } else {
      Object element = first.data;
      first = first.next; // change the reference since it's removed.
      return element;
    }
  }

  // Adds an element to the front of the linked list.
  public void addFirst(Object element) {
    // create a new node
    Node newNode = new Node();
    newNode.data = element;
    newNode.next = first;
    // change the first reference to the new node.
    first = newNode;
  }

  // Returns an iterator for iterating through this list.
  public ListIterator listIterator() {
    return new LinkedListIterator();
  }

  /////

  // keeps track of the size of linked list without needing to loop through
  private int size = 0;

  public boolean isEmpty() {
    // Uses a ternary statement to determine if there is any elements in the list
    return first == null ? true : false;  
  }

  public void addElementAt(Object element, int index) {
    // listIterator needs to be declared in method to reset current positon
    ListIterator listIterator = this.listIterator();

    if (index <= size && index >= 0) {
      // iterates to the proper position in linked list
      for (int i = 0; i < index; i++) {
        listIterator.next();
      }
      listIterator.add(element);
      size++;
    } else {
      IndexOutOfBoundsException err = new IndexOutOfBoundsException();
      throw err;
    }
  }

  public void addSomeElementsAt(Object element, int index, int howMany) {
    ListIterator listIterator = this.listIterator();

    if (index <= size && index >= 0) {
      if (howMany > 0) {
        // iterates to specified index
        for (int i = 0; i < index; i++) {
          listIterator.next();
        }
        // adds in element "howMany" amount of times
        for (int i = 0; i < howMany; i++) {
          listIterator.add(element);
          size++;
        }
      }
    } else {
      IndexOutOfBoundsException err = new IndexOutOfBoundsException();
      throw err;
    }
  }

  public String getElement(int index) {
    ListIterator listIterator = this.listIterator();

    if (index < size && index >= 0) {
      String data = "";
      
      // needs to loop one extra time to get data at current index
      for (int i = 0; i < index + 1; i++) { 
        data = "" + listIterator.next();
      }

      return data;
    } else {
      IndexOutOfBoundsException err = new IndexOutOfBoundsException();
      throw err;
    }
  }

  public String findLargestAndRemove() {
    ListIterator listIterator = this.listIterator();
    
    if (size != 0) {
      String largest = "" + listIterator.next();
      int lastIndex = 0;

      // loops through all elements and finds the largest string and its last index
      for (int i = 0; i < size - 1; i++) {
        String temp = "" + listIterator.next(); // stored in variable to prevent iterator from moving on to next element
        if (largest.compareTo(temp) <= 0) {
          largest = temp;
          lastIndex = i;
        }
      }

      // create new iterator to start at 0
      ListIterator iterateIndex = this.listIterator();
      // loops up till the last occcurence of largest element, removes all duplicates prior
      for (int i = 0; i <= lastIndex + 1; i++) {
        String currStr = "" + iterateIndex.next();
        if (currStr.equals(largest)) {
          iterateIndex.remove();
          size--;
        }
      }

      return largest;
    } else {
      return null;
    }
  }

  public int countHowMany(Object element) {
    ListIterator listIterator = this.listIterator();
    int count = 0;

    for (int i = 0; i < size - 1; i++) {
      if (element.equals(listIterator.next())) {
        count++;
      }
    }

    // adds one to count to include itself (String) in total number of times found in list
    return count != 0 ? count + 1 : 0;
    // return count; (input1.txt disregards counting the element itself)
  }

  public void reverseLastSome(int howMany) {
    ListIterator listIterator = this.listIterator();
    ListIterator reverseIterator = this.listIterator();

    if (howMany > 0) {
      // decides the max number of objects that can be reversed given the list's length
      int maxNum = howMany > size ? size : howMany;
      // temporary array to hold items that will be reversed
      Object[] tempArr = new Object[maxNum];
      
      for (int i = 0; i < size - maxNum; i++) {
        listIterator.next();
        reverseIterator.next();
      }

      for (int i = 0; i < maxNum; i++) {
        tempArr[i] = listIterator.next();
      }

      for (int i = tempArr.length - 1; i >= 0; i--) {
        reverseIterator.next();
        reverseIterator.set(tempArr[i]);
      }
    }
  }

  public String toString() {
    ListIterator listIterator = this.listIterator();
    String strList = "{ ";

    for (int i = 0; i < size; i++) {
      strList += listIterator.next() + " ";
    }

    return strList + "}\n";
  }

  // nested class to define its iterator
  private class LinkedListIterator implements ListIterator {
    private Node position; // current position
    private Node previous; // it is used for remove() method

    // Constructs an iterator that points to the front
    // of the linked list.

    public LinkedListIterator() {
      position = null;
      previous = null;
    }

    // Tests if there is an element after the iterator position.
    public boolean hasNext() {
      if (position == null) // not traversed yet
      {
        if (first != null)
          return true;
        else
          return false;
      } else {
        if (position.next != null)
          return true;
        else
          return false;
      }
    }

    // Moves the iterator past the next element, and returns
    // the traversed element's data.
    public Object next() {
      if (!hasNext()) {
        NoSuchElementException ex = new NoSuchElementException();
        throw ex;
      } else {
        previous = position; // Remember for remove

        if (position == null)
          position = first;
        else
          position = position.next;

        return position.data;
      }
    }

    // Adds an element after the iterator position
    // and moves the iterator past the inserted element.
    public void add(Object element) {
      if (position == null) // never traversed yet
      {
        addFirst(element);
        position = first;
      } else {
        // making a new node to add
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = position.next;
        // change the link to insert the new node
        position.next = newNode;
        // move the position forward to the new node
        position = newNode;
      }
      // this means that we cannot call remove() right after add()
      previous = position;
    }

    // Removes the last traversed element. This method may
    // only be called after a call to the next() method.
    public void remove() {
      if (previous == position) // not after next() is called
      {
        IllegalStateException ex = new IllegalStateException();
        throw ex;
      } else {
        if (position == first) {
          removeFirst();
        } else {
          previous.next = position.next; // removing
        }
        // stepping back
        // this also means that remove() cannot be called twice in a row.
        position = previous;
      }
    }

    // Sets the last traversed element to a different value.
    public void set(Object element) {
      if (position == null) {
        NoSuchElementException ex = new NoSuchElementException();
        throw ex;
      } else
        position.data = element;
    }
  } // end of LinkedListIterator class
} // end of LinkedList class
