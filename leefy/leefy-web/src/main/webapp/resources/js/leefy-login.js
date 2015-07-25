/*******************************************************************************
 * 	
 * 	Leefy is a simple social network to narrow the gap between people speaking different
 * 	languages and to aid the language learning process.
 *     Copyright (C) 2015  Jeewantha Samaraweera
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *     
 *******************************************************************************/
Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var signinForm = Ext.create('Ext.form.Panel',{
			url: defLoginUrl,
			bodyPadding:5,
			title: 'Sign-in',
			frame: true,
			cls: 'signin-form-class',
			width: 350,
			items: [{
					xtype: 'textfield',
					fieldLabel: 'Login',
					name: 'j_username'
			},{
					xtype: 'textfield',
					inputType: 'password',
					fieldLabel: 'Password',
					name: 'j_password'
			}, {
				xtype: 'checkbox',
				fieldLabel: 'Remember Me?',
				name: '_spring_security_remember_me',
				checked: false
			}],
			buttons: [{
					id: 'sif.btn.login',
					text: 'Login',
					handler: function() {
						fnLoginForm(signinForm);
					}
				},{
					id: 'sif.btn.reset',
					text: 'Reset',
					handler: function() {
						fnResetForm(signinForm);
					}
			}]
	});
	
	var signupForm = Ext.create('Ext.form.Panel',{
			url : addUrl,
			title : 'Sign-up',
			frame : true,
			bodyPadding : 5,
			cls : 'signup-form-class',
			width:350,
			items : [{
						xtype : 'textfield',
						fieldLabel : 'Username',
						name : 'username'
					}, {
						xtype : 'textfield',
						fieldLabel : 'Email',
						name : 'email'
					}, {
						xtype : 'textfield',
						inputType: 'password',
						fieldLabel : 'Password',
						name : 'password'
					}, {
						xtype : 'datefield',
						fieldLabel : 'Birthday',
						editable : false,
						name : 'birthday',
						maxValue: new Date()
					}],
			buttons : [{
						id : 'suf.btn.add',
						text : 'Signup',
						handler : function() {
							fnSignupForm(signupForm);
						}
					},{
						id : 'suf.btn.load',
						text : 'Reset',
						handler : function() {
							fnResetForm(signupForm);
						}
					}]
		});

		var win = Ext.create('widget.window', {
                title: 'Welcome To Leefy',
                header: {
                    titlePosition: 2,
                    titleAlign: 'center'
                },
                closable: true,
                closeAction: 'hide',
                maximizable: true,
                width: 400,
                minWidth: 350,
                tools: [{type: 'pin'}],
                items: [{
                    region: 'center',
                    xtype: 'tabpanel',
                    items: [signinForm,signupForm]
                }]
            });

            win.show();
});
	
function fnLoginForm(theForm) 
{
	theForm.getForm().submit({
		success: function(form, action) {
					window.location = homeUrl;
		},
		failure: function(form, action) {
			Ext.Msg.alert('Warning', action.result.errorMessage); 
		}
	});
} //end fnLoginForm

function fnResetForm(theForm)
{
	theForm.getForm().reset();
} //end fnResetForm

function fnLoadForm(theForm) {
	theForm.getForm().load({
				url : loadUrl,
				headers : {
					Accept : 'application/json, text/javascript, */*; q=0.01'
				},
				waitMsg : 'loading...',
				params : {
					id : 1
				},
				success : function(form, action) {
					/*Ext.getCmp('mf.btn.add').setDisabled(false);
					Ext.getCmp('mf.btn.reset').setDisabled(false);
					Ext.getCmp('mf.btn.load').setDisabled(true);*/
				},
				failure : function(form, action) {
					Ext.Msg.alert('Warning', 'Error Unable to Load Form Data.'); // action.result.errorMessage
				}
			});
} // end fnLoadForm

function fnSignupForm(theForm) {
	theForm.getForm().submit({
				success : function(form, action) {
					Ext.Msg.alert('Success', 'Data is stored in session.');
					form.reset();
				},
				failure : function(form, action) {
					Ext.Msg.alert('Warning', 'Signup failed.');
				}
			});
} // end fnSignupForm

function fnResetForm(theForm) {
	theForm.getForm().reset();
} // end fnResetForm

function fnGetJsonResp() {
	var myObj = {
		input : 'your hobby',
		obj1 : {
			a : 'something in obj1'
		}

	}
	Ext.Ajax.request({
				url : jsonpreq,
				method : 'GET',
				params : {
					ajax_req : Ext.util.JSON.encode(myObj),
					input : 'Your hobby'
				},
				success : function(transport) {
					var result = Ext.decode(transport.responseText);
					alert("success" + result.name);
					// do something
				},
				failure : function(transport) {
					alert("Error: " - transport.responseText);
				}
			});
} // end fnGetJsonResp