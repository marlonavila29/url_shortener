package dev.wmma.services

import dev.wmma.model.Url
import dev.wmma.repository.UrlRepository
import dev.wmma.repository.UrlRepositoryJava

import java.awt.Desktop
import java.io.IOException
import java.net.URI
import java.net.URISyntaxException
import java.net.URL
import java.net.MalformedURLException

class UrlServices {

    companion object {
        private const val URL_BASE = "http://localhost:8080/url/"

        fun getshortUrl(longUrl: String): String {
            return if (isUrlValid(longUrl)) {
                val urls = UrlRepository.listAllUrls()
                val url = Url()
                url.shortUrl = isThereConflitInLongUrls(longUrl, urls)

                if (url.shortUrl.isEmpty()) {
                    var thereIsThisUrl = false
                    do {
                        val newShortUrl = UrlShortener.Companion.shorten(longUrl)
                        if (isThereConflitInShortUrls(newShortUrl!!, urls))
                            thereIsThisUrl = true
                    } while (thereIsThisUrl)

                    url.longUrl = longUrl
                    url.shortUrl = UrlShortener.Companion.generateRandomShortUrl()
                    UrlRepositoryJava.saveUrl(url)
                }

                URL_BASE + url.shortUrl
            } else {
                "Digite alguma URL válida!"
            }
        }

        fun isThereConflitInShortUrls(shortUrl: String, urls: List<Url>): Boolean {
            for (item in urls) {
                if (item.shortUrl == shortUrl)
                    return true
            }
            return false
        }

        fun isThereConflitInLongUrls(longUrl: String, urls: List<Url>): String {
            for (item in urls) {
                if (item.longUrl == longUrl)
                    return item.shortUrl
            }
            return ""
        }

        fun openUrl(shortUrl: String) {
            var longUrl = ""

            val urls = UrlRepository.listAllUrls()

            for (item in urls) {
                if (item.shortUrl == shortUrl)
                    longUrl = item.longUrl.toString()
            }

            if (!longUrl.isEmpty()) {
                try {
                    Desktop.getDesktop().browse(URI(longUrl))
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: URISyntaxException) {
                    e.printStackTrace()
                }
            }
        }

        fun isUrlValid(urlStr: String): Boolean {
            return try {
                URL(urlStr)
                true
            } catch (e: MalformedURLException) {
                false
            }
        }
    }
}
