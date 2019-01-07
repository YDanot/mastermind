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
        final List<Token> incorrectTokens = incorrectTokensInSecretCombination();
        int correct = secret.size() - incorrectTokens.size();
        for (int i = 0; i < secret.tokens().size(); i++) {
            final Token submit = submitted.tokens().get(i);
            if (misplacedAtPosition(i) && incorrectTokens.contains(submit)) {
                misplaced++;
                incorrectTokens.remove(submit);
            }
        }

        return new Answer(correct, misplaced);
    }

    private boolean misplacedAtPosition(int i) {
        return secret.tokens().get(i) != submitted.tokens().get(i);
    }

    private List<Token> incorrectTokensInSecretCombination() {
        List<Token> incorrectTokens = new ArrayList<>();
        for (int i = 0; i < secret.size(); i++) {
            final Token secretToken = secret.tokens().get(i);
            final Token submit = submitted.tokens().get(i);
            if (!secretToken.equals(submit)) {
                incorrectTokens.add(secretToken);
            }
        }
        return incorrectTokens;
    }
}
