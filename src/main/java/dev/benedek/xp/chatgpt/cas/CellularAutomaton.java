package dev.benedek.xp.chatgpt.cas;

import java.util.Arrays;

public class CellularAutomaton<T> {
  private T[][] currentState;
  private T[][] nextState;
  private final Rule<T> rule;

  public CellularAutomaton(Rule<T> rule, T[][] initialState) {
    this.rule = rule;
    currentState = initialState;
    nextState = (T[][]) new Object[currentState.length][currentState[0].length];
  }

  public void step() {
    for (int i = 0; i < currentState.length; i++) {
      for (int j = 0; j < currentState[i].length; j++) {
        int top = (i == 0) ? currentState.length - 1 : i - 1;
        int bottom = (i == currentState.length - 1) ? 0 : i + 1;
        int left = (j == 0) ? currentState[i].length - 1 : j - 1;
        int right = (j == currentState[i].length - 1) ? 0 : j + 1;
        nextState[i][j] = rule.apply(currentState[top][left], currentState[top][j], currentState[top][right],
            currentState[i][left], currentState[i][j], currentState[i][right], currentState[bottom][left],
            currentState[bottom][j], currentState[bottom][right]);
      }
    }

    T[][] temp = currentState;
    currentState = nextState;
    nextState = temp;
  }

  public T[][] getCurrentState() {
    return currentState;
  }

  public interface Rule<T> {
    T apply(T topLeft, T top, T topRight, T left, T center, T right, T bottomLeft, T bottom, T bottomRight);
  }
}