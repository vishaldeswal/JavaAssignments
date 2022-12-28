function getInfo(){
    
    
    const name= document.getElementById('name').value;
    const email=document.getElementById('email').value;
    const website=document.getElementById('website').value;
    const image=document.getElementById('imagesrc').value;

    const male= document.getElementById('flexRadioDefault1');
    const female= document.getElementById('flexRadioDefault2');

    const java=document.getElementById('javaMarked');
    const html=document.getElementById('htmlMarked');
    const css=document.getElementById('cssMarked');
    
    var allValidated=validateName(name);
    
    if(allValidated){
        console.log("Name="+ name);
        allValidated=true;
    }
    
    allValidated = allValidated && validateEmail(email);
    
    if(allValidated){
        console.log("Email="+email);
    }
    
    allValidated = allValidated && validateURL(website);

    if(allValidated){
        console.log("Website="+website);
    }
    
    allValidated = allValidated && validateImage(image);
    if(allValidated){
        console.log("Image src="+image);
    }
    
    var gender;
    if(male.checked)
    {
        console.log("Gender="+male.value);
        gender=male.value;
    }
    else{
        console.log("Gender="+female.value);
        gender=female.value;
    }

    var skills= validateSkill(java, html, css);
    console.log("Skills="+skills);

    var description = document.createElement('p');
    description.innerHTML='<b> '+name+' </b> <br> '+email+' <br> <a href= '+website+' target="blank">'+website+'</a><br>  '+gender+'<br> '+skills;
    
    if(allValidated && skills!=""){
        addRow(description, image);
        clearForm();
    }
  
}


function validateName(name){
    
    
    if(name=="")
    {
        alert("Name cannot be empty field.");
        return false;
    }
    return true;
    
}

function validateEmail(email){
    if(email=="")
    {
        alert("Email cannot be empty field.");
        return false;

    }

    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    
    if(email.match(mailformat))
   {
     return true;
   }

   else
   {
     alert("Invalid email address!");
     return false;
   }
}

function validateURL(website){
    if(website=="")
    {
        alert("Website cannot be empty field.");   
        return false;
    }
    
    var urlFormat=/^((https?):\/\/)?([w|W]{3}\.)+[a-zA-Z0-9\-\.]{3,}\.[a-zA-Z]{2,}(\.[a-zA-Z]{2,})?$/;
    if(website.match(urlFormat))
    {
        return true;
    }
    else
    {
        alert("Invalid Website URL!");
        return false;
    }

}

function validateImage(image){
    if(image=="")
    {
        alert("Image Link cannot be empty field.");  
        return false; 
    }
    return true;

}

function validateSkill(java, html, css){

    var skills="";
    var isSkillEmpty= true;
    if(java.checked)
    {
        skills=skills+java.value+" ";
        isSkillEmpty=false;
    }
    if(html.checked)
    {
        skills=skills+html.value+" ";
        isSkillEmpty=false;

    }
    if(css.checked)
    {
        skills=skills+css.value+" ";
        isSkillEmpty=false;
    }

    if(isSkillEmpty){
        alert("Skills cannot be empty.Please tick mark any one of the given skills.");
    }
    
    return skills;
}

function addRow(description, imagesrc){
    var table= document.getElementById("enrolled");
    var row= table.insertRow();
    row.classList.add("rowtest");
    var cell=row.insertCell();
    cell.appendChild(description);
    var img=document.createElement('img');
    img.src=imagesrc;
    cell= row.insertCell();
    cell.innerHTML='<img src="'+img.src+'" alt="Invalid image link" width="100" height="120"/>';
}

function clearForm(){
    console.log("Ceal function");
    document.querySelector("#name").value = "";
    document.querySelector("#email").value = "";
    document.querySelector("#website").value = "";
    document.querySelector("#imagesrc").value = "";
    var checks = document.querySelectorAll('.check');
    for(var i=0;i<checks.length;i++){
        checks[i].checked = false;
    }
    document.getElementById('flexRadioDefault1').checked = true;
}