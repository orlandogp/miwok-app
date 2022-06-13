package com.example.miwok;

public class Word {

    /** Default translation for the word */
    private int mDefaultTranslation;

    /** Miwok translation for the word */
    private int mMiwokTranslation;

    /** Miwok image for the word */
    private int mImageResourceId  = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /** Miwok audio for the word */
    private int mMiwokAudioRessourceId;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     *
     * @param imageResourceId is the image asset for each word
     *
     * @param miwokAudio is the audio asset for each word
     *
     */
    public Word(int defaultTranslation, int miwokTranslation, int miwokAudio) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mMiwokAudioRessourceId = miwokAudio;
    }

    public Word(int defaultTranslation, int miwokTranslation, int imageResourceId, int miwokAudio){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mMiwokAudioRessourceId = miwokAudio;
    }

    /**
     * Get the default translation of the word.
     */
    public int getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public int getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the image Miwok translation of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Get the audio Miwok translation of the word.
     */
    public int getAudioResourceId() {
        return mMiwokAudioRessourceId;
    }

}