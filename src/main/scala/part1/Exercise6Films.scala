package part1

import films.{Director, Film}

object Exercise6Films:
  // Complete the following methods.
  // The exercises value gradually more complex as you go on.
  // The idea is to practice chaining methods together.
  // You DO NOT need to reference previous answers in later ones.

  def nameOfFilm(film: Film): String =
    film.name

  def filmsByDirector(director: Director): List[Film] =
    director.films

  def directorsWithBackCatalogOfSize(directors: List[Director], numberOfFilms: Int): List[Director] =
    directors.filter(_.films.length >= numberOfFilms)

  def directorsBornBefore(directors: List[Director], year: Int): List[Director] =
    directors.filter(_.yearOfBirth < year)

  def directorsBornBeforeWithBackCatalogOfSize(directors: List[Director], year: Int, numberOfFilms: Int): List[Director] =
    directors
      .filter(_.yearOfBirth < year)
      .filter(_.films.length >= numberOfFilms)

  def namesOfFilms(films: List[Film]): List[String] =
    films.map(f => f.name)

  def namesOfFilmsByDirector(director: Director): List[String] =
    director.films.map(f => f.name)

  def namesOfFilmsByDirectorScoringAtLeast(director: Director, imdbRating: Double): List[String] =
    director.films
      .filter(f => f.imdbRating >= imdbRating)
      .map(f => f.name)

  def main(): Unit =
    import films.TestData._

    println("nameOfFilm")
    println(nameOfFilm(memento))
    println(nameOfFilm(darkKnight))

    println("filmsByDirector")
    println(filmsByDirector(nolan))
    println(filmsByDirector(eastwood))

    println("directorsWithBackCatalogOfSize")
    println(directorsWithBackCatalogOfSize(directors, 1))
    println(directorsWithBackCatalogOfSize(directors, 4))
    println(directorsWithBackCatalogOfSize(directors, 5))
    println(directorsWithBackCatalogOfSize(Nil, 1))

    println("directorsBornBefore")
    println(directorsBornBefore(directors, 1930))
    println(directorsBornBefore(directors, 1931))
    println(directorsBornBefore(directors, 1951))
    println(directorsBornBefore(directors, 1952))
    println(directorsBornBefore(Nil, 2000))

    println("directorsBornBeforeWithBackCatalogOfSize")
    println(directorsBornBeforeWithBackCatalogOfSize(directors, 1931, 5))
    println(directorsBornBeforeWithBackCatalogOfSize(directors, 1931, 6))
    println(directorsBornBeforeWithBackCatalogOfSize(directors, 1930, 5))
    println(directorsBornBeforeWithBackCatalogOfSize(Nil, 2000, 1))

    println("namesOfFilms")
    println(namesOfFilms(List(memento, darkKnight)))
    println(namesOfFilms(Nil))

    println("namesOfFilmsByDirector")
    println(namesOfFilmsByDirector(nolan))
    println(namesOfFilmsByDirector(eastwood))
    println(namesOfFilmsByDirector(someGuy))

    println("namesOfFilmsByDirectorScoringAtLeast")
    println(namesOfFilmsByDirectorScoringAtLeast(nolan, 8.8))
    println(namesOfFilmsByDirectorScoringAtLeast(nolan, 8.9))
    println(namesOfFilmsByDirectorScoringAtLeast(someGuy, 0.0))
