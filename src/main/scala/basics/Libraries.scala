package basics

import java.io.PrintWriter
import scala.{::, Nil}
import scala.io.StdIn.{readInt, readLine}
import scala.util.Random
import scala.io.Source

object Libraries {
  def main(args: Array[String]): Unit = {
    println("What is your name? ")
    val name = readLine()
    println("How old are you? ")
    val age = readInt()
    println(s"$name $age")

    val arr: Array[Int] = Array(9, 8, 7, 6, 5, 4, 3, 2, 1)
    val list: List[Int] = List(9, 8, 7, 6, 5, 4, 3, 2, 1)

    val rand = new Random()
    val arr = Array.fill(10)(rand.nextInt(10))
    println(arr.mkString("Array(", ", ", ")"))


    val range = 1 to 10 by 2

    println(range.)

    arr.foreach(e => println(e))

    println(arr.count(_ % 2 == 0))

    println(arr.exists(_ < 5))

    println(arr.forall(_ < 5))

    println(arr.find(_ % 4 == 0).get)

    println(arr.partition(_ < 5)._1.mkString("Array(", ", ", ")"))

    println(arr.maxBy(_ > 100))

    println("This is a test".filter(_ < 'l'))
    println("This is a test".split(" ").mkString("Array(", ", ", ")"))

    val lst = buildList()
    println(lst)
    println(concatStrings(lst))

    val Array(a, b, c) = "one, two, three".split(", ")

    println(arr.find(_ > 100).getOrElse(-1))

    val source = Source.fromFile("matrix.txt")
    val lines = source.getLines()
    val matrix = lines.map(line => line.split(" ").map(_.toDouble)).toArray
    source.close()

    val pw = new PrintWriter("rowSums.txt")
    matrix.foreach(row => pw.println(row.sum))
    pw.close()

    grade(assignments = List(45, 98), tests = List(87, 69), quizzes = List(78, 90))
  }

  def buildList(): List[String] = {
    val input = readLine()
    if (input == "quit") {
      Nil
    } else {
      input :: buildList()
    }
  }

  def concatStrings(words: List[String]): String = {
    if (words.isEmpty) "" else words.head + concatStrings(words.tail)
  }

  def grade(quizzes:List[Int], assignments:List[Int], tests:List[Double] = Nil):Any = {
    null
  }
}
