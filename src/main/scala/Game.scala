package tictactoe

/**
  * Represents a single game
  */
class Game(val playerOneName: String, val playerTwoName: String, val choiceCharOne: Char = 'X') {

  private val board: BoardStandard = new BoardStandard()
  private val choiceCharTwo: Char = if(choiceCharOne.equals('X')) 'O' else 'X'
  private val playerOne: Player = new Player(playerOneName, choiceCharOne)
  private val playerTwo: Player = new Player(playerTwoName, choiceCharTwo)

  private def turn(player: Player): Unit = {

  }

  private def takeInputConsole(): (Int, Int) = {
    (0,0)
  }

  private def startGame(): Unit = {

  }

}
