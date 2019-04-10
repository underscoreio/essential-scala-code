package timing

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object Time {
  def sync[A](name: String)(func: () => A): A = {
    println(s"Started $name")
    val start  = System.currentTimeMillis
    val answer = func()
    val finish = System.currentTimeMillis
    println(s"Finished $name after ${finish - start}ms")
    answer
  }

  def async[A](name: String)(func: () => Future[A]): Future[A] = {
    println(s"Started $name")
    val start  = System.currentTimeMillis
    func().map { a =>
      val finish = System.currentTimeMillis
      println(s"Finished $name after ${finish - start}ms")
      a
    }
  }
}