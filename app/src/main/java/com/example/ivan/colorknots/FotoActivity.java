package com.example.ivan.colorknots;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FotoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
        //setContentView(R.layout.activity_foto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    class DrawView extends View {

        Paint paint;
        Bitmap bitmap;
        Rect rectSrc;
        Rect rectDst;
        Matrix matrix;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);

            /*String info =
                    String.format("Info: size = %s x %s, bytes = %s (%s), config = %s",
                            bitmap.getWidth(),
                            bitmap.getHeight(),
                            bitmap.getByteCount(),
                            bitmap.getRowBytes(),
                            bitmap.getConfig());
            Log.d("log", info);*/

            matrix = new Matrix();
            matrix.postRotate(45);
            matrix.postScale(2, 3);
            matrix.postTranslate(200, 50);

            rectSrc = new Rect(0, 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
            rectDst = new Rect(300, 100, 500, 200);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            canvas.drawBitmap(bitmap, 50, 50, paint);
            canvas.drawBitmap(bitmap, matrix, paint);
            canvas.drawBitmap(bitmap, rectSrc, rectDst, paint);
        }

    }
}
