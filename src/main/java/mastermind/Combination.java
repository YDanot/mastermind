package mastermind;

import org.assertj.core.util.Lists;

import java.util.List;

public class Combination {

    public List<Token> tokens() {
        return tokens;
    }

    private final List<Token> tokens;

    private Combination(Token token1, Token token2, Token token3, Token token4) {
        tokens = Lists.newArrayList(token1, token2, token3, token4);
    }

    public static Combination of(Token token1, Token token2, Token token3, Token token4) {
        return new Combination(token1, token2, token3, token4);
    }

    public int size() {
        return tokens.size();
    }

    @Override
    public String toString() {
        return "Combination{" +
                "tokens=" + tokens +
                '}';
    }
}
