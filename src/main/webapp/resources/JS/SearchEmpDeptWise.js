function getvalue(id)
 {
	 let xhttp=new XMLHttpRequest();
 	xhttp.onreadystatechange=function(){
 		 if(this.readyState==4 && this.status==200){
 			 document.getElementById("d").innerHTML=this.responseText;
 		 }
 	};
 	xhttp.open("GET","GetEmpbyDeptId?id="+id,true)
 	xhttp.send();
 }