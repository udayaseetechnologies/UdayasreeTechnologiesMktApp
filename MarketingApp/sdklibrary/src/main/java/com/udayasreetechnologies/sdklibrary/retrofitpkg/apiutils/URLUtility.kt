package com.udayasreetechnologies.sdklibrary.retrofitpkg.apiutils

class URLUtility {
    companion object {
        /**
         * TEST MODE -> TRUE
         * LIVE MODE -> FALSE
         */
        const val isDebug_ = true

        /***********************************************/

        private const val URL_TEST = "http://68.183.82.193/"

        private const val URL_LIVE = "http://udayasreetechnologies.com/"

        @JvmField
        val SDK_BASE_URL = if (isDebug_) URL_TEST else URL_LIVE
    }
}