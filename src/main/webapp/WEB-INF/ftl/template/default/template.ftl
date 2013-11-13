<#include "head.ftl">
    <div class="container">

      <!-- Example row of columns -->
      <div class="row">
        <@cms_folder vid="1">
			<#list list as e>
				${e.name}
			</#list>
		</@cms_folder>
      </div>

    </div> <!-- /container -->
<#include "foot.ftl">    
