import cats.effect._
import cats.implicits._

//// Constructors ////

// delay
IO.delay(1 + 2)
// apply
IO(1)
// pure
IO.pure(1)
// raiseError
IO.raiseError(new Throwable())
//// Eliminators, do not ever use in normal code! ////

// unsafeRunSync
IO(1).unsafeRunSync()
// unsafeToFuture
IO(1).unsafeToFuture()
//// Combinators ////

// map
IO(1).map(_ => 1)
// as
IO(1).as(2)
// void
IO(1).void

// mapN
(IO(1), IO(2)).mapN(_ + _)
// tupled

// flatMap
IO(1).flatMap(IO(_))
// handleErrorWith
IO.raiseError(new RuntimeException()).handleErrorWith(_ => IO(1))
// handleError
val ohNoes: IO[Int] = IO.raiseError(new RuntimeException())
ohNoes.handleError(_ => 1)
// adaptError
ohNoes.adaptError(_ => new NullPointerException())
// attempt
ohNoes.attempt