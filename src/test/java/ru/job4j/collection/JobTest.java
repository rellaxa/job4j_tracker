package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.JobKOctets;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenJobAskByName() {
        int rsl = new JobAscByName().compare(
                new Job("Black", 2),
                new Job("White", 10)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenJobDescByName() {
        int rsl = new JobDescByName().compare(
                new Job("Black", 2),
                new Job("White", 10)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenJobAscByPriority() {
        int rsl = new JobAscByPriority().compare(
                new Job("White", 10),
                new Job("Black", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenJobDescByPriority() {
        int rsl = new JobDescByPriority().compare(
                new Job("White", 10),
                new Job("Black", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAbsComparatorByPriorityAndByName() {
        Comparator<Job> cmpPriorityName = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpPriorityName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}