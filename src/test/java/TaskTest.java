import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.statistic.Epic;
import ru.netology.statistic.Meeting;
import ru.netology.statistic.SimpleTask;
import ru.netology.statistic.Todos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {
    @Test
    public void test1() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(true, actual);

    }

    @Test
    public void test2() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("позвонить");
        assertFalse(actual);

    }

    @Test
    public void testMatches() {
        String[] subtasks = {"задача1", "задача2", "задача3"};
        Epic epic = new Epic(5, subtasks);

        assertTrue(epic.matches("задача2"));
        assertFalse(epic.matches("задача4"));

        assertTrue(epic.matches("задача"));
        assertFalse(epic.matches("epic"));

        assertFalse(epic.matches("Задача2"));
    }

    @Test
    public void testMeeting() {
        Meeting meeting = new Meeting(5, "Тема", "Проект проектик", "31.08.2023 23:59");

        // Проверяем, что поиск по точному совпадению работает
        assertTrue(meeting.matches("Тема"));
        assertFalse(meeting.matches("Встреча"));

        // Проверяем, что поиск по части строки работает
        assertTrue(meeting.matches("Проект"));
        assertTrue(meeting.matches("проектик"));
        assertFalse(meeting.matches("проЭкт"));

    }
}
