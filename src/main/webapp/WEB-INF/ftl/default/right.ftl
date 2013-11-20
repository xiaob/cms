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
	                            <li><a href="${basePath}/${folder.name}"><i class="  icon-angle-right"></i> ${folder.name}</a></li>
	                            </#list>
                            </@cms_folder_list>
                        </ul>
                    </div>

                    <div class="blog-post">
                        <h3>最近发布的博客</h3>
                      
                        <div class="media">
                            <a href="javascript:;" class="pull-left">
                                <img alt="" blog-thumb-1.jpg"="" blog="" img="" default="" cms="" localhost:8080="" http:="" src="${basePath}/default/img/blog/blog-thumb-1.jpg" class=" ">
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
                                <img alt="" blog-thumb-2.jpg"="" blog="" img="" default="" cms="" localhost:8080="" http:="" src="${basePath}/default/img/blog/blog-thumb-2.jpg" class=" ">
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
                                <img alt="" blog-thumb-3.jpg"="" blog="" img="" default="" cms="" localhost:8080="" http:="" src="${basePath}/default/img/blog/blog-thumb-3.jpg" class=" ">
                            </a>
                            <div class="media-body">
                                <h5 class="media-heading"><a href="javascript:;">02 May 2013 </a></h5>
                                <p>
                                    Donec id elit non mi porta gravida at eget metus amet int
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="tags">
                        <h3>Tags</h3>
                        <ul class="list-unstyled tag">
                            <li><a href="#">flat</a></li>
                            <li><a href="#"> clean</a></li>
                            <li><a href="#"> admin</a></li>
                            <li><a href="#"> UI</a></li>
                            <li><a href="#"> responsive</a></li>
                            <li><a href="#"> Web Design</a></li>
                            <li><a href="#"> UIX</a></li>
                            <li><a href="#"> Blog</a></li>
                            <li><a href="#">flat Admin</a></li>
                            <li><a href="#"> Dashboard</a></li>
                        </ul>
                    </div>
                </div>
            </div>