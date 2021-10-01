<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>분류 관리</title>
	<script src="/resources/jq/jquery.js"></script>
	<style type="text/css">
		.box {
			display: inline-block;
			width: 200px;
			text-align: center;
		}

		.classify {
			width: 150px;

			margin: 20px;
		}

		#inputBox {
			width: 600px;
			border: 1px solid #ccc;
			margin-top: 30px;
		}
	</style>
	<script type="text/javascript">
		$().ready(() => {
			$("button").click(function () {
				const classify = $(this).data("classify");
				const action = $(this).data("action");
				const selectedData = {
					primaryId: "",
					foreginId: "",
					name: ""
				};
				const h2 = $("<h2 id='inputBoxTitle'>");
				const url = "/admin/object/classify/" + classify;
				const inputBox = $("#inputBox");

				//선택된 박스 정보
				const selectedBox = $("#" + classify + "Class option:selected");
				

				//선택된 데이터 정보값 가져오기
				selectedData.primaryId = selectedBox.data("primary");
				selectedData.name = selectedBox.data("name");
				selectedData.foreginId = selectedBox.data("foregin");

				//동적 from 생성
				const from = $("<form action = '" + url + "/" + action + "' method='POST'/>")
				let codeDiv;
				let nameDiv;
				let submitDiv;
				let foreDiv;
				from.append(h2);

				
				switch (classify) {
					case "top":
						h2.text("대분류");
						codeDiv = $("<div>");
						from.append(codeDiv);
						codeDiv.append($("<label for = 'primaryId'/>").text("분류CODE"));
						codeDiv.append($("<input type='text' name='primaryId' id='primaryId'/>"));

						nameDiv = $("<div>");
						from.append(nameDiv);
						nameDiv.append($("<label for = 'className'/>").text("분류명"));
						nameDiv.append($("<input type='text' name='name' id='className'/>"));

						submitDiv = $("<div>");
						from.append(submitDiv);
						submitDiv.append($("<input type='submit' value='추가'/>"));

						inputBox.empty();
						inputBox.append(from);
						break;
						
					case "mid":
						h2.text("중분류");
						codeDiv = $("<div>");
						from.append(codeDiv);
						codeDiv.append($("<label for = 'primaryId'/>").text("분류CODE"));
						codeDiv.append($("<input type='text' name='primaryId' id='primaryId'/>"));

						foreDiv = $("<div>");
						from.append(foreDiv);
						foreDiv.append($("<label for = 'foreginId'/>").text("상위 분류 코드"));
						foreDiv.append($("<input type='text' name='foreginId' id='foreginId'/>"));

						nameDiv = $("<div>");
						from.append(nameDiv);
						nameDiv.append($("<label for = 'className'/>").text("분류명"));
						nameDiv.append($("<input type='text' name='name' id='className'/>"));

						submitDiv = $("<div>");
						from.append(submitDiv);
						submitDiv.append($("<input type='submit' value='추가'/>"));

						inputBox.empty();
						inputBox.append(from);
						break;

					case "bot":
						h2.text("소분류");
						codeDiv = $("<div>");
						from.append(codeDiv);
						codeDiv.append($("<label for = 'primaryId'/>").text("분류CODE"));
						codeDiv.append($("<input type='text' name='primaryId' id='primaryId'/>"));

						foreDiv = $("<div>");
						from.append(foreDiv);
						foreDiv.append($("<label for = 'foreginId'/>").text("상위 분류 코드"));
						foreDiv.append($("<input type='text' name='foreginId' id='foreginId'/>"));

						nameDiv = $("<div>");
						from.append(nameDiv);
						nameDiv.append($("<label for = 'className'/>").text("분류명"));
						nameDiv.append($("<input type='text' name='name' id='className'/>"));

						submitDiv = $("<div>");
						from.append(submitDiv);
						submitDiv.append($("<input type='submit' value='추가'/>"));

						inputBox.empty();
						inputBox.append(from);

						break;

				}

				switch (action) {
					case "add":
						h2.text(h2.text() + " 신규 등록");
						break;

					case "update":
						h2.text(h2.text() + " 변경");
						$("#primaryId").attr("value",selectedData.primaryId);
						$("#primaryId").attr("readonly","readonly");
						$("#foreginId").attr("value",selectedData.foreginId);
						$("#foreginId").attr("readonly","readonly");
						$("#className").attr("value",selectedData.name);
						$("input[type='submit']").val("변경");
						break;
					case "delete":
						inputBox.empty();
						$.ajax({
							url: url + "/delete/" + selectedData.primaryId,
							success: function (data) {								
								inputBox.append($("<h2/>").text("삭제 완료"));
								selectedBox.remove();
							},
							error : function(data){
								inputBox.append($("<h2/>").text("삭제 실패"));
							}

						});
						break;
				}

			})
		})
	</script>
</head>

<body>
	<div>
		<div class="box">
			<h3>대분류</h3>
			<select id="topClass" size=10 class="classify">
				<c:forEach var="item" items="${topClass}">
					<option data-foregin="${item.foreginId}" data-primary="${item.primaryId }" data-name="${item.name }">[${item.primaryId }] ${item.name }</option>
				</c:forEach>
			</select>
			

			<div>
				<button data-classify="top" data-action="add" class="button">등록</button>
				<button data-classify="top" data-action="update" class="button">변경</button>
				<button data-classify="top" data-action="delete" class="button">삭제</button>
			</div>
		</div>

		<div class="box">
			<h3>중분류</h3>
			<select id="midClass" size=10 class="classify">
		<c:forEach var="item" items="${midClass}">
					<option data-foregin="${item.foreginId}" data-primary="${item.primaryId }" data-name="${item.name }">[${item.primaryId }] ${item.name }</option>
				</c:forEach>
			</select>
			<div>
				<button data-classify="mid" data-action="add" class="button">등록</button>
				<button data-classify="mid" data-action="update" class="button">변경</button>
				<button data-classify="mid" data-action="delete" class="button">삭제</button>
			</div>
		</div>

		<div class="box">
			<h3>소분류</h3>
			<select id="botClass" size=10 class="classify">
<c:forEach var="item" items="${botClass}">
					<option data-foregin="${item.foreginId}" data-primary="${item.primaryId }" data-name="${item.name }">[${item.primaryId }] ${item.name }</option>
				</c:forEach>
			</select>
			<div>
				<button data-classify="bot" data-action="add" class="button">등록</button>
				<button data-classify="bot" data-action="update" class="button">변경</button>
				<button data-classify="bot" data-action="delete" class="button">삭제</button>
			</div>
		</div>

		<div id="inputBox">

		</div>
	</div>
</body>

</html>