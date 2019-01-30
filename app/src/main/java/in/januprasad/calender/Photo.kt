package `in`.januprasad.calender

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Photo {
    @SerializedName("urls")
    @Expose
    var urls: Urls? = null
    var success = false
}