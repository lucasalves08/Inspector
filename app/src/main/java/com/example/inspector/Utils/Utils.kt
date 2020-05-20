package com.example.inspector.Utils

import android.content.Context
import android.widget.Toast

/**
 * Created by Lucas Alves dos Santos on 17/05/2020.
 * lucas.alves0828@gmail.com
 * {@see more in https://github.com/lucasalves08}
 */
class Utils {
    companion object {
        fun alert( text: String) {
            Toast.makeText(App.instance, text, Toast.LENGTH_SHORT).show()
        }
    }
}