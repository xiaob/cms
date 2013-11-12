<#include "head.ftl">
<div class="container" style="margin-top:20px;">

	<div class="row">
		<div class="col-md-3">
			<div class="list-group">
				<a href="#" class="list-group-item active"> Cras justo odio </a>
				<@cms_folder_list>
					<#list list as l>
						${l.name}
					</#list>
				</@cms_folder_list>
			</div>
		</div>
		<div class="col-md-9">
			<div class="panel panel-default">
			  <div class="panel-body">
			    Basic panel example
			  </div>
			</div>		
		</div>
	</div>

</div>
<!-- /container -->
<#include "foot.ftl">
