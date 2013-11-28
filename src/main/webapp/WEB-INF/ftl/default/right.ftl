                    <div class="search-row">
                        <input type="text" placeholder="Search here" class="form-control">
                    </div>
                    <div class="category">
                        <h3>分类</h3>
                        <ul class="list-unstyled">
                        	<@cms_folder_list fatherId="0" >
	                        	<#list folderList as folder>
	                            <li><a href="${basePath}/${folder.ename}"><i class="  icon-angle-right"></i> ${folder.name}</a></li>
	                            </#list>
                            </@cms_folder_list>
                        </ul>
                    </div>
					<div class="blog-post">
                        <h3>最新文章</h3>
                        <@cms_file_page type="article" folderId="${folderId}" pageNum="${pageNum}" rows="8">
                        <#list pageVo.list as file>
                        <div class="media">
                        	<#if file.picture == "exist">
                            <a href="javascript:;" class="pull-left">
                                <img alt="" src="${basePath}/upload/${file.fileId}_small.jpg" class=" ">
                            </a>
                            </#if>
                            <div class="media-body">
                                <a href="javascript:;">${file.name}</a>（${file.createTime?string("yyyy-MM-dd")}）
                            </div>
                        </div>
                        </#list>
                        </@cms_file_page>
                    </div>                    
