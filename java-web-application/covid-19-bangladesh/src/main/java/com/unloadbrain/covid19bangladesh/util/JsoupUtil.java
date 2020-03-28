package com.unloadbrain.covid19bangladesh.util;

import com.unloadbrain.covid19bangladesh.exception.IORuntimeException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * Provides JSoup related utils.
 */
public class JsoupUtil {

    public Document fetch(String url, int timeoutMillis) {
        try {
            return Jsoup.parse(new URL(url), timeoutMillis);
        } catch (IOException e) {
            throw new IORuntimeException("Could not download document.", e);
        }
    }
}
