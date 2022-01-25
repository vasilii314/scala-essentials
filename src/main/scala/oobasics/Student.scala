package oobasics

class Student(
             val firstName: String,
             val lastName: String,
             private var _quizzes: List[Int] = Nil,
             private var _assignments: List[Int] = Nil,
             private var _tests: List[Int] = Nil
             ) {

  private def validGrade(grade: Int): Boolean = grade >= -20 && grade <= 120

  def addQuiz(grade: Int): Unit = {
    if (validGrade(grade)) {
      _quizzes ::= grade
      true
    } else false
  }

  def testAverage: Double = if (_tests.isEmpty) 0.0 else _tests.sum.toDouble / _tests.length

  def assignmentAverage: Double = if (_assignments.isEmpty) 0.0 else _assignments.sum.toDouble / _assignments.length

  def quizAverage: Double = if (_quizzes.isEmpty) 0.0
    else if (_quizzes.length == 1) _quizzes.head
    else (_quizzes.sum - _quizzes.min).toDouble / _quizzes.length

  def average: Double = quizAverage * 0.1 + assignmentAverage * 0.5 + testAverage * 0.6

  def quizzes:List[Int] = _quizzes

  def assignments:List[Int] = _assignments
}
