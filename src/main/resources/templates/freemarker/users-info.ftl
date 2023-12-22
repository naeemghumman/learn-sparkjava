<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users Info</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<h1>Users</h1>

<table>
    <tr>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.getName()}</td>
            <td>${user.getEmail()}</td>
        </tr>
    </#list>
</table>

</body>
</html>