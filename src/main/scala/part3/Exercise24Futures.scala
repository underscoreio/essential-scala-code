package part3

import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

case class Stats(hostname: String, uptime: Long, requests: Int)

object Stats {
  def forHost(hostname: String): Future[Stats] = {
    for {
      u <- fetchUptime(hostname)
      r <- fetchRequestsHandled(hostname)
    } yield Stats(hostname, u, r)
  }

  def forHosts(hostnames: List[String]): Future[List[Stats]] = {
    Future.sequence(hostnames.map(forHost))
  }

  private def fetchUptime(hostname: String): Future[Long] = {
    Future {
      Thread.sleep((math.random * 100).toLong)
      hostname.hashCode % 10000L
    }
  }

  private def fetchRequestsHandled(hostname: String): Future[Int] = {
    Future {
      Thread.sleep((math.random * 100).toLong)
      hostname.reverse.hashCode % 100
    }
  }
}

object Exercise24Futures {

  def main(args: Array[String]): Unit = {
    val host1 = "alice.example.com"
    val host2 = "bob.example.com"
    val host3 = "charlie.example.com"

    println("Stats.forHost")
    println(Await.result(Stats.forHost(host1), 1.second))
    println(Await.result(Stats.forHost(host2), 1.second))
    println(Await.result(Stats.forHost(host3), 1.second))

    println("Stats.forHosts")
    println(Await.result(Stats.forHosts(List(host1, host2, host3)), 1.second))
  }
}
