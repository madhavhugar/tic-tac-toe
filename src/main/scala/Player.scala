package tictactoe

/**
  * Player represents a Player of TicTacToe
  */
private class Player(val name: String, val sign: Char) {

  // Ensure at this point that the player sign is either X or O
  assert(sign.equals('X') || sign.equals('Y'))

  /** To store the state of the moves of a player, since the Board is being kept stateless*/
  private var movesList: Seq[(Int, Int)] = Seq()

  /** Updates the list of player moves*/
  def addPlayerMove(position: (Int, Int)): Unit = {
    assert(position._1 < 3 && position._2 < 3)
    movesList = position +: movesList
  }

  def getMovesList: Seq[(Int, Int)] = movesList

}