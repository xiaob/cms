				<!-- BEGIN RIGHT SIDEBAR -->            
				<div class="col-xs-3 blog-sidebar bv-border">
					<@shishuocms_folder_list fatherId="${firstFolder.folderId}">
					<!-- CATEGORIES START -->
					<h2>${firstFolder.name}</h2>
					<ul class="nav sidebar-categories margin-bottom-40" style="padding-left:20px;">
						<#list tag_folder_list as secondLevelFolder>
						<li <#if secondLevelFolder.folderId == folder.folderId>class="active"</#if>><a href="${basePath}/${firstFolder.ename}/${secondLevelFolder.ename}/index.htm"><i class="fa fa-chevron-right"></i> ${secondLevelFolder.name}</a>
							<#if secondLevelFolder.folderList?size gt 0><#if secondLevelFolder.folderId == folder.folderId>class="active"</#if>
							<#if secondFolder?? && secondLevelFolder.folderId == secondFolder.folderId>
							<div class="folderList">
								<ul class="nav sidebar-categories">
								<#list secondLevelFolder.folderList as thirdLevelFolder>
									<#if thirdLevelFolder.folderId == folder.folderId>
										<li class="active"><p style="margin-left: 20px;"><i class="fa fa-caret-right"></i> ${thirdLevelFolder.name}</p></li>
									<#else>
										<li><a style="margin-left: 20px;" href="${basePath}/${firstFolder.ename}/${secondLevelFolder.ename}/${thirdLevelFolder.ename}/index.htm"><i class="fa fa-caret-right"></i> ${thirdLevelFolder.name}</a></li>
									</#if>
								</#list>
								</ul>
							</div>
							</#if>
							</#if>
						</li>
						</#list>
					</ul>
					<!-- CATEGORIES END -->
					</@shishuocms_folder_list>
				</div>
				<!-- END RIGHT SIDEBAR --> 
