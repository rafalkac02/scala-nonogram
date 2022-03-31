object Nonogram extends App {

  def hint(ls: Seq[Int]): Seq[Int] = {
    ls.map(_.toString).reduce(_+_).split("0+").filter(_.nonEmpty).map(_.length)
  }

  val nonogram = List(
    List(0, 1, 1, 1, 1, 0),
    List(1, 0, 0, 1, 1, 1),
    List(1, 0, 1, 1, 1, 1),
    List(1, 1, 1, 1, 1, 1),
    List(0, 1, 1, 1, 1, 0))

  // columns
  var hintsColumns = List.empty[Seq[Int]]
  for(i <- 0 until 6) {
    hintsColumns = hintsColumns :+ hint(nonogram.map(ls => ls(i)))
  }

  // rows
  var hintsRows = List.empty[Seq[Int]]
  for (l <- nonogram) {
    hintsRows = hintsRows :+ hint(l)
  }


  // print hints
  hintsColumns.foreach{ seq =>
    seq.foreach(n => print(s"$n "))
    println()
  }
  println()
  hintsRows.foreach{ seq =>
    seq.foreach(n => print(s"$n "))
    println()
  }
}