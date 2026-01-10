## Free Dictionary/辞書作成アプリケーション

ユーザーごと辞書を複数登録できます。”自由に目次をつくる”では、ブラウザに登録した単語を自由に配置し、座標が保存されます。

### 仕様技術
* **Java** (Servlet & JSP/JDBC)
* **CSS**
* **JavaScript**
* **PostgreSQL**

### 起動方法
1. PostgreSQLにて、リポジトリ内の"sql/schema.sql"を実行。データベースfreedictionaryと各テーブルが作成されます
2. "src/main/java/dao/BaseDAO.java"を開き"DB_URL" "DB_USER" "DB_PASSWORD"の内容をご自身のローカル環境の設定に変更
3. "src/main/webapp/jsp/login.jsp"をサーバーで実行
