package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemDescByNameTest {
    @Test
    public void whenSortDesc() {
        Item itemA = new Item("Atilla");
        Item itemB = new Item("Babylon");
        Item itemE = new Item("Egypt");
        Item itemK = new Item("Kenia");
        List<Item> tasks = Arrays.asList(itemA, itemE, itemK, itemB);
        tasks.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(itemK, itemE, itemB, itemA);
        assertThat(tasks).containsExactlyElementsOf(expected);
    }
}