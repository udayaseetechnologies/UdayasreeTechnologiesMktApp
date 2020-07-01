package com.udayasreetechnologies.utilitylibrary.customuiview.gifView;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Gururaj.C.M on 31-03-2017
 */

public  class GIFDataDownloader extends AsyncTask<String, Void, byte[]> {
    private Context context;
    public GIFDataDownloader(Context context){
        this. context = context;
    }
    private static final String TAG = "GIFDataDownloader";

    @Override protected byte[] doInBackground(final String... params) {
        final String gifUrl = params[0];

        if (gifUrl == null)
            return null;

        try {
            return getByteArrayFromURI(gifUrl,context);
        } catch (OutOfMemoryError e) {
            Log.e(TAG, "GifDecode OOM: " + gifUrl, e);
            return null;
        }
    }

    private static byte[] getByteArrayFromURI(String uri, Context context) {
        int size_ = 0;
        FileInputStream fis = null;
        try {
            AssetFileDescriptor fileDescriptor = context.getAssets().openFd(uri);
            fis = fileDescriptor.createInputStream();
            size_ = (int) fileDescriptor.getLength();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            byte[] bytes = new byte[size_];
            try {
                BufferedInputStream buf = null;
                if (fis != null) {
                    buf = new BufferedInputStream(fis);
                }
                buf.read(bytes, 0, bytes.length);
                buf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bytes;
        } catch (final Exception e) {
            Log.d(TAG, "IO exception", e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (final IOException ignored) {
                }
            }
        }
        return null;
    }
}
