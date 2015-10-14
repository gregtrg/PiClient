package Client.domain;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Класс для хренения информации и дальнейшей отправки в PI
 */
public class ProceedDataObject {
    private Deque<String> rows = new LinkedList<>();

    /**
     * Добавить строку с информацией в очередь
     * @param row добавляемая строка
     */
    public void add(String row) {
        rows.addLast(row);
    }

    /**
     * Получить строку с информацией из очереди
     * @return строка с информацией
     */
    public String get() {
        return rows.getFirst();
    }

    /**
     * Получить число строк с информацей
     * @return число строк
     */
    public int size() {
        return rows.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{ \"rows\" : [");
        for (String currentRow : rows) {
            result.append(currentRow);
        }
        result.append("]}");
        return result.toString();
    }
}
