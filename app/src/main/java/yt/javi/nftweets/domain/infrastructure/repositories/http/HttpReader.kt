package yt.javi.nftweets.domain.infrastructure.repositories.http

import java.net.URL


class HttpReader {
    fun getText(url: URL): StringBuilder = StringBuilder(url.readText())
}