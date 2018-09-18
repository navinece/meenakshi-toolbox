package LinkedLists

class MyLinkedList[A] extends ListADT[A] {

  private class Node(var Data:A, var Next:Node)
  private var head:Node = null;
  private var tail:Node = null;
  private var rover:Node = null;

  def apply(index:Int):A = {
    require( index >= 0)
    var rover:Node = head;
    for ( i <- 0 until index) rover = rover.Next
    rover.Data
  }

  def update(index:Int,elem:A):Unit = {
    require( index >= 0)
    var rover:Node = head;
    for ( i <- 0 until index) rover = rover.Next
    rover.Data = elem;
  }
  def insert(index:Int,elem:A):Unit = {

    require( index >= 0);
    if (index == 0 ) {

      head = new Node(elem,head);
    }else {
      var rover: Node = head;
      for (i <- 0 until index - 1) rover = rover.Next
      rover.Next = new Node(elem, rover.Next)
    }
  }
  def remove(index:Int):A = {
    require( index >= 0)
    if (index == 0 ) {
      var ret =head.Data
      head = head.Next;
      ret
    }
    else {
      var rover: Node = head;
      for (i <- 0 until index - 1) rover = rover.Next;
      var ret = rover.Next.Data;
      rover.Next = rover.Next.Next;
      ret
    }

  }

}
