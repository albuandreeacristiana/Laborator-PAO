package CSV;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collection;

public class CsvWriter <T>{
    private final BufferedWriter writer;
    private final CsvTypeFactory<T> factory;
    private final int numColumns;

    public CsvWriter(BufferedWriter writer, CsvTypeFactory<T> factory) throws IOException {
        this.writer = writer;
        this.factory = factory;
        String[] columnNames = factory.getColumnNames();
        this.numColumns = columnNames.length;
        writeLine(columnNames);
    }

    public void writeObject(T object) throws IOException {
        String[] strings = factory.toStringArray(object);
        writeLine(strings);
    }

    public void writeAll(Collection<T> objects) throws IOException {
        for (T object : objects) {
            writeObject(object);
        }
    }

    private void writeLine(String[] strings)throws IOException {
        String line = String.join(",", strings) + '\n';
        writer.write(line);
    }
}
