package othercollections

import java.io.File
import scala.io.Source.fromFile
import scala.io.StdIn.readLine

object UsingMaps extends App {

  case class NameInfo(
                       val gender: Char,
                       val year: Int,
                       name: String,
                       val count: Int
                     )

  val stateInfo = for (stateFile <- new File("babyNames").list(); if stateFile.endsWith(".TXT")) yield {
    val source = fromFile("babyNames/" + stateFile)
    val names = source
      .getLines()
      .filter(_.nonEmpty)
      .map(line => {
        val p = line.split(",")
        NameInfo(p(1)(0), p(2).toInt, p(3), p(4).toInt)
      }).toArray.groupBy(_.name)
    source.close()
    (stateFile.take(2), names)
  }
  var input = ""
  while (input != "quit") {
    println("What name are you interested in?")
    input = readLine()
    for ((state, info) <- stateInfo) {
      println("State " + state + " : " + info(input).maxBy(_.count))
    }
  }
}
