package com.chaochaogu.interfacer;

import java.applet.AudioClip;

/**
 * @author chaochao Gu
 * @date 2019/8/22
 */
public interface SingerSongwriter extends Singer, Songwriter {

    AudioClip strum();

    void actSensitive();
}
