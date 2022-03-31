object Nonogram extends App {

  val nonogram = List(
    List(0, 1, 1, 1, 1, 0),
    List(1, 0, 0, 1, 1, 1),
    List(1, 0, 1, 1, 1, 1),
    List(1, 1, 1, 1, 1, 1),
    List(0, 1, 1, 1, 1, 0))

  def checkSeq(ls: Seq[Int]): Seq[Int] = {
    ls.map(_.toString).reduce(_+_).split("0+").filter(_.nonEmpty).map(_.length)
  }


  def analyzeColumns(nonogram: Seq[Seq[Int]]) = {
    var hints = Seq.empty[Seq[Int]]
    for(i <- 0 until 6) {
      hints = hints :+ checkSeq(nonogram.map(ls => ls(i)))
    }
    hints
  }

  def analyzeRows(nonogram: Seq[Seq[Int]]) = {
    var hints = Seq.empty[Seq[Int]]
    for (l <- nonogram) {
      hints = hints :+ checkSeq(l)
    }
    hints
  }


  def finalHints(nonogram: Seq[Seq[Int]]): String = {
    var text = ""
    val columns = analyzeColumns(nonogram)
    val rows = analyzeRows(nonogram)

    columns.foreach{ column =>
      column.foreach{n => text += s"$n "}
      text += "\n"
    }

    text += "\n"

    rows.foreach{ row =>
      row.foreach{n => text += s"$n "}
      text += "\n"
    }

    text
  }
}