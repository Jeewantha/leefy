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
	
	var loginForm = new Ext.FormPanel({
			url: defLoginUrl,
			title: 'Login',
			renderTo: Ext.getBody(),
			frame: true,
			cls: 'my-form-class',
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
					id: 'lf.btn.login',
					text: 'Login',
					handler: function() {
						fnLoginForm(loginForm);
					}
				},{
					id: 'lf.btn.reset',
					text: 'Reset',
					handler: function() {
						fnResetForm(loginForm);
					}
			}]
	});

});

function fnLoginForm(theForm) 
{
	theForm.getForm().submit({
		success: function(form, action) {
					window.location = homeUrl;
		},
		failure: function(form, action) {
			//Ext.Msg.alert('Warning', action.result.errorMessage); 
		}
	});
} //end fnLoginForm

function fnResetForm(theForm)
{
	theForm.getForm().reset();
} //end fnResetForm

