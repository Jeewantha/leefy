/*******************************************************************************
 * 
 * Leefy is a simple social network to narrow the gap between people speaking
 * different languages and to aid the language learning process. Copyright (C)
 * 2015 Jeewantha Samaraweera
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 ******************************************************************************/

Ext.onReady(function(){
	Ext.QuickTips.init();

	
	var profileForm = Ext.create('Ext.form.Panel',{
		url : addUrl,
		title : loginSignupFormLabelTitle,
		frame : true,
		bodyPadding : 5,
		cls : 'signup-form-class',
		width:350,
		items : [{
			        xtype: 'displayfield',
			        fieldLabel: '',
			        labelSeparator:'',
			        name: 'errorsView',
			    },{
					xtype : 'displayfield',
					fieldLabel : loginSignupFormLableUsername,
					labelWidth: 150,
					labelSeparator: '',
					anchor: '90%',
					name : 'username',
					value : username
				}, {
					xtype : 'textfield',
					labelSeparator: '',
					anchor: '90%',
					fieldLabel : loginSignupFormLableEmail,
					labelWidth: 150,
					name : 'email',
					value : email
				}, {
					xtype : 'textfield',
					labelSeparator: '',
					anchor: '90%',
					fieldLabel : loginSignupFormLableConfirmEmail,
					labelWidth: 150,
					name : 'confirmEmail'
				}, {
					xtype:'combo',
					labelSeparator: '',
					anchor: '90%',
					fieldLabel : loginSignupFormLableCounrty,
					labelWidth: 150,
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
					labelWidth: 150,
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
	
var mainLayout = new Ext.Viewport({
			layout : 'border',
			renderTo : Ext.getBody(),
			items : [{
						region : 'north',
						xtype : 'toolbar',
						cls : 'toolbarStyles',
						items : [ {
									xtype : 'textfield',
									name : 'searchFriend',
									emptyText : 'enter name to search'
								},{
									xtype : 'label',
									text : 'Welcome '+username
								},{
									xtype : 'tbfill'
								},{
									xtype : 'button',
									text : 'My Account',
									glyph: 61,
									menu : [{
												text : 'My Profile'
											}, {
												text : 'My Friends'
											}, {
												text : 'My Messages'
											}]
								},{
									xtype : 'button',
									text : 'Logout',
									handler : function() {
										window.open(logoutUrl, "_self");
									}
								}]
					}, {
						region : 'west',
						xtype : 'panel',
						split : true,
						collapsible : true,
						collapseMode : 'mini',
						title : 'Anything new?',
						width : 200,
						miniSize : 200,
						html : ''
					}, {
						region : 'center',
						xtype : 'tabpanel',
						items : [{
									title : 'My Wall',
									items: [{
										xtype: 'monthyearfield',
										format: 'n, Y',
								        fieldLabel: 'Date',
										name: 'monthyearfieldiview'
									}]
								},{
									title : 'Live Feed',
									html : 'Live Feed'
								}, {
									title : 'Quick View',
									html : 'Quick View'
								}, {
									title : '+ Add',
									html : 'Add'
								}, profileForm],
						activeTab : 0
					}, {
						region : 'east',
						xtype : 'panel',
						split : true,
						collapsible : true,
						collapseMode : 'mini',
						title : 'Who\'s Online',
						width : 200,
						miniSize : 200,
						html : ''
					}, {
						region : 'south',
						xtype : 'label',
						fieldLabel : 'footerLabel',
						labelStyle : 'color:red',
						cls : 'footer-class',
						html : fnGetCopyRight()
					}]
		});

mainLayout.show();
});

function fnGetCopyRight() {
	var today = new Date();
	var year = Ext.Date.format(today,'Y'); 
	return "&copy; "+year+" Jeewantha Samaraweera.  All rights reserved.";
}

function fnResetForm(theForm) {
	theForm.getForm().reset();
} // end fnResetForm

function fnSignupForm(theForm) {
	theForm.getForm().submit({
				success : function(form, action) {
					window.location.assign(homeUrl);
				},
				failure : function(form, action) {
					var errors = [];
					var fields = form.getFields(); // form : Ext.form.Basic
					var errorsTpl = new Ext.XTemplate(
					    '<ul><tpl for="."><li>{field} : {error}</li></tpl></ul>'
					);
					fields.each(function (field) {
						if(field.getName() == 'errorsView'){
							field.show();
						}
					    errors = errors.concat(Ext.Array.map(field.getErrors(), function (error) {
					        return { field: field.getName(), error: error }
					    }));
					});
					//errorsTpl.overwrite('myOutputDiv', errors);
					//Ext.Msg.alert('Warning', errorMessage);
				}
			});
} // end fnSignupForm



Ext.define('Ext.form.field.Month', {
        extend: 'Ext.form.field.Date',
        alias: 'widget.monthfield',
        xtype: 'monthyearfield',
        requires: ['Ext.picker.Month'],
        alternateClassName: ['Ext.form.MonthField', 'Ext.form.Month'],
        selectMonth: null,
        createPicker: function() {
            var me = this,
                format = Ext.String.format;
            return Ext.create('Ext.picker.Month', {
                pickerField: me,
                ownerCt: me.ownerCt,
                renderTo: document.body,
                floating: true,
                hidden: true,
                focusOnShow: true,
                minDate: me.minValue,
                maxDate: me.maxValue,
                disabledDatesRE: me.disabledDatesRE,
                disabledDatesText: me.disabledDatesText,
                disabledDays: me.disabledDays,
                disabledDaysText: me.disabledDaysText,
                format: me.format,
                showToday: me.showToday,
                startDay: me.startDay,
                minText: format(me.minText, me.formatDate(me.minValue)),
                maxText: format(me.maxText, me.formatDate(me.maxValue)),
                listeners: {
                    select: {
                        scope: me,
                        fn: me.onSelect
                    },
                    monthdblclick: {
                        scope: me,
                        fn: me.onOKClick
                    },
                    yeardblclick: {
                        scope: me,
                        fn: me.onOKClick
                    },
                    OkClick: {
                        scope: me,
                        fn: me.onOKClick
                    },
                    CancelClick: {
                        scope: me,
                        fn: me.onCancelClick
                    },
                    afterrender : {
                        scope : me,
                        fn : function(c) {
                            var me = c;
                            me.el.on("mousedown", function(e) {
                                e.preventDefault();
                            }, c);
                        }
                    },
                },
                keyNavConfig: {
                    esc: function() {
                        me.collapse();
                    }
                }
            });
        },
        onCancelClick: function() {
            var me = this;
            me.selectMonth = null;
            me.collapse();
        },
        onOKClick: function() {
            var me = this;
            if (me.selectMonth) {
                me.setValue(me.selectMonth);
                me.fireEvent('select', me, me.selectMonth);
            }
            me.collapse();
        },
        onSelect: function(m, d) {
            var me = this;
            me.selectMonth = new Date((d[0] + 1) + '/1/' + d[1]);
        },
    });
