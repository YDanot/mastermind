package mastermind;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MasterMindTest {

    private MasterMind masterMind;

    @Test
    public void no_correct_or_misplaced_colors() {
        mastermind(Combination.of(Token.PINK, Token.PINK, Token.PINK, Token.PINK));

        Assertions.assertThat(submit(Combination.of(Token.BLUE, Token.YELLOW, Token.GREEN, Token.GREEN)))
                .isEqualToComparingFieldByField(answer(0, 0));
    }

    @Test
    public void single_correct_color_for_PPPP_PYGG() {
        mastermind(Combination.of(Token.PINK, Token.PINK, Token.PINK, Token.PINK));

        Assertions.assertThat(submit(Combination.of(Token.PINK, Token.YELLOW, Token.GREEN, Token.GREEN)))
                .isEqualToComparingFieldByField(answer(1, 0));
    }

    @Test
    public void single_correct_color_for_PPPP_YPGG() {
        mastermind(Combination.of(Token.PINK, Token.PINK, Token.PINK, Token.PINK));

        Assertions.assertThat(submit(Combination.of(Token.YELLOW, Token.PINK, Token.GREEN, Token.GREEN)))
                .isEqualToComparingFieldByField(answer(1, 0));
    }

    @Test
    public void three_correct_color_for_PPPP_YPPP() {
        mastermind(Combination.of(Token.PINK, Token.PINK, Token.PINK, Token.PINK));

        Assertions.assertThat(submit(Combination.of(Token.YELLOW, Token.PINK, Token.PINK, Token.PINK)))
                .isEqualToComparingFieldByField(answer(3, 0));
    }

    @Test
    public void one_misplace_color_for_YYGG_GRRR() {
        mastermind(Combination.of(Token.YELLOW, Token.YELLOW, Token.GREEN, Token.GREEN));

        Assertions.assertThat(submit(Combination.of(Token.GREEN, Token.RED, Token.RED, Token.RED)))
                .isEqualToComparingFieldByField(answer(0, 1));
    }

    @Test
    public void one_misplaced_color_for_YYGG_RRYR() {
        mastermind(Combination.of(Token.YELLOW, Token.YELLOW, Token.GREEN, Token.GREEN));

        Assertions.assertThat(submit(Combination.of(Token.RED, Token.RED, Token.YELLOW, Token.RED)))
                .isEqualToComparingFieldByField(answer(0, 1));
    }

    @Test
    public void two_misplaced_two_correct_for_YGPB_GYPB() {
        mastermind(Combination.of(Token.YELLOW, Token.GREEN, Token.PINK, Token.BLUE));

        Assertions.assertThat(submit(Combination.of(Token.GREEN, Token.YELLOW, Token.PINK, Token.BLUE)))
                .isEqualToComparingFieldByField(answer(2, 2));
    }

    @Test
    public void two_correct_one_misplaced_for_YYYG_YGYB() {
        mastermind(Combination.of(Token.YELLOW, Token.YELLOW, Token.YELLOW, Token.GREEN));

        Assertions.assertThat(submit(Combination.of(Token.YELLOW, Token.GREEN, Token.YELLOW, Token.BLUE)))
                .isEqualToComparingFieldByField(answer(2, 1));

    }

    @Test
    public void token_are_counted_only_once() {
        mastermind(Combination.of(Token.YELLOW, Token.GREEN, Token.PINK, Token.BLUE));

        Assertions.assertThat(submit(Combination.of(Token.YELLOW, Token.YELLOW, Token.BLUE, Token.BLUE)))
                .isEqualToComparingFieldByField(answer(2, 0));
    }

    private void mastermind(Combination secret) {
        masterMind = new MasterMind(secret);
    }

    private Answer submit(Combination combination) {
        return masterMind.submit(combination);
    }

    private Answer answer(int correct, int misplaced) {
        return new Answer(correct, misplaced);

    }

}
