package game.console;

import mastermind.Combination;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static mastermind.Token.*;

public class ConsoleGameTest {

    @Test
    public void transformToCombinaisonTest() {
        Assertions.assertThat(new Game.ConsoleReader().transformToCombinaison("YWBR")).isEqualToComparingFieldByField(Combination.of(YELLOW, WHITE, BLUE, RED));
        Assertions.assertThat(new Game.ConsoleReader().transformToCombinaison("GGGP")).isEqualToComparingFieldByField(Combination.of(GREEN, GREEN, GREEN, PINK));
        Assertions.assertThat(new Game.ConsoleReader().transformToCombinaison("G")).isNull();
        Assertions.assertThat(new Game.ConsoleReader().transformToCombinaison("AAAA")).isNull();
    }
}