
const thType = Array();
const addType = Array();
const comboBox = Array();

let action = "";
let insertCount = 0;
let tableName = "";
let view = false;
let selectedBox;
let popoverList = Array();


const state = {
	url: "",
	page: 1,
	perPage: 10,
	search: 0,
	keyword: "",
	order: "",
	orderMode: 0
}


$(function() {
	//QueryString 분석, 선택한 nav 표시하기

	selectedNav()

	//val 함수에 이벤트 추가.
	const originalVal = $.fn.val;
	$.fn.val = function() {
		const result = originalVal.apply(this, arguments);
		if (arguments.length > 0)
			$(this).change();
		return result;
	};
	
	//메인페이지 선택 하는 버튼
	$(".option").on("click", function() {
		$(".selectedHeader").removeClass("selectedHeader");
		$(this).addClass("selectedHeader");
		$(".option").find("i").removeClass("bi-caret-right-fill");
		$(this).find("i").addClass(" bi-caret-right-fill");

		const url = $(this).data("url");
		if (url != "#") {
			state.url = url
			$("#subContent").empty();
			state.page = 1;
			insertCount = 0;
			content(state.url);
		}
	})

	//mainContent Row 선택 이벤트
	$("#mainTable").on("click", ".dataRow", function() {
		$(".selectedRow").removeClass("selectedRow");
		$(this).addClass("selectedRow")

		if (view == true) {
			viewMarker($(this));
		}
	})

	//pager 이벤트 추가
	$("#pager").on("click", ".pager", function() {
		$("#page-list").empty();

		state.page = $(this).data("page");
		content(state.url);

	})



	//일반 액션 버튼-추가, 삭제, 저장. common 클래스 상속 받은 애들 처리
	$(".commonAction").on("click", function() {
		action = $(this).attr("id");
		switch (action) {
			case "add":
				insertCount = 0;
				commonAdd();
				break;

			case "update":
			case "delete":
				common();
				$("#commonModal").modal("show");
				break;
		}

	})
	//select change Image size
	$("#subContent").on("change", ".changeSize", function() {
		$(".viewImage").css("width", $(this).val());
	})

	//플러스 클릭
	$("#subContent").on("click", ".plus", function() {

		let tr = $("<tr class='insertRow'>");
		tr.append($("<td class='center'>").append($("<div class='minus'>")))
		tr.append($("<td class='center'>").append($("<label class='form-label numLabel'>").text(++insertCount)));

		for (let a = 0; a < addType.length; a++) {
			let td = $("<td>");
			let temp = makeCell(null, a, 0, addType[a][1], addType[a][2], "add")
			switch (addType[a][2]) {
				case "none":
					temp.addClass("center form-control");
					temp.attr("placeholder", "자동입력 됩니다.")
					break;

				case "text":
				case "number":
					temp.attr("placeholder", "값을 입력해 주세요.")

					break;
				case "area":
					temp.addClass("updateArea")
					temp.find(".showbox").text("내용편집:더블클릭")
					temp.find(".area").val("<p>&nbsp;</p>")
					break;

				case "combo":
					temp.addClass("addCombo");
					break;
				case "date":
					temp.addClass('addDate center form-control');
					break;
				case "datetime":
					temp.addClass('addDatetime center form-control');
					break;
				case "file":
					temp.addClass('addPopDiv');
					break;

			}
			temp.removeClass("updateRow nonBorderTextBox");
			td.append(temp);
			tr.append(td);

		}
		if (insertCount > 6) {
			let count = Number($("#subContent").css("height").match("[0-9]+").pop())

			$("#subContent").css("height", (count + 55));
		}

		$(this).parent().parent().before(tr);
		makePerfect("add");

	});

	//마이너스 클릭
	$("#subContent").on("click", ".minus", function() {
		$(this).parent().parent().remove();
		let arr = $(".numLabel");
		insertCount = 0;
		arr.each((index, value) => {
			$(value).text(++insertCount);
		})
		if (insertCount >= 6) {
			let count = Number($("#subContent").css("height").match("[0-9]+").pop())

			$("#subContent").css("height", count - 55);
		}

	})

	//subContent의 저장 버튼
	$("#subContent").on("click", ".insert", function() {
		let insertRow = $(".insertRow");
		fileUploader(insertRow);
		let rowlist = makeList(insertRow, "add");

		$.ajax("add/" + state.url, {
			contentType: "application/json",
			type: "post",
			data: JSON.stringify(rowlist),
			success: function(data) {
				state.page = 1;
				content(state.url);
				$("#insertTbody").empty();
				$("#insertTbody").append($("<tr>").append($(`<td colspan='${addType.length + 2}' class="center">`).append($("<h4>").text("등록을 완료 하였습니다."))));
				insertCount = 0;
			}

		})

	})

	//모달 버튼 commonModal 일때 반응
	$(".modal-footer").on("click", "#commonButton", function() {
		let selectedRow = $("#modal-table").find("tr");
		fileUploader(selectedRow);
		let list = makeList(selectedRow, "select");
		console.log(list);
		$.ajax(action + "/" + state.url, {
			contentType: "application/json",
			type: "post",
			data: JSON.stringify(list),
			success: function(data) {
				$("#commonModal").modal("hide");
				content(state.url);
				$("#subContent").empty();

			}
		})
	})

	//모달 버튼 Text편집기 일때 반응
	$(".modal-footer").on("click", "#changeArea", function() {
		CKEDITOR.instances.ckeditor.updateElement()
		const modalArea = $(".modal-body").find(".area");

		$("textarea.textEdit").val(modalArea.val());
		$("div.textEdit").html(modalArea.val());

		$("#commonModal").modal("hide");

	})
	//테이블 수정하면 check 박스 온
	$("#mainContent").on("change", ".updateRow", function() {
		$(this).parents(".dataRow").find(".form-check-input").prop("checked", true);
	});

	//모달 창이 닫힐때 이벤트
	$("#commonModal").on("hide.bs.modal", function() {
		const origin = $(".textEdit");
		origin.removeClass("textEdit");
		if (selectedBox == null || selectedBox.find(".area").hasClass("updateRow"))
			$(".selectedRow").find(".showbox").addClass("nonBorderTextBox")
	})

	//thead의 check 박스 이벤트
	$("#mainTable").on("click", "thead .form-check-input", function() {
		if ($(this).is(":checked"))
			$("tbody .form-check-input").prop("checked", true);
		else
			$("tbody .form-check-input").prop("checked", false);
	})


	//파일 변경시 이벤트
	$("#mainContent, #subContent").on("change", ".fileUploader", function() {
		const div = $(this).parent();
		tempfileUploader(div)

	});

	//메인에서 area 클릭시 ckeditor 모달창으로 띄우기
	$("#mainTable, #subContent").on("dblclick", ".areatext", function() {
		$(this).children().addClass("textEdit")

		let area = $(this).children("textarea").clone();

		$(this).removeClass("nonBorderTextBox");
		$(this).removeClass("comboBox")

		$(area).attr("name", "ckeditor");


		$(".modal-title").text("Text 편집기");

		$(".modal-body").empty();
		$(".modal-body").append($(area));

		$(".commonModal").attr("id", "changeArea");
		$(".commonModal").text("변경");

		CKEDITOR.replace('ckeditor');
		$("#commonModal").modal("show");
	})

	//날짜 더블클릭으로 초기화
	$("#mainTable, #subContent").on("dblclick", ".date", function() {
		$(this).val("");
	})

	//subContent에서 수정 
	$("#subContent").on("click", "#subUpdate", function() {
		const $items = $("#subContent");
		fileUploader($items);
		const list = makeList($items, "select")

		$.ajax("update/" + state.url, {
			contentType: "application/json",
			type: "post",
			data: JSON.stringify(list),
			success: function(data) {
				state.page = 1;
				content(state.url);
				$("#subContent").empty();
				$("#subContent").append($("<div class='m-5'>").append($(`<td colspan='${addType.length + 2}' class="center">`).append($("<h4>").text("수정을 완료 하였습니다."))));

			}

		})

	});

});
//fileUploader
function fileUploader(inputs) {
	const file = inputs.find(".fileUploader");
	const id = inputs.find(".C0");
	if (file.length > 0) {
		const fileSrc = inputs.find(".fileSrc");
		console.log(fileSrc);
		const form = $('<form method="POST" enctype="multipart/form-data">').append(file.clone());
		form.append($('<input type="text" name="folder">').attr("value", state.url));

		id.each((index, value) => {
			form.append($('<input type="text" name="name">').attr("value", $(value).val()));
		});

		const formData = new FormData(form.get(0));

		$.ajax({
			method: "post",
			enctype: 'multipart/form-data',
			url: "/fileUpload",
			data: formData,
			async: false,
			processData: false,
			contentType: false,
			cache: false,
			timeout: 600000,
			success: function(data) {

				fileSrc.each((index, value) => {

					if (data[index] != undefined) {
						$(value).val(data[index]);
						console.log(data[index]);
						console.log($(value).val());
					}
				})

			},
			error: function(e) {
				alert("파일 업로드를 실패하였습니다.");
			}
		});
	}
}


