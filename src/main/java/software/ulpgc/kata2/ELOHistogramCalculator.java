package software.ulpgc.kata2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ELOHistogramCalculator implements HistogramCalculator {
    private final List<ChessPlayer> players;
    private final static int BIN_SIZE = 30;

    public ELOHistogramCalculator(List<ChessPlayer> players) {
        this.players = players;
    }

    @Override
    public Map<String, Integer> calculate() {
        Map<String, Integer> result = new HashMap<>();
        for (ChessPlayer player : players) {
            String key = toBin(player.ELO());
            result.put(key, result.getOrDefault(key, 0)+1);
        }
        return result;
    }

    private String toBin(int elo) {
        return low(elo) + "-" + high(elo);
    }

    private int high(int elo) {
        return low(elo) + BIN_SIZE;
    }

    private int low(int elo) {
        return (elo/BIN_SIZE) * BIN_SIZE;
    }
}
