package com.example.core;

import com.example.core.utils.Utils;
import com.example.core.utils.UtilsKt;

/**
 * @author yu
 */
class JavaTest {

    public static void main(String[] args) {
        BaseApplication.Companion.getCurrentApplication();

        UtilsKt.toast("");
        Utils.dp2px(1f);
        Utils.INSTANCE.px2dp(1f);
    }

}
