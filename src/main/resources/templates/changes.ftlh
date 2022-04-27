<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form method="post" action="/profile/update">
    <@spring.bind path="accountDto"/>
    <p class="error">${spring.status.errorMessage}</p>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <label for="firstName"><@spring.message 'accountDto.form.label.enterFirstName'/></label>
    <#assign i18Tooltip><@spring.message code="accountDto.form.placeholder.firstName"/></#assign>
    <@spring.formInput "accountDto.firstName" "placeholder=${i18Tooltip}"/>
    <br>
    <label for="lastName"><@spring.message 'accountDto.form.label.enterLastName'/></label>
    <#assign i18Tooltip><@spring.message code="accountDto.form.placeholder.lastName"/></#assign>
    <@spring.formInput "accountDto.lastName" "placeholder=${i18Tooltip}"/>
    <br>
    <label for="password"><@spring.message 'accountDto.form.label.enterPassword'/></label>
    <#assign i18Tooltip><@spring.message code="accountDto.form.placeholder.password"/></#assign>
    <@spring.formPasswordInput "accountDto.password" "placeholder=${i18Tooltip}"/>
    <br>
    <input type="submit" value="Сохранить" class="submit">
</form>
</body>
</html>
