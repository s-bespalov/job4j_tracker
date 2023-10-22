package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Apply for job", 10),
                new Job("Rollback changes", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Apply for job", 10),
                new Job("Rollback changes", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmpName = new JobAscByPriority();
        int rsl = cmpName.compare(
                new Job("Apply for job", 10),
                new Job("Rollback changes", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("Apply for job", 10),
                new Job("Rollback changes", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscNameAndDescPriority() {
        Comparator<Job> cmpName = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpName.compare(
                new Job("Apply for job", 0),
                new Job("Apply for job", 10)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByAscPriorityAndDescName() {
        Comparator<Job> cmpName = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpName.compare(
                new Job("Download Image", 7),
                new Job("Clear Cache", 7)
        );
        assertThat(rsl).isLessThan(0);
    }
}