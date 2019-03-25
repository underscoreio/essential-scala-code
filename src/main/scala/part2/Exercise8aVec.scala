package part2

class Vec(val x: Double, val y: Double) {
  // Tip -- use `math.sqrt(n)` to calculate a square root
  def length: Double = {
    math.sqrt(x*x + y*y)
  }

  def +(that: Vec): Vec = {
    new Vec(this.x + that.x, this.y + that.y)
  }

  def *(m: Double): Vec = {
    new Vec(x * m, y * m)
  }

  override def equals(that: Any): Boolean = {
    that match {
      case that: Vec => this.x == that.x && this.y == that.y
      case _         => false
    }
  }

  override def toString: String = {
    s"Vec($x, $y)"
  }
}

object Vec {
  val zero: Vec =
    new Vec(0, 0)

  val unitX: Vec =
    new Vec(1, 0)

  val unitY: Vec =
    new Vec(0, 1)

  def longest(v1: Vec, v2: Vec): Vec =
    if(v1.length > v2.length) v1 else v2

  // Harder
  def longest(vecs: List[Vec]): Vec =
    vecs match {
      case Nil          => Vec.zero
      case head :: tail => longest(head, longest(tail))
    }

}

object Exercise8aVec {
  val vec1 = new Vec(3, 4)
  val vec2 = new Vec(5, 12)

  def main(args: Array[String]): Unit = {
    println("length")
    println(vec1.length)
    println(vec2.length)

    println("+")
    println(vec1 + vec2)
    println((vec1 + vec2).length)

    println("*")
    println(vec1 * 10)
    println((vec1 * 10).length)

    println("zero, unitX, unitY")
    println(Vec.zero)
    println(Vec.unitX * 3 + Vec.unitY * 4)

    println("longest(Vec, Vec)")
    println(Vec.longest(vec1, vec2))
    println(Vec.longest(Vec.unitX * 2, Vec.unitY))

    println("longest(List[Vec])")
    println(Vec.longest(List(Vec.unitX, Vec.unitX + Vec.unitY, Vec.unitY)))
    println(Vec.longest(Nil))
  }
}
