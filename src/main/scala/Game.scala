package tictactoe

import scala.io.StdIn.readInt
/**
  * Represents a single game
  */
class Game(val playerOneName: String, val playerTwoName: String, val choiceCharOne: Char = 'X') {

  private val board: BoardStandard = new BoardStandard()
  private val choiceCharTwo: Char = if(choiceCharOne.equals('X')) 'O' else 'X'
  private val playerOne: Player = new Player(playerOneName, choiceCharOne)
  private val playerTwo: Player = new Player(playerTwoName, choiceCharTwo)

  private def turn(player: Player): Unit = {

    var flag: Boolean =  true
    do {
      println(s"\n${player.name}'s turn, enter coordinates for [${player.sign}]: ")
      val position: (Int, Int) = takeInputConsole()
      if(!board.positionTaken(position)) {
        player.addPlayerMove(position)
        flag = false
      }
    } while (flag)


  }

  private def takeInputConsole(): (Int, Int) = {
    val xCoordinate: Int = readInt()
    val yCoordinate: Int = readInt()
    (xCoordinate, yCoordinate)
  }

  /** Game controller*/
  def startGame(): Unit = {

    var currentPlayer: Player = playerTwo
    var continueGame: Boolean = true
    do {
      // First assign who is playing
      if(currentPlayer == playerTwo) {
        currentPlayer = playerOne
      } else {
        currentPlayer = playerTwo
      }
      // Print the board
      board.printBoard(playerOne, playerTwo)
      // currentPlayer enters coordinates
      turn(currentPlayer)
      // if the player won or an draw occured after the move, game ends, else the game continues
      if(board.checkWinner(currentPlayer)) {
        println(s"${currentPlayer.name} won the game! Congratulations!\n")
        continueGame = false
      }
      else if (board.checkDraw){
        println(s"Game ended in a draw.\n")
        continueGame = false
      }

    } while(continueGame)
  }


}
