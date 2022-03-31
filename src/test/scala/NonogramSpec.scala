import org.scalatest._
import flatspec._
import matchers._

class NonogramSpec extends AnyFlatSpec with should.Matchers {

  "Nonogram" should "read matrix of numbers and give hints about number 1 occurencies in COLUMNS" in {
    import Nonogram._
    hintsColumns should be (List(Seq(3), Seq(1, 2), Seq(1, 3), Seq(5), Seq(5), Seq(3)))
  }

  it should "read matrix of numbers and give hints about number 1 occurencies in ROWS" in {
    import Nonogram._
    hintsRows should be (List(Seq(4), Seq(1, 3), Seq(1, 4), Seq(6), Seq(4)))
  }
}