package `in`.januprasad.calender.api

import `in`.januprasad.calender.Photo
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UnsplashAPI : ApiService() {
    private var photoLive = MutableLiveData<Photo>()
    private var myPhotosLive = MutableLiveData<ArrayList<Photo>>()


    fun getPhoto(key: String): LiveData<Photo> {

        apiService.getRandomPhoto(key).enqueue(object : Callback<Photo> {
            override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                if (response != null && response.isSuccessful && response.body() != null) {
                    val photo = response.body()
                    if (photo != null) {
                        photo.success = true
                    }
                    photoLive.postValue(response.body())
                } else {
                    val photo = Photo()
//                    photoLive.error = Constants.API_ERROR
                    this@UnsplashAPI.photoLive.postValue(photo)
                }
            }


            override fun onFailure(call: Call<Photo>, t: Throwable) {
                Log.v("onFailure", "failed")
                val tResponse = Photo()
//                tResponse.error = Constants.API_ERROR
                photoLive.postValue(tResponse)
            }
        })

        return photoLive
    }


    fun getMyPhotos(name: String, count:String, key: String): LiveData<ArrayList<Photo>> {

        apiService.getMyPhotos(name,count, key).enqueue(object : Callback<ArrayList<Photo>> {
            override fun onResponse(call: Call<ArrayList<Photo>>, response: Response<ArrayList<Photo>>) {
                if (response != null && response.isSuccessful && response.body() != null) {
                    val photo = response.body()
//                    if (photo != null) {
//                        photo.success = true
//                    }
                    myPhotosLive.postValue(response.body())
                }
//                } else {
//                    val photo = Photos()
////                    photoLive.error = Constants.API_ERROR
//                    this@UnsplashAPI.myPhotosLive.postValue(photo)
//                }
            }


            override fun onFailure(call: Call<ArrayList<Photo>>, t: Throwable) {
                Log.v("onFailure", "failed")
//                val tResponse = Photos()
//                tResponse.error = Constants.API_ERROR
//                myPhotosLive.postValue(tResponse)
            }
        })

        return myPhotosLive
    }


}
