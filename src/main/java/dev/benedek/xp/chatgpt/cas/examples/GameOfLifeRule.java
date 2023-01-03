package dev.benedek.xp.chatgpt.cas.examples;

import dev.benedek.xp.chatgpt.cas.CellularAutomaton;

public class GameOfLifeRule implements CellularAutomaton.Rule<Integer> {
  @Override
  public Integer apply(Integer topLeft, Integer top, Integer topRight, Integer left, Integer center, Integer right, Integer bottomLeft, Integer bottom, Integer bottomRight) {
    // Count the number of alive cells in the 3x3 grid of cells surrounding the center cell
    int aliveCount = getAliveCount(topLeft, top, topRight, left, right, bottomLeft, bottom, bottomRight);

    // If the center cell is alive, it will stay alive if it has 2 or 3 alive neighbors
    // Otherwise, it will die of loneliness or overcrowding
    if (center == 1) {
      return (aliveCount == 2 || aliveCount == 3) ? 1 : 0;
    }
    // If the center cell is dead, it will come to life if it has exactly 3 alive neighbors
    else {
      return (aliveCount == 3) ? 1 : 0;
    }
  }

  // Returns the number of alive cells in the given list of cells
  private int getAliveCount(Integer... values) {
    int count = 0;
    for (Integer value : values) {
      if (value == 1) {
        count++;
      }
    }
    return count;
  }
}