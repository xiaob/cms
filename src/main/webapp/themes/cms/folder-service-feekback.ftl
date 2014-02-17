<#include "header.ftl">
<div class="page-container">
	<!-- BEGIN BREADCRUMBS -->
	<#include "topbar.ftl">
	<!-- END BREADCRUMBS -->
	<!-- BEGIN CONTAINER -->
	<div class="container min-hight">
		<!-- BEGIN BLOG -->
		<div class="row">
			<#include "sidebar.ftl">
			<!-- BEGIN LEFT SIDEBAR -->
			<div class="col-xs-9 blog-posts margin-bottom-40">
					<div class="panel panel-default">   
	                  	<div class="panel-heading"><h3 class="panel-title">${folder.name}<#if isAdmin><a target="_blank" style="color:red;" href="${basePath}/admin/article/add.htm?folderId=${folder.folderId}">[增加文章]</a></#if></h3></div>
	                    <div class="panel-body">
							<div>
                <div class="contact-form">
                    <form role="form">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name" placeholder="">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="text" class="form-control" id="email" placeholder="">
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone</label>
                            <input type="text" class="form-control" id="phone">
                        </div>
                        <div class="form-group">
                            <label for="phone">Message</label>
                            <textarea class="form-control" rows="5" placeholder=""></textarea>
                        </div>
                        <button type="submit" class="btn btn-danger">Submit</button>
                    </form>

                </div>
            </div>
						</div>
					</div>
				</div>
			<!-- END LEFT SIDEBAR -->
		</div>
		<!-- END BEGIN BLOG -->
	</div>
	<!-- END CONTAINER -->
</div>
<script type="text/javascript">
	$(function(){
		$('#addFeedBack').ajaxForm(function(data){
			showErrors($('#addFeedBack'),data.errors);
			if(data.result){
				bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
					});
			}
		});
	});
</script>
<#include "footer.ftl">