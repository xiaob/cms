<#include "head.ftl">
    <!--container start-->
    <div class="container">
        <div class="row">
            <!--blog start-->
            <div class="col-lg-9 ">
            <@cms_file fileId = "8">
                <div class="blog-item">
                    <div class="row">
                        <div class="col-lg-2 col-sm-2">
                            <div class="date-wrap">
                                <span class="date">${file.createTime?string("dd")}</span>
                                <span class="month">${file.createTime?string("MM")}月</div>
                            <div class="comnt-wrap">
                                <span class="comnt-ico">
                                    <i class="icon-comments"></i>
                                </span>
                                <span class="value">15</span>
                            </div>
                        </div>
                        <div class="col-lg-10 col-sm-10">
                            <div class="blog-img">
                                <img src="${basePath}/default/img/blog/img1.jpg" alt=""/>
                            </div>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2 col-sm-2 text-right">
                            <div class="author">
                                By <a href="#">Admin</a>
                            </div>
                            <ul class="list-unstyled">
                                <li><a href="javascript:;"><em>travel</em></a></li>
                                <li><a href="javascript:;"><em>tour</em></a></li>
                                <li><a href="javascript:;"><em>recreation</em></a></li>
                                <li><a href="javascript:;"><em>tourism</em></a></li>
                            </ul>
                            <div class="shate-view">
                                <ul class="list-unstyled">
                                    <li><a href="javascript:;">209 View</a></li>
                                    <li><a href="javascript:;">23 Share</a></li>

                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-10 col-sm-10">
                            <h1><a href="blog_detail.html">${file.name}</a></h1>
                            <p>${file.description}</p>
                            <@cms_comment_list fileId = "8">
                            <#list commentVoList as comment>
                            <div class="media">
                             <#if  comment_index ==0>
                                <h3>评论</h3>
                                <hr>
                             </#if>
                                <a href="javascript:;" class="pull-left">
                                    <img alt="" src="${basePath}/default/img/avatar1.jpg" class="media-object">
                                </a>
                                <div class="media-body">
                                    <h4 class="media-heading">
                                        ${comment.name} <span>|</span>
                                        <span>${comment.createTime?string("yyyy-MM-dd")}</span>
                                    </h4>
                                    <p>
                                        ${comment.content}
                                    </p>
                                    <a href="javascript:;">回复</a>
                                    <hr>
                                    <!-- Nested media object -->
                                    <#list comment.childComment as child>
                                    <div class="media">
                                        <a href="javascript:;" class="pull-left">
                                            <img alt="" src="${basePath}/default/img/avatar2.jpg" class="media-object">
                                        </a>
                                        <div class="media-body">
                                            <h4 class="media-heading">
                                                ${child.name} <span>|</span>
                                                <span>${child.createTime?string("yyyy-MM-dd")}</span>
                                            </h4>
                                            <p>
                                               ${child.content} 
                                            </p>
                                            <a href="javascript:;">回复</a>
                                        </div>
                                    </div>
                                    <!--end media-->
                                    <hr>
                                    </#list>
                                </div>
                            </div>
                            </#list>
                            </@cms_comment_list>
                                <div class="post-comment">
	                                <h3 class="skills">发布评论</h3>
	                                <form role="form" class="form-horizontal" action="comment/add" method="post">
	                                    <div class="form-group">
	                                        <div class="col-lg-4">
	                                            <input type="text" class="col-lg-12 form-control" placeholder="名字" name="name">
	                                        </div>
	                                        <div class="col-lg-4">
	                                            <input type="text" class="col-lg-12 form-control" placeholder="邮箱" name="email">
	                                        </div>
	                                        <input type="hidden" name="fileId" value="8">
                                        </div>
	                                    <div class="form-group">
	                                        <div class="col-lg-12">
	                                            <textarea class=" form-control" rows="8" placeholder="评语" name="content"></textarea>
	                                        </div>
	                                    </div>
	                                    <p>
	                                        <button class="btn btn-danger pull-right" type="submit">发布</button>
	                                    </p>
	                                </form>
                                </div>  
                        </div>
                    </div>
                </div>
                </@cms_file>
            </div>
            <#include "right.ftl">
            <!--blog end-->
        </div>
    </div>
    <!--container end-->
    <#include "foot.ftl">
