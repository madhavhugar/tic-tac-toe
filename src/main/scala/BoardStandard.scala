package tictactoe


/**
  * BoardStandard represents the standard 3X3 TicTacToe board
  */
private class BoardStandard() {

  /** A predefined standard board has 3X3 matrix */
  val board: Array[Array[Int]] = Array.ofDim[Int](3, 3)

  /** Initializes all the matix elements to 999*/
  def initializeBoard(): Unit = {
    for (i <- 0 until 3) {
      for (j <- 0 until 3) {
        board(i)(j) = 999
      }
    }
  }


  /** Console prints the board */
  def printBoard(x: Player,o: Player): Unit = {
    val xMoves = x.getMovesList
    val oMoves = o.getMovesList
    for (i <- 0 until 3) {
      for (j <- 0 until 3) {
        val currPosition: (Int, Int) = (i, j)
        if (xMoves.contains(currPosition)) {
          print(s" $x.sign ")
        }
        else if (oMoves.contains(currPosition)) {
          print(s" $o.sign ")
        }
        else {
          print("   ")
        }
        print("|")
      }
      print("---------")
    }
  }

}
