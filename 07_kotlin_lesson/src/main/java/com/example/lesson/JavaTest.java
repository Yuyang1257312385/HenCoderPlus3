package com.example.lesson;

import com.example.lesson.entity.Lesson;
import com.example.lesson.entity.Lesson1;

/**
 * @author yu
 */
class JavaTest {

    public static void main(String[] args) {
        Lesson lesson = new Lesson("","", Lesson.State.LIVE);
        lesson.getDate();
        lesson.setDate("");

        Lesson1 lesson1 = new Lesson1("","",Lesson1.State.LIVE);

    }

}
