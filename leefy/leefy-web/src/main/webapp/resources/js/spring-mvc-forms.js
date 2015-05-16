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
	
		var mf = new Ext.FormPanel({
			url: addUrl,
			title: 'User',
			frame: true,
			bodyPadding: 5,
			cls: 'my-form-class',
			width: 400,
			items: [{
					xtype: 'textfield',
					fieldLabel: 'Name',
					name: 'name'
			},{
					xtype: 'textfield',
					fieldLabel: 'Phone No.',
					name: 'phone'
			},{
					xtype: 'textfield',
					fieldLabel: 'Email',
					name: 'email'
			}],
			buttons: [{
					id: 'mf.btn.load',
					text: 'Load',
					handler: function() {
						fnLoadForm(mf);
					}
				},{
					id: 'mf.btn.add',
					text: 'Add',
					disabled: true,
					handler: function() {
						fnUpdateForm(mf);
					}
			},{
					id: 'mf.btn.reset',
					text: 'Reset',
					disabled: true,
					handler: function() {
						fnResetForm(mf);
					}
			},{
					id: 'mf.btn.jsonpreq',
					text: 'Json',
					handler: function() {
						fnGetJsonResp();
					}
		}]
	});

	
	var topToolBar = new Ext.grid.Panel({
		renderTo: Ext.getBody(),
		defaults:{autoWidth:true, autoHeight:true},
		dockedItems: [{
		    xtype: 'toolbar',
		    dock: 'top',
		    items: [{
		        xtype: 'button',
		        text: 'Log Out',
		        href:logoutUrl
		    }, {
		        xtype: 'button',
		        text: 'Home'
		    }]
		}]
	});
	
	var topPanel = new Ext.TabPanel({
		renderTo: Ext.getBody(),
		layoutOnTabChange:true,
		width: 500,
		activeTab: 0,
		frame: true,
		defaults:{autoHeight: true},
		resizeTabs: true,
		enableTabScroll: true,
		title:'Home',
		items: [mf]
	});
	
	
});

function fnLoadForm(theForm) 
{
	//for the purpose of this tutorial, load 1 record.
	theForm.getForm().load({
		url: loadUrl,
		headers: {Accept: 'application/json, text/javascript, */*; q=0.01'},
        waitMsg: 'loading...',
		params : {
			id: 1
		},
		success: function(form, action) {
			Ext.getCmp('mf.btn.add').setDisabled(false);		
			Ext.getCmp('mf.btn.reset').setDisabled(false);		
			Ext.getCmp('mf.btn.load').setDisabled(true);		
		},
		failure: function(form, action) {
			Ext.Msg.alert('Warning', 'Error Unable to Load Form Data.'); //action.result.errorMessage
		}
	});
} //end fnLoadForm

function fnUpdateForm(theForm)
{
	theForm.getForm().submit({
		success: function(form, action) {
			Ext.Msg.alert('Success', 'Data is stored in session.');
			form.reset();
		},
		failure: function(form, action) {
			Ext.Msg.alert('Warning', action.result.errorMessage); 
		}
	});
} //end fnUpdateForm
function fnResetForm(theForm)
{
	theForm.getForm().reset();
	Ext.getCmp('mf.btn.add').setDisabled(true);		
	Ext.getCmp('mf.btn.reset').setDisabled(true);		
} //end fnResetForm

function fnGetJsonResp()
{
		/*Ext.data.JsonP.request({
		    url: jsonpreq,
		    required:['Ext.data.JsonP'],
		    crossDomain: true,
		    type: "GET",
		    dataType: "json",
		    callbackKey: 'callback',
		    scope: this,
		    callback: function (response, value, request) {
		        var result = Ext.decode(response.responseText);
		        alert(result.propertyName);
		    }
		});*/
	
		var myObj = {
			 input : 'your hobby',
			 obj1    : {
			    a : 'something in obj1'
			 }

			}
			Ext.Ajax.request({
				   	url: jsonpreq,
				   	method: 'GET',
				      	params: { 
				   				ajax_req: Ext.util.JSON.encode(myObj),
				   				input:'Your hobby'
						},
				   	success: function(transport){
				   		var result = Ext.decode(transport.responseText);
				   		alert("success"+result.name);
			                  // do something
				   	},
				   	failure: function(transport){
				   			alert("Error: " - transport.responseText);
				   	}
				});
} // end fnGetJsonResp