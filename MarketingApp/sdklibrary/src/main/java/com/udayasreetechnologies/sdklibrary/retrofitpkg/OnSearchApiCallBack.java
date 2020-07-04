package com.udayasreetechnologies.sdklibrary.retrofitpkg;

import java.util.ArrayList;

public interface OnSearchApiCallBack {
    void onSearchResponseSuccessfulListener(ArrayList<String> searchResponse);
    void onResponseFailed(String error);
}
