package part2

import org.scalatest._

class Exercise8aVecSpec extends FlatSpec with Matchers {
  val vec1 = new Vec(3, 4)
  val vec2 = new Vec(5, 12)

  "length" should "calculate the correct value" in {
    vec1.length should equal(5)
    vec2.length should equal(13)
  }

  "+" should "calculate the correct value" in {
    (vec1 + vec2) should equal(new Vec(8, 16))
    (vec1 + vec2).length should equal(math.sqrt(8*8 + 16*16))
  }

  "*" should "calculate the correct value" in {
    (vec1 * 10) should equal(new Vec(30, 40))
    (vec1 * 10).length should equal(50)
  }

  "zero, unitX, unitY" should "calculate the correct value" in {
    Vec.zero should equal(new Vec(0, 0))
    (Vec.unitX * 3 + Vec.unitY * 4) should equal(new Vec(3, 4))
  }

  "longest(Vec, Vec)" should "calculate the correct value" in {
    Vec.longest(vec1, vec2) should equal(vec2)
    Vec.longest(Vec.unitX * 2, Vec.unitY) should equal(Vec.unitX * 2)
  }

  "longest(List[Vec])" should "calculate the correct value" in {
    Vec.longest(List(
      Vec.unitX,
      Vec.unitX + Vec.unitY,
      Vec.unitY
    )) should equal(Vec.unitX + Vec.unitY)

    Vec.longest(Nil) should equal(Vec.zero)
  }
}
