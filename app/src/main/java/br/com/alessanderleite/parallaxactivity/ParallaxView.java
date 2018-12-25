package br.com.alessanderleite.parallaxactivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class ParallaxView extends SurfaceView implements Runnable {

    private volatile boolean running;
    private Thread gameThread = null;

    // For drawing
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder ourHolder;

    // Holds a reference to the Activity
    Context context;

    // Control the fps
    long fps = 60;

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
        while (running) {
            long startFrameTime = System.currentTimeMillis();

            update();

            draw();

            // Calculate the fps this frame
            long timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if (timeThisFrame >= 1) {
                fps = 1000 / timeThisFrame;
            }
        }
    }

    private void update() {
        // Update all the background positions
    }

    private void draw() {

        if (ourHolder.getSurface().isValid()) {
            // First we lock the area of memory we will be drawing to
            canvas = ourHolder.lockCanvas();

            // draw a background color
            canvas.drawColor(Color.argb(255, 0, 3, 70));

            // draw the background parallax

            // draw the rest of the game
            paint.setTextSize(60);
            paint.setColor(Color.argb(255, 255, 255, 255));
            canvas.drawText("I am a plane", 350, screenHeight / 100 * 5, paint);
            paint.setTextSize(220);
            canvas.drawText("I am a train", 50, screenHeight / 100 * 80, paint);

            // draw the foreground parallax

            // unlock and draw the scene
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }
}