//tempfileUploader //썸네일 업로드
function tempfileUploader(inputs) {
	const file = inputs.find(".fileUploader");
	if (file.length > 0) {
		const fileSrc = inputs.find(".fileSrc");
		console.log(fileSrc);
		const form = $('<form method="POST" enctype="multipart/form-data">').append(file.clone());
		form.append($('<input type="text" name="folder">').attr("value", state.url));
		const formData = new FormData(form.get(0));

		$.ajax({
			method: "post",
			enctype: 'multipart/form-data',
			url: "/tempfileUpload",
			data: formData,
			processData: false,
			contentType: false,
			cache: false,
			timeout: 600000,
			success: function(data) {

				fileSrc.each((index, value) => {
					if (data[index] != "") {
						let parent = $(value).parent()
						if (parent.hasClass("viewFile")) {
							parent.parents(".imgDiv").next().children("img").attr("src", data[index])
						} else {
							parent.attr("data-bs-content", `<img class='popImg' src='${data[index]}'/>`)
							nowPop = bootstrap.Popover.getInstance(parent.get(0))
							nowPop.hide();
							nowPop = new bootstrap.Popover(parent, { html: true });
							nowPop.show();
						}
					}
				})


			},
			error: function(e) {
				alert("파일 업로드를 실패하였습니다.");
			}
		});
	}
}


