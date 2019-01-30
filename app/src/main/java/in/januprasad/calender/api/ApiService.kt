package `in`.januprasad.calender.api

open class ApiService {

    protected val apiService: MockUnsplashAPI
        get() {
            return APIServiceBuilder.createAuthService(MockUnsplashAPI::class.java)
        }

    fun apiService(token: String) = APIServiceBuilder.createUserValidService(MockUnsplashAPI::class.java, token)

}
