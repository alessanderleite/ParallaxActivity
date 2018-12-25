package br.com.alessanderleite.parallaxactivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class ParallaxView extends SurfaceView implements Runnable {

    // For drawing
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder ourHolder;

    // Holds a reference to the Activity
    Context context;

    // Screen resolution
    int screenWidth;
    int screenHeight;

    public ParallaxView(Context context, int screenWidth, int screenHeight) {
        super(context);

        this.context = context;

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        // Initialize our drawing objects
        ourHolder = getHolder();
        paint = new Paint();
    }


    @Override
    public void run() {

    }
}
