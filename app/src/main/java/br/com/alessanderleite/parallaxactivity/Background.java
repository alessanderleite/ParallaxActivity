package br.com.alessanderleite.parallaxactivity;

import android.content.Context;
import android.graphics.Bitmap;

public class Background {

    Bitmap bitmap;
    Bitmap bitmapReversed;

    int width;
    int height;
    boolean reversedFirst;
    float speed;

    int xClip;
    int startY;
    int endY;

    public Background(Context context, int screenWidth, int screenHeight, String bitmapName, int sY, int eY, float s) {
    }

    public void update(long fps) {

    }
}
