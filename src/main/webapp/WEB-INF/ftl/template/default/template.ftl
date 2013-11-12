<#include "head.ftl">
    <div class="container">
      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>使用Java开发的CMS</h1>
        <p class="lead">完全免费，Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet.</p>
        <p><a class="btn btn-lg btn-success" href="#" role="button">现在就下载</a></p>
      </div>

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
