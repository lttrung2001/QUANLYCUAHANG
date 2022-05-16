window.onload=function(){
    function reset(){
        document.querySelector('.mailOriginal').style.display='block'
        document.querySelector('.boxChange .emailChange .boxChangeEmail').style.display='none'
        document.querySelector('.titleEmailChange').innerHTML=' Email'
    }




    let infoCustomer=document.querySelectorAll('.container .list ul li')
    for(let i=0; i<infoCustomer.length; i++){
        infoCustomer[i].addEventListener('click',function(){
            if(i==0){
                document.querySelector('.boxInfo').style.display='flex'
                document.querySelector('.emailChange').style.display='none'
                document.querySelector('.passChange').style.display='none'
            }
            
            else if(i==1){
                document.querySelector('.emailChange').style.display='none'
                document.querySelector('.boxInfo').style.display='none'
                document.querySelector('.passChange').style.display='block'
                
                
            }
            else{
                document.querySelector('.emailChange').style.display='block'
                document.querySelector('.titleEmailChange').textContent=' Email mới'
                document.querySelector('.boxInfo').style.display='none'
                document.querySelector('.passChange').style.display='none'
                reset()
            }
        })
    }
    document.querySelector('.emailFixButton').addEventListener('click',function(){
        document.querySelector('.boxChange .emailChange .boxChangeEmail').style.display='block'      
        document.querySelector('.mailOriginal').style.display='none'
        document.querySelector('.titleEmailChange').innerHTML=' Email mới'
    })  
    
}