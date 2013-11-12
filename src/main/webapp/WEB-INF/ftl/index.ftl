
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<@cms_folder vid="1">
	<#list list as l>
		${l}
	</#list>
</@cms_folder>
<br>
<br>
<br>
<@cms_fileList vid="1">
	<#list list as l>
		${l}
	</#list>
</@cms_fileList>
<br>
<br>
<@cms_file vid="1">
	${file.name}
</@cms_file>
</body>
</html>