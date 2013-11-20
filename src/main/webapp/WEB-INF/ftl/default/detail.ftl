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
                            <div class="media">
                                <h3>评论</h3>
                                <hr>
                                <a href="javascript:;" class="pull-left">
                                    <img alt="" src="default/img/avatar1.jpg" class="media-object">
                                </a>
                                <div class="media-body">
                                    <h4 class="media-heading">
                                        Anjelina Joli <span>|</span>
                                        <span>12 July 2013, 10:20 </span>
                                    </h4>
                                    <p>
                                        Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
                                    </p>
                                    <a href="javascript:;">Reply</a>
                                    <hr>
                                    <!-- Nested media object -->
                                    <div class="media">
                                        <a href="javascript:;" class="pull-left">
                                            <img alt="" src="default/img/avatar2.jpg" class="media-object">
                                        </a>
                                        <div class="media-body">
                                            <h4 class="media-heading">
                                                Tom Cruse <span>|</span>
                                                <span>12 July 2013, 10:30 </span>
                                            </h4>
                                            <p>
                                                Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
                                            </p>
                                            <a href="javascript:;">Reply</a>
                                        </div>
                                    </div>
                                    <!--end media-->
                                    <hr>
                                    <div class="media">
                                        <a href="javascript:;" class="pull-left">
                                            <img alt="" src="default/img/avatar1.jpg" class="media-object">
                                        </a>
                                        <div class="media-body">
                                            <h4 class="media-heading">
                                                Nicol Kidman <span>|</span>
                                                <span>12 July 2013, 10:40 </span>
                                            </h4>
                                            <p>
                                                Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
                                            </p>
                                            <a href="javascript:;">Reply</a>
                                        </div>
                                    </div>
                                    <hr>
                                    <!--end media-->
                                </div>
                            </div>
                            <div class="media">
	                                <a href="javascript:;" class="pull-left">
	                                    <img alt="" src="default/img/avatar2.jpg" class="media-object">
	                                </a>
	                                <div class="media-body">
	                                    <h4 class="media-heading">
	                                        Tom Cruse <span>|</span>
	                                        <span>12 July 2013, 11:10 </span>
	                                    </h4>
	                                    <p>
	                                        Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
	                                    </p>
	                                    <a href="javascript:;">Reply</a>
	                                </div>
                                </div>
                                <div class="post-comment">
	                                <h3 class="skills">发布评论</h3>
	                                <form role="form" class="form-horizontal">
	                                    <div class="form-group">
	                                        <div class="col-lg-12">
	                                            <textarea class=" form-control" rows="8" placeholder="评语"></textarea>
	                                        </div>
	                                    </div>
	                                    <p>
	                                        <button class="btn btn-danger pull-right" type="submit">Post Comment</button>
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
