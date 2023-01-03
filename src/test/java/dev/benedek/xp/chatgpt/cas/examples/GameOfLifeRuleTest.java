package dev.benedek.xp.chatgpt.cas.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeRuleTest {
  private GameOfLifeRule rule = new GameOfLifeRule();

  @Test
  public void testUnderpopulation() {
    // Center cell is alive with 0 alive neighbors
    assertEquals(0, rule.apply(0, 0, 0, 0, 1, 0, 0, 0, 0));

    // Center cell is alive with 1 alive neighbor
    assertEquals(0, rule.apply(1, 0, 0, 0, 1, 0, 0, 0, 0));
  }

  @Test
  public void testOverpopulation() {
    // Center cell is alive with 4 alive neighbors
    assertEquals(0, rule.apply(1, 1, 1, 1, 1, 0, 1, 0, 1));

    // Center cell is alive with 5 alive neighbors
    assertEquals(0, rule.apply(1, 1, 1, 1, 1, 1, 1, 1, 1));

    // Center cell is alive with 6 alive neighbors
    assertEquals(0, rule.apply(1, 1, 1, 1, 1, 1, 1, 1, 0));

    // Center cell is alive with 7 alive neighbors
    assertEquals(0, rule.apply(1, 1, 1, 1, 1, 1, 1, 0, 1));

    // Center cell is alive with 8 alive neighbors
    assertEquals(0, rule.apply(1, 1, 1, 1, 1, 1, 0, 1, 1));
  }

  @Test
  public void testCreation() {
    // Center cell is dead with 3 alive neighbors
    assertEquals(1, rule.apply(1, 1, 1, 0, 0, 0, 0, 0, 0));
    assertEquals(1, rule.apply(0, 1, 1, 1, 0, 0, 0, 0, 0));
    assertEquals(1, rule.apply(0, 0, 1, 1, 1, 0, 0, 0, 0));
    assertEquals(1, rule.apply(0, 0, 0, 1, 1, 1, 0, 0, 0));
    assertEquals(1, rule.apply(0, 0, 0, 0, 1, 1, 1, 0, 0));
    assertEquals(1, rule.apply(0, 0, 0, 0, 0, 1, 1, 1, 0));
    assertEquals(1, rule.apply(0, 0, 0, 0, 0, 0, 1, 1, 1));
    assertEquals(1, rule.apply(1, 0, 0, 0, 0, 0, 1, 1, 0));
    assertEquals(1, rule.apply(0, 1, 0, 0, 0, 0, 1, 1, 0));
    assertEquals(1, rule.apply(0, 0, 1, 0, 0, 0, 1, 1, 0));
    assertEquals(1, rule.apply(0, 0, 0, 1, 0, 0, 1, 1, 0));
    assertEquals(1, rule.apply(0, 0, 0, 0, 1, 0, 1, 1, 0));
  }
}