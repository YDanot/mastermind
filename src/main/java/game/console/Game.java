package game.console;

import mastermind.Answer;
import mastermind.Combination;
import mastermind.MasterMind;
import mastermind.Token;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Game {

    public static void main(String[] args) {

        final Combination secret = randomCombination();
        final MasterMind masterMind = new MasterMind(secret);
        Answer answer;
        do {
            final Combination combination = new ConsoleReader().readCombination();
            answer = masterMind.submit(combination);
            System.out.println(answer);
        } while (answer.correct() != secret.tokens().size());

    }

    private static Combination randomCombination() {
        final Token[] values = Token.values();
        return Combination.of(values[new Random().nextInt(values.length)], values[new Random().nextInt(values.length)], values[new Random().nextInt(values.length)], values[new Random().nextInt(values.length)]);
    }

    static class ConsoleReader {

        private static Map<Character, Token> map = initMap();

        private static Map<Character, Token> initMap() {
            Map<Character, Token> map = new HashMap<>();
            for (Token value : Token.values()) {
                map.put(value.name().charAt(0), value);
            }
            return map;
        }

        private BufferedReader reader;

        ConsoleReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        private Combination readCombination() {
            Combination combination = null;
            do {
                System.out.print("Entrez votre combinaison de 4 pions (R,G,B,P,W,Y) : ");
                try {
                    combination = transformToCombinaison(reader.readLine());

                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            } while (combination == null);

            return combination;
        }

        Combination transformToCombinaison(String line) {
            if (line == null || line.length() < 4) {
                return null;
            }

            List<Token> tokens = new ArrayList<>();
            for (char c : line.toCharArray()) {
                final Token t = map.get(c);
                if (t == null) {
                    return null;
                }
                tokens.add(t);
            }

            return Combination.of(tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3));

        }
    }
}