//view maker
function viewMarker(selectedRow) {
	let div = $("<div>");
	let div2 = $('<div class="mx-5 mt-2 row row-cols-2">') //2줄 짜리
	let div1 = $('<div class="mx-5 mt-4 row row-cols-1">') //1줄 짜리
	div.append(div2);
	div.append(div1);

	for (let a = 0; a < thType.length; a++) {
		let innerDiv;
		let type = thType[a][2];
		let th = thType[a][0];
		let c = "C" + a;

		let nowCol = $(selectedRow).find("." + c);
		//가장 상위 부모와 라벨 만들기
		innerDiv = $("<div>")
		innerDiv.append($('<label class="form-label">')
			.append($('<i class="bi bi-nut">'))
			.append($("<strong>").text(th))
		);


		const temp = makeCell(nowCol.val(), a, 0, nowCol.attr("name"), type, "select");
		innerDiv.append(temp);

		//수정가능한 cell
		switch (type) {
			case "none":
				temp.addClass("form-control")
				break;
			case "date":
				temp.addClass("viewDate form-control")
				break;
			case "datetime":
				temp.addClass("viewDatetime form-control")
				break;

			case "combo":
				temp.addClass("viewCombo")
				break;

			case "text":
			case "number":
				break;

			case "area":

				temp.find(".showbox").removeClass("center showbox-restraint").css("min-height", "200px")

				break;
			case "file":
				temp.addClass("viewFile mx-3")
				innerDiv.append($("<select class='mx-3 changeSize form-select'>")
					.append($("<option value='200px'>").text("200px"))
					.append($("<option value='400px'>").text("400px"))
					.append($("<option value='600px'>").text("600px"))
					.append($("<option value='50%'>").text("50%"))
					.append($("<option value='100%'>").text("100%"))
				)
				break;
		}

		//붙이기 1칸짜리와 2칸짜리 위치가 틀림.
		switch (type) {
			case "none":
			case "date":
			case "datetime":
			case "combo":
			case "text":
			case "number":
				div2.append($("<div class='col mt-2'>").append(innerDiv));
				break;

			case "area":
				div1.append($("<div class='col  mt-2'>").append(innerDiv));
				break;
			case "file":
				let src = makeSrc(temp.find(".fileSrc").val());

				div1.append($("<div class='col  mt-3 imgDiv'>").append(innerDiv));
				div1.append($("<div class='col form-control center'>").append($("<img class='viewImage  mt-2 mx-0 p-0'>").attr("src", src)));
				break;
		}

	}
	//div.prepend(divrow);
	//저장 버튼
	div.append($("<div class='row g-3 mx-4 my-3'>")
		.append($("<div class='col'>"))
		.append($("<div class='col'>"))
		.append($("<div class='col'>"))
		.append($("<div class='col'>"))
		.append($("<div class='mx-4 gx-4 col row-cols-1'>")
			.append(
				$('<button id="subUpdate" class=" update btn btn-primary col">').text("수 정")
			)));
	$("#subContent").empty();
	$("#subContent").append(div);
	makePerfect("view");
}
//QueryString 분석, 선택한 nav 표시하기
function selectedNav() {
	const url = new URLSearchParams(window.location.search)
	if(url.has("nav")){
	const selectedNav = $("#left-side").find("#nav-" + url.get("nav"));	
	selectedNav.addClass("selectedNav");
	selectedNav.find(".activeable").addClass("white");
	}
}

