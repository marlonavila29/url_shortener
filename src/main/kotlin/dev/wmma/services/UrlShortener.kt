package dev.wmma.services

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

class UrlShortener{
	
	companion object{
		
		private val random = Random()

	
	    fun shorten(longUrl: String): String? {
	        // cria um hash MD5 da URL longa
	        return try {
	            val md = MessageDigest.getInstance("MD5")
	            md.update(longUrl.toByteArray())
	            val hash = md.digest()
	
	            // converte o hash em uma string hexadecimal
	            val sb = StringBuilder()
	            for (b in hash) {
	                sb.append(String.format("%02x", b))
	            }
	            sb.toString()
	
	        } catch (e: NoSuchAlgorithmException) {
	            e.printStackTrace()
	            null
	        }
	    }
	
	    fun generateRandomShortUrl(): String {
	        val characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
	        val sb = StringBuilder()
	        for (i in 0 until 10) {
	            val index = random.nextInt(characters.length)
	            sb.append(characters[index])
	        }
	        return sb.toString()
	    }
	}
}
