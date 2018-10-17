/**
 * 
 */
function quant()
{
 var retval=true;
 var avail=document.getElementById("avail").value;
 var req=document.getElementById("req").value;
 if(req.length==0)
	 {
	 document.getElementById("noquant").innerHTML="*required cannot be null";
	 }
 if(req>avail)
	 {
	 
	 document.getElementById("noquant").innerHTML="*required cannot be greater than availablity";
	 return false;
	 }
	
}
function validaddress(){

	var retval=true;
	var toaddress=document.getElementById("toAddress").value;
	if(  toaddress.length==0)
		{
	 document.getElementById("add").innerHTML="*Address Field cannot be empty";
		retval=false;
		
		}
	return true;
}
 function validphone()
 {
	 var phoneno=document.getElementById("phoneNo").value;
      var patt1=/^[0-9]+$/;
		
	if(phoneno.length==0)
		{
		 document.getElementById("phne").innerHTML="*Phone Field cannot be empty";
		return false;
	    } 
	else if(!phoneno.match(patt1))
	    {
	     document.getElementById("phne").innerHTML="*phone Number should only numeric";
	return false;
	   }
	else if(phoneno.length!=10)
		{
	  document.getElementById("phne").innerHTML="*phone Number should be valid one";
	return false;
		}
	
 }
 function clearspan1()
 {
	 document.getElementById("phne").innerHTML="";
	 document.getElementById("add").innerHTML="";
	 document.getElementById("noquant").innerHTML="";
 }
 function clearspan2()
 {
	 document.getElementById("add").innerHTML="";
	 
 }
 function vaildformm()
 {
	 var retval=true;
	 var patt1=/^[0-9]+$/;
	 var toaddress=document.getElementById("toAddress").value;
	 var phoneno=document.getElementById("phoneNo").value;
	 var phoneno=document.getElementById("phoneNo").value;
     var patt1=/^[0-9]+$/;
     var avail=document.getElementById("avail").value;
     var req=document.getElementById("req").value;
     if(req.length==0)
	 {
	 document.getElementById("noquant").innerHTML="*required cannot be null";
	 }
     else if(req>avail)
	 {
	 
	 document.getElementById("noquant").innerHTML="*required cannot be greater than availablity";
	 return false;
	 }
     if(phoneno.length==0)
		{
		 document.getElementById("phne").innerHTML="*Phone Field cannot be empty";
		return false;
	    } 
	else if(!phoneno.match(patt1))
	    {
	     document.getElementById("phne").innerHTML="*phone Number should only numeric";
	return false;
	   }
	else if(phoneno.length!=10)
	{
    document.getElementById("phne").innerHTML="*phone Number should be valid one";
    return false;
	}
   if(toaddress.length==0)
		{
	 document.getElementById("add").innerHTML="*Address Field cannot be empty";
		return false;
		
		}
	else
		{
		return true;
		}
	 
 }