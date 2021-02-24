package com.example.lesson.entity

//可以适应val 或 var,若使用 val,则只有 get 方法
class Lesson1(val date: String, val content: String, val state: State) {

    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String {
                return "等待中"
            }
        };

        abstract fun stateName(): String
    }

}