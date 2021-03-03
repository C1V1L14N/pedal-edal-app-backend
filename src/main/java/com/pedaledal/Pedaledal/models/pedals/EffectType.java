package com.pedaledal.Pedaledal.models.pedals;

public enum EffectType {

    LOOPER(),
    MULTI(),
    REVERB(),
    SYNTH();

    enum SATURATION {
        OVERDRIVE,
        FUZZ,
        DISTORTION,
        PREAMP
    }

    enum MODULATION {
        TREMOLO,
        CHORUS,
        FLANGER,
        PHASER,
        VIBRATO,
        PITCHSHIFTER,
        WAH_WAH,
        FILTER
    }


    enum DELAY{
        ANALOGUE,
        DIGITAL
    }

    enum DYNAMICS{
        GATE,
        COMPRESSOR
    }

    enum UTILITY{
        TUNER,
        EQUALISER,
        BOOST,
        VOLUME,
        EXPRESSION,
        SPLITTER,
        COMBINER,
        SWITCHER,
        TAP,
        MIDI,
        BUFFER
    }

    EffectType() {

    }

}
