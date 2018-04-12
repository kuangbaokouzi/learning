<%--
  Created by IntelliJ IDEA.
  User: kouzikaile
  Date: 18-4-11
  Time: 下午9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div>
    <h2>Create a free Spitter account</h2>
    <sf:form method="post" modelAttribute="spitter">
        <fieldset>
            <table cellspacing="0">
                <tr>
                    <th><label for="user_full_name">Full name:</label></th>
                    <td><sf:input path="fullName" size="15" maxlength="15" id="user_full_name"/></td>
                </tr>
                <tr>
                    <th><label for="user_screen_name">Username:</label></th>
                    <td>
                        <sf:input path="username" size="15" maxlength="15" id="user_screen_name"/>
                        <small id="username_msg">No spaces, please.</small>
                    </td>
                </tr>
                <tr>
                    <th><label for="user_password">Password:</label></th>
                    <td>
                        <sf:input path="password" size="30" showPassword="true" id="user_password"/>
                        <small>6 Characters or more (be tricky!)</small>
                    </td>
                </tr>
                <tr>
                    <th><label for="user_email">Email Address:</label></th>
                    <td>
                        <sf:input path="email" size="30" id="user_email"/>
                        <small>In case you forget something</small>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:checkbox path="updateByEmail" size="30" id="user_send_email_newsletter"/>
                        <label for="user_send_email_newsletter">Send me email updates!</label>
                    </td>
                </tr>
            </table>
        </fieldset>
    </sf:form>
</div>