package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 * @author yu
 * @description
 */
class LessonPresenter(private val activity: LessonActivity) {

    companion object{
        private val LESSON_PATH:String = "lessons"
    }

    private var lessons = arrayListOf<Lesson>()

    private val type: Type = object : TypeToken<List<Lesson>>(){}.type

    fun fetchData(){
        HttpClient.get(LESSON_PATH,type,object : EntityCallback<ArrayList<Lesson>>{
            override fun onSuccess(entity: ArrayList<Lesson>) {
                this@LessonPresenter.lessons = entity
                activity.runOnUiThread { activity.showResult(entity) }
            }

            override fun onFail(message: String?) {
                activity.runOnUiThread { activity.showError(message ?: "unknown error") }
            }

        })
    }

    fun showPlayback(){
        val playbackLessons = arrayListOf<Lesson>()
        for (lesson in lessons) {
            if (lesson.state == Lesson.State.PLAYBACK){
                playbackLessons.add(lesson)
            }
        }
        activity.showResult(playbackLessons)
    }

}