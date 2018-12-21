package mastermind;

import mastermind.Answer;
import mastermind.Combination;
import mastermind.Submission;

public class MasterMind {

    private final Combination secret;

    public MasterMind(Combination secret) {
        this.secret = secret;
    }

    public Answer submit(Combination combination) {
        return new Submission(secret, combination).answer();
    }
}
