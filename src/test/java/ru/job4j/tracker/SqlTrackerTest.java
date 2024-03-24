package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

class SqlTrackerTest {

    private static Connection testConnection;

    @BeforeAll
    public static void setupBeforeTests() throws Exception {
        try (InputStream input = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("test.driver-class-name"));
            testConnection = DriverManager.getConnection(
                    config.getProperty("test.url"),
                    config.getProperty("test.username"),
                    config.getProperty("test.password")
            );
        }
    }

    @BeforeEach
    public void setupTest() {
        try (var statement = testConnection.createStatement()) {
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS items (id serial primary key, name text, created timestamp);");
        } catch (SQLException e) {
            fail(e.getMessage());
        }
        try (var statement = testConnection.createStatement()) {
            statement.execute(
                    "DELETE FROM items;");
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @AfterAll
    public static void tearDownAfterTests() {
        try {
            testConnection.close();
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Store tracker = new SqlTracker(testConnection);
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenTestFindById() {
        Store tracker = new SqlTracker(testConnection);
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenTestFindAll() {
        Store tracker = new SqlTracker(testConnection);
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getName()).isEqualTo(first.getName());
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Store tracker = new SqlTracker(testConnection);
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Store tracker = new SqlTracker(testConnection);
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(1).getName()).isEqualTo(second.getName());
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        Store tracker = new SqlTracker(testConnection);
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        Item updateItem = new Item("Bug with description");
        tracker.replace(id, updateItem);
        assertThat(tracker.findById(id).getName()).isEqualTo("Bug with description");
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        Store tracker = new SqlTracker(testConnection);
        Item item = new Item("Bug");
        tracker.add(item);
        Item updateItem = new Item("Bug with description");
        boolean result = tracker.replace(1000, updateItem);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        Store tracker = new SqlTracker(testConnection);
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    public void whenDeleteItemIsNotSuccessful() {
        Store tracker = new SqlTracker(testConnection);
        Item item = new Item("Bug");
        tracker.add(item);
        tracker.delete(1000);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
    }
}