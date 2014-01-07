                    <div class="search-row">
                        <input type="text" placeholder="Search here" class="form-control">
                    </div>
                    <div class="category">
                        <h3>分类</h3>
                        <ul class="list-unstyled">
                        	<@shishuocms_folder_list fatherId="0" >
	                        	<#list tag_folder_list as folder>
	                            <li><a href="${basePath}/${folder.ename}.htm"><i class="  icon-angle-right"></i> ${folder.name}</a></li>
	                            </#list>
                            </@shishuocms_folder_list>
                        </ul>
                    </div>
					<div class="blog-post">
                        <h3>最新文章</h3>
                        <@shishuocms_file_page type="article" folderId="${folderId}" pageNum="${pageNum}" rows="8">
                        <#list tag_file_page.list as file>
                        <div class="media">
                            <div class="media-body">
                                <a href="${basePath}/${file.folder.ename}/${file.fileId}.htm">${file.name}</a>（${file.createTime?string("yyyy-MM-dd")}）
                            </div>
                        </div>
                        </#list>
                        </@shishuocms_file_page>
                    </div>  
					<div class="blog-post">
                        <h3>快捷方式</h3>
                        <div class="media">
                            <div class="media-body">
                                <a href="${basePath}/auth/admin/login.htm">管理员登录</a>
                            </div>
                        </div>
                    </div>                                       
