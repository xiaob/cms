<#include "head.ftl">
    <!--container start-->
    <div class="container">
        <div class="row">
            <!--blog start-->
            <div class="col-lg-9 ">
            <@cms_file_page type="0" folderId="1" pageNum="${pageNum}">
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
                            <a href="blog_detail.html" class="btn btn-danger">瞧一瞧</a>
                        </div>
                    </div>
                </div>
                </#list>
                </@cms_file_page>
                <div class="text-center">
                    <ul class="pagination">
                        <li><a href="#">«</a></li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">»</a></li>
                    </ul>
                </div>
            </div>
            <#include "right.ftl">
            <!--blog end-->
        </div>
    </div>
    <!--container end-->
    <#include "foot.ftl">
