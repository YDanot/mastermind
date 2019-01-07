package mastermind;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static mastermind.Token.*;

public class MasterMindTest {

    private MasterMind masterMind;

    @Test
    public void no_correct_or_misplaced_colors() {
        mastermind(Combination.of(PINK, PINK, PINK, PINK));

        Assertions.assertThat(submit(Combination.of(BLUE, YELLOW, GREEN, GREEN)))
                .isEqualToComparingFieldByField(answer(0, 0));
    }

    @Test
    public void single_correct_color_for_PPPP_PYGG() {
        mastermind(Combination.of(PINK, PINK, PINK, PINK));

        Assertions.assertThat(submit(Combination.of(PINK, YELLOW, GREEN, GREEN)))
                .isEqualToComparingFieldByField(answer(1, 0));
    }

    @Test
    public void single_correct_color_for_PPPP_YPGG() {
        mastermind(Combination.of(PINK, PINK, PINK, PINK));

        Assertions.assertThat(submit(Combination.of(YELLOW, PINK, GREEN, GREEN)))
                .isEqualToComparingFieldByField(answer(1, 0));
    }

    @Test
    public void three_correct_color_for_PPPP_YPPP() {
        mastermind(Combination.of(PINK, PINK, PINK, PINK));

        Assertions.assertThat(submit(Combination.of(YELLOW, PINK, PINK, PINK)))
                .isEqualToComparingFieldByField(answer(3, 0));
    }

    @Test
    public void one_misplace_color_for_YYGG_GRRR() {
        mastermind(Combination.of(YELLOW, YELLOW, GREEN, GREEN));

        Assertions.assertThat(submit(Combination.of(GREEN, RED, RED, RED)))
                .isEqualToComparingFieldByField(answer(0, 1));
    }

    @Test
    public void one_misplaced_color_for_YYGG_RRYR() {
        mastermind(Combination.of(YELLOW, YELLOW, GREEN, GREEN));

        Assertions.assertThat(submit(Combination.of(RED, RED, YELLOW, RED)))
                .isEqualToComparingFieldByField(answer(0, 1));
    }

    @Test
    public void two_misplaced_two_correct_for_YGPB_GYPB() {
        mastermind(Combination.of(YELLOW, GREEN, PINK, BLUE));

        Assertions.assertThat(submit(Combination.of(GREEN, YELLOW, PINK, BLUE)))
                .isEqualToComparingFieldByField(answer(2, 2));
    }

    @Test
    public void two_correct_one_misplaced_for_YYYG_YGYB() {
        mastermind(Combination.of(YELLOW, YELLOW, YELLOW, GREEN));

        Assertions.assertThat(submit(Combination.of(YELLOW, GREEN, YELLOW, BLUE)))
                .isEqualToComparingFieldByField(answer(2, 1));

    }

    @Test
    public void token_are_counted_only_once() {
        mastermind(Combination.of(YELLOW, GREEN, PINK, BLUE));

        Assertions.assertThat(submit(Combination.of(YELLOW, YELLOW, BLUE, BLUE)))
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
