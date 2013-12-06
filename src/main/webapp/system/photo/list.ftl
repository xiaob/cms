<#assign menu="appendix">
<#assign submenu="photo_list">
<#include "/system/head.ftl">
<style type="text/css">
.panel-heading {
    border-color: #EFF2F7;
    font-size: 16px;
    font-weight: 300;
    height: 65px;
}
.col-sm-10 {
    width: 30%;
}
.add_folder{
	float: left;
}
</style>
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <!-- page start-->
              <section class="panel">
                  <header class="panel-heading">
                      <div class="form-group">
                      	<div class="col-sm-10">
                        	<select class="form-control input-lg m-bot15" style="font-size:15px;width: 300px;height: 45px;" name="folderId">
                        	<#list folderList as folder>  	
                            	<option value="${folder.folderId}">
                                	<#list 1..folder.level as i>-</#list> ${folder.name}
                            	</option>
                       		</#list>
                       		<option >--------------------------------------</option>
                       		<option >创建文件夹</option>
                            </select>
                        </div>
                        <div class="add_folder">
                        	<a href="${basePath}/admin/folder/add">创建文件夹</a>
                        </div>
                        <div class="add_folder" style="float: right;">
                        	<a href="${basePath}/admin/picture/upload">上传文件</a>
                        </div>
                     </div>
                  </header>
                  <div class="panel-body">
                      <ul class="grid cs-style-3">
                          <li>
                              <figure>
                                  <img src="${basePath}/upload/photo/1.jpg" alt="img04">
                                  <figcaption>
                                      <h3>Mindblowing</h3>
                                      <span>lorem ipsume </span>
                                      <a class="fancybox" rel="group" href="${basePath}/upload/photo/1.jpg">Take a look</a>
                                  </figcaption>
                              </figure>
                          </li>
                          <li>
                              <figure>
                                  <img src="${basePath}/upload/photo/2.jpg" alt="img01">
                                  <figcaption>
                                      <h3>Clean & Fresh</h3>
                                      <span>dolor ament</span>
                                      <a class="fancybox" rel="group" href="img/gallery/1.jpg">Take a look</a>
                                  </figcaption>
                              </figure>
                          </li>
                          <li>
                              <figure>
                                  <img src="${basePath}/upload/photo/3.jpg" alt="img02">
                                  <figcaption>
                                      <h3>Flat Concept</h3>
                                      <span>tawseef tasi</span>
                                      <a class="fancybox" rel="group" href="img/gallery/2.jpg">Take a look</a>
                                  </figcaption>
                              </figure>
                          </li>
                          <li>
                              <figure>
                                  <img src="${basePath}/upload/photo/4.jpg" alt="img05">
                                  <figcaption>
                                      <h3>Modern</h3>
                                      <span>dkmosa inc</span>
                                      <a class="fancybox" rel="group" href="img/gallery/5.jpg">Take a look</a>
                                  </figcaption>
                              </figure>
                          </li>
                          <li>
                              <figure>
                                  <img src="${basePath}/upload/photo/5.jpg" alt="img03">
                                  <figcaption>
                                      <h3>Clean Code</h3>
                                      <span>nice concept</span>
                                      <a class="fancybox" rel="group" href="img/gallery/3.jpg">Take a look</a>
                                  </figcaption>
                              </figure>
                          </li>
                          <li>
                              <figure>
                                  <img src="${basePath}/upload/photo/6.jpg" alt="img06">
                                  <figcaption>
                                      <h3>Cheers</h3>
                                      <span>sumon ahmed</span>
                                      <a class="fancybox" rel="group" href="img/gallery/6.jpg">Take a look</a>
                                  </figcaption>
                              </figure>
                          </li>
                          <li>
                              <figure>
                                  <img src="${basePath}/upload/photo/7.jpg" alt="img04">
                                  <figcaption>
                                      <h3>Freshness</h3>
                                      <span>rerum facilis </span>
                                      <a class="fancybox" rel="group" href="img/gallery/4.jpg">Take a look</a>
                                  </figcaption>
                              </figure>
                          </li>
                          <li>
                              <figure>
                                  <img src="${basePath}/upload/photo/8.jpg" alt="img01">
                                  <figcaption>
                                      <h3>Awesome</h3>
                                      <span>At vero eos</span>
                                      <a class="fancybox" rel="group" href="img/gallery/1.jpg">Take a look</a>
                                  </figcaption>
                              </figure>
                          </li>
                          <li>
                              <figure>
                                  <img src="${basePath}/upload/photo/9.jpg" alt="img02">
                                  <figcaption>
                                      <h3>Music</h3>
                                      <span>atque corrupti </span>
                                      <a class="fancybox" rel="group" href="img/gallery/2.jpg">Take a look</a>
                                  </figcaption>
                              </figure>
                          </li>
                          <li>
                              <figure>
                                  <img src="${basePath}/upload/photo/10.jpg" alt="img03">
                                  <figcaption>
                                      <h3>Clean Code</h3>
                                      <span>nice concept</span>
                                      <a class="fancybox" rel="group" href="img/gallery/3.jpg">Take a look</a>
                                  </figcaption>
                              </figure>
                          </li>
                          <li>
                              <figure>
                                  <img src="${basePath}/upload/photo/11.jpg" alt="img06">
                                  <figcaption>
                                      <h3>Cheers</h3>
                                      <span>sumon ahmed</span>
                                      <a class="fancybox" rel="group" href="img/gallery/6.jpg">Take a look</a>
                                  </figcaption>
                              </figure>
                          </li>
                          <li>
                              <figure>
                                  <img src="${basePath}/upload/photo/12.jpg" alt="img04">
                                  <figcaption>
                                      <h3>Freshness</h3>
                                      <span>rerum facilis </span>
                                      <a class="fancybox" rel="group" href="img/gallery/4.jpg">Take a look</a>
                                  </figcaption>
                              </figure>
                          </li>
                      </ul>

                  </div>
              </section>

              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
  <script type="text/javascript">
      $(function() {
        //    fancybox
          jQuery(".fancybox").fancybox();
      });

  </script>
<#include "/system/foot.ftl">
