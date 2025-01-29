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
	<div class="container bg-white">
		<form action="" method="post">
			<h2 class="eventh1">Events(管理者)</h2>
		
			<h3 id="イベント名">イベント名
			<input type="text" value="${events.title}" name="title">
			</h3>
			
			<img src="images/face-front.png"> 
			
			<h3 id="イベント日程">イベント日程</h3>
			      <input type="text" value="${events.date}" name="date"></td> 
			 
			<h3 id="トリートメント内容">トリートメント内容</h3>
			      <textarea cols="50" rows="10" name="treatment">
			 ${events.treatment}</textarea>
			
			 
			
			<h3 id="ギフト">ギフト</h3>
			      <textarea cols="50" rows="5" name="gift">
			       ${events.gift}
			      </textarea> 
				<br>
			<input type="submit" value="登録">
		</form>
		<a href="<%=request.getContextPath()%>/logout">ログアウト</a>
	</div>
</body>
</html>