//common-add
function commonAdd() {
	let div = $("<div>");
	let headerDiv = $("<div class='row row-cols-2'>")
		.append($("<div class='col d-flex flex-row'>")
			.append($("<h5 class='px-5 '>")
				.append($('<i class="bi bi-archive-fill mid">'))
				.append($('<strong class="tableName mid">').text(" " + tableName))
			)

		)

		.append($('<div class="col d-flex flex-row-reverse">')
			.append($('<button class="mx-5 btn btn-secondary col-3 insert mid" >')
				.append($('<i class="bi bi-sd-card-fill">'))
				.append($('<strong>').text(" 저 장"))
			)

		)
	div.append(headerDiv)

	let table = $("<table class='table'>")

	//thead 만들기
	let thead = $('<thead>')
	let theadTr = $('<tr>')
	theadTr.append($('<th class="col-auto">').append($("<div class='cell mx-2'>").text("+")));
	theadTr.append($('<th class="center col-auto">').append($("<div class='cell'>").text("No.#")));
	for (let a = 0; a < addType.length; a++) {
		let th = $("<th class='center'>").append($("<div class='cell'>").text(addType[a][0]));
		theadTr.append(th);
	}
	table.append(thead.append(theadTr));

	let tbody = $('<tbody id="insertTbody">');
	let tbodyTr = $("<tr>");
	tbodyTr.append($('<td class="center">')
		.append($('<div>').addClass("plus"))
	);
	table.append(tbody.append(tbodyTr));

	div.append(table);

	$("#subContent").empty();
	$("#subContent").append(div);
	$(".plus").trigger("click")
}

//삭제, 수정 모달에 띄우기
function common() {
	const table = $('<table id="modal-table" class="table table-striped">');
	const selectedRow = $('tbody input[type="checkbox"]:checked').parent().parent()
	const selectedRow_clone = selectedRow.clone();
	const showRow = selectedRow_clone.find(".nothing");
	showRow.remove();
	const tbody = $("<tbody>");
	const select = selectedRow.find("select");
	for (let a = 0; a < select.length; a++) {
		const select_clone = selectedRow_clone.find("select");
		$(select_clone[a]).val(select[a].value).prop("selected", true);
	}

	tbody.append(selectedRow_clone.removeClass("selectedRow"));


	if (action === "delete") {
		$(".modal-title").text("[삭 제] 하시겠습니까?");
		$(".commonModal").text("삭 제");
	}

	if (action === "update") {
		$(".modal-title").text("[수 정] 하시겠습니까?");
		$(".commonModal").text("수 정");
	}

	table.append(tbody);
	$(".modal-body").empty().append(table);
	$(".commonModal").attr("id", "commonButton");

}

