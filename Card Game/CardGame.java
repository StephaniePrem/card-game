//package cardgame;

import java.util.ArrayList;

public class CardGame
{
  //properties
  Cards fullPack;
  ArrayList<Player> players;
  ScoreCard scoreCard;
  Cards[] cardsOnTable;
  int roundNo;
  int turnOfPlayer;
  
  //contructors
  public CardGame(Player p1, Player p2, Player p3, Player p4)
  {
    players = new ArrayList<Player>();
    players.add(p1);
    players.add(p2);
    players.add(p3);
    players.add(p4);
  }
  
  //methods
  public boolean playTurn(Player p, Card c)
  {
    if (!isTurnOf(p) || isGameOver())
      return false;
    else
    {
      cardsOnTable[getTurnOfPlayerNo() - 1].addTopCard(c);
      if (roundNo % 4 == 3)
        updateScores();
      if (roundNo < 51)
        roundNo++;
      return true;
    }
  }
  private void updateScores()
  {
    Card max = new Card(0);
    for (int i = 0; i < scoreCard.scores.length - 1; i++)
    {
      if (cardsOnTable[i].cards[getRoundNo() -1].getFaceValue() >= max.getFaceValue())
        max = cardsOnTable[i].cards[getRoundNo() - 1];
    }
    for (int j = 0; j < scoreCard.scores.length; j++)
    {
      if (cardsOnTavle[j].cards[getRoundNo() - 1].getFaceValue() == max.getFaceValue())
        scoreCard.update(j, 1);
    }
  //if there is more than max cards w/ the same face values and diff suite all of them get the point for that round
  }
  public boolean isTurnOf(Player p)
  {
    if (players.get(roundNo % 4).getName().equals(p.getName()))
      return true;
    else
      return false;
  }
  public boolean isGameOver()
  {
    if (getRoundNo() == 13 && cardsOnTable[3].cards.length == 13)
      return true;
    else
      return false;
  }
  public int getScore(int playerNumber)
  {
    return players.get(playerNumber - 1).getName();
  }
  public int getTurnOfPlayerNo()
  {
    int i;
    for (i = 0; i < players.size() && !isTurnOf(players.get(i)); i++)
    {
      System.out.print("i dont know what is supposed to go here");  //this was empty fill it
    }
    return i + 1;
  }
  public Player[] getWinners()
  {
    Player[] winner = new Player[scoreCard.getWinners().length];
    for (int i = 0; i < winners.length; i++)
      winners[i] = players.get(scoreCard.getWinners()[i]);
    return winners;
  }
  public void initGame()
  {
    if (players.size() == 4)
    {
      fullPack = new Cards(true);
      fullPack.shuffle();
      for (int i = 0; i < 52; i++)
        players.get(i % 4).hand.addTopCard(fullPack.getTopCard());
      scoreCard = new ScoreCard(4);
      cardsOnTable = new Cards[4];
      for (int i = 0; i < 4; i++)
        cardsOnTable[i] = new Cards(false);
      roundNo = 0;
      turnOfPlayer = 0;
    }
  }
  public String showScoreCard()
  {
    return scoreCard.toString();
  }
}
  
  
