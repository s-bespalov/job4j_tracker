package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
             for (Subject subject : pupil.subjects()) {
                 sum += subject.score();
                 count++;
             }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> scores = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            scores.add(new Label(pupil.name(), sum / pupil.subjects().size()));
        }
        return scores;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> scores = new ArrayList<>();
        Map<String, Integer> subjects = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Integer val = subjects.get(subject.name());
                if (val == null) {
                    val = 0;
                }
                subjects.put(subject.name(), val + subject.score());
            }
        }
        for (Map.Entry<String, Integer> subject : subjects.entrySet()) {
            scores.add(new Label(subject.getKey(), (double) subject.getValue() / pupils.size()));
        }
        return scores;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        LinkedList<Label> chart = new LinkedList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            chart.add(new Label(pupil.name(), sum));
        }
        chart.sort(Comparator.naturalOrder());
        return chart.getLast();
    }

    public static Label bestSubject(List<Pupil> pupils) {
        LinkedList<Label> chart = new LinkedList<>();
        Map<String, Integer> subjects = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Integer val = subjects.get(subject.name());
                if (val == null) {
                    val = 0;
                }
                subjects.put(subject.name(), val + subject.score());
            }
        }
        for (Map.Entry<String, Integer> subject : subjects.entrySet()) {
            chart.add(new Label(subject.getKey(), subject.getValue()));
        }
        chart.sort(Comparator.naturalOrder());
        return chart.getLast();
    }
}
