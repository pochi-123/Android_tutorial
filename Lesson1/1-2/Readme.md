# Lesson 1-2

## サイコロアプリを作るよ٩( 'ω' )و

### 手順

1. プロジェクト作成
2. テキスト追加
3. ボタン追加<br>
  ボタンのラベル直書きは好ましくないので`res/values/String.xml`に記述する
4. 位置調整
5. ボタンに処理を追加する
6. カウントアップの処理追加
7. カウントリセットの処理追加

--------------------------------------------------------------------------------

#### ライフサイクル

- アクティビティが開始されるときの処理の実行する順番

- アクティビティのライフサイクル<br>
  <https://www.javadrive.jp/android/activity/index2.html><br>

- developerドキュメント(アクティビティのライフサイクルについて)<br>
  <https://developer.android.com/guide/components/activities/activity-lifecycle?hl=ja>

#### サイズの単位

- サイズの単位はいろいろあるけど、基本的に画面に合わせて相対的に変わる`dp`,`sp`を使用する
- 文字サイズの場合は`sp`を使用するとユーザーのフォントサイズ設定により縮小されるので推奨されている

- Android dp（dip）とspについて 【Android TIPS】<br>
  <https://tech.pjin.jp/blog/2013/06/07/android%E3%80%80dp%EF%BC%88dip%EF%BC%89%E3%81%A8sp%E3%81%AB%E3%81%A4%E3%81%84%E3%81%A6-%E3%80%90android-tips%E3%80%91/><br>

- 【Android】今さら聞けない、px、sp、dip、dpの違い<br>
  <http://blog.shonanshachu.com/2012/10/androidpxspdipdp.html>
