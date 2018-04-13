<%--
  Created by IntelliJ IDEA.
  User: kouzikaile
  Date: 18-4-11
  Time: 上午11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="left-float">
    <h2>A global community of friends and strangers</h2>
    <h3>Look at what these people are spitting right now...</h3>
    <ol class="spittle-list">
        <c:forEach var="spittle" items="${spittles}">
            <s:url value="/spitter/{spitterName}" var="spitter_url">
                <s:param name="spitterName" value="${spittle.spitter.username}"/>
            </s:url>
            <li>
                <span class="spittleListImage">
                    <%--<img src="http://s3.amazonaws.com/spitterImages/${spittle.spitter.id}.jpg"--%>
                     <img src="data:image/webp;base64,UklGRigCAABXRUJQVlA4TBwCAAAvP8APEE/koI0kRypv4I/jSH7YPRAO2kYSnHH2yrD8obwMpG2Tzr/Tiziitm3k9HlEjsTxO9oK27ZBOubd0Xj+d/e1z9f/fvr6Bn3mjW9r1vRJY04wQjAK5TVnBAcJcLRQhBAQxsvrB9EiwniAC4T5I4xLgPFQChDBCDeyBAEiQGHxgCBACSDCOAK5mwSEljM3jvMtiPFoCSBOpIQAEK4+H585I0C2bdumHV1zxrZtq5ybclVs27adnPnX8T5rn8e8RPQ/bQ6XH5YFPQ6bwwdLfQ4XLHb7YXEA7yFRjVMH9xfLv9PwIguSvGiYKNrky8vPeIiommyDZH4kAsqqK74xMnTInTgIUgwOR0GRfUbFaSFiYL6Kj3NJeHuMiu26ppEPMN/Ap51ivJVxT4XBh14Iqvl815mA141U94dDkMqXR1/i8fIXVfchyBb56qynLAJPf6jag7CKbx2Ph2oL26jahrSb0jXIyusT+imchqyWt+tXlHVBlk55M4TzFOdCWGJQuAfxTwo7IP9hUJQPDcWzBs0vQENJ67dxg6YroSH9ioJpaPlK85c50BI2SNOfoCksdE1zo2HQlvl39YrqlVjojP5nULWSDI3h9VtUziRCX27rNpX37RHQUv6/vW/2kCY2SqGreIZm9loioTGvc59vX07UREBzWMHHgaW985uT3ZXh7xXRePcIwuKABxY7HT5Y6rXbHO4ALAs47TY="
                          width="48"
                          border="0"
                          align="middle"
                          onerror="this.src='<s:url value="/resources/images"/>/spitter_avatar.png';"/>
                </span>
                <span class="spittleListText">
                    <a href="${spitter_url}">
                        <c:out value="${spittle.spitter.username}"/>
                    </a> -
                    <c:out value="${spittle.text}"/><br>
                    <small><fmt:formatDate value="${spittle.when}" pattern="hh:mma MMM d, yyyy"/> </small>
                </span>
            </li>
        </c:forEach>
    </ol>
</div>
<%--<div class="right-float">
    &lt;%&ndash;<iframe src="loginForm.jsp"></iframe>&ndash;%&gt;
    <jsp:include page="loginForm.jsp"/>
</div>--%>