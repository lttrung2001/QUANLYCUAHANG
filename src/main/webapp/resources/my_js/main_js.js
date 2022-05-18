
window.onload=function(){
	
	
	$(document).on('click', 'a[href^="#"]', function (event) {
		event.preventDefault();
			document.body.scrollTop = 0; // For Safari
  			// document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
		$('html, body').animate({
			scrollTop: $($.attr(this, 'href')).offset().top
		}, 800);
	});

//khai báo main menu
	var mainButton=document.querySelectorAll('#main-menu>li>a')
	var listSection=document.querySelectorAll('section')
//event main menu
	for(let xm=0; xm<mainButton.length; xm++){
		mainButton[xm].addEventListener('click',function(e){
			// if(xm==0){
				// e.preventDefault()
			// 	// $('#home').animate({scrollTop:500},1000)
			// 	document.body.scrollTop = 0; // For Safari
  			// 	document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
			// }
			for(let xs=0; xs<mainButton.length; xs++){
				listSection[xs].style.display='none'
				mainButton[xs].style.color='#fff'
			}
			listSection[xm].style.display='block'
			mainButton[xm].style.color='#ed7d31'
		})
	}
	
		
	// smooth scroll
	
	// end of smooth scroll
	// include trong html
		// $(function(){
		// 	$('#include').load('dynamic_background.html')
		// })	
	// end of include
//  

	
	
	
	var filterLogin=document.querySelector('.filter-login')
	var iconHeader=document.querySelectorAll('.icon-button-header button')
	
	// var items=document.querySelectorAll('#home .items')
	var buyItem=document.querySelectorAll('.buy-item')
	var imgs=document.querySelectorAll('.items img')
	var nextImg=document.querySelector('.next-object')
	var prevImg=document.querySelector('.prev-object')
	let chooseImg=document.querySelector('.object-select img')
	var selectItem=document.querySelector('.select-item')
	var closeObject=document.querySelector('.close-object')

	//Tao object
	function Object(size, total,totalPrice){
		this.size=size
		this.total=total
		this.totalPrice=totalPrice
	} 


	
	
	


	function notification_option(){
		var result=prompt("Bạn có tiền mua không?","Không");
		if(result=='Không' ){
			alert("Không có tiền thì mời lượn");
		}
		else if(result=='Có'){
			alert("Mời quý khách vào lựa ạ");
		}
	}
	
	var searchBox=document.querySelector('.search-input');
	var iconSearch=document.getElementById('icon-search-btn');
	iconSearch.addEventListener('click',function(e){
		searchBox.classList.toggle('hide')
	})
	
// icon account
	
	
		
	// }
	// $('#icon-person-btn').click(myFunction_Account);	
	// function cancelButton(button){
	// 	window.addEventListener('mouseup', function(event){
	// 		if(event.target!=button && event.target.parentNode !=button ){
	// 			button.style.display="none";
	// 			console.log('asdkhjg')
	// 		}
	// 	});
	// }

	
	var iconAccount=document.getElementById('icon-person-btn')
	var menuAccount=document.getElementById('login_signup')
	let iconLogged=document.querySelector('.iconLogged')
	let iconCart=document.querySelector('.iconCart')
	let controlIconAccount=0
	function getMenu(){
		menuAccount.classList.toggle('hideAccount')
		
	}
	if(iconAccount!=null){
		iconAccount.addEventListener('click',getMenu)
	}
	
	
//	iconAccount.addEventListener('click',getClick)
//	function getClick(){
//		controlIconAccount++
//		console.log(controlIconAccount)
//		if(controlIconAccount%2!=0){
//			var user=document.getElementById("username-login")
//			var pass=document.getElementById("password-login")
//			var errorLogin=document.querySelector('.error-login')
//			var warningLogin=document.querySelector('.warning-login')
//			var loading=document.querySelector('.loading-login')
//			function resetFormLogin(){
//				loading.style.display='none'
//				errorLogin.style.display='none'
//				warningLogin.style.display='none'
//				user.value=''
//				pass.value=''
//			}
//			function resetFormSignup(){
//				let userSignup=document.getElementById('username-signup')
//				let passSignup=document.getElementById('password-signup')
//				let emailSignup=document.getElementById('email-signup')
//				let confirmPassSignup=document.getElementById('confirm-password-signup')
//				userSignup.value=''
//				passSignup.value=''
//				emailSignup.value=''
//				confirmPassSignup.value=''
//				document.getElementById('address-signup').value=''
//				document.getElementById('phone-signup').value=''
//				document.getElementById('name-signup').value=''
//			}
//			menuAccount.classList.remove('hideAccount')
//			let chooseLogin=document.getElementById('Login')
//			let chooseSignup=document.getElementById('Signup')
//			var signupBox=document.getElementById('signup-form')
//			var loginBox = document.getElementById("login-form");
//			chooseLogin.addEventListener('click',function(){
//				
//				loginBox.style.display="block";
//				menuAccount.classList.add('hideAccount')
//				resetFormLogin()
//				filterLogin.style.display='block'
//				let closeLogin=document.getElementById('close-login')
//				// let iconUser=document.querySelector('.iconUser')
//				controlIconAccount=1
//				iconHeader.forEach(function(e){
//					e.disabled=true
//				})
//				function enterLogin(){
//					if(user.value=='' || pass.value==''){		
//						warningLogin.style.display='block'
//						errorLogin.style.display='none'
//					}
//					else{
//						warningLogin.style.display='none'
//						if(user.value=="n19dccn018@student.ptithcm.edu.vn" && pass.value=="xxx"){
//							errorLogin.style.display='none'
//							loading.style.display='block'
//							console.log(2)
//							setTimeout(function(){
//								loginBox.style.display='none'
//								filterLogin.style.display='none'
//								iconAccount.style.display='none'
//								iconLogged.style.display='block'
//								iconCart.style.display='block'
//								controlIconAccount=0
//								iconHeader.forEach(function(e){
//									e.disabled=false
//								})
//							},200)
//							
//							
//						}
//						else{
//							errorLogin.style.display='block'
//						}
//					}
//				}
//				var login=document.querySelector('.login-button')
//				login.addEventListener('click',enterLogin)
//				
//				closeLogin.addEventListener('click',function(){
//					loginBox.style.display='none'
//					filterLogin.style.display='none'
//					controlIconAccount=0
//					iconHeader.forEach(function(e){
//						e.disabled=false
//					})
//				})
//			})
//			chooseSignup.addEventListener('click',function(){
//				var formSignup=document.querySelector('#signup-form form')
//				var submitSignup=document.querySelector('.btn-submit-signup')
//				signupBox.style.display="block";
//				menuAccount.classList.add('hideAccount')
//				filterLogin.style.display='block'
//				resetFormSignup()
//				let closeSignup=document.getElementById('close-signup')
//				controlIconAccount=1
//				iconHeader.forEach(function(e){
//					e.disabled=true
//				})
//				formSignup.addEventListener('submit',function(e){
//					let userSignup=document.getElementById('username-signup')
//					let passSignup=document.getElementById('password-signup')
//					e.preventDefault()
//					console.log(userSignup.value, passSignup.value)
//					resetFormSignup()
//					
//				})
//				// submitSignup.addEventListener('click',function(){
//				// 	loading.style.display='block'
//				// 	setTimeout(function(){
//				// 		signupBox.style.display='none'
//				// 		filterLogin.style.display='none'
//				// 		controlIconAccount=0
//				// 		iconHeader.forEach(function(e){
//				// 			e.disabled=false
//				// 		})
//				// 		},2000)
//				// })
//				closeSignup.addEventListener('click',function(){
//
//					signupBox.style.display='none'
//					filterLogin.style.display='none'
//					controlIconAccount=0
//					iconHeader.forEach(function(e){
//						e.disabled=false
//					})
//				})
//			})
			
		}
