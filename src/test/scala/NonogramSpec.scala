import org.scalatest._
import flatspec._
import matchers._
import Nonogram._

class NonogramSpec extends AnyFlatSpec with should.Matchers {

  val nonogram = List(
    List(0, 1, 1, 1, 1, 0),
    List(1, 0, 0, 1, 1, 1),
    List(1, 0, 1, 1, 1, 1),
    List(1, 1, 1, 1, 1, 1),
    List(0, 1, 1, 1, 1, 0))

  "Function checkSeq()" should "take seq of zeros and ones and output seq of integers for occurrences of ones in each series" in {
    checkSeq(Seq(0, 0, 1, 0, 1, 1, 1, 0, 0, 0)) should be (Seq(1, 3))
    checkSeq(Seq(0, 0, 0)) should be (Seq.empty[Int])
    checkSeq(Seq(0, 1, 0)) should be (Seq(1))
    checkSeq(Seq(1, 1, 1, 1, 1)) should be (Seq(5))
    checkSeq(nonogram(1)) should be (Seq(1, 3))
  }

    "Function analyzeColumns()" should "output checkSeq() results for all columns" in {
    analyzeColumns(nonogram) should be (Seq(Seq(3), Seq(1, 2), Seq(1, 3), Seq(5), Seq(5), Seq(3)))
  }

    "Function analyzeRows()" should "output checkSeq() results for all rows" in {
    analyzeRows(nonogram) should be (List(Seq(4), Seq(1, 3), Seq(1, 4), Seq(6), Seq(4)))
  }

    "Function finalHints()" should "output checkSeq() results for all rows" in {
    finalHints(nonogram) should be ("3\n1 2\n1 3\n5\n5\n3\n\n4\n1 3\n1 4\n6\n4")
  }

}