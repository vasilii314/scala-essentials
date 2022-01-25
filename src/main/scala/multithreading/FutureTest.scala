package multithreading

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}
import scala.io.Source.fromURL
import scala.util.{Failure, Success}

object FutureTest extends App {

  def fib(n: Int): Int = if (n < 2) 1 else fib(n - 1) + fib(n - 2)

  println("This is first.")
  val f = Future {
    println("Printing in the future.")
//    throw new RuntimeException("Exception!")
    List(1, 2, 3, 4, 5)
  }
//  Thread.sleep(100)
  println("This is last.")

  println(Await.result(f, 5.seconds))

//  f.onComplete {
//    case Success(l) => println(l)
//    case Failure(ex) => println("Something went wrong. " + ex)
//  }


  val page1 = Future {
    "Google " + fromURL("http://www.google.com").take(100).mkString
  }

  val page2 = Future {
    "Facebook " + fromURL("http://www.facebook.com").take(100).mkString
  }

  val page3 = Future {
    "Youtube " + fromURL("http://www.youtube.com").take(100).mkString
  }

  val pages = List(page1, page2, page3)

//  val firstPage = Future.firstCompletedOf(pages)
//
//  firstPage.foreach(println)

  val allPages = Future.sequence(pages)
  allPages.foreach(println)

  Thread.sleep(5000)
}