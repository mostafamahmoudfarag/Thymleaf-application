function searchFunction(){
	`use strict`
	var input = document.getElementById("myInput");
	 var filter = input.value.toUpperCase();
	  console.log(filter)
var names=Array.from(document.getElementsByTagName("tr"));
for(var i=1;i<names.length;i++){
	 var td = names[i].getElementsByTagName("td")[0];
	if(td.innerText.toUpperCase().indexOf(filter)>-1){
		names[i].style.display="";
	
	}
	else
	{
		names[i].style.display="none";
				
}
	
}





}


