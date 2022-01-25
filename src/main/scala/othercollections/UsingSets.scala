package othercollections

import java.io.File
import scala.io.Source.fromFile

object UsingSets extends App {
  val year = 2015

  val nationalData: Set[String] = {
    val source = fromFile(s"babyNames/yob$year.txt")
    val names = source.getLines().filter(_.nonEmpty).map(_.split(",")(0)).toSet
    source.close()
    names
  }

  val start = System.nanoTime()
  for (stateFile <- new File("babyNames").list(); if stateFile.endsWith(".TXT")) {
    val stateData: Int = {
      val source = fromFile("babyNames/" + stateFile)
      val names = source.getLines().filter(_.nonEmpty).map(_.split(",")).filter(a => a(2).toInt == year).map(a => a(3)).toSeq
      source.close()
      val count = names.count(n => nationalData.contains(n))
      count
    }

    println(stateFile.take(2) + " " + stateData.toDouble / nationalData.size)
  }
  println((System.nanoTime() - start) / 1e9)
}
