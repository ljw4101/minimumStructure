var app=app || {}; /*name space*/

app.common = (()=>{
	var init = ctx=>{
		app.session.init(ctx);
		app.index.init();
	};
	
	return {init : init};
})();

/*******************************
 * index
 *******************************/
app.index = (()=>{
	var ctx;
	var init = ()=>{
		ctx = $$('x');
		js=$$('j');
		setContentView();
	};
	
	var setContentView = ()=>{
		$.getJSON(ctx+'/list/count', d=>{
			alert(d.flag+"/"+d.count);
		});
		
	};
	
	return {init : init};
})();

/*******************************
 * session
 * session :login 후 필요한 정보 담음
 *******************************/
app.session=
	{
		//set
		init : (ctx)=>{
					sessionStorage.setItem('x', ctx);	//접근경로를 로그인 할때만 준다(보안)
					sessionStorage.setItem('j', ctx+'/resources/js');
					sessionStorage.setItem('i', ctx+'/resources/img');
					sessionStorage.setItem('c', ctx+'/resources/css');
			   },
		//get
		getPath : (x)=>{
			return sessionStorage.getItem(x);
		}
	};

//함수
var $$ = (x)=>{return app.session.getPath(x);};