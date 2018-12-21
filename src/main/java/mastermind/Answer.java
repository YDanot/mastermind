package mastermind;

public class Answer {

    private final int correct;
    private final int misplaced;

    Answer(int correct, int misplaced) {
        this.correct = correct;
        this.misplaced = misplaced;
    }


    public int correct() {
        return correct;
    }

    public int misplaced() {
        return misplaced;
    }

    @Override
    public String toString() {
        return
                "correct =" + correct +
                        ", misplaced =" + misplaced
                ;
    }
}
