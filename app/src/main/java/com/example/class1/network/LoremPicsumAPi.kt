package com.example.class1.network
import retrofit2.http.GET

interface LoremPicsumApi {

    @GET("https://picsum.photos/v2/list?page=2&limit=100")
    suspend fun getPhotos(): List<Photo>
}
