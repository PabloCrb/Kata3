package software.ulpgc.kata2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class CSVFileChessPlayerLoader implements ChessPlayerLoader {
    private final File file;

    private CSVFileChessPlayerLoader(File file) {
        this.file = file;
    }

    public static CSVFileChessPlayerLoader with(String fileName) {
        return new CSVFileChessPlayerLoader(new File(fileName));
    }

    @Override
    public List<ChessPlayer> load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return load(reader);
        } catch (IOException e) {
            return emptyList();
        }
    }

    public List<ChessPlayer> load(BufferedReader reader) {
        return reader.lines()
                .skip(1)
                .map(this::toChessPlayer)
                .collect(toList());
    }

    private ChessPlayer toChessPlayer(String line) {
        return toChessPlayer(line.split(","));
    }

    private ChessPlayer toChessPlayer(String[] fields) {
        return new ChessPlayer(
                parseInt(fields[0]),
                fields[1],
                parseInt(fields[2]),
                fields[3],
                fields[4],
                parseInt(fields[5]),
                parseInt(fields[6])
                );
    }
}
