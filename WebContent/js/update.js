/**
 * 
 */
 var retval=true;
 function mandate()
 {
	var value1=document.display.deliveryStatus.value;
 	var bdt=display.bdate.value;
 	/* alert(display.bdate.value); */
 	//var bdt1=bdt.substring(0,4)+"/"+bdt.substring(5,7)+"/"+bdt.substring(8,10);
 	var bdt2=new Date(bdt);
 	var adt=new Date(document.getElementById('datepicker').value);
 	var adt1=document.getElementById("datepicker").value;
 	/* alert(adt); */
 	if(adt1==""){
 		document.getElementById('delmsg2').innerHTML="date should not be empty";
 		return false;
 	}
 	if(adt<bdt2){
 		document.getElementById('delmsg2').innerHTML="must be greater than booking date";
 		return false;
 	} 
 	if(value1=="" || value1==null){
 		document.getElementById('delmsg1').innerHTML="should not be empty";
 		return false;
 	}
 	if(value1.length<10)
	{
	document.getElementById('delmsg1').innerHTML="Should be more than ten characters";
	return false;
	}
 	if(retval!=false)
	{
	retval=true;
	}
 	
 	return retval;
 		 
 	//return false;
 }
 function clearSpan(elem){
	    document.getElementById("delmsg1").innerHTML=''; 
	}
 function clearSpan(elem){
	    document.getElementById("delmsg2").innerHTML=''; 
	}