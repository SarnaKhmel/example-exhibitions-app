package goro.igor.exampleexhibitionapp

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import goro.igor.fileexhibitsloader.FileExhibitionLoader
import goro.igor.model.Exhibit
import kotlinx.android.synthetic.main.exhibition_layout.*

class MainExhibitionActivity : Activity() {

    private val exhibitionAdapter = ExhibitionAdapter()
    private lateinit var exhibitsList: List<Exhibit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exhibition_layout)

        exhibitsList = FileExhibitionLoader.getExhibitList(this)
        recyclerViewSetUp()
    }

    private fun recyclerViewSetUp() {
        exhibitsRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)

            exhibitionAdapter.setExhibits(exhibitsList)
            adapter = exhibitionAdapter
        }
    }
}