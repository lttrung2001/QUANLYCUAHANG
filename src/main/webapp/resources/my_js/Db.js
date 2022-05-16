// MenuToggle
let toggle=document.querySelector('.toggle')
let mainMenu=document.querySelector('.mainMenu')
let navigation=document.querySelector('.navigation')
let main=document.querySelector('.main')
let logo=document.querySelector('.logoManagement')
let logoImg=document.querySelector('.imgLogoManagement')
toggle.addEventListener('click',function(){
    mainMenu.classList.toggle('active')
    logo.classList.toggle('hideTitle')
    logoImg.classList.toggle('zoomOut')
})




// keep hover
let listMenu=document.querySelectorAll('.navigation li')
function activeLink(){
    listMenu.forEach((item)=> 
        item.classList.remove('hovered'))

        this.classList.add('hovered')
}
listMenu.forEach((item)=>
    item.addEventListener('mouseover',activeLink))

// end keep hover


// Login admin
let login=document.querySelector('#data .admin button')
let formLogin=document.querySelector('.formLogin')

login.addEventListener('click',function(){
    login.style.display='none'
    formLogin.style.display='flex'
    let accountLogin=document.getElementById('accountLogin')
    let user=document.getElementById('user')
    let pass=document.getElementById('pass')
    let loginButton=document.querySelector('.formLogin form button')
        loginButton.addEventListener('click',function(e){
            if(user.value=='admin' && pass.value=='123'){
                e.preventDefault()
                accountLogin.style.display='flex'
                formLogin.style.display='none'
            }
            else{
                alert('cas')
            }
        })
})
// End of login admin

// Order Managerment
    let lineTableOrder=document.querySelectorAll('.orderList table tbody tr')
    for(let i=0; i<lineTableOrder.length; i++){
        if(i%2!=0){
            lineTableOrder[i].classList.add('colorLine')
        }
    }

// End of Managerment



// Product Management
    let dropDownTypeProduct=document.querySelector('.menuTypeProduct button')
    let listTypeProduct=document.querySelector('.listTypeProduct')
    let valueTypeProduct=document.querySelector('.mainProduct .tableProduct .menuTypeProduct .typeProduct input')
    dropDownTypeProduct.addEventListener('click',function(){
        listTypeProduct.classList.toggle('hideListTypeProduct')
        let chooseTypeProduct=document.querySelectorAll('.listTypeProduct p')
        let displayTypeProduct=document.querySelector('.typeProduct')
        chooseTypeProduct.forEach((item)=>
            item.addEventListener('click',function(){
                displayTypeProduct.innerHTML=item.innerHTML
                valueTypeProduct.value=item.innerHTML
                listTypeProduct.classList.add('hideListTypeProduct')
            }))
        
        // let valueTable=document.querySelectorAll('.tableProduct table tbody tr td')
        // for(let i=0; i<chooseTypeProduct.length; i++){
        //     chooseTypeProduct[i].addEventListener('click',function(){
        //         if(i==3){
        //             valueTable.forEach(e=>
        //                 e.innerHTML=''
        //             )
        //         }
        //     })
        // }
    })
    let inputSearchProduct=document.querySelector('.searchProduct input')
    let iconSearchProduct=document.querySelectorAll('.mainProduct .topMainProduct .searchProduct span')
    let demHoverSearchQLSP=0
    for(let i=0; i<iconSearchProduct.length; i++){
        iconSearchProduct[i].addEventListener('mouseenter',function(){
            document.querySelector('.mainProduct .topMainProduct .searchProduct span:first-child').style.width='60%'
        })
        iconSearchProduct[i].addEventListener('mouseleave',function(){
            if(demHoverSearchQLSP==0){
                document.querySelector('.mainProduct .topMainProduct .searchProduct span:first-child').style.width='0'
            }
        })
    }
    // iconSearchProduct.addEventListener('click',function(){
    //     iconSearchProduct.style.right=0
    //     inputSearchProduct.style.width='300px'
    // })
    inputSearchProduct.addEventListener('keypress',function(){
        demHoverSearchQLSP=1
    })
    

// End of Product Management

// Customer Managerment
    mailCustomer=document.querySelectorAll('.cardCustomer .extendInfo .mail')
    spanMailCustomer=document.querySelectorAll('.cardCustomer .extendInfo .mail span')
    let demMail=0
    addressCustome=document.querySelectorAll('.cardCustomer .extendInfo .address span')
    for(let i=0; i<mailCustomer.length; i++){
        
    }
// End o fCustomer Managerment

// Statistical : Thống kê

    let mainStatistical=document.querySelector('.mainStatistical')
    let mainCustomerManagement=document.querySelector('.mainCM')
    let mainProduct=document.querySelector('.mainProduct')
    let mainOrder=document.querySelector('.mainOrder')
    let mainTypeProduct=document.querySelector('.mainTypeProduct')
    for(let i=0; i<listMenu.length; i++){
        listMenu[i].addEventListener('click',function(){
            if(i==5){
                mainStatistical.style.display='block'    
            }
            else{
                mainStatistical.style.display='none'
            }
            if(i==4){
                mainCustomerManagement.style.display='flex'
                
            }
            else{
                mainCustomerManagement.style.display='none'
            }
            if(i==3){
                mainProduct.style.display='block'
            }
            else{
                mainProduct.style.display='none'
            }
            if(i==2){
                mainTypeProduct.style.display='block'
            }
            else{
                mainTypeProduct.style.display='none'
            }
            if(i==1){
                mainOrder.style.display='block'
            }
            else{
                mainOrder.style.display='none'
            }

        })
    }
    // hoverStatistical.addEventListener('mouseover',function(){
    //     mainStatistical.style.display='block'
    // })
// End of Statistical