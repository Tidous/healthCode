;(function(window,$){
	$(document).ready(function(){
		$('.gx-bg').on('click',function(){
			$(this).toggleClass('on');
		})
		$('[data-littlePic=picLittle]').on('click',function(){
            $('[data-pictilt=picLitt]').attr('src','http://passport.xywy.com/reg.php?act=mobile_reg_vcode_send_captcha&amp;'+Math.random());
		
		})
		$('.m_yzm_btn').on('click',  function(){
			var trimName=$.trim( $('.m_username').val());
			//var trimName=Name.replace('+86','');
			  var trimYzPar = $('.m_username').parent().parent();			
			if( trimName==''){
				trimYzPar.addClass('bor-error');
				trimYzPar.siblings('.m_wrom').show();
				trimYzPar.siblings('.m_wrom').html(' 请输入手机号');
			}else{				
				if(trimName.match(/^1[3|4|5|7|8][0-9]\d{8}$/)){
					$.ajax({
						url:'http://passport.xywy.com/reg_jsonp.php?act=mobile_reg_isreg&callback=?',
						dataType: 'JSONP',
						data:'&account='+ trimName,
						success:function(data){
							if(data.result == 10000){
								$.ajax({
									url:'http://passport.xywy.com/reg_jsonp.php?act=mobile_reg_vcode_if_limit&callback=?',
									dataType: 'JSONP',
									data:'&phone='+ trimName,
									success:function(data){		
										//console.log(data);											
										if(data.result == 10000){
											////
											$.ajax({
												dataType:'jsonp',	
												url:'http://passport.xywy.com/reg_jsonp.php?act=mobile_reg_vcode_if_limit_ip',				
												success:function( data ){
													//var evcishu = eval('('+data+')');
													//console.log(evcishu) ;
													if(data.result == 10000)
													{
														if( trimName=='')
														{
															trimYzPar.addClass('bor-error');
															trimYzPar.siblings('.m_wrom').show();
															trimYzPar.siblings('.m_wrom').html(' 请输入手机号');
																						
														}else
														{
															if(trimName.match(/^1[3|4|5|7|8][0-9]\d{8}$/))
															{
																/////
																$.ajax({
																	url:'http://passport.xywy.com/reg_jsonp.php?act=mobile_reg_vcode_send&callback=?',
																	dataType: 'JSONP',
																	data:'&phone='+ trimName,
																	success:function(data){
																		//console.log(data);
																		if(data.result == 10000)
																		{
																			trimYzPar.removeClass('bor-error');
																			$('.m_yzm_btn').removeAttr('disabled');
																		//console.log(obj);
																			trimYzPar.siblings('.m_wrom').hide();
																			trimYzPar.removeClass('bor-error');
																			$('.m_yzm_btn').css({'color':'#999','background':'#f7f7f7'});
																			$('.m_yzm_btn').attr('disabled','disabled');
																			$('.m_yzm_btn').unbind("mouseover");
																			this.value = '重新发送(60)';
																			var secondFS = 60;
																			var secondITV = setInterval(function(){
																				secondFS --;
																				$('.m_yzm_btn').val( '重新发送('+secondFS+')');
																			},1000);
																			setTimeout(function(){
																				$('.m_yzm_btn').removeAttr('disabled');
																				$('.m_yzm_btn').css({'color':'#333333','background':'#f7f7f7'});
																				$('.m_yzm_btn').val('重新发送');
																				clearInterval(secondITV);
																			},60000);
																		}else if(data.result == -10005)
																		{
																			trimYzPar.siblings('.m_wrom').show();
																			trimYzPar.addClass('bor-error');
																			trimYzPar.siblings('.m_wrom').html('60秒以内禁止重复发送');
																			
																			return false;
																		}else if(data.result == -10002)
																		{
																			trimYzPar.siblings('.m_wrom').show();
																			trimYzPar.addClass('bor-error');
																			trimYzPar.siblings('.m_wrom').html('手机号格式有误，请重新输入');
																			
																			return false;
																		}else
																		{
																			trimYzPar.siblings('.m_wrom').show();
																			trimYzPar.addClass('bor-error');
																			trimYzPar.siblings('.m_wrom').html('今日发送激活码已达上限，请在24小时后重试！');
																			
																			return false;													
																		}
																	}
																})
																/////									
															}else
															{
																trimYzPar.siblings('.m_wrom').show();
																trimYzPar.addClass('bor-error');
																trimYzPar.siblings('.m_wrom').html('手机号格式有误，请重新输入');
																
																return false;	
															}								
														}
													}else
													{

														$('.my-yam').removeClass('hidden');
														var ztyzmno=$('.ztyzmno').val();
														if(ztyzmno!=''){
															
														
														if( trimName=='')
														{
															trimYzPar.addClass('bor-error');
															trimYzPar.siblings('.m_wrom').show();
															trimYzPar.siblings('.m_wrom').html(' 请输入手机号');
																						
														}else
														{
															if(trimName.match(/^1[3|4|5|7|8][0-9]\d{8}$/))
															{

																/////
																$.ajax({
																	url:'http://passport.xywy.com/reg_jsonp.php?act=mobile_reg_vcode_send&callback=?',
																	dataType: 'JSONP',
																	data:'&phone='+ trimName+'&captcha='+ztyzmno,
																	success:function(data){
																		//console.log(data);
																		if(data.result == 10000)
																		{
																			$('.m_yzm_btn').removeAttr('disabled');
																			$('.ztyzmno').parent().removeClass('bor-error');
																			$('.my-yam').addClass('hidden');
																		//console.log(obj);
																			trimYzPar.siblings('.m_wrom').hide();
																			trimYzPar.removeClass('bor-error');
																			$('.m_yzm_btn').css({'color':'#999','background':'#f7f7f7'});
																			$('.m_yzm_btn').attr('disabled','disabled');
																			$('.m_yzm_btn').unbind("mouseover");
																			this.value = '重新发送(60)';
																			var secondFS = 60;
																			var secondITV = setInterval(function(){
																				secondFS --;
																				$('.m_yzm_btn').val( '重新发送('+secondFS+')');
																			},1000);
																			setTimeout(function(){
																				$('.m_yzm_btn').removeAttr('disabled');
																				$('.m_yzm_btn').css({'color':'#333333','background':'#f7f7f7'});
																				$('.m_yzm_btn').val('重新发送');
																				clearInterval(secondITV);
																			},60000);
																		}else if(data.result == -10005)
																		{
																			trimYzPar.siblings('.m_wrom').show();
																			trimYzPar.addClass('bor-error');
																			trimYzPar.siblings('.m_wrom').html('60秒以内禁止重复发送');
																			
																			return false;
																		}else if(data.result == -10002)
																		{
																			trimYzPar.siblings('.m_wrom').show();
																			trimYzPar.addClass('bor-error');
																			trimYzPar.siblings('.m_wrom').html('手机号格式有误，请重新输入');
																			
																			return false;
																		}else if(data.result == -1080)
																		{
																			trimYzPar.siblings('.m_wrom').show();
																			trimYzPar.siblings('.m_wrom').html('验证码不能为空');
																			
																			return false;													
																		}else if(data.result == -1088)
																		{
																			trimYzPar.siblings('.m_wrom').show();
													
																			trimYzPar.siblings('.m_wrom').html('验证码不正确');
										
																			$('[data-pictilt=picLitt]').attr('src','http://passport.xywy.com/reg.php?act=mobile_reg_vcode_send_captcha&amp;'+Math.random());
																			return false;													
																		}
																	}
																})
																/////									
															}else
															{
																trimYzPar.siblings('.m_wrom').show();
																trimYzPar.addClass('bor-error');
																trimYzPar.siblings('.m_wrom').html('手机号格式有误，请重新输入');
																
																return false;	
															}								
														}							
														}else {
															$('.ztyzmno').parent().addClass('bor-error');
															trimYzPar.siblings('.m_wrom').show();
															trimYzPar.siblings('.m_wrom').html('请输入验证码');
														}
														
													}
												}
										})
										////
											}else if(data.result == -10004){
															trimYzPar.siblings('.m_wrom').show();
															trimYzPar.addClass('bor-error');
															trimYzPar.siblings('.m_wrom').html('今日发送激活码已达上限，请在24小时后重试！');
															

															return false;
														}else if(data.result == -10002){
															trimYzPar.siblings('.m_wrom').show();
															trimYzPar.addClass('bor-error');
															trimYzPar.siblings('.m_wrom').html('手机号码不正确');
															
															return false;
														}								 
													}
												});  
							}else if(data.result == -10001){
									
									// $('.m_yzm').parent().removeClass('bor-error');
									trimYzPar.addClass('bor-error');
									trimYzPar.siblings('.m_wrom').show();
									trimYzPar.siblings('.m_wrom').html('该手机号已注册，请<a style="color: blue;"  href="http://3g.i.xywy.com/index/login">登录</a>');
									return true
							}else{
									trimYzPar.siblings('.m_wrom').show();
									trimYzPar.addClass('bor-error');
									trimYzPar.siblings('.m_wrom').html('手机号码不正确');
								
									return false;
							}								 
						}
					});                         					   		
				}else{
					trimYzPar.siblings('.m_wrom').show();
					trimYzPar.addClass('bor-error');
					trimYzPar.siblings('.m_wrom').html('手机号格式有误，请重新输入');
					
					return false;
				}
			}			

		});
		/* $('.m_password').on('blur', function(){
			var passlen= $('.m_password').val().length;
			var trimPasslen= $.trim( $('.m_password').val()).length;
			{
				
				
			}
		 });*/
		$('#my_reg').on('click',  function(){
			var trimName=$.trim( $('.m_username').val());
			var trimPass=$.trim( $('.m_password').val());
			var trimYzm=$.trim( $('.m_yzm').val());
			var userReg=$.trim( $('#3g_web_reg').val());
			var trimYzPar = $('.m_username').parent().parent();
			var trimPasslen= $.trim( $('.m_password').val()).length;
			if( trimName==''){
				trimYzPar.addClass('bor-error');
				trimYzPar.siblings('.m_wrom').show();
				trimYzPar.siblings('.m_wrom').html(' 请输入手机号');
			}else{				
				if(trimName.match(/^1[3|4|5|7|8][0-9]\d{8}$/)){
					$.ajax({
						url:'http://passport.xywy.com/reg_jsonp.php?act=mobile_reg_isreg&callback=?',
						dataType: 'JSONP',
						data:'&account='+ trimName,
						success:function(data){
							if(data.result == 10000)
							{
								var passlen= $('.m_password').val().length;
								var trimPasslen= $.trim( $('.m_password').val()).length;	
								if(trimPass!='')
								{
									if($('.gx-bg').hasClass('on')){
										if(passlen==trimPasslen){												
											$.ajax({
												url:'http://passport.xywy.com/reg_jsonp.php?act=mobile_reg_submit&callback=?',
												dataType: 'JSONP',
												data:'&phone='+trimName+'&passwd='+trimPass+'&code='+trimYzm+'&source='+userReg,
												success:function(data){												
													if(data.result == 10000)
													{
														var backurl=$('#backurl').val();
														console.log(backurl);
														if(backurl==''){
															location.href="http://3g.i.xywy.com/user/index"; 
														}else
														{
															location.href=backurl; 
														}
													}else if(data.result == -10001)
													{
														trimYzPar.siblings('.m_wrom').show();
														trimYzPar.addClass('bor-error');
														trimYzPar.siblings('.m_wrom').html('该手机号已注册，请<a style="color: blue;"  href="http://3g.i.xywy.com/index/login">登录</a>');
														return false;
													}else if(data.result == -10002)
													{
														
														trimYzPar.siblings('.m_wrom').show();
														trimYzPar.addClass('bor-error');
														trimYzPar.siblings('.m_wrom').html('手机号格式有误，请重新输入');
														return false;
													}else if(data.result == -10005)
													{
														$('.m_password').parent().parent().siblings('.m_wrom').show();
														$('.m_password').parent().parent().siblings('.m_wrom').html(' 请输入6-15个字符（只支持数字或字母）');	
														trimYzPar.removeClass('bor-error');	
														$('.m_password').parent().parent().addClass('bor-error');
														return false;
													}else if(data.result == -10004)
													{
														$('.m_password').parent().parent().removeClass('bor-error');
														trimYzPar.removeClass('bor-error');	
														$('.m_yzm').parent().addClass('bor-error');
														$('.m_yzm').parent().parent().siblings('.m_wrom').show();
														$('.m_yzm').parent().parent().siblings('.m_wrom').html(' 激活码输入错误');
														return false;
													}else if(data.result == -10003)
													{
														trimYzPar.removeClass('bor-error');	
														$('.m_password').parent().parent().removeClass('bor-error');
														$('.m_yzm').parent().parent().siblings('.m_wrom').show();
														$('.m_yzm').parent().addClass('bor-error');
														$('.m_yzm').parent().parent().siblings('.m_wrom').html('请输入激活码');
														return false;
													}else
													{
														$('.m_yzm').parent().parent().siblings('.m_wrom').show();
														trimYzPar.addClass('bor-error');	
														$('.m_password').parent().parent().removeClass('bor-error');
														$('.m_yzm').parent().removeClass('bor-error');
														$('.m_yzm').parent().parent().siblings('.m_wrom').html('今日发送激活码已达上限，请在24小时后重试！');
																										
													}
												}
											})	
										}else{
											trimYzPar.removeClass('bor-error');	
											$('.m_yzm').parent().removeClass('bor-error');												
											$('.m_password').parent().parent().addClass('bor-error');
											$('.m_password').parent().parent().siblings('.m_wrom').show();
											$('.m_password').parent().parent().siblings('.m_wrom').html(' 请输入密码');														
										}											
									}else
									{
										$('.m_password').parent().parent().removeClass('bor-error');
										$('.m_yzm').parent().removeClass('bor-error');
										trimYzPar.removeClass('bor-error');	$('.m_yzm').parent().parent().siblings('.m_wrom').show();												
										$('.m_yzm').parent().parent().siblings('.m_wrom').html('您还未同意寻医问药网注册协议');
									}
	
								}else
									{
										trimYzPar.removeClass('bor-error');	
										$('.m_yzm').parent().removeClass('bor-error');												
										$('.m_password').parent().parent().addClass('bor-error');
										$('.m_password').parent().parent().siblings('.m_wrom').show();
										$('.m_password').parent().parent().siblings('.m_wrom').html(' 请输入密码');														
									}
							}else if(data.result == -10001)
							{												
								// $('.m_yzm').parent().removeClass('bor-error');
								trimYzPar.addClass('bor-error');
								trimYzPar.siblings('.m_wrom').show();
								trimYzPar.siblings('.m_wrom').html('该手机号已注册，请<a style="color: blue;"  href="http://3g.i.xywy.com/index/login">登录</a>');
								$('.m_yzm').parent().removeClass('bor-error');
								$('.m_password').parent().parent().removeClass('bor-error');																								
								return true;
							}else
							{
								trimYzPar.removeClass('bor-error');	
								trimYzPar.siblings('.m_wrom').show();
								trimYzPar.addClass('bor-error');
								trimYzPar.siblings('.m_wrom').html('手机号码不正确');
								$('.m_yzm').parent().removeClass('bor-error');
								$('.m_password').parent().parent().removeClass('bor-error');
								return false;
							}								 
						}
					});                         					   		
				}else
				{
					trimYzPar.siblings('.m_wrom').show();
					trimYzPar.addClass('bor-error');
					trimYzPar.siblings('.m_wrom').html('手机号格式有误，请重新输入');
					$('.m_yzm').parent().removeClass('bor-error');
					$('.m_password').parent().parent().removeClass('bor-error');
					return false;
				}
			}		
		});
	});
	
})(window,jQuery);
