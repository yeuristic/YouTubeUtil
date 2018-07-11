package com.yeuristic.util;

import android.net.Uri;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class YouTubeUtilEmbedTest {

    @Test
    public void testEmbed() {
        assertEquals("Woq5iX9XQhA", YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/embed/Woq5iX9XQhA?"));
        assertEquals("Woq5iX9XQhA", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/embed/Woq5iX9XQhA?v=1")));
        assertEquals("Woq5iX9XQhA", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/embed/Woq5iX9XQhA")));
        assertEquals("Woq5iX9XQhA", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/embed/Woq5iX9XQhA&x=asdf#")));
        assertEquals("Woq5iX9XQhA", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/embed/Woq5iX9XQhA/")));
        assertEquals("Woq5iX9XQhA", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/embed/Woq5iX9XQhA//")));
        assertEquals("Woq5iX9XQhA", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/embed/Woq5iX9XQhA//#")));
        assertEquals("Woq5iX9XQhA", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/embed/Woq5iX9XQhA/#")));
        assertEquals("Woq5iX9XQhA", YouTubeUtil.getYouTubeVideoId(Uri.parse("http://www.youtube.com/embed/Woq5iX9XQhA#")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmbedWrong() {
        YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/embed/?");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmbedWrong2() {
        YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/embed/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmbedWrong3() {
        YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/embed?");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmbedWrong4() {
        YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/embed/#");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmbedWrong5() {
        YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/embed#");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmbedWrong6() {
        YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/embed&");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmbedWrong7() {
        YouTubeUtil.getYouTubeVideoId("http://www.youtube.com/embed&Woq5iX9XQhA");
    }
}
