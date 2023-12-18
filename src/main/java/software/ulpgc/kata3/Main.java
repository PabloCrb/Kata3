package software.ulpgc.kata3;
import software.ulpgc.kata2.*;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.getDisplay().show("Chess FIDE ELO Histogram", "ELO", "Frequency", chessHistogram());
        frame.setVisible(true);
    }

    private static Histogram chessHistogram() {
        return new Histogram() {
            @Override
            public int bins() {
                return 15;
            }

            @Override
            public double[] values() {
                return CSVFileChessPlayerLoader.with("C:\\Users\\Pablo\\IdeaProjects\\Archivos\\Chess FIDE Rankings.csv").load().
                        stream().
                        mapToDouble(ChessPlayer::ELO)
                        .toArray();
            }
        };
    }
}
