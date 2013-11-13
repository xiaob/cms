<#include "head.ftl">
<style>
.list-group-item.file{
    background-color: #DBDBDB;
    border-color: #000000;
    color: #FFFFFF;
    z-index: 2;
}
</style>
<div class="container" style="margin-top:20px;">
	<div class="row">
		<div class="col-md-3">
			<div class="list-group">
				<@cms_folder_list folderId="${folderId}" fatherId="${fatherId}">
					<#list folderList as folder>
						<a href="#" class="list-group-item <#if folderId==folder.folderId>active</#if>">${folder.name}</a>
					</#list>
				</@cms_folder_list>
			</div>
		</div>
		<div class="col-md-9">
			<div class="panel panel-default">
			  <div class="panel-body">   
				<@cms_file folderId="${folderId}">
					${file.images}<br>
			    	<a href="#">${file.name}</a><br>
			    	${file.createTime?string("yyyy-MM-dd HH:mm:ss")}
			    </@cms_file>
			  </div>
			</div>		
		</div>
	</div>
</div>
<!-- /container -->
<#include "foot.ftl">
