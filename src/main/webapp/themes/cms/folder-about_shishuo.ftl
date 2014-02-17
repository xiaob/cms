<#include "header.ftl">
<div class="page-container">
	<!-- BEGIN BREADCRUMBS -->   
	<#include "topbar.ftl">
    <!-- END BREADCRUMBS -->
		<!-- BEGIN CONTAINER -->   
		<div class="container min-hight">
			<!-- BEGIN BLOG -->
			<div class="row">
				<#include "sidebar.ftl">
				<!-- BEGIN LEFT SIDEBAR -->            
				<div class="col-xs-9 blog-posts margin-bottom-40">
               		
					<div class="panel panel-default">   
	                  	<div class="panel-heading"><h3 class="panel-title">${folder.name}<#if isAdmin><a target="_blank" style="color:red;" href="${basePath}/admin/folder/update.htm?folderId=${folder.folderId}">[编辑]</a></#if></h3></div>
	                    <div class="panel-body">
	                    	<h3>Welcome to 师说CMS</h3>
                <p>
                    Welcome To Avada
                    Lid est laborum dolo rumes fugats untras. Etharums ser quidem rerum facilis dolores nemis omnis fugats vitaes nemo minima rerums unsers sadips amets.. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore dolore magnm aliquam quaerat voluptatem.
                </p>
                <p>
                    Aenean nibh ante, lacinia non tincidunt nec, lobortis ut tellus. Sed in porta diam. Suspendisse potenti. Donec luctus ullamcorper nulla. Duis nec velit odio.
                </p>
                	<div class="flex-viewport" style="overflow: hidden; position: relative;"><ul class="slides about-flex-slides" style="width: 800%; transition-duration: 0s; transform: translate3d(-916px, 0px, 0px);"><li class="clone" style="width: 458px; float: left; display: block;">
                                         <div class="about-testimonial-image ">
                                             <img src="${TEMPLATE_PATH}/img/avatar2.jpg" alt="">
                                         </div>
                                         <a href="#" class="about-testimonial-author">Jonathan Smith</a>
                                         <span class="about-testimonial-company">DEF LLC</span>
                                         <div class="about-testimonial-content">
                                             <p class="about-testimonial-quote">
                                                 Pellentesque et pulvinar enim. Quisque at tempor ligula. Maecenas augue ante, euismod vitae egestas sit amet, accumsan eu nulla. Nullam tempor lectus a ligula lobortis pretium. Donec ut purus sed tortor malesuada venenatis eget eget lorem.
                                             </p>
                                         </div>
                                     </li>
                                     <li style="width: 458px; float: left; display: block;" class="">
                                         <div class="about-testimonial-image ">
                                             <img src="${TEMPLATE_PATH}/img/testimonial-img-1.jpg" alt="">
                                         </div>
                                         <a href="#" class="about-testimonial-author">Ericson Reagan</a>
                                         <span class="about-testimonial-company">ABC Realestate LLC</span>
                                         <div class="about-testimonial-content">
                                             <p class="about-testimonial-quote">
                                                 Pellentesque et pulvinar enim. Quisque at tempor ligula. Maecenas augue ante, euismod vitae egestas sit amet, accumsan eu nulla. Nullam tempor lectus a ligula lobortis pretium. Donec ut purus sed tortor malesuada venenatis eget eget lorem.
                                             </p>
                                         </div>
                                     </li>
                                     <li style="width: 458px; float: left; display: block;" class="flex-active-slide">
                                         <div class="about-testimonial-image ">
                                             <img src="${TEMPLATE_PATH}/img/avatar2.jpg" alt="">
                                         </div>
                                         <a href="#" class="about-testimonial-author">Jonathan Smith</a>
                                         <span class="about-testimonial-company">DEF LLC</span>
                                         <div class="about-testimonial-content">
                                             <p class="about-testimonial-quote">
                                                 Pellentesque et pulvinar enim. Quisque at tempor ligula. Maecenas augue ante, euismod vitae egestas sit amet, accumsan eu nulla. Nullam tempor lectus a ligula lobortis pretium. Donec ut purus sed tortor malesuada venenatis eget eget lorem.
                                             </p>
                                         </div>
                                     </li>
                                 <li style="width: 458px; float: left; display: block;" class="clone">
                                         <div class="about-testimonial-image ">
                                             <img src="${TEMPLATE_PATH}/img/testimonial-img-1.jpg" alt="">
                                         </div>
                                         <a href="#" class="about-testimonial-author">Ericson Reagan</a>
                                         <span class="about-testimonial-company">ABC Realestate LLC</span>
                                         <div class="about-testimonial-content">
                                             <p class="about-testimonial-quote">
                                                 Pellentesque et pulvinar enim. Quisque at tempor ligula. Maecenas augue ante, euismod vitae egestas sit amet, accumsan eu nulla. Nullam tempor lectus a ligula lobortis pretium. Donec ut purus sed tortor malesuada venenatis eget eget lorem.
                                             </p>
                                         </div>
                                     </li></ul></div>
                     <h3 class="skills">Our Crazy Skills</h3>
                     <div class="about-skill-meter">
                         <div class="progress progress-xs">
                             <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                                 <span class="sr-only">Web Design : 60% Complete</span>
                             </div>
                         </div>
                     </div>
                     <div class="about-skill-meter">
                         <div class="progress progress-xs">
                             <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 90%;">
                                 <span class="sr-only">Html/CSS : 90% Complete</span>
                             </div>
                         </div>
                     </div>
                     <div class="about-skill-meter">
                         <div class="progress progress-xs">
                             <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 70%;">
                                 <span class="sr-only">Wordpress : 70% Complete</span>
                             </div>
                         </div>
                     </div>
                     <div class="about-skill-meter">
                         <div class="progress progress-xs">
                             <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 55%;">
                                 <span class="sr-only">Graphic Design : 55% Complete</span>
                             </div>
                         </div>
                     </div>
						${folder.content}
						</div>
					</div>
				</div>
				<!-- END LEFT SIDEBAR -->
			</div>
			<!-- END BEGIN BLOG -->
		</div>
		<!-- END CONTAINER -->		
</div>
<#include "footer.ftl">