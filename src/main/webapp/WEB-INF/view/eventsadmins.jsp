<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="description"
	content="「毎日の健康な素肌を保つ
お手伝い」をコンセプトに日々の素肌のお手入れをご提案する「suhada」化粧品。
健康管理の一環として取り入れられるスキンケアをお試しください">
<meta name="keywords" content="suhada,健康,揺らぎ肌,日々のお手入れ">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Events</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<div class="container bg-white"
		<form action="/eventsadmin" method="post">
<h1 class="eventh1">Events(管理者)</h1>

<h2>イベント名
<input type="text" name="name" > 
</h2> 

<img src="images/face-front.png"> 

<h3>イベント日程
<input type="text" name="date" >
</h3> 
 
<h3>トリートメント内容
<textarea name="treatment" cols="50" rows="10"> 
</textarea>
</h3> 
 

<h3>ギフト
<textarea name="gift" cols="50" rows="5"> 
 </textarea> 
</h3> 


<button type="submit">登録</button>
</form>
		<a href="<%=request.getContextPath()%>/logout">ログアウト</a></div>

</body>
</html>