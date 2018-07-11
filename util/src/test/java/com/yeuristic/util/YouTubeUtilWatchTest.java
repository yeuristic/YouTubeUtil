package com.yeuristic.util;

import android.net.Uri;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class YouTubeUtilWatchTest {

    @Test
    public void testWatch() {
        assertEquals("384IUU43bfQ", YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/watch?v=384IUU43bfQ"));
        assertEquals("384IUU43bfQ", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/watch?v=384IUU43bfQ")));
        assertEquals("384IUU43bfQ", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/watch?v=384IUU43bfQ&x=asdf")));
        assertEquals("384IUU43bfQ", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/watch?v=384IUU43bfQ&x=asdf#")));
        assertEquals("384IUU43bfQ", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/watch/?v=384IUU43bfQ&x=asdf#")));
        assertEquals("384IUU43bfQ", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/watch//?v=384IUU43bfQ#")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWatchWrong() {
        YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/watch?w=384IUU43bfQ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWatchWrong2() {
        YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/watch/384IUU43bfQ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWatchWrong3() {
        YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/watch");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWatchWrong4() {
        YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/watch/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWatchWrong5() {
        YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/watch//");
    }
}
