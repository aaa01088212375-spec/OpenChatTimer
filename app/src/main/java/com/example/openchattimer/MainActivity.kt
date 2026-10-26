
package com.example.openchattimer

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private var running = false
    private val handler = android.os.Handler(android.os.Looper.getMainLooper())
    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(Color.rgb(245, 247, 250))
        }

        val title = TextView(this).apply {
            text = "오픈채팅 타이머"
            textSize = 26f
            setTextColor(Color.BLACK)
            gravity = Gravity.CENTER
        }

        val message = EditText(this).apply {
            hint = "보낼 메시지를 입력하세요"
            setText("안녕하세요!")
            textSize = 18f
        }

        status = TextView(this).apply {
            text = "상태: 대기 중"
            textSize = 16f
            gravity = Gravity.CENTER
        }

        val start = Button(this).apply {
            text = "시작"
            setOnClickListener {
                if (message.text.toString().isBlank()) {
                    Toast.makeText(this@MainActivity, "메시지를 입력해 줘", Toast.LENGTH_SHORT).show()
                } else {
                    running = true
                    status.text = "상태: 실행 중 (5분 간격)"
                    Toast.makeText(this@MainActivity, "타이머 시작", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val stop = Button(this).apply {
            text = "중지"
            setOnClickListener {
                running = false
                status.text = "상태: 중지됨"
                Toast.makeText(this@MainActivity, "타이머 중지", Toast.LENGTH_SHORT).show()
            }
        }

        layout.addView(title)
        layout.addView(message)
        layout.addView(status)
        layout.addView(start)
        layout.addView(stop)

        setContentView(layout)
    }
}
