package LinkedLists

import org.junit._
import org.junit.Assert._

class TestLinkedList {
  var lst:MyLinkedList[Int] = null;

  @Before def makelist : Unit = {    lst = new MyLinkedList[Int]() }

  @Test def addOne: Unit =  {
    lst.insert(0,4);
    assertEquals(4,lst(0))

  }

  @Test def addTwo: Unit =  {
    lst.insert(0,8);
    lst.insert(0,9);
    //assertEquals(4,lst(2))
    assertEquals(8,lst(1))
    assertEquals(9,lst(0))
  }

  @Test def addTwoandupdate: Unit =  {
    lst.insert(0,8);
    lst.insert(0,9);
    lst(0) =123;
    lst(1) =256;
    //assertEquals(4,lst(2))
    assertEquals(256,lst(1))
    assertEquals(123,lst(0))
  }


  @Test def removetest: Unit =  {
    lst.insert(0,4);
    lst.insert(0,3);
    lst.insert(0,2);
    lst.insert(0,1);
    assertEquals(3,lst.remove(2))

    //assertEquals(4,lst(2))
    assertEquals(1,lst(0))
    assertEquals(2,lst(1))
    assertEquals(4,lst(2))

  }


}
