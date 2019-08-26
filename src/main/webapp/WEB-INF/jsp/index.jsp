<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/index1.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/vue.min.js"></script>
<meta charset="UTF-8">
<title>前台页面</title>
</head>
<body>
  <header><h2>智慧旅游系统</h2><p id="time"></p></header>
  <nav><li><a href="#" onclick="a(this)">首页</a><div id="dv" style="display:none"><dd>adduser</dd><dd>updateuser</dd><dd>delUser</dd></div></li><li><a href="#" onclick="a(this)">购票</a><div id="dv" style="display:none"><dd>adduser</dd><dd>updateuser</dd><dd>delUser</dd></div></li><li><a href="#" onclick="a(this)">景点浏览</a><div id="dv" style="display:none"><dd>adduser</dd><dd>updateuser</dd><dd>delUser</dd></div></li><li><a href="#" onclick="a(this)">服务</a><div id="dv" style="display:none"><dd>adduser</dd><dd>updateuser</dd><dd>delUser</dd></div></li><li><a href="#" onclick="a(this)">周边</a><div id="dv" style="display:none"><dd>adduser</dd><dd>updateuser</dd><dd>delUser</dd></div></li><li><a href="#" onclick="a(this)">联系我们</a><div id="dv" style="display:none"><dd>adduser</dd><dd>updateuser</dd><dd>delUser</dd></div></li><div style="clear:both"></div></nav>
  <div style="clear:both;display:none"></div>
  <aside>
      <div id="menu">
       <dt  v-on:click="chang">用户管理</dt>
          <dd v-bind:class="{active:seen}"><a href="/user/toupdate" target="content">用户修改</a></dd>
          <dd v-bind:class="{active:seen}"><a target="content" href="/user/show?show=1">用户查询</a></dd>
          <dd v-bind:class="{active:seen}"><a target="content" href="/user/torole">用户授权</a></dd>
       <dt  v-on:click="chang1">票务管理</dt>
          <dd v-bind:class="{active:ok}"><a href="/ticket/toadd" target="content">票务增加</a></dd>
          <dd v-bind:class="{active:ok}"><a href="/ticket/initItemList" target="content">票务查询</a></dd>
          <dd v-bind:class="{active:ok}"><a href="/ticket/toupdate" target="content">票务更新</a></dd>
          <dd v-bind:class="{active:ok}"><a href="/ticket/todelete" target="content">删除票务</a></dd>
       <dt v-on:click="chang2()">景点管理</dt>
           <dd v-bind:class="{active:third}"><a href="/role/all" target="content">查询所有景点</a></dd>
           <dd v-bind:class="{active:third}"><a href="/role/all" target="content">删除景点</a></dd>
           <dd v-bind:class="{active:third}"><a href="/role/all" target="content">新增景点</a></dd>
           <dd v-bind:class="{active:third}"><a href="/role/all" target="content">更新景点</a></dd>
           <dd></dd>
       <dt v-on:click="chang3()">角色管理</dt>
           <dd v-bind:class="{active:four}"><a href="/priv/all?show=2" target="content">权限添加</a></dd> 
          </div>
  </aside>
  <section> 
      <iframe src="" name="content" id="content" width="100%" height="100%"></iframe>
  </section>
  <footer>&copy; copyright by www.sztl.com</footer>
</body>
</html>
<script>
var vm=new Vue({
	 el:"#menu",
	 data:{
		 seen:true,
		 ok:true,
		 third:true,
		 four:true
	 },
	   methods:{
		   chang : function() {
				//alert(!this.seen)
				this.seen = !this.seen;
				if (!this.seen) {
					this.ok = true;
					this.third = true;
					this.four=true;
				}
			},
			chang1 : function() {
				//alert(!this.seen)

				this.ok = !this.ok;
				if (!this.ok) {
					this.third = true;
					this.seen = true;
					this.four=true;
				}
			},
			chang2 : function() {
				//alert(!this.seen)

				this.third = !this.third;
				if (!this.third) {
					this.seen = true;
					this.ok = true;
					this.four=true;
				}
			},
			chang3:function(){
				this.four=!this.four;
		     if(!this.four){
		    	 this.seen=true;
		    	 this.ok=true;
		    	 this.third=true;
		     }
			}
	   }
});

function a(a){
	var ele = a.parentElement.parentElement;
	for (i=0;i<ele.childNodes.length;i++){
		node = ele.childNodes[i];
		if(a!=node.childNodes[0]&&node.childNodes[1].style.display!='none')
			node.childNodes[1].style.display='none';
	}
	var e=a.nextSibling;//文档对象的下一个元素。prevousSibling前一个元素,childNodes子元素结点数组,parentElement父元素,//document.getElementById("dv");
	if(e.style.display=='none')//控制显示或隐藏下拉菜单项。
		 e.style.display="block";
	else
		e.style.display="none";
	
}
 function time(){
	 var date=new Date();
	 var time=date.toLocaleString();
	 var obj=document.getElementById("time");
	 obj.innerHTML=time;
 }
 setInterval("time()",1000);
</script>