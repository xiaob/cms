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
                        <div class="media">
                            <a href="javascript:;" class="pull-left">
                                <img alt="" src="${basePath}/default/img/blog/blog-thumb-1.jpg" class=" ">
                            </a>
                            <div class="media-body">
                                <h5 class="media-heading"><a href="javascript:;">02 May 2013 </a></h5>
                                <p>
                                    Donec id elit non mi porta gravida at eget metus amet int
                                </p>
                            </div>
                        </div>
                        <div class="media">
                            <a href="javascript:;" class="pull-left">
                                <img alt="" src="${basePath}/default/img/blog/blog-thumb-2.jpg" class=" ">
                            </a>
                            <div class="media-body">
                                <h5 class="media-heading"><a href="javascript:;">02 May 2013 </a></h5>
                                <p>
                                    Donec id elit non mi porta gravida at eget metus amet int
                                </p>
                            </div>
                        </div>
                        <div class="media">
                            <a href="javascript:;" class="pull-left">
                                <img alt="" src="${basePath}/default/img/blog/blog-thumb-3.jpg" class=" ">
                            </a>
                            <div class="media-body">
                                <h5 class="media-heading"><a href="javascript:;">02 May 2013 </a></h5>
                                <p>
                                    Donec id elit non mi porta gravida at eget metus amet int
                                </p>
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