//ajax으로 보낼때 사용할 리스트 만들기.
//관련 tr을 통째로 가져와서 C+넘버링 되어 있는 것들을 발라냄.
function makeList(selectedRow, type) {

	let rowNum
	if (type === "select")
		rowNum = thType.length;
	else if (type === "add")
		rowNum = addType.length;

	const rowlist = { list: Array() };

	selectedRow.each((index, value) => {
		let $value = $(value);
		let row = {};
		for (let a = 0; a < rowNum; a++) {
			let children = $value.find(".C" + a)

			if (children != undefined)
				row[children.attr("name")] = children.val();
		}
		if (Object.keys(row).length > 1)
			rowlist.list.push(row);
	})
	return rowlist;
}


//메인테이블 페이저
function makePager(pager) {
	$("#page-first").data("page", 1)
	$("#page-prev").data("page", pager.prev)

	let pagelist = pager.list;
	let val;
	let item;
	for (let index = 0; index < 5; index++) {

		item = $("#page-" + index);
		if (pagelist.length > index) {
			val = pagelist[index];
			item.data("page", val)
			item.parent().removeClass("active")
			item.parent().removeClass("hide")
			item.text(val);

			if (pager.page === val) {
				item.parent().addClass("active")
			}
		} else {
			item.parent().addClass("hide")
		}

	}
	$("#page-next").data("page", pager.next)
	$("#page-last").data("page", pager.last)
}

function initArray() {
	thType.length = 0;
	addType.length = 0;
	comboBox.length = 0;
}

//메인테이블 그리기
function makeGrid(data) {
	const thead = $("<thead>");
	const tr = $("<tr>"); //헤더용
	const tbody = $("<tbody>");
	const len = Number(data.thLength)
	const comLen = Number(data.comLength)
	const insertLen = Number(data.insertLength)
	const thData = data.th;
	const insertData = data.insert;
	initArray();


	//헤드 작업	
	tr.append($('<th class="center col-auto" scope="col">')
		.append($('<div class="cell">').append('<input type="checkbox" class="mx-3 form-check-input">'))
	)
	tr.append($('<th class="center col-auto" scope="col">')
		.append($('<div class="cell">').text("No.#")));

	for (let a = 0; a < len; a++) {
		let th = $('<th class="center" scope="col">');

		let str = thData["th" + a].split("-")
		thType.push(str);

		if (insertLen > a) {
			addType.push(insertData["add" + a].split("-"));
		}

		if (str[2] != "hide")
			th.append($('<div class="cell">').text(str[0]));
		tr.append(th);
	}
	thead.append(tr)

	//콤보 박스
	for (let a = 0; a < comLen; a++) {
		const select = $('<select>');
		const arr = data.com["com" + a];

		arr.forEach((value) => {
			select.append($(`<option value='${value.id}'>`).text(value.text))
		});
		comboBox.push(select);

	}

	//바디 작업
	let arr = Array();
	arr = data.list;
	arr.forEach((value, index) => {
		let trForBody = $(`<tr class="center dataRow">`).data("data-index", index);
		trForBody.attr("data-index", index);

		trForBody.append($('<td class="center" scope="row">').append($(`<input  type="checkbox" class="form-check-input nothing" value="\${value.code }">`)))
		trForBody.append($('<td class="center nothing">').text(index + 1));
		for (let a = 0; a < len; a++) {
			let type = thType[a][2];
			let temp = makeCell(value.grid["C" + a], a, index, thType[a][1], type, "select");
			switch (type) {
				case "none":
					temp.addClass('center form-control-plaintext');

				case "number":
				case "text":
					temp.addClass('updateRow nonBorderTextBox ');
					break;
				case "date":
					temp.addClass('updateRow nonBorderTextBox updateDate center form-control-plaintext');
					break;
				case "datetime":
					temp.addClass('updateRow nonBorderTextBox updateDatetime center form-control-plaintext');
					break;
				case "area":
					temp.addClass("updateArea")
					temp.find(".showbox").addClass("nonBorderTextBox");
					temp.find(".area").addClass('updateRow');
					break;

				case "combo":
					temp.addClass("updateCombo");
					break;
				case "file":
					temp.addClass("updatePopDiv");
					break;

			}

			trForBody.append($("<td>").append(temp));
		}
		tbody.append(trForBody);
	})



	$("#mainTable").append(thead);
	$("#mainTable").append(tbody);
	makePager(data.pager);
}

