package films

object TestData {
  val memento           = Film("Memento", 2000, 8.5)
  val darkKnight        = Film("Dark Knight", 2008, 9.0)
  val inception         = Film("Inception", 2010, 8.8)

  val highPlainsDrifter = Film("High Plains Drifter", 1973, 7.7)
  val outlawJoseyWales  = Film("The Outlaw Josey Wales", 1976, 7.9)
  val unforgiven        = Film("Unforgiven", 1992, 8.3)
  val granTorino        = Film("Gran Torino", 2008, 8.2)
  val invictus          = Film("Invictus", 2009, 7.4)

  val predator          = Film("Predator", 1987, 7.9)
  val dieHard           = Film("Die Hard", 1988, 8.3)
  val huntForRedOctober = Film("The Hunt for Red October", 1990, 7.6)
  val thomasCrownAffair = Film("The Thomas Crown Affair", 1999, 6.8)

  val eastwood = Director(
    "Clint",
    "Eastwood",
    1930,
    List(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus)
  )

  val mcTiernan = Director(
    "John",
    "McTiernan",
    1951,
    List(predator, dieHard, huntForRedOctober, thomasCrownAffair)
  )

  val nolan = Director(
    "Christopher",
    "Nolan",
    1970,
    List(memento, darkKnight, inception)
  )

  val someGuy = Director(
    "Just",
    "Some Guy",
    1990,
    Nil
  )

  val directors: List[Director] = List(
    someGuy,
    mcTiernan,
    nolan,
    eastwood,
  )

  val films: List[Film] = List(
    memento,
    darkKnight,
    inception,
    highPlainsDrifter,
    outlawJoseyWales,
    unforgiven,
    granTorino,
    invictus,
    predator,
    dieHard,
    huntForRedOctober,
    thomasCrownAffair,
  )
}
