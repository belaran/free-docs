<?xml version="1.0" encoding="UTF-8"?>
<!--
	BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" encoding="UTF-8" indent="yes"/>

	<!-- FUTURE: Externalising text to allow i18n generation  -->
	<xsl:variable name="Since"					select="'Since: PMD'"/>
	<xsl:variable name="definedByJavaClass"		select="'This rule is defined by the following Java class'"/>
	<xsl:variable name="ExampleLabel"			select="'Example(s)'"/>
	<xsl:variable name="PropertiesLabel"		select="'This rule has the following properties'"/>
	<xsl:variable name="Property.Name"			select="'Name'"/>
	<xsl:variable name="Property.DefaultValue"	select="'Default Value'"/>
	<xsl:variable name="Property.Desc"			select="'Description'"/>
	<xsl:variable name="RuleSet"				select="'Ruleset'"/>

	<xsl:template match="rulesets">
		<html>
			<head>
				<link href="theme.css" rel="stylesheet" type="text/css"></link>
			</head>
			<body>
				<xsl:copy-of select="intro"/>
				<xsl:apply-templates/>
			</body>
		</html>
		
	</xsl:template>

	<xsl:template match="ruleset">
		<h2><xsl:value-of select="@name"/></h2>
		<table>
			<tr><th>Règle</th><th>Description</th></tr>
			<xsl:apply-templates/>
		</table>
	</xsl:template>

	<xsl:template match="rule">
		<xsl:variable name="rulename" select="@name"/>
		<tr>
			<td><xsl:value-of select="@name"/></td>
			<td><xsl:value-of select="description"/>
			<br/>
				<xsl:choose>
					<xsl:when test="count(./example) > 0">
						<p>Exemples:</p>
						<ul>
                                		<xsl:for-each select="./example">
				                	<li><code>
								<xsl:value-of select="."/>
							</code></li>
						</xsl:for-each>	
						</ul>
					</xsl:when>
				</xsl:choose>
			</td>
		</tr>
	</xsl:template>

</xsl:stylesheet>
