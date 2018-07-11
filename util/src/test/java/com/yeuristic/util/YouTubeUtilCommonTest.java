package com.yeuristic.util;

import android.net.Uri;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class YouTubeUtilCommonTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument() {
        YouTubeUtil.getYouTubeVideoId((String) null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument2() {
        YouTubeUtil.getYouTubeVideoId("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument3() {
        YouTubeUtil.getYouTubeVideoId((Uri) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument4() {
        YouTubeUtil.getYouTubeVideoId("sfsfsdfasfd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument5() {
        YouTubeUtil.getYouTubeVideoId("www.youtube.com");
    }
}
