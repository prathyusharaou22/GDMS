/**
 * 
 */

 

  function formvalidationcust()
{
	
	var fn=document.getElementById("firstName").value;
	var ln=document.getElementById("lastName").value;
	var pwd=document.getElementById("passWord").value;
	var rpwd=document.getElementById("retypepassWord").value;
	var cno=document.getElementById("contactNo").value;
	var dob=document.getElementById("datepicker1").value;
	var addr=document.getElementById("address").value;
	var gender=document.getElementById("select12").value;
	var email=document.getElementById("emailId").value;
	
	if(fn == "")
		{
		document.getElementById("firstName1").innerHTML="Enter first name";
		
    if(ln == "")
		{
    	document.getElementById("lastname1").innerHTML="Enter last name";
		
	if(pwd == "")
		 {
		 document.getElementById("passWord1").innerHTML="Enter password";
	if(rpwd == "")
		 {
		 document.getElementById("retypepassWord1").innerHTML="Retype password";
	if(cno == "")
		 {
		 document.getElementById("contactNo1").innerHTML="Enter contact no";
	if(dob == "")
		 {
		 document.getElementById("datepicker12").innerHTML="Select date of birth";
	if(addr == "")
		 {
		 document.getElementById("address1").innerHTML="Enter address";
	if(gender == "")
		{
		document.getElementById("gender1").innerHTML="Select gender";
		
    if(email == "")
		 {
		 document.getElementById("emailId1").innerHTML="Enter email id";
		 return false;
		 }
		 }
		 }
		 }
		 }
		 }
		}
		}
		}
	 return true;
	}
 
function isalphaspace(elem)
{
	   var elem1=elem.value;
	   var re=/^[a-zA-Z ]+$/;
	   if(elem1.match(re))
		   {
		   return true;
		   }
	   else
		   {
		  document.getElementById("firstName1").innerHTML="Enter only alphabets";
		  return false;
		   }
}

function clearSpan(elem)
{
	document.getElementById(elem).innerHTML=" ";
}

function iscontactno(elem)
{
	var elem1=elem.value;
	var phoneno = /^\d{10}$/;  
	if(elem1.match(phoneno))
		{
		return true;
		}
	else
		{
		document.getElementById("contactNo1").innerHTML="Contact number should be 10 digits";
		return false;
		}
}

function isemailid(elem)
{
var elem1=elem.value;
var emailRegEx = /^([a-zA-Z0-9])([a-zA-Z0-9\._-])*@(([a-zA-Z0-9])+(\.))+([a-zA-Z]{2,4})+$/ ;
if(elem1.match(emailRegEx))
	{
	return true;
	}
else
	{
	//alert('Enter valid Email id which should contain @ and .');
	document.getElementById("emailId1").innerHTML="Enter valid Email id which should contain @ and .";
	return false;
	}
}

function isPassword(elem)
{
	
	var elem1=elem.value;
	var pwd=/^(?=.*[0-9])(?=.*[!@#$])[a-zA-Z0-9!@#$%^&*]{1,25}$/;
	var pwd1=/^[0-9]+$/;
	var pwd2=/^[!@#$]+$/;
	if(elem1.length<8)
	{
		document.getElementById('passWord1').innerHTML="Password must contain atleast 8 characters";
		return false;
	}
    else if(!elem1.match(pwd))
	{
		document.getElementById('passWord1').innerHTML="Include atleast one number and special character";
		return false;
		}
	else if(elem1.charAt(0).match(pwd1) || elem1.charAt(0).match(pwd2))
		{
		document.getElementById('passWord1').innerHTML="Do not start with special character or number";
		return false;
		}
	else
		{
		return true;
		}
}

function isRepassword(elem1,elem2)
{
	var pwd=elem1.value;
	var rpwd=elem2.value;
	if(pwd.match(rpwd))
		{
		return true;
		}
	else
		{
		document.getElementById('retypepassWord1').innerHTML="Password does not match";
		return false;
		}
}

function isemailid1(elem)
{
	
var elem1=elem.value;
var emailRegEx = /^([a-zA-Z0-9])([a-zA-Z0-9\._-])*@(([a-zA-Z0-9])+(\.))+([a-zA-Z]{2,4})+$/ ;
if(elem1.match(emailRegEx))
	{
	return true;
	}
else
	{
	document.getElementById('userName1').innerHTML="Enter valid Email id";
	return false;
	}
}

function isPassword1(elem)
{
	var elem1=elem.value;
	var pwd=/^(?=.*[0-9])(?=.*[!@#$])[a-zA-Z0-9!@#$%^&*]{1,25}$/;
	var pwd1=/^[0-9]+$/;
	var pwd2=/^[!@#$]+$/;
	if(elem1.length<8)
	{
		//alert('Password must contain atleast 8 characters');
		 document.getElementById('passWord1').innerHTML="Password must contain atleast 8 characters";
		return false;
	}
    else if(!elem1.match(pwd))
	{
    	//alert('Include atleast one number and special character');
		 document.getElementById('passWord1').innerHTML="Include atleast one number and special character";
		return false;
		}
	else if(elem1.charAt(0).match(pwd1) || elem1.charAt(0).match(pwd2))
		{
		//alert('Do not start with special character or number');
		 document.getElementById('passWord1').innerHTML="Do not start with special character or number";
		return false;
		}
	else
		{
		return true;
		}
}

function formvalidationlogin() {
	var un=document.getElementById("userName").value;
	var pwdlogin=document.getElementById("passWord").value;
	var select=document.getElementById("select1").value;
	if(un== "")
		{
		document.getElementById("userName1").innerHTML="Enter name";
		if(pwdlogin == "")
			{
			document.getElementById("passWord1").innerHTML="Enter password";
		if(select == "")
			{
			
			document.getElementById("loginType1").innerHTML="Select logintype";
			return false;
			}
			}
		
		}
	return true;
}

