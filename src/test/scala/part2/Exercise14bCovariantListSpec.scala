package part2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Exercise14bCovariantListSpec extends AnyFlatSpec with Matchers {
  // def pair[A](h: A, t: MyList[A]): MyList[A] =
  //   MyPair(h, t)

  // def nil[A]: MyList[A] =
  //   MyNil

  // val numbers1: MyList[Int] =
  //   pair(1, pair(2, pair(3, nil)))

  // val numbers2: MyList[Int] =
  //   pair(4, pair(5, pair(6, nil)))

  // val strings1: MyList[String] =
  //   pair("foo", pair("bar", pair("baz", nil)))

  "exists" should "work as expected" in {
    pending
    // numbers1.exists(n => n < 2) should equal(true)
    // numbers1.exists(n => n < 1) should equal(false)
    // numbers1.exists(n => n > 2) should equal(true)
    // numbers1.exists(n => n > 3) should equal(false)
  }

  "map" should "work on integers" in {
    pending
    // numbers1.map(n => n + 1) should equal(pair(2, pair(3, pair(4, nil))))
    // numbers2.map(n => n + 3) should equal(pair(7, pair(8, pair(9, nil))))
    // strings1.map(s => s + "!") should equal(pair("foo!", pair("bar!", pair("baz!", nil))))
  }

  "append" should "work as expected" in {
    pending
    // nil[Int].append(nil) should equal(nil[Int])
    // nil[Int].append(numbers1) should equal(numbers1)
    // numbers1.append(nil[Int]) should equal(numbers1)
    // numbers1.append(numbers2) should equal(pair(1, pair(2, pair(3, pair(4, pair(5, pair(6, nil)))))))
  }

  "filter" should "work as expected" in {
    pending
    // numbers1.filter(n => n > 0) should equal(numbers1)
    // numbers1.filter(n => n < 0) should equal(nil)
    // numbers1.filter(n => n > 2) should equal(pair(3, nil))
    // numbers2.filter(n => n > 0) should equal(numbers2)
    // numbers2.filter(n => n < 0) should equal(nil)
    // numbers2.filter(n => n > 4) should equal(pair(5, pair(6, nil)))
    // strings1.filter(s => s.contains('b')) should equal(pair("bar", pair("baz", nil)))
  }

  "reduce" should "accumulate from left to right" in {
    pending
    // numbers1.reduce[Int](0, (a, b) => a + b) should equal(6)
    // numbers2.reduce[Int](0, (a, b) => a + b) should equal(15)
    // strings1.reduce[String]("", (a, b) => a + b) should equal("foobarbaz")
    // numbers1.reduce[String]("", (a, b) => a + b) should equal("123")
  }
}
