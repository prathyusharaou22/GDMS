function ClearTextboxes() {
	
	document.getElementById('datepicker').value = '';
	document.getElementById('datepicker1').value = '';
	
}

function clearspan(elem){
	

	
	document.getElementById(elem).innerHTML="";
	
}
function notEmpty(){
	
	var todate=document.getElementById("datepicker1").value;
	var fromdate=document.getElementById("datepicker").value;
	if(fromdate=="" || todate==""){
	
	document.getElementById("tdate").innerHTML="date should not be empty";
	
	return false;
	}
	else
	{
	return true;
	}
}






function clearspan(elem){
	document.getElementById("fdate").innerHTML="";
	document.getElementById("tdate").innerHTML="";
}

function dateValidate1(elem)
{	
	var curdate=new Date();
	curdate.setHours(0, 0, 0, 0);
	var todate=new Date(elem.value);
	
	if(todate>=curdate)
		{
			alert('Date should be less than Todays date');
			
			elem.value='';
			elem.focus();
			return false;
		}
	else
		{		
			return true;
		}

}
function equalValidate(){
	
	var todate=document.getElementById("datepicker1").value;
	var fromdate=document.getElementById("datepicker").value;
	var retval=true;
	if(fromdate>=todate && fromdate!="" && todate!=""){
		alert("Todate should be greater than Fromdate");
		retval=false;
	}
	
	
	return retval;
}

function formvalidate()
{
	var formdate=document.getElementById("datepicker").value;
	var todate=document.getElementById("datepicker1").value;
	
	var retval=true;
	
	if(fromdate.length==0){
		document.getElementById("fdate").innerHTML="date should not be empty";
		retval=false;
	}
	else if(todate==0)
		{
		document.getElementById("tdate").innerHTML="date should not be empty";
		retval=false;
		}
	return retval;
}





