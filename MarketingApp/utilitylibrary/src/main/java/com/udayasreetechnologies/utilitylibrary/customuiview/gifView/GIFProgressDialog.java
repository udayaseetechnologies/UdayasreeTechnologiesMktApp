package com.udayasreetechnologies.utilitylibrary.customuiview.gifView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import com.udayasreetechnologies.utilitylibrary.R;
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView;

public class GIFProgressDialog extends Dialog {

    private boolean isDialogGifanimation = false;
    private Context context;
    private GIFImageView gifImageView;
    private USTextView customTextView;

    public GIFProgressDialog(Context context) {
        super(context);
        this.context = context;
    }

    public GIFProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.gif_progress_dialog);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getWindow().getAttributes().windowAnimations = R.style.Animation_left_right;
        setCancelable(false);
        isDialogGifanimation = true;
        gifImageView = findViewById(R.id.gif_progress_imageview);
        customTextView = findViewById(R.id.gif_progress_textview);

        gifImageView.setOnFrameAvailable(new GIFImageView.OnFrameAvailable() {
            @Override
            public Bitmap onFrameAvailable(Bitmap bitmap) {
                return bitmap;
            }
        });
        gifImageView.setOnAnimationStop(new GIFImageView.OnAnimationStop() {
            @Override
            public void onAnimationStop() {
                if (isDialogGifanimation) {
                    gifImageView.resetAnimation();
                    gifImageView.startAnimation();
                } else {
                    dismissGif();
                }
            }
        });
        new GIFDataDownloader(context) {
            @Override
            protected void onPostExecute(final byte[] bytes) {
                gifImageView.setBytes(bytes);
                gifImageView.startAnimation();
                isDialogGifanimation = true;
            }
        }.execute("gear_moment_giff.gif");
    }

    public void showGif() {
        if (!isShowing()) {
            show();
        }
    }

    public void dismissGif() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void setMessage(String message) {
        customTextView.setText(message);
    }
}
