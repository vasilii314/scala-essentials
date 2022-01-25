package networking

import java.io.{BufferedReader, InputStreamReader, PrintStream}
import java.net.Socket
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.io.StdIn.readLine

object ChatClient extends App {
  println("Making socket")
  val socket = new Socket("localhost", 4000)
  println("Socket made")

  val in = new BufferedReader(new InputStreamReader(socket.getInputStream))
  val out = new PrintStream(socket.getOutputStream)
  var stopped = false
  Future {
    while (!stopped) {
      val input = readLine
      if (input != null) out.println(input)
    }
  }

  var input = ""

  while (input != ":quit") {
    input = in.readLine()
    println(input)
  }

  socket.close()
  stopped = true
}
