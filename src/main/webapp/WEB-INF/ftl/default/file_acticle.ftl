				  <@cms_file fileId = "${fileId}">
					<div class="blog-post">
					 <#if file.picture=="exist">
						 <#list pageFile.list  as acticle>
	                       <#if acticle_index==0><h3>最新文章</h3></#if>
	                        <div class="media">
	                            <a href="javascript:;" class="pull-left">
	                                <img alt="" src="${basePath}/default/img/blog/blog-thumb-1.jpg" class=" ">
	                            </a>
	                            <div class="media-body">
	                                <h5 class="media-heading"><a href="javascript:;">${acticle.createTime?string("yyyy-MM-dd")}</a></h5>
	                                <p>
	                                    ${acticle.content}
	                                </p>
	                            </div>
	                        </div>
	                        </#list>
                        </#if>
                    </div>
                    </@cms_file>                   
