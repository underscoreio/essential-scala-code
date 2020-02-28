package part2

case class VecB(x: Double, y: Double) {
  // Tip -- use `math.sqrt(n)` to calculate a square root
  def length: Double = {
    math.sqrt(x * x + y * y)
  }

  def +(that: VecB): VecB = {
    VecB(this.x + that.x, this.y + that.y)
  }

  def *(m: Double): VecB = {
    VecB(x * m, y * m)
  }
}

object VecB {
  val zero: VecB =
    VecB(0, 0)

  val unitX: VecB =
    VecB(1, 0)

  val unitY: VecB =
    VecB(0, 1)

  def longest(v1: VecB, v2: VecB): VecB =
    if (v1.length > v2.length) v1 else v2

  // Harder
  def longest(vecs: List[VecB]): VecB =
    vecs match {
      case Nil          => VecB.zero
      case head :: tail => longest(head, longest(tail))
    }

}

object Exercise8bVec {
  val vec1 = VecB(3, 4)
  val vec2 = VecB(5, 12)

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
    println(VecB.zero)
    println(VecB.unitX * 3 + VecB.unitY * 4)

    println("longest(Vec, Vec)")
    println(VecB.longest(vec1, vec2))
    println(VecB.longest(VecB.unitX * 2, VecB.unitY))

    println("longest(List[Vec])")
    println(VecB.longest(List(VecB.unitX, VecB.unitX + VecB.unitY, VecB.unitY)))
    println(VecB.longest(Nil))
  }
}
