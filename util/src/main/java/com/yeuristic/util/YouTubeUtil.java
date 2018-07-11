package com.yeuristic.util;

import android.net.Uri;

import java.util.List;

public class YouTubeUtil {

    public static final String WWW_HOST = "www.youtube.com";
    public static final String SHORT_LINK_HOST = "youtu.be";
    public static final String G_DATA_HOST = "gdata.youtube.com";


    /**
     * @param videoUrl youtube video videoUrl
     *            Supported Url type:
     *            http://www.youtube.com/watch?v=384IUU43bfQ
     *            http://www.youtube.com/embed/Woq5iX9XQhA?html5=1
     *            https://youtu.be/MXuXsMZs1I0
     *            http://gdata.youtube.com/feeds/api/videos/xTmi7zzUa-M&whatever
     * @return youtubeId
     * @throws IllegalArgumentException
     */
    public static String getYouTubeVideoId(String videoUrl) throws IllegalArgumentException {
        if (videoUrl == null || videoUrl.isEmpty()) {
            throw new IllegalArgumentException("videoUrl can't be null or empty");
        } else {
            return getYouTubeVideoId(Uri.parse(videoUrl));
        }
    }

    public static String getYouTubeVideoId(Uri videoUri) {
        if (videoUri == null) {
            throw new IllegalArgumentException("videoUri can't be null");
        } else {

            IllegalArgumentException invalidUrlException = new IllegalArgumentException("url is invalid");

            List<String> paths = videoUri.getPathSegments();
            String host = videoUri.getHost();
            if (host == null) {
                throw invalidUrlException;
            }
            switch (host) {
                case WWW_HOST:
                    if (paths.size() < 1) {
                        throw invalidUrlException;
                    } else {
                        if ("watch".equals(paths.get(0))) {
                            String v = videoUri.getQueryParameter("v");
                            if (v == null) {
                                throw invalidUrlException;
                            }
                            return v;
                        } else if ("embed".equals(paths.get(0))) {
                            if (paths.size() < 2) {
                                throw invalidUrlException;
                            } else {
                                return sanitizeId(paths.get(1));
                            }
                        } else {
                            throw invalidUrlException;
                        }
                    }
                case SHORT_LINK_HOST:
                    if (paths.size() < 1) {
                        throw invalidUrlException;
                    } else {
                        return sanitizeId(paths.get(0));
                    }
                case G_DATA_HOST:
                    if (paths.size() < 4) {
                        throw invalidUrlException;
                    } else {
                        return sanitizeId(paths.get(3));
                    }
                default:
                    throw invalidUrlException;
            }
        }
    }

    private static String sanitizeId(String id) {
        if (id == null) {
            return null;
        } else {
            char[] charArray = id.toCharArray();
            int lastIndex = charArray.length;
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (c == '#' || c == '&' || c == '?') {
                    break;
                }
                lastIndex = i;
            }
            return id.substring(0, lastIndex + 1);
        }
    }
}
