<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ログアウト</title>

<link rel="stylesheet" href="css/style.css">
</head>
<body>
<header class="admin-header">
  <div class="container">
    <nav class="navbar navbar-default">
      <div class="navbar-header">
        <h1 class="logouth1">Events</h1>
      </div>
    </nav>
  </div>
</header>
<div class="container admin-container">
  <main>
    <h2 class="logouth2">ログアウト完了</h2>
    <p><a href="<%= request.getContextPath() %>/login">ログインページに戻る</a></p>
  </main>
</div>

<script src="../js/jquery-2.1.4.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>