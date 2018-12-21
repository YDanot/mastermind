package mastermind;

import java.util.ArrayList;
import java.util.List;

public class Submission {

    private final Combination secret;
    private final Combination submitted;

    public Submission(Combination secret, Combination submitted) {
        this.secret = secret;
        this.submitted = submitted;
    }

    public Answer answer() {
        int misplaced = 0;
        int correct = 0;
        final List<Token> incorrectTokens = incorrect();
        for (int i = 0; i < secret.tokens().size(); i++) {
            if (correctlyPlacedAtPosition(i)) {
                correct++;
            } else {
                final Token submit = submitted.tokens().get(i);
                if (incorrectTokens.contains(submit)) {
                    misplaced++;
                    incorrectTokens.remove(submit);
                }
            }
        }

        return new Answer(correct, misplaced);
    }

    private boolean correctlyPlacedAtPosition(int i) {
        return secret.tokens().get(i) == submitted.tokens().get(i);
    }

    private List<Token> incorrect() {
        List<Token> correctTokens = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            final Token secretToken = secret.tokens().get(i);
            final Token submit = submitted.tokens().get(i);
            if (!secretToken.equals(submit)) {
                correctTokens.add(secretToken);
            }
        }
        return correctTokens;
    }
}
