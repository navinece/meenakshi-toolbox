


import org.apache.hadoop.mapred.Mapper
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

import scala.math._


object collections1 {

  def main(args : Array[String]) : Unit =  {

    val conf  = new SparkConf()
    conf.setAppName("dataset test")

    conf.setMaster("local[2]")
    val sc  = new SparkContext(conf)
    val spark = SparkSession.builder().getOrCreate()
    println(sc)

    val input_file1 ="/Users/meenakshi/data/input_file1.dat"

    val input_file_rdd = sc.textFile(input_file1,8)

    val input_file_rdd_map = input_file_rdd.map(x => x.split(",")).map( x => (x(2).toInt, x(1).toInt ) )

    println("the result of the applying function to RDD input_file_rdd_map" +
      input_file_rdd_map.collect().mkString(",") + " type of the RRD input_file_rdd_map is "+ input_file_rdd_map.collect()  )
  /*the result of the applying function to RDD input_file_rdd_map(200,80),(200,80),(500,80),(500,80),(500,80),(200,80) type of the RRD input_file_rdd_map is [Lscala.Tuple2;@47447ccf*/

    val filter = (t:(Int,  Int) )  =>  if ({t._1} == 500) true else false
    val filter1 = (t:Int ) =>  if (t  == 500) true else false

    val  input_file_rdd_filter= input_file_rdd_map.filter( filter )
/*    val  input_file_rdd_select= input_file_rdd_map.map( t => for (i <- 0 to Vector(t._1,t._2 ).length -1 )  if (  Vector(i) ==200)  )
*/
    println("the result of the applying filter function to RDD input_file_rdd_map" +
      input_file_rdd_filter.collect().mkString(",") + " type of the RRD input_file_rdd_map is "+ input_file_rdd_filter.collect()  )
/*the result of the applying filter function to RDD input_file_rdd_map(500,80),(500,80),(500,80) type of the RRD input_file_rdd_map is [Lscala.Tuple2;@148c7c4b  */
  /*  println("the result of the applying the select map function to input_file_rdd_map" +
      input_file_rdd_select.collect().mkString(",") + " type of the RDD input_file_rdd_map is "+ input_file_rdd_select.collect() )
*/
    val select1 = (t:(Int,  Int) )  =>  t._1
    val  input_file_rdd_select1 = input_file_rdd_map.map(select1)

    println("the result of the applying the select map2 function to input_file_rdd_map" +
      input_file_rdd_select1.collect().mkString(",") + " type of the RDD input_file_rdd_select1 is "+ input_file_rdd_select1.collect() )
/*the result of the applying the select map2 function to input_file_rdd_map200,200,500,500,500,200 type of the RDD input_file_rdd_select1 is [I@760cf594*/


    val input_file_rdd_map4 = input_file_rdd.map(x => x.split(",")).map( x => (x(2).toInt, x(1).toInt, x(3) ) )

    println("retrieving the website address " + input_file_rdd_map4.collect.mkString(",") + "  Rdd of type " + input_file_rdd_map4 )

    val sort = ( t:(Int,Int,String) ) => t._3
    val input_file_rdd_sort  = input_file_rdd_map4.sortBy(sort,ascending = false, numPartitions = 8)
    println("sorting by website address " + input_file_rdd_sort.collect.mkString(",") + "  Rdd of type " + input_file_rdd_sort )
  /*sorting by website address (500,80,10.01.90.185),(500,80,10.01.90.185),(200,80,10.01.90.185),(200,80,10.01.90.186),(200,80,10.01.90.187),(500,80,10.01.90.188)  Rdd of type MapPartitionsRDD[12] at sortBy at collections.scala
 /*sorting by website address (500,80,10.01.90.188),(200,80,10.01.90.187),(200,80,10.01.90.186),(500,80,10.01.90.185),(500,80,10.01.90.185),(200,80,10.01.90.185)  Rdd of type MapPartitionsRDD[12] at sortBy at collections.scala:56*/
  */

    val groupby1 = ( ( t:(Int,Int,String) ) => t._3 )
  val  input_file_rdd_group = input_file_rdd_map4.groupBy(groupby1)
    println("grouping by website address " + input_file_rdd_group.collect.mkString(",") + "  Rdd of type " + input_file_rdd_group )

/*grouping by website address (10.01.90.186,CompactBuffer((200,80,10.01.90.186))),(10.01.90.187,CompactBuffer((200,80,10.01.90.187))),(10.01.90.188,CompactBuffer((500,80,10.01.90.188))),(10.01.90.185,CompactBuffer((500,80,10.01.90.185), (500,80,10.01.90.185), (200,80,10.01.90.185)))  Rdd of type ShuffledRDD[14] at groupBy at collections.scala:63
1*/
    val agg  = ( mapper:(String,Array[String] )  ) => ( for (i <- mapper.productIterator) i.

    val  input_file_rdd_group_count_ports =input_file_rdd_group.map(  agg  )

  }

}

