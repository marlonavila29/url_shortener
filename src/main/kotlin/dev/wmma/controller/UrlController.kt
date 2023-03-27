package dev.wmma.controller

import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import dev.wmma.model.Url
import dev.wmma.services.UrlServices
import com.google.gson.Gson


@Path("/url")
class UrlController {

    @POST
    @Path("/shorten")
    @Consumes(MediaType.APPLICATION_JSON)
    fun encorderUrl(longUrl: String): String {
        val gson = Gson()
        val url = gson.fromJson(longUrl, Url::class.java)
        return gson.toJson(UrlServices.getshortUrl(url.longUrl))
    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    fun openOriginalUrl(@PathParam("param") param: String) {
        UrlServices.openUrl(param)
    }
}
