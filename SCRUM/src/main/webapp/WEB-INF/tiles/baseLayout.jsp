<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>        
        <style>
           body {
                margin: 0em;
                padding: 0em;
                height: 40em;
            }

            #menu {
                position: absolute;
                border-right: 1px solid black;
                background:rgba(142,142,142,0.2);
                height: 100%;

                width: 15em;
                top: 0em;
                left: 0em;
                bottom: 0em;
            }

            #content {
                position: absolute;
                left: 15em;
                top: 0em;
                height: 100%;
                right: 0em;
                min-width: 35em;		
            } 
        </style>
    </head>
    <body>
        <aside id="menu">
            <tiles:insertAttribute name="menu" />
	</aside>
	<div id="content">
            <tiles:insertAttribute name="body" />
	</div>
    </body>
</html>
