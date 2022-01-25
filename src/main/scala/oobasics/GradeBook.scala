package oobasics

import scala.::

object GradeBook {
  def main(args: Array[String]): Unit = {
    val students = List(new Student("Jane", "Doe"), new Student("John", "Doe"))

    students.head.quizzes.::(1)
    for (s <- students) {
      printStudent(s)
    }
  }

  def printStudent(s: Student): Unit = {
    println(s.firstName + " " + s.lastName)
    println("Grade = " + s.average)
  }
}
