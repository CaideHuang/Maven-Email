function submit(email,password){
	$.ajax({
		
		url:"insertUser.do",
		type:"post",
		data:{
			email:email,
			password:password
		},
		success:function(data){
			if(data.code==1){
			   window.location.href="list.do";
			}else{
				alert(data.message);
			}
		}
		
	})
}

function submit_email(email){
	$.ajax({
		
		url:"jsonSelectUser.do",
		type:"post",
		data:{
			email:email,
		},
		success:function(data){
	          if(data.state=="1"){
	        	  $("#btn").addClass("disabled");
	          }else{
	        	  $("#btn").removeClass("disabled");
	          }
		}
		
	})
}