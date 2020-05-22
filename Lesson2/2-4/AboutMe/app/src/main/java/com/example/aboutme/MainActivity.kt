package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // バインディングで呼び出せるようにする
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        // ボタンタップの処理
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        // TextViewタップの処理
        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
    }

    /**
     * ニックネーム追加
     */
    private fun addNickname(view: View) {
        // 入力した値をTextViewに挿入
//        binding.nicknameText.text = binding.nicknameEdit.text

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            // EditTextとButtonの非表示、TextViewの表示
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // キーボード非表示にする
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * ニックネームの編集
     */
    private fun updateNickname (view: View) {
        //　EditTextとButtonの表示、TextViewの非表示
        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE    // ニックネームのTextView

        // EditTextにフォーカス
        binding.nicknameEdit.requestFocus()
        // キーボードの表示
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)
    }

}