//maintable 내용 요청하기
function content(url_) {
	state.url = url_;
	$.ajax("api/" + url_ + "?", {
		contentType: "application/json",
		dataType: "json",
		method: "get",
		data: state,
		success: function(data) {
			$("#mainTable").empty();
			console.log(data);
			view = data.view;

			tableName = data.tableName;
			makeGrid(data);
			makePerfect("update");
		}
	})
}

//이미지가 갱신 되도록 src를 만들어주기
function makeSrc(src) {
	str = src.split("?");
	const queryString = new URLSearchParams(str[1]);
	queryString.append("a", Math.random())
	src = str[0] + "?" + queryString.toString();
	return src
}

function makePerfect(action) {
	//combobox 완성
	$("." + action + "Combo").combobox();
	//달력 완성
	$("." + action + "Date").datepicker({
		language: 'ko',
	});
	//달력 + 시간 설정
	$("." + action + "Datetime").datepicker({
		language: 'ko'
		, timepicker: true
		, timeFormat: 'hh:ii:00'


	});
	//이미지 완성
	var popoverTriggerList = [].slice.call(document.querySelectorAll("." + action + "PopDiv"))
	popoverList = popoverTriggerList.map(function(popoverTriggerEl) {
		return new bootstrap.Popover(popoverTriggerEl, { html: true })
	})
}

function makeCell(val, col, row, name, type, action) {
	const c = "C" + col
	const rc = "R" + row + c;
	let temp;
	let comboNumber;
	let popCount = 0;
	if (action === "select")
		comboNumber = Number(thType[col][3])
	else if (action === "add")
		comboNumber = Number(addType[col][3])

	switch (type) {


		case "none":
		case "hide":
			temp = $("<input type='text' readonly class=''>")
			break;

		case "number":
			temp = $("<input type='number' class='form-control'>")
			break;

		case "text":
			temp = $("<input type='text' class='form-control'>")
			break;

		case "area":
			temp = $("<div class='areatext form-control '>")
				.append($("<div class='showbox small center showbox-restraint'>").html(val))
				.append($("<textarea rows='1' class='area hide'>").val(val).addClass(c).attr("name", name));
			break;

		case "combo":

			if (comboNumber < comboBox.length)
				temp = comboBox[comboNumber].clone();
			else
				temp = $("<select>");
			temp.find(`option[value=${val}]`).prop("selected", true);
			break;

		case "date":
		case "datetime":
			temp = $("<input type='text' readonly class='date'>")
			break;

		case "file":
			let src = "/upload/noImage.gif"

			if (val != null) {
				src = makeSrc(val);
			}
			temp = $(`<div  class="d-inline-block" title=" 이미지" tabindex="${popCount++}" 
				data-bs-toggle="popover" data-bs-placement="bottom" data-bs-trigger="hover focus" data-bs-content="<img class='popImg' src='${src}'/>">`)
				.append($("<input type='file' name='files' accept='image/*' class='form-control fileUploader'>"))
				.append($("<input type='text' class='hide fileSrc'>").val(val).addClass(c).attr("name", name))

			break;
	}


	switch (type) {
		case "none":
		case "number":
		case "text":
		case "datetime":
		case "combo":
			temp.val(val).addClass(c).attr("name", name)
			break;
		case "date":
			if (val != null)
				temp.val(val.split(" ")[0])
			temp.addClass(c).attr("name", name)
			break;

		case "area":
			break;
		case "file":
			break;
		case "hide":
			temp.val(val).addClass(c).attr("name", name).addClass("hide")
			break;

	}
	temp.addClass(rc + " small").attr("data-point", rc);


	return temp;

}

