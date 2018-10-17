
function formvalidation(){
	
	var giftType1=document.getElementById("giftType").value;

	var giftDescription1=document.getElementById("giftDescription").value;
	
	var otherType1=document.getElementById("otherType").value;
	
	var occasion1=document.getElementById("occasion").value;

	var otherOcasion1=document.getElementById("otherOcasion").value;
	
	var quantity1=document.getElementById("quantity").value;
	
	var cost1=document.getElementById("cost").value;
	
	var gtype=document.getElementById("otherType").value;
	
	var otype=document.getElementById("otherOcasion").value;
	
	var numbers = /^[0-9]+$/;
	var retval=true;
	
	if(giftType1=="--select--"){
		
		document.getElementById("giftType1").innerHTML="Select gift type";
		retval=false;
	}
	if(giftType1=="other"){
		if(gtype.length==0)
			{
		document.getElementById("otherType1").innerHTML="Enter new gift type";
		retval=false;
			}
	}
	
	if(giftDescription1.length==0){
		document.getElementById("giftDescription1").innerHTML="Enter gift description";
		retval=false;
	}
	if(occasion1=="--select--"){
		
		document.getElementById("occasion1").innerHTML="Select occasion type";
		retval=false;
	}
	if(occasion1=="other")
		{
		if(otype.length==0){
		document.getElementById("otherOcasion1").innerHTML="Enter new Occasion";
		retval=false;
		}
		}
	if(quantity1.length==0){
		document.getElementById("quantity1").innerHTML="Enter quantity";
		retval=false;
	}
	
	if(cost1.length==0){
		document.getElementById("cost1").innerHTML="Enter Cost";
		retval=false;
	}
	
	
	
	return retval;
}


function AddAfter(ele){
	
	if(ele.value=="other"){
		alert('entered');	
    var target = document.getElementById('oTypeRow');	
    var newElement = document.createElement('tr');
    newElement.style.visibility='visible';
    target.parentNode.insertBefore(newElement, target.nextSibling );
    var td1= newElement.insertCell(0);
    td1.innerHTML="<font style='color=white;'>Other Type</font>";
    var td2= newElement.insertCell(1);
    td2.innerHTML="<input type='text' name='otherType' onfocus='clearSpan('otherType1')' >" +
    		"<span id='otherType1' style='color: white'></span>";
    
    return newElement;
 }
}

function visible1(){
	
    var gifttype = document.getElementById('giftType').value; 
	
    if(gifttype == "other"){
    	
        document.getElementById("otherType").style.display = "block";
        document.getElementById("otherlbl").style.display = "block"; 
    }
    
    else
    	{
        document.getElementById("otherType").style.display = "none";
    	document.getElementById("otherlbl").style.display="none";
    	}
}

function visible2(){

    var gifttype = document.getElementById('occasion').value; 
	
    if(gifttype == "other"){
    	
        document.getElementById("otherOcasion").style.display = "block";
        document.getElementById("otherlb2").style.display = "block"; 
    }
    
    else
    	{
        document.getElementById("otherOcasion").style.display = "none";
    	document.getElementById("otherlb2").style.display="none";
    	}
}

function clearSpan(elem){
    document.getElementById(elem).innerHTML=''; 
}

function isNumeric1(elem){
	var numericExpression = /^[0-9]+$/;
	if(elem.value.match(numericExpression)){
		return true;
	}else{
		document.getElementById('quantity1').innerHTML="Enter only numerics";
		
		elem.focus();		
		return false;
	}
}
function isNumeric2(elem){
	var numericExpression = /^[0-9]+$/;
	if(elem.value.match(numericExpression)){
		return true;
	}else{
		document.getElementById('cost1').innerHTML="Enter only numerics";
		
		elem.focus();		
		return false;
	}
}

function ischar(elem){
	var data=/^[a-zA-z]+$/;
	
	if(elem.value.match(data)){
		return true;
	}else
		{
		document.getElementById('otherType1').innerHTML="Enter only Alphabets";
		elem.focus();
		return false;
		}
	
}
function ischar1(elem){
	var data=/^[a-zA-z]+$/;
	
	if(elem.value.match(data)){
		return true;
	}else
		{
		document.getElementById('otherOcasion1').innerHTML="Enter only Alphabets";
		elem.focus();
		return false;
		}
	
}