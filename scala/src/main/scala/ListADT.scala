package LinkedLists

trait ListADT[A] {

  def apply(index:Int):A
  def update(index:Int,elem:A):Unit
  def insert(index:Int,elem:A):Unit
  def remove(index:Int):A


}
