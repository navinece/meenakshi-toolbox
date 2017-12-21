

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf,SparkContext}

object sparktest {

  def main(args : Array[String]) : Unit =  {

    val conf  = new SparkConf()
    conf.setAppName("dataset test")
    conf.setMaster("local[2]")
    val sc  = new SparkContext(conf)
    val spark = SparkSession.builder().getOrCreate()
    println(sc)


  }

}
