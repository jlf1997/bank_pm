<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>文件上传</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<form class="form-horizontal" role="form" method="post" enctype="multipart/form-data" action="UploadCustomerInfoFile.action">
	<div class="form-group">
	     <label for="khbh" class="col-sm-2 control-label">客户编号</label>
	 	 <div class="col-sm-4">
	 		  <input type="text" class="form-control" id="khbh" name="khbh" placeholder="请输入客户编号">
	     </div>
	</div>
	<div class="form-group">
	     <label for="ghrgh" class="col-sm-2 control-label">管户人工号</label>
	 	 <div class="col-sm-4">
	 		  <input type="text" class="form-control" id="ghrgh" name="ghrgh" placeholder="请输入管户人工号">
	     </div>
	</div>	
	
	<div class="form-group">
	     <label for="type" class="col-sm-2 control-label">类型</label>
	 	 <div class="col-sm-4">
	 		  <input type="text" class="form-control" id="type" name="type" placeholder="请输入类型">
	     </div>
	</div>	
	
	<div class="form-group">
		<label for="inputfile" class="col-sm-2 control-label">上传文件</label>
		<input type="file" class="col-sm-4 control-label" id="inputfile" name="fileupload">
	</div>
	<div class="form-group">
	<div class="col-sm-4 control-label">
	<button type="submit" class="btn btn-default">提交</button>
	</div>
	</div>
</form>
	
</body>
</html>