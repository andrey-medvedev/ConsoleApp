public interface CsvConvertable {
    String toCSV(); // Создаём строку для CSV
    String getCSVHeaders(); // Для заголовка при выгрузке

    void fromCSV(String[] fields);
}


