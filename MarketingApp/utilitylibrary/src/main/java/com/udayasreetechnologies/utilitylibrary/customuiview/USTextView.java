package com.udayasreetechnologies.utilitylibrary.customuiview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.IntDef;
import androidx.appcompat.widget.AppCompatTextView;

import com.udayasreetechnologies.utilitylibrary.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class USTextView extends AppCompatTextView {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({USButton.TypefaceFont.REGULAR, USButton.TypefaceFont.DESCRIPTION, USButton.TypefaceFont.TITLE, USButton.TypefaceFont.SUBTITLE})
    public @interface TypefaceFont {
        int REGULAR = 0;
        int DESCRIPTION = 1;
        int TITLE = 2;
        int SUBTITLE = 3;
    }

    private Context context;
    private int typefaceFont = USButton.TypefaceFont.REGULAR;

    public USTextView(Context context) {
        super(context);
        this.context = context;
        setTypefaceFont();
    }

    public USTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }

    public USTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        try {
            if (attrs != null) {
                TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.USTextView);
                typefaceFont = typedArray.getInt(R.styleable.USTextView_typefaceTextView, USButton.TypefaceFont.REGULAR);
                setTypefaceFont();
                typedArray.recycle();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTypefaceFont() {
        try {
            Typeface typeface = null;
            switch (typefaceFont) {
                case TypefaceFont.DESCRIPTION:
                    typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Tajawal-Light.ttf");
                    break;
                case TypefaceFont.SUBTITLE:
                    typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Tajawal-Medium.ttf");
                    break;
                case TypefaceFont.TITLE:
                    typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Tajawal-Bold.ttf");
                    break;
                case TypefaceFont.REGULAR:
                default:
                    typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Tajawal-Regular.ttf");
                    break;
            }
            setTypeface(typeface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
