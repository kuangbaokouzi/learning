$(document).ready(function() {
	$('#uid').textbox({
		label : '用户id:',
		iconCls : 'icon-man',
		width : 300,
		prompt : 'please input uid...',
		required : true
	});
	$('#name').textbox({
		label : '姓名:',
		iconCls : 'icon-man',
		width : 300,
		prompt : 'please input name...',
		required : true
	});
	$('#idCard').textbox({
		label : '身份证:',
		iconCls : 'icon-man',
		width : 300,
		prompt : 'please input idcard...',
		required : true
	});
	$('#password').textbox({
		label : '密码:',
		iconCls : 'icon-lock',
		type : 'password',
		width : 300,
		required : true
	});
	$('#status').combobox({
		valueField : 'status',
		textField : 'text',
		width : 300,
		panelHeight : 100
	});
});

/**
 * 更新用户表单提交
 * 
 * @returns
 */
function updateUser() {
	$('#userForm').form('submit', {
		onSubmit : function() { // 提交动作发生时，回调的函数
			var isValid = $(this).form('validate');
			if (!isValid) {
				$.messager.progress('close'); // 验证失败，隐藏进度条
				return false;
			}
			// 利用ajax方式提交表单
			ajaxUpdateSubmit();
			return false;
		}
	});
}

/**
 * ajax方式提交表单
 * 
 * @returns
 */
function ajaxUpdateSubmit() {
	// 将表单参数转换成表单的js对象
	// 将表单的js对象转换成json字符串
	$.ajax({
		url : 'UserServlet',
		method : 'post',
		data : {
			tp : 'update',
			formData : JSON.stringify(formDataToJson())
		},
		dataType : 'json',
		success : function(data) {
			$.messager.alert('提示', data.msg);
		}
	})
}

/**
 * 将表单参数数组转成json对象
 * 
 * @returns
 */
function formDataToJson() {
	var formArray = $('#userForm').serializeArray();
	var formJsonObject = {};
	for (var index = 0; index < formArray.length; index++) {
		var temp = formArray[index];
		formJsonObject[temp.name] = temp.value;
	}
	return formJsonObject;
}