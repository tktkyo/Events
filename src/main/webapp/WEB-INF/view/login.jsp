<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title class="login_title">ログイン</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<header class="admin-header">
  <div class="container">
    <nav class="navbar navbar-default">
      <div class="navbar-header">
        <h1 class="loginh1">Events</h1>
      </div>
    </nav>
  </div>
</header>
<div class="container admin-container">
  <main>
    <h2 class="loginh2">ログイン</h2>
    <p class="loginp1">ログインIDを入力し、ログインボタンを押してください。</p>
<form action="" method="post">
     
    <table class="login-table">
      <tr>
        <th>ログインID</th>
        <td><input type="text" name="user_id" ></td>
      </tr>
      
    </table>
    <p><input class="btn btn-primary" type="submit" value="ログイン"></p>
    
    </form>
  </main>
</div>
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>