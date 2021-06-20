package com.oxidalwave.euler

import com.oxidalwave.euler.problem.{Problem, Problem1, Problem2}

import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}

object Euler extends App {
  println("Please select a Question:")
  val questions: Seq[Problem] = Vector(
    Problem1,
    Problem2
  )
  questions.map(q => s"${q.id}) ${q.name}").foreach(println)
  val selection = readLine()
  val question = Try(selection.toInt)

  question match {
    case Success(Problem1.id) => Problem1.solve()
    case Success(Problem2.id) => Problem2.solve()
    case Success(_) => println("Invalid ID")
    case Failure(e) => println("Could not parse ID. IDs must be integers.")
  }
}
