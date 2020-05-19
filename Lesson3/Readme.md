# Lesson 3

## サイコロアプリに画像をつけるよ٩( 'ω' )و

### 手順

1. Lesson2のプロジェクトをコピー
2. 画像の追加
3. 文字を画像に変更
4. コードの効率化<br>
  ボタンを押すたびに`findViewById`したら負荷がかかりアプリの処理に遅延が発生する場合があるため
5. アプリ起動時の画像をデフォルトの画像に変更
6. APIレベルと互換性を理解する

--------------------------------------------------------------------------------

### Null-safety

kotlinには`null`絶対許さないマンの言語仕様がある<br>
`null`の値が参照されることによってアプリがクラッシュしないようにコンパイラエラーで事前にチェックしている

#### non-null と nullable

通常変数に`null`を挿入するとコンパイラエラーになる(non-null)<br>
型名の後ろに`?`をつけることによって`null`を挿入できるようになる(nullable)

```kotlin
val str1: String = null   // エラー

var str2: String = "text"
str2 = null               // エラー

val str3: String? = null  // OK

var str4: String? = "test2"  
str4 = null               // OK
```

#### nullチェック

`nullable`な変数にアクセスする場合、nullチェックをしなければコンパイラエラーがおきる

```kotlin
val str1 = "Kotlin"
println(str1.length)      // OK

val str2: String? = null
println(str2.length)      // エラー
```

##### 条件式

- 変数がvalで宣言されていた場合条件式で`null`を除外した場合アクセスできる

  ```kotlin
  // 条件式でのチェック
  val str3: String? = "hello"
  if (str3 != null) {
    val length = str3.length
  }
  ```

##### safe call 演算子

- 変数名の後に`?`をつけると変数の値が`null`なら`null`を返し、そうじゃなければアクセスするようになる

  ```kotlin
  // safe call 演算子でのチェック
  val str4: String? = "aaaaa"
  println(str4?.length)           // 5

  val str5: String? = null
  println(str5?.length)           // null
  ```

##### エルビス演算子

- 三項演算子のように値が`null`の時に特定の値を返す

  ```kotlin
  val str6: String? = "bbb"
  println(str6?.length ?: 0)  // 3

  val str7: String? = null
  println(str7?.length ?: 0)  // 0

  //val length = if (str6 != null) str6?.length else 0 と同じ
  ```

##### !!演算子

- `nullable`に対して強制的にアクセスできる<br>
  値が`null`だった場合は`NullPointerException`になるから取扱注意

  ```kotlin
  val str8: String? = "cccc"
  println(str8!!.length)  // 4

  val str9: String? = null
  println(str9!!.length)  // エラー
  ```

#### 参考にしたサイト

- Null Safety<br>
  <https://kotlinlang.org/docs/reference/null-safety.html>

- Kotlin Null Safetyについて知ろう<br>
  <https://tech.pjin.jp/blog/2017/04/10/kotlin_null_safety/>

- Kotlin - Nullを安全に処理する方法(Null safety、板の安定性)<br>
  <https://codechacha.com/ja/kotlin-null-safety/>

--------------------------------------------------------------------------------

### 初期化の遅延

クラス内で使いまわせる、ビューに配置しているパーツの値を使用した変数を宣言したいけど`onCreate()`が呼び出されるまでアクセスできないので

```
var diceImage : ImageView? = null
```

このように宣言することになるがそれだとNull-safetyの仕様的に好ましくないので`lateinit`や`by lazy`を使用して初期化の遅延をすることによって`null`不可の変数として扱えるようにする

- Properties and Fields<br>
  <https://kotlinlang.org/docs/reference/properties.html>

- Kotlinで初期化を遅延する<br>
  <https://re-engines.com/2018/11/15/kotlin%E3%81%A7%E5%88%9D%E6%9C%9F%E5%8C%96%E3%82%92%E9%81%85%E5%BB%B6%E3%81%99%E3%82%8B/>

--------------------------------------------------------------------------------

### Tool属性

`xml`ファイルで`tools:`を使用するとレイアウの確認などができるようになる<br>
ビルド時に削除されるためAPKのサイズやランタイムの動作に影響はない

- ツール属性のリファレンス<br>
  <https://developer.android.com/studio/write/tool-attributes?hl=ja>
