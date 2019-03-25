package films

final case class Director(
  firstName: String,
  lastName: String,
  yearOfBirth: Int,
  films: List[Film]
) {
  def name: String =
    s"$firstName $lastName"
}
