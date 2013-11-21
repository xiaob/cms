      <div class="col-lg-3">
                <div class="blog-side-item">
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
                </div>
            </div>