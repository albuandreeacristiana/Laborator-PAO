package CSV;

public interface CsvTypeFactory <T> {
    String[] getColumnNames();
    String[] toStringArray(T object);
    T fromStringArray(String[] data);
}
