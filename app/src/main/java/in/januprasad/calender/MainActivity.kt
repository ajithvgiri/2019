package `in`.januprasad.calender

import `in`.januprasad.calender.Constants.COUNT
import `in`.januprasad.calender.Constants.NAME
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.squareup.picasso.Picasso
import de.jodamob.android.calendar.CalendarBuilder
import de.jodamob.android.calendar.CalenderWidget
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    lateinit var photoVM: PhotoViewModel
    lateinit var app: App2019

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        app = this.application as App2019
        Picasso.get().load(R.drawable.bg).into(load_it_here)
        month.text = Utils.monthString
        month_year.text = Utils.monthYearNumber
        val widget = findViewById<CalenderWidget>(R.id.calendar)
        widget.set(CalendarBuilder(R.layout.calendar_item, R.layout.calendar_header))


        /**
         * for loading random photo

         */
        photoVM = ViewModelProviders.of(this).get(PhotoViewModel::class.java)
//        observeRandomPhoto(photoVM.randomPhoto())
    }

    private fun observeRandomPhoto(photoVM: LiveData<Photo>) {
        photoVM.observe(this, Observer { it ->
            if (it != null && it.success) {
                Picasso.get().load(it.urls!!.regular).placeholder(R.drawable.bg)
                    .into(load_it_here)
            }
        })
    }

    private fun observeMyPhotos(photoVM: LiveData<ArrayList<Photo>>) {
        photoVM.observe(this, Observer { it ->
            if (it != null) {
                app.set(it)
                val size = it.size
                var index = Random().nextInt(size)
                Picasso.get().load(it[index].urls!!.regular).placeholder(R.drawable.bg)
                    .into(load_it_here)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        if (app.get() != null && app.get().size > 0) {
            loadImageView()
        } else
            observeMyPhotos(photoVM.myPhoto(NAME, COUNT))
    }

    private fun loadImageView() {
        val size = app.get().size
        var index = Random().nextInt(size)
        Picasso.get().load(app.get()[index].urls!!.regular).placeholder(R.drawable.bg)
            .into(load_it_here)

    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private fun showSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }
}
