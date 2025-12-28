<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #workspace{
        width: 100%;
        height: 100vh;
        position: relative;
        border: 1px solid #ccc;
    }
    .word{
    cursor: grab;
    background: #f5f5f5;
    padding: 5px;
    border-radius: 5px;
    display: inline-block;
    position: absolute;
    }
</style>
</head>
<body>
<div style＝”position: absolute; top: 10px; left: 10px; z-index: 1000;">
    <a href="/free_dictionary/home" style="color: #666; text-decolation: none;">ホームに戻る</a>
</div>


<div id = "workspace">
    <c:forEach var="w" items="${words}">
    <div class="word"
        data-id="${w.wordId}"
        style='left: ${w.posX}px; top: ${w.posY}px;'>
        <a href="/free_dictionary/ReadWord?wordId=${w.wordId}&dictionaryId=${w.dictionaryId}">
            ${w.wordName}
        </a>
    </div>
    </c:forEach>
</div>

<script>

document.querySelectorAll('.word').forEach(el =>{
	const link = el.querySelector("a");
	
	if(link){
		link.onclick = function(e){
			e.preventDefault();
		};
	}
	el.ondragstart = () => false;
	el.onmousedown = function(e){
		if(e.button !== 0) return;
		
		current = el;
		isDragging = false;
		
		const startX = e.clientX;
		const startY = e.clientY;
		
		let offsetX = e.clientX - el.offsetLeft;
		let offsetY = e.clientY - el.offsetTop;
		
		document.onmousemove = function(e){
			if(Math.abs(e.clientX - startX) > 3 || Math.abs(e.clientY - startY) > 3){
				isDragging = true;
			}
			current.style.left = (e.clientX - offsetX) + "px";
			current.style.top = (e.clientY - offsetY) + "px";
		};
		document.onmouseup = function(){
			document.onmousemove = null;
			document.onmouseup = null;
			
			if(!isDragging){
				if(link){
					window.location.href = link.href;
				}
			}else{
				savePos(el.dataset.id, el.style.left, el.style.top);
			}
			current = null;
		};
	};
});


/*
let current = null;
let isDragging = false;
/*let offsetX = 0;
let offsetY = 0;*/
/*
document.querySelectorAll('.word').forEach(el => {//forEach　wordクラスを指定した要素を一つずつelに代入　＝＞はfunction(el) functionは関数を作る
    //isDragging = false; //letは宣言するときに書く javascriptは型の指定はなし
    //const link = el.querySelector("a");
   
	el.ondragstart = function(){
		return false;
		}; //aタグに不随するドラッグが働かないようにする
    //要素をクリックした時に発生させるのでel.
	el.onmousedown = function(e){ //マウスを押した時の関数を作成　eにはイベント情報(mouseevent)が入る　mousedownはドラッグ開始の合図になるため、この関数の{}内にupやmoveも書く
        //let isDragging = false;
    	//つまりこのイベント発生後、同イベント内で動かす処理と終了する処理を有効にする必要がある
		e.preventDefault();//デフォルト操作を停止する

		current = el;//mousedownされたelを記録する
		isDragging = false;
		
		let offsetX = e.clientX - el.offsetLeft;//e.clientXはマウスのx座標　el.offsetLeftは要素の左位置
		let offsetY = e.clientY - el.offsetTop;//つまりクリックした位置からの差　対象をつまんだ位置
		
		
		
		document.onmousemove = function(e){//要素の外で発生させるのでdocument.
			isDragging = true;
			current.style.left = (e.clientX - offsetX) + "px";//currentは今選択されているel。要素のcssのleftを右オペラントにする。右は移動中の左端の座標位置
			current.style.top = (e.clientY - offsetY) + "px";
		};
		
		document.onmouseup = function(){
			document.onmousemove = null;
			document.onmouseup = null; 

			if(!isDragging){
                //link.click();
				//isDraggingがfalse ドラッグされなければ、つまりクリックされれば
				const link = el.querySelector("a");//再代入不可の変数宣言const 要素の<a>タグを取得
				//link.addEventListener("click", (e)=> e.preventDefault());
				if(link) link.click();//linkの中身があればclick()つまりaタグのリンク先に遷移する　ドラッグされればクリック扱いにならない
			}else{
				savePos(el.dataset.id, el.style.left, el.style.top);//ドラッグされれば位置を保存
			}

			current = null;
		};
	};
});*/
function savePos(wordId, x, y){
	fetch("UpdatePosition", {//fetchでservletにリクエストを送る　@/updatePosition
		method: "POST",
		headers:{"Content-Type": "application/x-www-form-urlencoded"},//Content-Type　送るデータの形式　postのbodyはurlエンコード形式という意味
		body: "word_id=" + wordId + "&x=" + parseInt(x) + "&y=" + parseInt(y)//pxなどの無駄な文字を消して送るためにparseIntする数字だけの文字列としてservletはキャッチする
	});
}
</script>

</body>
</html>