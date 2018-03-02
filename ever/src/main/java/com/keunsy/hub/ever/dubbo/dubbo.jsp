<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">dubbo服务调用</h3>
    </div>
    <div class="panel-body">
        <div class="opts">
            <label><span>IP </span><input name="ip" type="text"/></label>
            <label><span>Port </span><input name="port" type="text"/></label>
            <input class="btn btn-primary" type="button" value="List Services" id="listService"/>
            <label><span>Service Name(complete): </span><input name="serviceName"
                                                               type="text"/></label>
            <input class="btn btn-primary" type="button" value="List Methods" id="listMethod"/>
            <label><span>Method Name </span><input name="methodName" type="text"/></label>
            <span>Parameter </span><textarea name="parameter"></textarea>
            <input class="btn btn-primary" type="button" value="Invoke" id="invoke"/>
        </div>
        <div id="result"></div>
    </div>
</div>
<script type="text/javascript">

    $('.opts #invoke').click(function () {
        invoke();
    });

    $('.opts #listService').click(function () {
        listService();
    });

    $('.opts #listMethod').click(function () {
        listMethod();
    });

    function invoke() {

        var data = {
            ip: $('input[name=ip]').val(),
            port: $('input[name=port]').val(),
            serviceName: $('input[name=serviceName]').val(),
            methodName: $('input[name=methodName]').val(),
            parameter: $('textarea[name=parameter]').val(),
        };
        $.ajax({
                   url: '/dev/api/dubbo/invoke',
                   method: 'POST',
                   data: data,
                   success: function (data) {
                       if (data.success) {
                           generateContent(data.model);
                       } else {
                           alert(data.message);
                       }
                   }
               });
    }

    function listService() {

        var data = {
            ip: $('input[name=ip]').val(),
            port: $('input[name=port]').val(),
        };
        $.ajax({
                   url: '/dev/api/dubbo/listService',
                   method: 'POST',
                   data: data,
                   success: function (data) {
                       if (data.success) {
                           $('#result').html("<pre>" + data.model + "</pre>");
                       } else {
                           alert(data.message);
                       }
                   }
               });
    }

    function listMethod() {

        var data = {
            ip: $('input[name=ip]').val(),
            port: $('input[name=port]').val(),
            serviceName: $('input[name=serviceName]').val()
        };
        $.ajax({
                   url: '/dev/api/dubbo/listMethod',
                   method: 'POST',
                   data: data,
                   success: function (data) {
                       if (data.success) {
                           $('#result').html("<pre>" + data.model + "</pre>");
                       } else {
                           alert(data.message);
                       }
                   }
               });
    }

    function generateContent(model) {
        var html;
        if (model) {
//            html=JSON.stringify(model, null, 2);
            html = model;
        } else {
            html = '返回值为空';
        }
        $('#result').html("<pre>" + format(html, false) + "</pre>");
    }

    function format(txt, compress/*是否为压缩模式*/) {/* 格式化JSON源码(对象转换为JSON文本) */
        var indentChar = '    ';
        if (/^\s*$/.test(txt)) {
            alert('数据为空!');
            return txt;
        }
        try {
            var data = eval('(' + txt + ')');
        }
        catch (e) {
//            alert('非json格式或存在语法错误,格式化失败! 错误信息: ' + e.description, 'err');
            return txt;
        }
        ;
        var draw = [], last = false, This = this, line = compress ? '' : '\n', nodeCount = 0,
            maxDepth = 0;

        var notify = function (name, value, isLast, indent/*缩进*/, formObj) {
            nodeCount++;
            /*节点计数*/
            for (var i = 0, tab = ''; i < indent; i++) tab += indentChar;
            /* 缩进HTML */
            tab = compress ? '' : tab;
            /*压缩模式忽略缩进*/
            maxDepth = ++indent;
            /*缩进递增并记录*/
            if (value && value.constructor == Array) {/*处理数组*/
                draw.push(tab + (formObj ? ('"' + name + '":') : '') + '[' + line);
                /*缩进'[' 然后换行*/
                for (var i = 0; i < value.length; i++)
                    notify(i, value[i], i == value.length - 1, indent, false);
                draw.push(tab + ']' + (isLast ? line : (',' + line)));
                /*缩进']'换行,若非尾元素则添加逗号*/
            } else if (value && typeof value == 'object') {/*处理对象*/
                draw.push(tab + (formObj ? ('"' + name + '":') : '') + '{' + line);
                /*缩进'{' 然后换行*/
                var len = 0, i = 0;
                for (var key in value) len++;
                for (var key in value) notify(key, value[key], ++i == len, indent, true);
                draw.push(tab + '}' + (isLast ? line : (',' + line)));
                /*缩进'}'换行,若非尾元素则添加逗号*/
            } else {
                if (typeof value == 'string') value = '"' + value + '"';
                draw.push(tab + (formObj ? ('"' + name + '":') : '') + value + (isLast ? '' : ',')
                          + line);
            }
            ;
        };
        var isLast = true, indent = 0;
        notify('', data, isLast, indent, false);
        return draw.join('');
    }

</script>
<script>
    $('.navbar ul.nav li').removeClass('active');
    $('#nav-dubbo').addClass('active');
</script>