<#include "header.ftl">
    <!--container start-->
    <div class="container">
        <div class="row">
            <!--blog start-->
            <div class="col-lg-9 ">
            <@cms_file_page type="article" folderId="${folderId}" pageNum="${pageNum}" rows="10">
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
                                <img src="${basePath}/upload/${file.fileId}_big.jpg" alt=""/>
                            </div>
                            <h1><a href="${basePath}/${file.folder.ename}/${file.fileId}.htm"><b>${file.name}</b></a></h1>
                            <div class="author">
                            	分类：<a href="${basePath}/${file.folder.ename}.htm">${file.folder.name}</a> | 作者：<a>${file.admin.name}</a> | 浏览数：${file.viewCount}
                            </div>
                            <hr>
                            <p>${file.content}</p>
                        </div>
                    </div>
                </div>
                </#list>
	             <div class="text-center">
	                ${pageVo.pageNumHtml}
	              </div>
                </@cms_file_page>
            </div>
            <div class="col-lg-3">
              <div class="blog-side-item">
              <#include "sidebar.ftl">
              </div>
            </div>
            <!--blog end-->
        </div>
    </div>
    <!--container end-->
<#include "footer.ftl">
