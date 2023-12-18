package software.ulpgc.kata2;

public record ChessPlayer(
        int rank,
        String name,
        int ELO,
        String title,
        String federation,
        int games,
        int birthYear
) {
}
