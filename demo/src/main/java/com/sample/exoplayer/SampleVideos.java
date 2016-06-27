package com.sample.exoplayer;

import com.google.android.exoplayer.util.Util;

import java.util.Locale;

class SampleVideos {

  public static class Sample {

    public final String name;
    public final String contentId;
    public final String provider;
    public final String uri;
    public final int type;

    public Sample(String name, String uri, int type) {
      this(name, name.toLowerCase(Locale.US).replaceAll("\\s", ""), "", uri, type);
    }

    public Sample(String name, String contentId, String provider, String uri, int type) {
      this.name = name;
      this.contentId = contentId;
      this.provider = provider;
      this.uri = uri;
      this.type = type;
    }

  }

  public static final Sample[] HLS = new Sample[] {
    new Sample("Apple master playlist",
        "https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/"
        + "bipbop_4x3_variant.m3u8", Util.TYPE_HLS),
    new Sample("Apple master playlist advanced",
        "https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/"
        + "bipbop_16x9_variant.m3u8", Util.TYPE_HLS),
    new Sample("Apple TS media playlist",
        "https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear1/"
        + "prog_index.m3u8", Util.TYPE_HLS),
    new Sample("Apple AAC media playlist",
        "https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear0/"
        + "prog_index.m3u8", Util.TYPE_HLS),
    new Sample("Apple ID3 metadata", "http://devimages.apple.com/samplecode/adDemo/ad.m3u8",
        Util.TYPE_HLS),
  };

  public static final Sample[] MISC = new Sample[] {
    new Sample("Dizzy", "http://html5demos.com/assets/dizzy.mp4", Util.TYPE_OTHER),
    new Sample("Apple AAC 10s", "https://devimages.apple.com.edgekey.net/"
        + "streaming/examples/bipbop_4x3/gear0/fileSequence0.aac", Util.TYPE_OTHER),
    new Sample("Apple TS 10s", "https://devimages.apple.com.edgekey.net/streaming/examples/"
        + "bipbop_4x3/gear1/fileSequence0.ts", Util.TYPE_OTHER),
    new Sample("Android screens (Matroska)", "http://storage.googleapis.com/exoplayer-test-media-1/"
        + "mkv/android-screens-lavf-56.36.100-aac-avc-main-1280x720.mkv",
        Util.TYPE_OTHER),
    new Sample("Big Buck Bunny (MP4 Video)",
        "http://redirector.c.youtube.com/videoplayback?id=604ed5ce52eda7ee&itag=22&source=youtube&"
        + "sparams=ip,ipbits,expire,source,id&ip=0.0.0.0&ipbits=0&expire=19000000000&signature="
        + "513F28C7FDCBEC60A66C86C9A393556C99DC47FB.04C88036EEE12565A1ED864A875A58F15D8B5300"
        + "&key=ik0", Util.TYPE_OTHER),
    new Sample("Screens 360P (WebM,VP9,No Audio)",
        "https://storage.googleapis.com/exoplayer-test-media-1/gen-3/screens/dash-vod-single-segmen"
        + "t/video-vp9-360.webm", Util.TYPE_OTHER),
    new Sample("Screens 480p (FMP4,H264,No Audio)",
        "https://storage.googleapis.com/exoplayer-test-media-1/gen-3/screens/dash-vod-single-segmen"
        + "t/video-avc-baseline-480.mp4", Util.TYPE_OTHER),
    new Sample("Screens 1080p (FMP4,H264, No Audio)",
        "https://storage.googleapis.com/exoplayer-test-media-1/gen-3/screens/dash-vod-single-segmen"
        + "t/video-137.mp4", Util.TYPE_OTHER),
    new Sample("Screens (FMP4,AAC Audio)",
        "https://storage.googleapis.com/exoplayer-test-media-1/gen-3/screens/dash-vod-single-segmen"
        + "t/audio-141.mp4", Util.TYPE_OTHER),
    new Sample("Google Play (MP3 Audio)",
        "http://storage.googleapis.com/exoplayer-test-media-0/play.mp3", Util.TYPE_OTHER),
    new Sample("Google Play (Ogg/Vorbis Audio)",
        "https://storage.googleapis.com/exoplayer-test-media-1/ogg/play.ogg", Util.TYPE_OTHER),
    new Sample("Google Glass (WebM Video with Vorbis Audio)",
        "http://demos.webmproject.org/exoplayer/glass_vp9_vorbis.webm", Util.TYPE_OTHER),
    new Sample("Big Buck Bunny (FLV Video)",
        "http://vod.leasewebcdn.com/bbb.flv?ri=1024&rs=150&start=0", Util.TYPE_OTHER),
  };

  private SampleVideos() {}

}
