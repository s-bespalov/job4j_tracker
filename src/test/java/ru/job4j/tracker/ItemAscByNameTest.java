package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemAscByNameTest {
    @Test
    public void whenSortAsc() {
        Item itemA = new Item("Adjust Size");
        Item itemC = new Item("Correct Behavior");
        Item itemD = new Item("Do Something");
        Item itemR = new Item("Remove All");
        List<Item> tasks = Arrays.asList(itemR, itemC, itemA, itemD);
        tasks.sort(new  ItemAscByName());
        List<Item> expected = Arrays.asList(itemA, itemC, itemD, itemR);
        assertThat(tasks).containsExactlyElementsOf(expected);
    }
}