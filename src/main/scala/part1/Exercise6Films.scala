package part1

import films.{Director, Film}

object Exercise6Films {
  // Complete the following methods.
  // The exercises value gradually more complex as you go on.
  // The idea is to practice chaining methods together.
  // You DO NOT need to reference previous answers in later ones.

  def nameOfFilm(film: Film): String = {
    film.name
  }

  def filmsByDirector(director: Director): List[Film] = {
    director.films
  }

  def directorsWithBackCatalogOfSize(directors: List[Director], numberOfFilms: Int): List[Director] = {
    directors.filter(_.films.length >= numberOfFilms)
  }

  def directorsBornBefore(directors: List[Director], year: Int): List[Director] = {
    directors.filter(_.yearOfBirth < year)
  }

  def directorsBornBeforeWithBackCatalogOfSize(directors: List[Director], year: Int, numberOfFilms: Int): List[Director] = {
    directors
      .filter(_.yearOfBirth < year)
      .filter(_.films.length >= numberOfFilms)
  }

  def namesOfFilms(films: List[Film]): List[String] = {
    films.map(f => f.name)
  }

  def namesOfFilmsByDirector(director: Director): List[String] = {
    director.films.map(f => f.name)
  }

  def namesOfFilmsByDirectorScoringAtLeast(director: Director, imdbRating: Double): List[String] = {
    director.films
      .filter(f => f.imdbRating >= imdbRating)
      .map(f => f.name)
  }
}
