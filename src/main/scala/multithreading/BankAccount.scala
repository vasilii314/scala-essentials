package multithreading

import scala.collection.parallel.CollectionConverters._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class BankAccount(private var _balance: Int) {
  def balance:Int = _balance

  def deposit(amount: Int): Boolean = this.synchronized {
    if (amount < 0) false
    else {
      _balance += amount
      true
    }
  }

  def withdraw(amount: Int): Boolean = this.synchronized {
    if (amount < 0 || amount > _balance) false
    else {
      _balance -= amount
      true
    }
  }
}

object BankAccount extends App {
  val account = new BankAccount(0)
  for (i <- (1 to 1000000).par) {
    account.deposit(i)
  }
  println(account.balance)

  var count =0

  Future {
    for (i <- 1 to 1000000) count += 1
  }

  Future {
    for (i <- 1 to 1000000) count += 1
  }

  Thread.sleep(100)
  println(count)

  import collection.mutable
  var b1 = mutable.Buffer[String]()
  var b2 = mutable.Buffer[String]()

  def work(count: Int): Unit = {
    Thread.sleep(count)
  }

  def useBuffers(buf1: mutable.Buffer[String], buf2: mutable.Buffer[String]): Unit = {
    buf1.synchronized {
      work(1000)
      buf2.synchronized {
        work(1000)
      }
    }
  }

  Future {
    useBuffers(b1, b2)
  }.foreach(_ => println("Call 1 done."))

  Future {
    useBuffers(b2, b1)
  }.foreach(_ => println("Call 2 done."))

  Thread.sleep(3000)
  println("Main done")
}
