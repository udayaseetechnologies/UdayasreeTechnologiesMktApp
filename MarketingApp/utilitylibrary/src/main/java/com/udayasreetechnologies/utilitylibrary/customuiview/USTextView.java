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
                case USButton.TypefaceFont.DESCRIPTION:
                    typeface = Typeface.createFromAsset(context.getAssets(), "fonts/PlayfairDisplay_Desc.ttf");
                    setTextSize(26 / getResources().getDisplayMetrics().scaledDensity);
                    break;
                case USButton.TypefaceFont.SUBTITLE:
                    typeface = Typeface.createFromAsset(context.getAssets(), "fonts/PlayfairDisplay_Subtitle.ttf");
                    setTextSize(28 / getResources().getDisplayMetrics().scaledDensity);
                    break;
                case USButton.TypefaceFont.TITLE:
                    typeface = Typeface.createFromAsset(context.getAssets(), "fonts/PlayfairDisplay_Title.ttf");
                    setTextSize(36 / getResources().getDisplayMetrics().scaledDensity);
                    break;
                case USButton.TypefaceFont.REGULAR:
                default:
                    typeface = Typeface.createFromAsset(context.getAssets(), "fonts/PlayfairDisplay_Regular.ttf");
                    setTextSize(32 / getResources().getDisplayMetrics().scaledDensity);
                    break;
            }
            setTypeface(typeface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
