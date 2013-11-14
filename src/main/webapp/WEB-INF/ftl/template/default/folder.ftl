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
				<@cms_folder_list fatherId="${currentFolder.fatherId}">
					<#list folderList as folder>
						<a href="${folder.ename}" class="list-group-item <#if folder.folderId== currentFolder.folderId>active</#if>">${folder.name}</a>
					</#list>
				</@cms_folder_list>
			</div>
		</div>
		<div class="col-md-9">
			<div class="panel panel-default">
			  <div class="panel-body">   
				<@cms_file_page folderId="${currentFolder.folderId}" pageNum="${pageNum}">
					<#list pageVo.list as page>
			    		<a href="#">${page.name}</a><br>
			    	</#list>
			    </@cms_file_page>
			  </div>
			</div>		
		</div>
	</div>
</div>
<!-- /container -->
<#include "foot.ftl">
