package com.oxidalwave.euler.problem

trait Problem {
  def id: Int

  def name: String

  def description: String

  def solve(): Unit
}
