package tictactoe

import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position


/**
  * BoardStandard represents the standard 3X3 TicTacToe board
  */
private class BoardStandard() {



  /** Both the player moves */
  var playersMovesSet: Set[(Int, Int)] = Set()


  /** Checks if the entered position is invalid or has already been taken*/
  def positionTaken(position: (Int, Int)): Boolean = {
    if(playersMovesSet.contains(position) && !(position._1 < 3 && position._2 < 3)) {
      println("Invalid or occupied position")
      true
    } else {
      playersMovesSet = playersMovesSet + position
      false
    }
  }

  /** Checks if a player has won*/
  def checkWinner(player: Player): Boolean = {
    val moves = player.getMovesList

    // Checks for row entries
      for (i <- 0 until 3) {
        var count = 0
        for (j <- 0 until 3) {
          if (moves.contains(i, j))
            count += 1
        }
        if (count == 3) return true
      }

      // Checks for column entries
      for (j <- 0 until 3) {
        var count = 0
        for (i <- 0 until 3) {
          if (moves.contains(i, j))
            count += 1
        }
        if (count == 3) return true
      }

    // Checks for diagonal entries
      var count = 0
      for (i <- 0 until 3) {
        if (moves.contains(i, i))
          count += 1
      }
      if (count == 3) return true
      count = 0
      for (i <- 0 until 3) {
        for (j <- 2 to 0) {
          if (moves.contains(i, j))
            count += 1
        }
      }
      if (count == 3) return true

    false
  }

  /** Checks for a draw between the players*/
  def checkDraw(): Boolean = {
    if(playersMovesSet.size == 9)
      true
    else
      false
  }


  /** Console prints the board */
  def printBoard(x: Player,o: Player): Unit = {
    val xMoves = x.getMovesList
    val oMoves = o.getMovesList
    for (i <- 0 until 3) {
      for (j <- 0 until 3) {
        val currPosition: (Int, Int) = (i, j)
        if (xMoves.contains(currPosition)) {
          print(s" ${x.sign} ")
        }
        else if (oMoves.contains(currPosition)) {
          print(s" ${o.sign} ")
        }
        else {
          print("   ")
        }
        if(j < 2) print("|")
      }
      println("")
      if(i < 2) println("-----------")
    }
  }

}
