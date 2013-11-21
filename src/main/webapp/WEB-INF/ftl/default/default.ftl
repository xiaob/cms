<#include "head.ftl">
    <!--container start-->
    <div class="container">
        <div class="row">
            <!--blog start-->
            <div class="col-lg-9 ">
            <@cms_file_page type="0" folderId="${currentFolder.folderId}" pageNum="${pageNum}">
               <#list pageVo.list as file>
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
                                <span class="value">${file.commentCount}</span>
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
                                                                                                              作者 <a>${file.user.name}</a>
                            </div>
                            <div class="shate-view">
                                <ul class="list-unstyled">
                                    <li><a>浏览人数:${file.viewCount}</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-10 col-sm-10">
                            <h1><a href="${basePath}/detail/${file.fileId}">${file.name}</a></h1>
                            <p>${file.description}</p>
                            <a href="detail/${file.fileId}" class="btn btn-danger">瞧一瞧</a>
                        </div>
                    </div>
                </div>
                </#list>
	             <div class="text-center">
	                ${pageVo.pageNumHtml}
	              </div>
                </@cms_file_page>
            </div>
            <#include "right.ftl">
            <!--blog end-->
        </div>
    </div>
    <!--container end-->
    <#include "foot.ftl">
