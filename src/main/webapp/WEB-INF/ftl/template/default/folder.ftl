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
				<@cms_folder_fatherId_list>
					<#list folderList as l>
						<a href="#" class="list-group-item active">${l.name}</a>
					</#list>
				</@cms_folder_fatherId_list>
			</div>
		</div>
		<div class="col-md-9">
			<div class="panel panel-default">
			  <div class="panel-body">   
			    <table>
			    	<@cms_file>
            		<tfoot>
            		</tfoot>
            		<tbody>         
			    			<tr>
			    				<td>
			    					<div class="list-group-item file">
			    						<a href="#">${file.name}</a>
			    					</div>
			    				</td>
			    			</tr>
            		</tbody>
            		</@cms_file>
          		</table>
			  </div>
			</div>		
		</div>
	</div>
</div>
<!-- /container -->
<#include "foot.ftl">
