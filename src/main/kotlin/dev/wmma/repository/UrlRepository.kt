package dev.wmma.repository

import dev.wmma.model.Url
import javax.transaction.Transactional


class UrlRepository {
    companion object {

        fun listAllUrls(): List<Url> {
            return Url.listAll()
        }

        @Transactional
        fun saveUrl(newUrl: Url) {
            newUrl.persist()
        }
    }
}