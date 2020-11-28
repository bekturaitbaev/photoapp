package ab.android.photoapp.api

interface ApiServiceInterface {

    @GET("list")
    fun getPhotos(@Query("page") page: Int, @Query("limit") limit: Int): Response<ArrayList<Photo>>

    @GET("weather")
    fun getWeather(): Response<Photo>

}