# 目录标签 #
## 获得一级子目录 ##
**名称**

    cms_folder_list

**参数**

    fatherId：父亲Id


**实例**

    <#list pageVo.list as fileList
    	<tr>
    		<td>
    			<div class="list-group-item file">
    				<a href="#">${fileList.name}</a>
    			</div>
    		</td>
    	</tr>
    </#list>

# 文件标签 #
## 获得单个文件 ##
**名称**

	cms_file

**参数**

	folderId:目录Id

**实例**

	<@cms_file>         
		<tr>
			<td>
				<div class="list-group-item file">
					<a href="#">${file.name}</a>
				</div>
			</td>
		</tr>
	</@cms_file>

## 获得指定目录下的文件列表 ##
**名称**

	cms_file_page

**参数**

	folderId:目录Id

**实例**

	<#list pageVo.list as fileList>         
		<tr>
			<td>
				<div class="list-group-item file">
					<a href="#">${fileList.name}</a>
				</div>
			</td>
		</tr>
	</#list>