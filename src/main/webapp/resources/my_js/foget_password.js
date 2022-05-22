// ========= QUEN MAT KHAU ===========================
let btnForgetPass=document.querySelector('.forgotPassword .submitFP')
btnForgetPass.addEventListener('click',function(){
    btnForgetPass.innerHTML='XÁC NHẬN'
    document.querySelector('.forgotPassword .codeCheckPass').style.display='block'
    document.querySelector('.forgotPassword small').innerHTML='Nhập mã code vừa được gửi tới email của bạn'
})