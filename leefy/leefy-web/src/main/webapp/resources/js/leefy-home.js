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

var mainLayout = new Ext.Viewport({
			layout : 'border',
			renderTo : Ext.getBody(),
			items : [{
						region : 'north',
						xtype : 'toolbar',
						cls : 'toolbarStyles',
						items : [{
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
								}, {
									xtype : 'tbfill'
								}, {
									xtype : 'textfield',
									name : 'field1',
									emptyText : 'ente name to search'
								}, {
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
						title : 'Some Info',
						width : 200,
						miniSize : 200,
						html : 'West'
					}, {
						region : 'center',
						xtype : 'tabpanel',
						items : [{
									title : 'Movie Grid',
									html : 'Center'
								}, {
									title : 'Movie Description',
									html : 'Description'
								}],
						activeTab : 0
					}, {
						region : 'east',
						xtype : 'panel',
						split : true,
						collapsible : true,
						collapseMode : 'mini',
						title : 'Live Feeds',
						width : 200,
						miniSize : 200,
						html : 'East'
					}, {
						region : 'south',
						xtype : 'panel',
						title : 'footer',
						html : 'South'
					}]
		});

mainLayout.show();
});