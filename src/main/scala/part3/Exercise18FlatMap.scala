package part3

import films.{Director, Film}

object Exercise18FlatMap {
  def filmsByDirector(director: Director): List[Film] = {
    director.films
  }

  def namesOfFilmsByDirector(director: Director): List[String] = {
    director.films.map(f => f.name)
  }

  def filmsByAllDirectors(directors: List[Director]): List[Film] = {
    directors.flatMap(d => d.films)
  }

  def namesOfFilmsByAllDirectors(directors: List[Director]): List[String] = {
    directors.flatMap(d => d.films.map(f => f.name))
  }

  // Return a list of messages of the form "Tonight only! <FILM> by <DIRECTOR>!"
  def tonightOnlyMessages(directors: List[Director]): List[String] = {
    directors.flatMap(d => d.films.map(f => s"Tonight only! ${f.name} by ${d.name}!"))
  }

  def main(): Unit = {
    import films.TestData._

    println("filmsByDirector")
    println(filmsByDirector(nolan))
    println(filmsByDirector(mcTiernan))
    println(filmsByDirector(someGuy))

    println("namesOfFilmsByDirector")
    println(namesOfFilmsByDirector(nolan))
    println(namesOfFilmsByDirector(mcTiernan))
    println(namesOfFilmsByDirector(someGuy))

    println("filmsByAllDirectors")
    println(filmsByAllDirectors(List(nolan, mcTiernan)))
    println(filmsByAllDirectors(List(eastwood, someGuy)))

    println("namesOfFilmsByAllDirectors")
    println(namesOfFilmsByAllDirectors(List(nolan, mcTiernan)))
    println(namesOfFilmsByAllDirectors(List(eastwood, someGuy)))

    println("tonightOnlyMessages")
    println(tonightOnlyMessages(List(nolan, mcTiernan)))
  }
}
