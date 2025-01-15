<%@ page pageEncoding="UTF-8" %> 
<!DOCTYPE html> 

<html lang="ja"> 
<head> 
<meta charset="UTF-8"> 
<meta name="description" content="「毎日の健康な素肌を保つ
お手伝い」をコンセプトに日々の素肌のお手入れをご提案する「suhada」化粧品。
健康管理の一環として取り入れられるスキンケアをお試しください"> 
<meta name="keywords" content="suhada,健康,揺らぎ肌,日々のお手入れ" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Events</title> 

<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
 
<link rel="stylesheet" href="css/style.css"> 
</head> <body> 
<div class="container bg-white">
<form action="/eventsadmin" method="post"></form> 

<h1 class="eventh1">Events(管理者)</h1> 
<input type="text" name="eventName" value="春のお手入れ会"> 

<img src="images/face-front.png"> 

<h3 id="イベント日程">イベント日程</h3> 
<input type="text" name="eventDate" value="2024-02-10 14:00~15:00">
 
<h3 id="トリートメント内容">トリートメント内容</h3> 

<textarea name="treatmentDetails" cols="50" rows="10"> 
ハンドトリートメント 
指先から肘まで/所要時間:約15分 
フェイストリートメント 
デコルテからおでこまで/所要時間:約30分 
ボディトリートメント 
全身/所要時間:所要時間:約90分 
フットトリートメント 
ひざ下からつま先まで/所要時間:約20分</textarea> 

<h3 id="ギフト">ギフト</h3> 
<textarea name="giftDetails" cols="50" rows="5"> 
10,000円以上ご購入の場合 スターターキットミニ 
30,000円以上ご購入の場合 デラックスサンプル(ポーチ付き) </textarea> 

<form action="/Events/events"method="post">
<button type"submit">登録</button>
</form>

<a href="<%= request.getContextPath() %>/logout">ログアウト</a> 
</div> 

</body> 
</html>