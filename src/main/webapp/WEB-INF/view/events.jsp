<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="description"
	content="「毎日の健康な素肌を保つお手伝い」をコンセプトに日々の素肌のお手入れをご提案する「suhada」化粧品。健康管理の一環として取り入れられるスキンケアをお試しください">
<meta name="keywords" content="suhada,健康,揺らぎ肌,日々のお手入れ"
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Events</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header class="admin-header">
        <div class="container bg-white">

            <div class="container-fluid">
            
            <h1 class="evh1"><input type="text" value="${events.title}" name="title"></h1>
            <img src="images/face-front.png">
            <p>
              <a href="#イベント日程">イベント日程</a>
              <a href="#トリートメント内容">トリートメント内容</a>
              <a href="#ギフト">ギフト</a>
            </p>

            <h2 class="eventh2">イベント日程</h2>
             <input type="text" value="${events.date}" name="date"></td>
           
            <h2 class="eventh2">トリートメント内容</h2>
            
                  <textarea cols="50" rows="10" name="treatment">
			 ${events.treatment}</textarea>
          </table>
           
              <h2 class="eventh2">ギフト</h2>
              <textarea cols="50" rows="5" name="gift">
			       ${events.gift}
			      </textarea>
 
            <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>