//		else{
//			menuAccount.classList.add('hideAccount')
//		}
//	}

	


	//======================================================
// end of icon account

// =======Logged
	iconLogged.addEventListener('click',function(){
		document.querySelector('.menuLogged').classList.toggle('hide')
		
	})

	
// =======End of Logged

	
	
	
	// Buy item
	let totalTemp=0
	let totalObject=document.querySelector('.total-object p')	
	let descItem=document.querySelectorAll('.describe-item')
	let priceItem=document.querySelectorAll('.price-item')
	let priceTemp=0
	let totalPriceObject=document.querySelector('.price-object')
	let descSelected=document.querySelector('.describe-object p')
	for(let i=0; i<buyItem.length; i++){
		
		buyItem[i].addEventListener('click',function(){
			totalTemp=0
			totalPriceObject.innerHTML=''
			totalObject.innerHTML=0
			filterLogin.style.display='block'
			selectItem.style.display='flex'
			chooseImg.src=imgs[i].src
			descSelected.innerHTML=descItem[i].textContent			
			priceTemp=priceItem[i].innerHTML
			// close object
				
			// next and prev object
				
		})
		closeObject.addEventListener('click',function(){
			selectItem.style.display='none'
			filterLogin.style.display='none'
		})
		nextImg.addEventListener('click',function(){
			setTimeout(function(){
				selectItem.style.display='flex'
			},200)
			selectItem.style.display='none'
		})
		prevImg.addEventListener('click',function(){
			setTimeout(function(){
				selectItem.style.display='flex'
			},200)
			selectItem.style.display='none'
		})	
	}
	// select size object
	
	// add and subtract total object
	var addTotalObject=document.querySelector('.add-total')
	var subTotalObject=document.querySelector('.subtract-total')
	
	addTotalObject.addEventListener('click',function(){
		totalTemp=totalTemp+1
		totalObject.innerHTML=totalTemp
		console.log(priceTemp)
		// Sum Price of Object
		totalPriceObject.innerHTML=priceTemp*totalTemp
	})
	subTotalObject.addEventListener('click',function(){
		if(totalTemp>0){
			totalTemp=totalTemp-1
			totalObject.innerHTML=totalTemp
			console.log(priceTemp)
			// Sum Price of Object
			totalPriceObject.innerHTML=priceTemp*totalTemp
		}
	})
	
	// Total in cart
	let totalCart=document.querySelector('#icon-cart')
	let totalCartTemp=0;
	let confirmObject=document.querySelector('.confirm-object button')
	confirmObject.addEventListener('click',function(){
		totalCartTemp=totalTemp
		totalCart.innerHTML=totalCartTemp
	})
	// End of Buy item
	
	// Load more
	// $('#home .items').slice(0,8).show()
	let loadMore=document.getElementById('loadMore')
	loadMore.addEventListener('click',function(e){
		e.preventDefault()
		$('#home .items:hidden').slice(0,4).slideDown()
		if($('#home .items:hidden').length==0){
			loadMore.style.display='none'
		}
		
	})
	// let allImages=['my_image/']
	// let image=document.createElement('img')
	// let listImages=document.getElementById('listImages')
	// image.src=allImages[0]
	// let listItem=document.createElement('li').appendChild(image)
	// listImages.appendChild(listItem)

	// End of Load more