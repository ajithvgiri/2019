package `in`.januprasad.calender.api

import `in`.januprasad.calender.Photo
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by nintoantok on 2/4/18.
 */

interface MockUnsplashAPI {

    @GET("/photos/random")
    fun getRandomPhoto(@Query("client_id") accessKey: String): Call<Photo>

    @GET("/users/{name}/photos")
    fun getMyPhotos(@Path("name") name: String,@Query("per_page") per_page: String, @Query("client_id") accessKey: String): Call<ArrayList<Photo>>


}
