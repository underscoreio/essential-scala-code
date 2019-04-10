package part3

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import timing._

object Exercise24aFibonacci {
  // fib(n) is a computation of exponential complixity in terms of n.
  // - at n ~= 40 it will start taking a noticeable amount of time.
  // - at n ~= 50 it'll take an extremely long time.
  def fib(n: Int): Int =
    if(n <= 2) 1 else fib(n-1) + fib(n-2)

  def main(args: Array[String]): Unit = {
    // Step 1.
    // The computations below run in sequence.
    // Make them run in parallel.
    println("simple fibonacci calculations")
    val fibA = Time.sync("fibA")(() => fib(45))
    val fibB = Time.sync("fibB")(() => fib(45))
    val fibC = Time.sync("fibC")(() => fib(45))
    val fibD = Time.sync("fibD")(() => fib(45))

    // Step 2.
    // Find the sum of the four fibonacci numbers above
    // (ideally without blocking any threads).
  }
}