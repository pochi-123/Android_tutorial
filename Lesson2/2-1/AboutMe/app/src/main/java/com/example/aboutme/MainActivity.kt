package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ボタンタップの処理
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }

        // TextViewタップの処理
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
    }

    /**
     * ニックネーム追加
     */
    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        // 入力した値をTextViewに挿入
        nicknameTextView.text = editText.text

        // EditTextとButtonの非表示、TextViewの表示
        editText.visibility = View.GONE
        view.visibility = View.GONE     // ボタン
        nicknameTextView.visibility = View.VISIBLE

        // キーボード非表示にする
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * ニックネームの編集
     */
    private fun updateNickname (view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        //　EditTextとButtonの表示、TextViewの非表示
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE     // ニックネームのTextView

        // EditTextにフォーカス
        editText.requestFocus()
        // キーボードの表示
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }

}
