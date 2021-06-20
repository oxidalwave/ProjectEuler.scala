package com.oxidalwave.euler

import scala.io.StdIn.readLine

object Prompt {
  def apply(prompt: String): String = {
    println(prompt)
    readLine()
  }
}
