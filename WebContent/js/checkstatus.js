function check(){
	var c=document.getElementById("book").value;
	var Exp = /^[0-9a-zA-Z]+$/; 
	if(c==""){
		document.getElementById("ownmer").innerHTML="Enter booking id";
		return false;
	}
	else if(!c.match(Exp)){
		document.getElementById("ownmer").innerHTML="Enter Only Alpha Numeric Values";
		return false;
	}
}
function clearSpan(elem){
    document.getElementById("ownmer").innerHTML=''; 
}
