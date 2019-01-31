<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title!'默认标题'}</title>
</head>
<body>
list 遍历
<table width="100%">
    <thead>
        <tr>
            <th>ID</th>
            <th>名字</th>
        </tr>
    </thead>
    <tbody>
    <#list personList as person>
    <tr>
        <td>${person.id}</td>
        <td>${person.name!''}</td>
    </tr>
    </#list>
    </tbody>

</table>

<br>
<table width="100%">
    <thead>
    <tr>
        <th>名字</th>
        <th>手机</th>
    </tr>
    </thead>
    <tbody>
    <#list nameList as nameStr>
        <#assign arr = "${nameStr}"?split("_")>
    <#if arr?size gte 2 >
           <tr>
               <td>${arr[0]}</td>
               <td>${arr[1]}</td>
           </tr>
    </#if>

    </#list>
    </tbody>

</table>
<hr>
rangData 所属区间
<#if rangData lt 0>
   小于0
<#elseif rangData lt 50>
    0-50
<#elseif rangData lt 95>
    50-95
<#else>
   大于等于95
</#if>
日期处理
<br>
<hr>
${curTime?string("yyyy-MM-dd HH:mm:ss ")}
<br>
${curTime?string("yyyy-MM-dd ")!''}
<b></b>
</body>
</html>
