package com.example.flutter_method_channel

import android.content.Intent
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel


class MainActivity : FlutterActivity() {
    private val CHANNEL = "flutter.native/helper"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method.equals("helloFromNativeCode")) {
                helloFromNativeCode()
                //result.success(greetings)
            }
        }
    }

    private fun helloFromNativeCode(): Unit {
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        startActivity(intent)
    }
}


