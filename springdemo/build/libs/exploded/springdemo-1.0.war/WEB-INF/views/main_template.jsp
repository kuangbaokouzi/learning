<%--
  Created by IntelliJ IDEA.
  User: kouzikaile
  Date: 18-4-13
  Time: 下午3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<style>
    .left-float {
        float: left;
    }

    .right-float {
        float: right;
    }
</style>
<tiles:insertAttribute name="side"/>
<tiles:insertAttribute name="content"/>