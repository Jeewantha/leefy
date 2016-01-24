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
	
	var signupForm = Ext.create('Ext.form.Panel',{
			url : addUrl,
			title : loginSignupFormLabelTitle,
			frame : true,
			bodyPadding : 5,
			cls : 'signup-form-class',
			width:350,
			items : [{
						xtype : 'textfield',
						labelSeparator: '',
						anchor: '90%',
						fieldLabel : loginSignupFormLableUsername,
						name : 'username'
					}, {
						xtype : 'textfield',
						labelSeparator: '',
						anchor: '90%',
						fieldLabel : loginSignupFormLableEmail,
						name : 'email'
					}, {
						xtype : 'textfield',
						labelSeparator: '',
						anchor: '90%',
						fieldLabel : loginSignupFormLableConfirmEmail,
						name : 'confirmEmail'
					}, {
						xtype:'combo',
						labelSeparator: '',
						anchor: '90%',
						fieldLabel : loginSignupFormLableCounrty,
						name : 'country',
					    displayField: 'name',
					    valueField:'iso2Code',
					    listConfig: {
                            getInnerTpl: function(displayField) {
                            	return "<div><span class='flag-icon flag-icon-{iso2Code}'></span> {"+displayField+"}</div>";
                            }
                        },
					    store: countryStore,
					    queryMode: 'local',
					    typeAhead: true
					},{
						xtype : 'textfield',
						labelSeparator: '',
						anchor: '90%',
						labelWidth: 150,
						inputType: 'password',
						fieldLabel : loginSignupFormLablePassword,
						name : 'password'
					}, {
						xtype : 'textfield',
						labelSeparator: '',
						anchor: '90%',
						labelWidth: 150,
						inputType: 'password',
						fieldLabel : loginSignupFormLableConfirmPassword,
						name : 'confirmPassword'
					}, {
						xtype : 'datefield',
						labelSeparator: '',
						anchor: '90%',
						fieldLabel : loginSignupFormLableBirthday,
						editable : false,
						name : 'birthday',
						maxValue: new Date()
					}],
			buttons : [{
						id : 'suf.btn.add',
						text : loginSignupFormButtonSignup,
						handler : function() {
							fnSignupForm(signupForm);
						}
					},{
						id : 'suf.btn.load',
						text : loginSignupFormButtonReset,
						handler : function() {
							fnResetForm(signupForm);
						}
					}]
		});

	var signinForm = Ext.create('Ext.form.Panel',{
			url: defLoginUrl,
			bodyPadding:5,
			title: loginSigninFormTitle,
			frame: true,
			cls: 'signin-form-class',
			width: 350,
			items: [{
					xtype: 'textfield',
					allowBlank: false,
					labelSeparator: '',
					anchor: '90%',
					fieldLabel: loginSigninFormLableLogin,
					name: 'j_username'
			},{
					xtype: 'textfield',
					allowBlank: false,
					labelSeparator: '',
					anchor: '90%',
					inputType: 'password',
					fieldLabel: loginSigninFormLablePassword,
					name: 'j_password'
			}, {
				xtype: 'checkbox',
				labelWidth: 110,
				labelSeparator: '',
				fieldLabel: loginSigninFormLableRememberMe,
				name: '_spring_security_remember_me',
				checked: false
			}],
			buttons: [{
					id: 'sif.btn.login',
					text: loginSigninFormButtonLogin,
					handler: function() {
						fnLoginForm(signinForm);
					}
				},{
					id: 'sif.btn.reset',
					text: loginSigninFormButtonReset,
					handler: function() {
						fnResetForm(signinForm);
					}
			}]
	});

		
		var win = Ext.create('widget.window', {
                title: loginWelcomeTitle,
                header: {
                    titlePosition: 2,
                    titleAlign: 'center'
                },
                tools : [{
								id : 'Language',
								handler : function(e, toolEl, panel, tc) {
									menu.show(toolEl, 'tr-br?');
								}
							}],
                closable: false,
                closeAction: 'hide',
                maximizable: false,
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
			Ext.Msg.alert('Warning', loginError); 
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
					form.reset();
				},
				failure : function(form, action) {
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
