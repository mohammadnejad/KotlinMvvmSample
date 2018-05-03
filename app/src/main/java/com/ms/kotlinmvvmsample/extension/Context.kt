package com.ms.kotlinmvvmsample.extension

import android.content.Context
import android.widget.Toast

/**
 * @author majid
 * @version 1.0
 * @date 5/3/18
 */

fun Context.toast(message: String?, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, message + "", duration).show()
