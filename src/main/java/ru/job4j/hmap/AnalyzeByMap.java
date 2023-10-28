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
                subjects.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> subject : subjects.entrySet()) {
            scores.add(new Label(subject.getKey(), (double) subject.getValue() / pupils.size()));
        }
        return scores;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label rsl = null;
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            if (rsl == null || rsl.score() < sum) {
                rsl = new Label(pupil.name(), sum);
            }
        }
        return rsl;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Label rsl = null;
        Map<String, Integer> subjects = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjects.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> subject : subjects.entrySet()) {
            if (rsl == null || rsl.score() < subject.getValue()) {
                rsl = new Label(subject.getKey(), subject.getValue());
            }
        }
        return rsl;
    }
}
