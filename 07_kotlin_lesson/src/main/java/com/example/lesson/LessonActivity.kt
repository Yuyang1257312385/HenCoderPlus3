package com.example.lesson

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.core.BaseView
import com.example.core.utils.toast
import com.example.lesson.entity.Lesson

/**
 * @author yu
 * @description
 */
class LessonActivity : AppCompatActivity(),BaseView<LessonPresenter>,Toolbar.OnMenuItemClickListener {

    private val lessonPresenter : LessonPresenter = LessonPresenter(this)

    override fun getPresenter(): LessonPresenter {
       return lessonPresenter
    }

    private val lessonAdapter:LessonAdapter = LessonAdapter()

    private lateinit var refreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
        val toolbar:Toolbar = findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_lesson)
        toolbar.setOnMenuItemClickListener(this)

        val recyclerView:RecyclerView = findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = lessonAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(this,LinearLayout.VERTICAL))

        refreshLayout = findViewById(R.id.swipe_refresh_layout)
        refreshLayout.setOnRefreshListener { getPresenter().fetchData() }
        refreshLayout.isRefreshing = true

        getPresenter().fetchData()
    }

    fun showResult(lessons:ArrayList<Lesson>){
        lessonAdapter.updateAndNotify(lessons)
        refreshLayout.isRefreshing = false
    }

    fun showError(msg:String){
        toast(msg)
        refreshLayout.isRefreshing = false
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        getPresenter().showPlayback()
        return false
    }
}