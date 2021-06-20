package com.oxidalwave.euler.problem

import com.oxidalwave.euler.Prompt

import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}

object Problem1 extends Problem {
  val id: Int = 1

  val name: String = "Multiples of 3 and 5"

  val description: String =
    """If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
      |
      |Find the sum of all the multiples of 3 or 5 below 1000.""".stripMargin

  def solve(): Unit = {
    Prompt("Would you like to use custom parameters (y/n)?").toLowerCase match {
      case "y" | "yes" => println(custom())
      case "n" | "no" => println(apply())
      case _ => println("Invalid option.")
    }
  }

  def custom(): Long = {
    // Read the multiples from cmd
    val multipleOfStr: String = Prompt("Please enter the multiples to check, separated by commas (e.g. \"3,5\")")
    val multipleOfArr = multipleOfStr.split(",")
    Try(multipleOfArr.map(_.toLong)) match {
      case Success(multipleOf: Array[Long]) =>
        // Read the max value from cmd
        val maxStr = Prompt("Please enter a maximum valid")
        Try(maxStr.toInt) match {
          case Success(max) => this(multipleOf, max)
        }
      case Failure(e) =>
        println(s"There was an invalid option given: $multipleOfStr")
        throw e
    }
  }

  def apply(multipleOf: Seq[Long] = Vector(3L, 5L), max: Long = 1000L): Long =
    (1L until max)
      .filter(i => multipleOf.exists(i.divides))
      .sum

  implicit class LongWithDivides(val num: Long) {
    /** Returns whether $num is a multiple of $divisor */
    def divides(divisor: Long): Boolean = num % divisor == 0L
  }
}
