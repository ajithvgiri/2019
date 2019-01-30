package `in`.januprasad.calender

import `in`.januprasad.calender.api.UnsplashAPI
import android.app.Application
import android.arch.lifecycle.AndroidViewModel

class PhotoViewModel(application: Application) : AndroidViewModel(application) {
    fun randomPhoto() = UnsplashAPI().getPhoto(Constants.KEY)
    fun myPhoto(name: String, count: String) = UnsplashAPI().getMyPhotos(name,count, Constants.KEY)
}
